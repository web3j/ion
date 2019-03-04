package org.web3j.sample

import org.junit.Assert.assertEquals
import org.junit.Test
import org.web3j.protocol.core.methods.response.EthBlock
import org.web3j.utils.Numeric

class RlpTest {

    // taken from go-ethereum transaction_test.go - only field used in Rlp encoding are populated
    val TRANSACTION = EthBlock.TransactionObject(
            "",
            "0x3",
            "",
            "",
            "",
            "",
            "0xb94f5374fce5edbc8e2a8697c15331677e6ebf0b",
            "0xa",
            "0x1",
            "0x7d0",
            "0x5544",
            "",
            "",
            "",
            "98FF921201554726367D2BE8C804A7FF89CCF285EBC57DFF8AE4C44B9C19AC4A",
            "8887321BE575C8095F789DD4C743DFE42C1820F9231F98A962B210E3AC2452A3",
            28)

    // taken from go-ethereum transaction_test.go
    val RLP = "0xf86103018207d094b94f5374fce5edbc8e2a8697c15331677e6ebf0b0a8255441ca098ff921201554726367d2be8c804a7ff89ccf285ebc57dff8ae4c44b9c19ac4aa08887321be575c8095f789dd4c743dfe42c1820f9231f98a962b210e3ac2452a3"

    @Test
    fun transactionToRlpTest() {
        assertEquals(RLP, Numeric.toHexString(TRANSACTION.toRlp()))
    }
}