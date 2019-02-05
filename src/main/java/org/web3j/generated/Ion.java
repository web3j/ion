package org.web3j.generated;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Bytes32;
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
public class Ion extends Contract {
    private static final String BINARY = "608060405234801561001057600080fd5b5060405160208061087b8339810160405251600055610847806100346000396000f3006080604052600436106100775763ffffffff7c010000000000000000000000000000000000000000000000000000000060003504166320e49a1b811461007c5780634060009a146100a2578063626a26e01461010b5780639a8a059214610120578063a3ce463f14610147578063ec3b77f21461017c575b600080fd5b34801561008857600080fd5b506100a0600160a060020a03600435166024356101b0565b005b3480156100ae57600080fd5b50604080516020600460443581810135601f81018490048402850184019095528484526100a0948235600160a060020a03169460248035953695946064949201919081908401838280828437509497506103839650505050505050565b34801561011757600080fd5b506100a061062e565b34801561012c57600080fd5b506101356107d0565b60408051918252519081900360200190f35b34801561015357600080fd5b50610168600160a060020a03600435166107d6565b604080519115158252519081900360200190f35b34801561018857600080fd5b506101946004356107eb565b60408051600160a060020a039092168252519081900360200190f35b60006101bb33610813565b151561025d576040805160e560020a62461bcd02815260206004820152606060248201527f43616c6c65722061646472657373206973206e6f7420612076616c696420636f60448201527f6e74726163742e20506c6561736520696e68657269742074686520426c6f636b60648201527f53746f726520636f6e747261637420666f722070726f7065722075736167652e608482015290519081900360a40190fd5b3360009081526001602052604090205460ff1615156102ec576040805160e560020a62461bcd02815260206004820152602360248201527f56616c69646174696f6e206d6f64756c65206973206e6f74207265676973746560448201527f7265640000000000000000000000000000000000000000000000000000000000606482015290519081900360840190fd5b50604080517fe7a27c420000000000000000000000000000000000000000000000000000000081526004810183905290518391600160a060020a0383169163e7a27c42916024808201926020929091908290030181600087803b15801561035257600080fd5b505af1158015610366573d6000803e3d6000fd5b505050506040513d602081101561037c57600080fd5b5050505050565b600061038e33610813565b1515610430576040805160e560020a62461bcd02815260206004820152606060248201527f43616c6c65722061646472657373206973206e6f7420612076616c696420636f60448201527f6e74726163742e20506c6561736520696e68657269742074686520426c6f636b60648201527f53746f726520636f6e747261637420666f722070726f7065722075736167652e608482015290519081900360a40190fd5b3360009081526001602052604090205460ff1615156104bf576040805160e560020a62461bcd02815260206004820152602360248201527f56616c69646174696f6e206d6f64756c65206973206e6f74207265676973746560448201527f7265640000000000000000000000000000000000000000000000000000000000606482015290519081900360840190fd5b6104c884610813565b1515610544576040805160e560020a62461bcd02815260206004820152602960248201527f53746f7261676520616464726573732070726f7669646564206973206e6f742060448201527f636f6e74726163742e0000000000000000000000000000000000000000000000606482015290519081900360840190fd5b50604080517f66eb1c9200000000000000000000000000000000000000000000000000000000815260048101848152602482019283528351604483015283518693600160a060020a038516936366eb1c929388938893919260640190602085019080838360005b838110156105c35781810151838201526020016105ab565b50505050905090810190601f1680156105f05780820380516001836020036101000a031916815260200191505b509350505050600060405180830381600087803b15801561061057600080fd5b505af1158015610624573d6000803e3d6000fd5b5050505050505050565b61063733610813565b15156106d9576040805160e560020a62461bcd02815260206004820152606060248201527f43616c6c65722061646472657373206973206e6f7420612076616c696420636f60448201527f6e74726163742e20506c6561736520696e68657269742074686520426c6f636b60648201527f53746f726520636f6e747261637420666f722070726f7065722075736167652e608482015290519081900360a40190fd5b3360009081526001602052604090205460ff1615610767576040805160e560020a62461bcd02815260206004820152602e60248201527f56616c69646174696f6e206d6f64756c652068617320616c726561647920626560448201527f656e20726567697374657265642e000000000000000000000000000000000000606482015290519081900360840190fd5b3360008181526001602081905260408220805460ff1916821790556002805491820181559091527f405787fa12a823e0f2b7631cc41b3ba8828b3321ca811111fa75cd3aa3bb5ace01805473ffffffffffffffffffffffffffffffffffffffff19169091179055565b60005481565b60016020526000908152604090205460ff1681565b60028054829081106107f957fe5b600091825260209091200154600160a060020a0316905081565b6000903b11905600a165627a7a723058208005754a7ff0328e2218af9f946cbfa4d8bf492697425c13060d4ef9ad6eb5ed0029";

    public static final String FUNC_ADDCHAIN = "addChain";

    public static final String FUNC_STOREBLOCK = "storeBlock";

    public static final String FUNC_REGISTERVALIDATIONMODULE = "registerValidationModule";

    public static final String FUNC_CHAINID = "chainId";

    public static final String FUNC_M_REGISTERED_VALIDATION = "m_registered_validation";

    public static final String FUNC_VALIDATION_MODULES = "validation_modules";

    @Deprecated
    protected Ion(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Ion(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Ion(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Ion(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<TransactionReceipt> addChain(String _storageAddress, byte[] _chainId) {
        final Function function = new Function(
                FUNC_ADDCHAIN, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_storageAddress), 
                new org.web3j.abi.datatypes.generated.Bytes32(_chainId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> storeBlock(String _storageAddress, byte[] _chainId, byte[] _blockBlob) {
        final Function function = new Function(
                FUNC_STOREBLOCK, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_storageAddress), 
                new org.web3j.abi.datatypes.generated.Bytes32(_chainId), 
                new org.web3j.abi.datatypes.DynamicBytes(_blockBlob)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> registerValidationModule() {
        final Function function = new Function(
                FUNC_REGISTERVALIDATIONMODULE, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<byte[]> chainId() {
        final Function function = new Function(FUNC_CHAINID, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteCall<Boolean> m_registered_validation(String param0) {
        final Function function = new Function(FUNC_M_REGISTERED_VALIDATION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<String> validation_modules(BigInteger param0) {
        final Function function = new Function(FUNC_VALIDATION_MODULES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    @Deprecated
    public static Ion load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Ion(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Ion load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Ion(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Ion load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Ion(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Ion load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Ion(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Ion> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, byte[] _id) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_id)));
        return deployRemoteCall(Ion.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<Ion> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, byte[] _id) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_id)));
        return deployRemoteCall(Ion.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<Ion> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, byte[] _id) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_id)));
        return deployRemoteCall(Ion.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<Ion> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, byte[] _id) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_id)));
        return deployRemoteCall(Ion.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }
}
