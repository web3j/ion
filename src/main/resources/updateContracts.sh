#!/usr/bin/env bash

cd ../solidity

rm -rf *

git clone https://github.com/clearmatics/ion.git

mv ion/contracts/* .

rm -rf ion