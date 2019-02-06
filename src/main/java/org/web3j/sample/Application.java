package org.web3j.sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.generated.Base;
import org.web3j.generated.EthereumStore;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.generated.Ion;
import org.web3j.tx.gas.DefaultGasProvider;

/**
 * A simple web3j application that demonstrates a number of core features of web3j:
 *
 * <ol>
 * <li>Connecting to a node on the Ethereum network</li>
 * <li>Loading an Ethereum wallet file</li>
 * <li>Deploying the Ion smart contracts to the network</li>
 * </ol>
 *
 * <p>To run this demo, you will need to provide:
 *
 * <ol>
 * <li>Ethereum client (or node) endpoint. The simplest thing to do is
 * <a href="https://infura.io/register.html">request a free access token from Infura</a></li>
 * <li>A wallet file. This can be generated using the web3j
 * <a href="https://docs.web3j.io/command_line.html">command line tools</a></li>
 * <li>Some Ether. This can be requested from the
 * <a href="https://www.rinkeby.io/#faucet">Rinkeby Faucet</a></li>
 * </ol>
 *
 * <p>For further background information, refer to the project README.
 */
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) throws Exception {
        new Application().run();
    }

    private void run() throws Exception {

        // We start by creating a new web3j instance to connect to remote nodes on the network.
        // Note: if using web3j Android, use Web3jFactory.build(...
        Web3j web3j = Web3j.build(new HttpService(
                "https://rinkeby.infura.io/<your token>"));  // FIXME: Enter your Infura token or node url here;

        // We then need to load our Ethereum wallet file
        // FIXME: Generate a new wallet file using the web3j command line tools https://docs.web3j.io/command_line.html
        Credentials credentials =
                WalletUtils.loadCredentials(
                        "<password>",
                        "/path/to/<walletfile>");
        log.info("Credentials loaded");

        // Deploying Ion contract
        Ion ion = Ion.deploy(
                web3j, credentials,
                new DefaultGasProvider(),
                "MyBlockChainId".getBytes()).send();
        log.info("Ion contract deployed");

        EthereumStore ethereumStore = EthereumStore.deploy(
                web3j, credentials,
                new DefaultGasProvider(),
                ion.getContractAddress()).send();
        log.info("EthereumStore contract deployed");

        Base baseValidation = Base.deploy(
                web3j, credentials,
                new DefaultGasProvider(),
                ion.getContractAddress()).send();
        log.info("Base validation contract deployed");

    }
}
