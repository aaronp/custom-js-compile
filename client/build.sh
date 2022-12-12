#!/usr/bin/env bash

pushd $(dirname $0)

echo "compiling $(dirname $0) files from build.sh"

rm -rf js-output
cp -r ./js ./js-output

popd