package org.web3j.generated;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.0.1.
 */
public class Base extends Contract {
    private static final String BINARY = "608060405234801561001057600080fd5b50604051602080610491833981016040525160008054600160a060020a03909216600160a060020a031990921691909117905561043f806100526000396000f30060806040526004361061003d5763ffffffff60e060020a6000350416631aa3a008811461004257806395b0ea001461006b578063b66bbb6c14610091575b600080fd5b34801561004e57600080fd5b506100576100fa565b604080519115158252519081900360200190f35b34801561007757600080fd5b5061008f600435600160a060020a036024351661016d565b005b34801561009d57600080fd5b5060408051602060046024803582810135601f810185900485028601850190965285855261008f95833595369560449491939091019190819084018382808284375094975050509235600160a060020a0316935061030692505050565b60008060009054906101000a9004600160a060020a0316600160a060020a031663626a26e06040518163ffffffff1660e060020a028152600401600060405180830381600087803b15801561014e57600080fd5b505af1158015610162573d6000803e3d6000fd5b505050506001905090565b6000809054906101000a9004600160a060020a0316600160a060020a0316639a8a05926040518163ffffffff1660e060020a028152600401602060405180830381600087803b1580156101bf57600080fd5b505af11580156101d3573d6000803e3d6000fd5b505050506040513d60208110156101e957600080fd5b505182141561027f57604080517f08c379a000000000000000000000000000000000000000000000000000000000815260206004820152602a60248201527f43616e6e6f7420616464207468697320636861696e20696420746f206368616960448201527f6e20726567697374657200000000000000000000000000000000000000000000606482015290519081900360840190fd5b60008054604080517f20e49a1b000000000000000000000000000000000000000000000000000000008152600160a060020a03858116600483015260248201879052915191909216926320e49a1b926044808201939182900301818387803b1580156102ea57600080fd5b505af11580156102fe573d6000803e3d6000fd5b505050505050565b610311838383610316565b505050565b600080546040517f4060009a000000000000000000000000000000000000000000000000000000008152600160a060020a0384811660048301908152602483018890526060604484019081528751606485015287519290941694634060009a9487948a948a94936084909201916020860191908190849084905b838110156103a8578181015183820152602001610390565b50505050905090810190601f1680156103d55780820380516001836020036101000a031916815260200191505b50945050505050600060405180830381600087803b1580156103f657600080fd5b505af115801561040a573d6000803e3d6000fd5b505050505050505600a165627a7a72305820ea304f2449c75dc3fbd91a0ec0c8a8bbc741d5e5918b475f8e2b52760b9b177c0029";

    public static final String FUNC_REGISTER = "register";

    public static final String FUNC_REGISTERCHAIN = "RegisterChain";

    public static final String FUNC_SUBMITBLOCK = "SubmitBlock";

    @Deprecated
    protected Base(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Base(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Base(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Base(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<TransactionReceipt> register() {
        final Function function = new Function(
                FUNC_REGISTER, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> RegisterChain(byte[] _chainId, String _storeAddr) {
        final Function function = new Function(
                FUNC_REGISTERCHAIN, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_chainId), 
                new org.web3j.abi.datatypes.Address(_storeAddr)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> SubmitBlock(byte[] _chainId, byte[] _rlpBlock, String _storageAddr) {
        final Function function = new Function(
                FUNC_SUBMITBLOCK, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_chainId), 
                new org.web3j.abi.datatypes.DynamicBytes(_rlpBlock), 
                new org.web3j.abi.datatypes.Address(_storageAddr)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static Base load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Base(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Base load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Base(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Base load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Base(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Base load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Base(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Base> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String _ionAddr) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_ionAddr)));
        return deployRemoteCall(Base.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<Base> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String _ionAddr) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_ionAddr)));
        return deployRemoteCall(Base.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<Base> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _ionAddr) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_ionAddr)));
        return deployRemoteCall(Base.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<Base> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _ionAddr) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_ionAddr)));
        return deployRemoteCall(Base.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }
}
