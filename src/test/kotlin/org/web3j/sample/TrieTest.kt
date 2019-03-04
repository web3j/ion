package org.web3j.sample

import junit.framework.Assert.assertEquals
import org.junit.Assert
import org.junit.Test
import org.web3j.protocol.Web3j
import org.web3j.protocol.core.DefaultBlockParameter
import org.web3j.protocol.core.methods.response.EthBlock
import org.web3j.protocol.http.HttpService
import org.web3j.utils.Numeric
import tech.pegasys.pantheon.ethereum.trie.SimpleMerklePatriciaTrie
import tech.pegasys.pantheon.util.bytes.Bytes32
import tech.pegasys.pantheon.util.bytes.BytesValue

class TrieTest {
    // taken from trie_test.go in go-ethereum
    private val EMPTY_TRIE_ROOT = Bytes32.wrap(Numeric.hexStringToByteArray("56e81f171bcc55a6ff8345e692c0f86e5b48e01b996cadc001622fb5e363b421"))

    @Test
    fun emptyTrieTest() {
        assertEquals(EMPTY_TRIE_ROOT, SimpleMerklePatriciaTrie<BytesValue, BytesValue> { b -> b }.rootHash)
    }

    @Test
    fun putTest() {
        val trie = SimpleMerklePatriciaTrie<BytesValue, String> { s -> BytesValue.wrap(s.toByteArray()) }

        trie.put(BytesValue.wrap("doe".toByteArray()), "reindeer")
        trie.put(BytesValue.wrap("dog".toByteArray()), "puppy")
        trie.put(BytesValue.wrap("dogglesworth".toByteArray()), "cat")

        val exp = Bytes32.wrap(Numeric.hexStringToByteArray("8aad789dff2f538bca5d8ea56e8abe10f4c7ba3a5dea95fea4cd6e7c3a1168d3"))
        val root = trie.rootHash

        assertEquals(exp, root)
    }

    @Test
    fun txTrieTest() {
        // set-up
        val web3j = Web3j.build(HttpService("https://rinkeby.infura.io/v3/41c8d0234db44c429d9b7f6bb29874ae"))
        val txHash = "0xafc3ab60059ed38e71c7f6bea036822abe16b2c02fcf770a4f4b5fffcbfe6e7e"
        val tx = web3j.ethGetTransactionByHash(txHash).send().transaction.get()
        val blockNumber = tx.blockNumber
        val block = web3j.ethGetBlockByNumber(DefaultBlockParameter.valueOf(blockNumber), true).send().block
        val transactions = block.transactions
                .map { it.get() as EthBlock.TransactionObject }
                .toList()

        //test
        val txTrie = Trie.buildTransactionTrie(transactions)

        assertEquals(block.transactionsRoot, txTrie.rootHash)


    }

    @Test
    fun receiptTrieTest() {
        // set-up
        val web3j = Web3j.build(HttpService("https://rinkeby.infura.io/v3/41c8d0234db44c429d9b7f6bb29874ae"))
        val txHash = "0xafc3ab60059ed38e71c7f6bea036822abe16b2c02fcf770a4f4b5fffcbfe6e7e"
        val tx = web3j.ethGetTransactionByHash(txHash).send().transaction.get()
        val blockNumber = tx.blockNumber
        val block = web3j.ethGetBlockByNumber(DefaultBlockParameter.valueOf(blockNumber), true).send().block
        val transactions = block.transactions
                .map { it.get() as EthBlock.TransactionObject }
                .toList()
        val blockReceipts = transactions.map { t ->
            web3j.ethGetTransactionReceipt(t.hash).send().transactionReceipt.get()
        }.toList()

        //test
        val receiptsTrie = Trie.buildReceiptTrie(blockReceipts)

        Assert.assertEquals(block.receiptsRoot, receiptsTrie.rootHash)


    }
}
