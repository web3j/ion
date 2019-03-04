package org.web3j.sample

import org.slf4j.LoggerFactory
import org.web3j.crypto.Credentials
import org.web3j.crypto.Hash
import org.web3j.generated.*
import org.web3j.generated.Function
import org.web3j.protocol.Web3j
import org.web3j.protocol.core.methods.response.EthBlock
import org.web3j.protocol.http.HttpService
import org.web3j.rlp.RlpEncoder
import org.web3j.rlp.RlpList
import org.web3j.rlp.RlpString
import org.web3j.rlp.RlpType
import org.web3j.tx.gas.DefaultGasProvider
import org.web3j.utils.Bytes
import org.web3j.utils.Numeric
import java.util.*

/**
 * A simple web3j application that demonstrates a number of core features of web3j:
 *
 *  1. Connecting to a node on the Ethereum network
 *  2. Loading an Ethereum wallet file
 *  3. Deploying the Ion smart contracts to the network
 *
 * To run this demo, you will need to provide:
 *
 *  1. Two Ethereum client (or node) endpoints. The simplest thing to do is
 * [request a free access token from Infura](https://infura.io/register.html)
 *  2. A wallet file. This can be generated using the web3j
 * [command line tools](https://docs.web3j.io/command_line.html)
 *  3. Some Ether. This can be requested from the
 * [Rinkeby Faucet](https://www.rinkeby.io/#faucet)
 *
 * For further background information, refer to the project README.
 */
class Application {

    @Throws(Exception::class)
    fun run() {

        // Connect to the blockchain you want to send information from
        // Note: if using web3j Android, use Web3jFactory.build(...
        val blockchain1 = Web3j.build(HttpService(
                "https://rinkeby.infura.io/<your token>"))

        // Connect to the blockchain you want to send information to
        // Note: if using web3j Android, use Web3jFactory.build(...
        val blockchain2 = Web3j.build(HttpService(
                "https://rinkeby.infura.io/<your token>"))

        /** We then need to create a credentials object
         * You can use WalletUtils to load Credentials from a WalletFile
         * !!BE CAREFUL WHEN HANDLING YOUR PRIVATE KEY!!
         * The address of these credentials is 0x716c1b5ac5422b4e7089b223e3e64543624eb336
         * It is funded on Rinkeby
         */
        val credentials = Credentials.create("C48BCA3858EA492480A6E3C1BA72B86C632B8AC102027BB632B19708CDDFE078")
        log.info("Credentials loaded")

        // Specify the chainId of the blockchain you want to send information from (blockchain1)
        val ionChainId = Hash.sha3String("MYCHAINID").substring(0, 32).toByteArray()

        // Deploy Ion to the blockchain you want to send information to (blockchain2)
        // Deploying Ion contract
        val ion = Ion.deploy(
                blockchain2, credentials,
                DefaultGasProvider(),
                ionChainId).send()
        log.info("Ion contract deployed")

        // Deploying Ethereum store contract
        // You may need a different implementation depending on you DLT
        val ethereumStore = EthereumStore.deploy(
                blockchain2, credentials,
                DefaultGasProvider(),
                ion.contractAddress).send()
        log.info("EthereumStore contract deployed")

        // Deploying Base Validation
        // You may want to use a custom Validation contract for your consensus mechanism
        val baseValidation = Base.deploy(
                blockchain2, credentials,
                DefaultGasProvider(),
                ion.contractAddress).send()
        baseValidation.RegisterChain(ionChainId, ethereumStore.contractAddress)
        log.info("Base validation contract deployed")

        // Deploy the contracts that will verify and consume interesting event from blockchain1
        val triggerEventVerifier = TriggerEventVerifier.deploy(
                blockchain1, credentials,
                DefaultGasProvider()).send()
        log.info("Event verifier contract deployed")
        val function = Function.deploy(
                blockchain1, credentials,
                DefaultGasProvider(),
                ethereumStore.contractAddress,
                triggerEventVerifier.contractAddress).send()
        log.info("Event consumer contract deployed")

        // Deploy the contract that will supply interesting event you want to transfer to blockchain2
        val trigger = Trigger.deploy(
                blockchain1, credentials,
                DefaultGasProvider()).send()
        log.info("Event supplier contract deployed")

        // Trigger the event
        val triggerReceipt = trigger.fire().send()

        // Submit the block from blockchain1 that contains the event you are interested in to
        // Ion on blockchain2
        val interestingBlock = blockchain1.ethGetBlockByHash(triggerReceipt.blockHash, true).send().block
        baseValidation.SubmitBlock(ionChainId, interestingBlock.blockHeaderRlp(), ethereumStore.contractAddress).send()

        // TODO: Here you need to wait for the ethereum store contract to fire block stored event
        //  but this is an internal transaction so event is not stored on blockchain

        // Use interesting data on blockchain2
        function.verifyAndExecute(ionChainId,
                Numeric.hexStringToByteArray(interestingBlock.hash),
                Numeric.hexStringToByteArray(triggerReceipt.to),
                // TODO: Code to create these proofs do no exist in java
                // https://github.com/zmitton/eth-proof
                byteArrayOf(),
                // the value you expect to be in the event in the block you transferred from blockchain1
                Numeric.hexStringToByteArray(credentials.address))
                .send()

    }

    companion object {

        private val log = LoggerFactory.getLogger(Application::class.java)

    }
}

fun EthBlock.Block.blockHeaderRlp(): ByteArray {
    val result = ArrayList<RlpType>()
    result.add(RlpString.create(Numeric.hexStringToByteArray(parentHash)))
    result.add(RlpString.create(Numeric.hexStringToByteArray(sha3Uncles)))
    result.add(RlpString.create(Numeric.hexStringToByteArray(miner)))
    result.add(RlpString.create(Numeric.hexStringToByteArray(stateRoot)))
    result.add(RlpString.create(Numeric.hexStringToByteArray(transactionsRoot)))
    result.add(RlpString.create(Numeric.hexStringToByteArray(receiptsRoot)))
    result.add(RlpString.create(Numeric.hexStringToByteArray(logsBloom)))
    result.add(RlpString.create(Numeric.hexStringToByteArray(difficultyRaw)))
    result.add(RlpString.create(Numeric.hexStringToByteArray(numberRaw)))
    result.add(RlpString.create(Numeric.hexStringToByteArray(gasLimitRaw)))
    result.add(RlpString.create(Numeric.hexStringToByteArray(gasUsedRaw)))
    result.add(RlpString.create(Numeric.hexStringToByteArray(timestampRaw)))
    result.add(RlpString.create(Numeric.hexStringToByteArray(extraData)))
    result.add(RlpString.create(Numeric.hexStringToByteArray(mixHash)))
    result.add(RlpString.create(Numeric.hexStringToByteArray(nonceRaw)))
    return RlpEncoder.encode(RlpList(result))
}

@Throws(Exception::class)
fun main(args: Array<String>) {
    Application().run()
}
