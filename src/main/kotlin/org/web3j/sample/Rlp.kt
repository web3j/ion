package org.web3j.sample

import org.web3j.protocol.core.methods.response.EthBlock
import org.web3j.protocol.core.methods.response.Log
import org.web3j.protocol.core.methods.response.Transaction
import org.web3j.protocol.core.methods.response.TransactionReceipt
import org.web3j.rlp.RlpEncoder
import org.web3j.rlp.RlpList
import org.web3j.rlp.RlpString
import org.web3j.rlp.RlpType
import org.web3j.utils.Numeric
import java.util.ArrayList

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

fun TransactionReceipt.toRlp(): ByteArray {
    val result = ArrayList<RlpType>()
    result.add(RlpString.create(Numeric.hexStringToByteArray(status)))
    result.add(RlpString.create(Numeric.hexStringToByteArray(cumulativeGasUsedRaw)))
    result.add(RlpString.create(Numeric.hexStringToByteArray(logsBloom)))
    result.add(RlpList(logs.map { it.toRlpType() }.toList()))
    return RlpEncoder.encode(RlpList(result))
}

fun Log.toRlpType(): RlpType {
    val result = ArrayList<RlpType>()
    result.add(RlpString.create(Numeric.hexStringToByteArray(address)))
    result.add(RlpList(topics.map { RlpString.create(Numeric.hexStringToByteArray(it)) }.toList()))
    result.add(RlpString.create(Numeric.hexStringToByteArray(data)))
    return RlpList(result)
}

fun Transaction.toRlp(): ByteArray {
    val result = ArrayList<RlpType>()
    result.add(RlpString.create(Numeric.hexStringToByteArray(nonceRaw)))
    result.add(RlpString.create(Numeric.hexStringToByteArray(gasPriceRaw)))
    result.add(RlpString.create(Numeric.hexStringToByteArray(gasRaw)))
    result.add(RlpString.create(Numeric.hexStringToByteArray(to)))
    result.add(RlpString.create(Numeric.hexStringToByteArray(valueRaw)))
    result.add(RlpString.create(Numeric.hexStringToByteArray(input)))
    result.add(RlpString.create(Numeric.hexStringToByteArray(v.toString())))
    result.add(RlpString.create(Numeric.hexStringToByteArray(r)))
    result.add(RlpString.create(Numeric.hexStringToByteArray(s)))
    result.add(RlpString.create(Numeric.hexStringToByteArray(hash)))
    return RlpEncoder.encode(RlpList(result))
}