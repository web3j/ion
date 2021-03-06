# web3j Sample Ion Project

This project provides a very simple starter application for working with web3j and the [Ion Interoperability Framework](https://github.com/clearmatics/ion) using an Ethereum network (testnet) known as Rinkeby.

The demo deploys the *Ion* smart contract.

In order to run this demo, three pieces of information are required:

1. Ethereum client (or node) endpoint. The simplest thing to do is 
[request a free access token](https://infura.io/register.html) from Infura.
1. A wallet file. This can be generated using the web3j 
[command line tools](https://docs.web3j.io/command_line.html).
1. Some Ether. This can be requested from the [Rinkeby Faucet](https://www.rinkeby.io/#faucet).

Once these details have been added to the main Application class, you'll be good to go.

Below is a diagram with a high level overview of how components interact in the [Ion Interoperability Framework](https://github.com/clearmatics/ion)

![alt text](https://raw.githubusercontent.com/web3j/ion/master/doc/images/ion_mermaid.png "Ion framework mermaid diagram")


## Functionality

This application demonstrates a number of core features of web3j and Ethereum:

- Connecting to a node on the Ethereum network
- Loading an Ethereum wallet file
- Deploying the [Ion Interoperability Framework](https://github.com/clearmatics/ion)


## Background

This application has purposefully been kept as simple as possible with the aim of demonstrating 
how to deploy the [Ion Interoperability Framework](https://github.com/clearmatics/ion) on a decentralised Ethereum network.

If you require further background information about the above configuration items for the project
you can refer to the below.

For a more comprehensive overview, I recommend you read the 
[Java Magazine Article](https://web3j.io/articles/web3j%20article%20-%20Java%20Magazine%20JanuaryFebruary%202017.pdf), watch 
the 
[YouTube](https://youtube.com/watch?v=ea3miXs_P6Y) talk, and read all of the 
[documentation](https://docs.web3j.io).


### Smart contracts

The contained smart contract is based on the 
[Ion Interoperability Framework](https://github.com/clearmatics/ion)

The associated Java smart contract wrappers reflect their respective Solidity smart contracts.

You should use /resource/build.sh to compile the contracts

For more background on smart contracts, refer to the 
[smart contracts](https://docs.web3j.io/smart_contracts.html) section of the docs.


### Infura

If you don't want to sign up to Infura, and would like to run a node yourself, there are 
instructions in the [getting started](https://docs.web3j.io/getting_started.html#start-a-client) 
section of the docs.

### Testnets

For more information on the different Ethereum test networks (or testnets), refer 
to the 
[testnet overview](https://docs.web3j.io/transactions.html#ethereum-testnets) in the docs.

### Ether

For background on Ether, refer to the transactions 
[overview](https://docs.web3j.io/transactions.html#transactions) section of the docs.

### Wallets and transaction signing

For a more technical overview of working with wallet files, refer to the 
[Offline transaction signing](https://docs.web3j.io/transactions.html#offline-transaction-signing)
section of the docs.
 

## Viewing requests

A logback configuration is included in the project dependencies allowing the logging of protocol 
messages if required. To enable, simply change the following [line]() in the logback configuration
to read:

```xml
<logger name="org.web3j.protocol" level="DEBUG"/>
```
