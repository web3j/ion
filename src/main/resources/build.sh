#!/usr/bin/env bash

cd ../java
outDir=`pwd`
cd ../solidity
allowPaths=`pwd`

targets="
Ion
validation/Base
storage/EthereumStore
"

for target in ${targets}; do
    dirName=$(dirname $target)
    fileName=$(basename $target)

    cd $dirName
    echo "Compiling Solidity files in ${dirName}:"
    solc --bin --abi --optimize --overwrite --allow-paths ${allowPaths} `pwd`/${fileName}.sol -o build/
    echo "Complete"

    echo "Generating web3j bindings"
    web3j solidity generate \
        -b build/${fileName}.bin \
        -a build/${fileName}.abi \
        -p org.web3j.generated \
        -o ${outDir} > /dev/null
    echo "Complete"

    cd -
done
