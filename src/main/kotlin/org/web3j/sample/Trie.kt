package org.web3j.sample

import org.web3j.protocol.core.methods.response.EthBlock
import org.web3j.protocol.core.methods.response.TransactionReceipt
import tech.pegasys.pantheon.ethereum.trie.SimpleMerklePatriciaTrie
import tech.pegasys.pantheon.util.bytes.BytesValue

object Trie {

    fun buildTransactionTrie(transactions: List<EthBlock.TransactionObject>)
            : SimpleMerklePatriciaTrie<BytesValue, EthBlock.TransactionObject> {
        val trie = SimpleMerklePatriciaTrie<BytesValue, EthBlock.TransactionObject> { t -> BytesValue.wrap(t.toRlp()) }
        transactions.forEachIndexed { i, t ->
            val key = BytesValue.wrap(i.toBigInteger().toRlp())
            trie.put(key, t)
        }
        return trie
    }

    fun buildReceiptTrie(receipts: List<TransactionReceipt>)
            : SimpleMerklePatriciaTrie<BytesValue, TransactionReceipt> {
        val trie = SimpleMerklePatriciaTrie<BytesValue, TransactionReceipt> { t -> BytesValue.wrap(t.toRlp()) }
        receipts.forEachIndexed { i, t ->
            val key = BytesValue.wrap(i.toBigInteger().toRlp())
            trie.put(key, t)
        }
        return trie
    }
}