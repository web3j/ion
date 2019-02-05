#!/usr/bin/env bash

cd ../solidity

targets="
./validation/Base
./Ion
"

for target in ${targets}; do
    dirName=$(dirname $target)
    fileName=$(basename $target)

    cd $dirName
    echo "Compiling Solidity files in ${dirName}:"
    solc --bin --abi --optimize --overwrite ${fileName}.sol -o build/
    echo "Complete"

    echo "Generating web3j bindings"
    web3j solidity generate \
        -b build/${fileName}.bin \
        -a build/${fileName}.abi \
        -p org.web3j.generated \
        -o ../java/ > /dev/null
    echo "Complete"

    cd -
done
