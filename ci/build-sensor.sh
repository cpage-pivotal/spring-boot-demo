#!/bin/bash
#
# All CF_* variables are provided externally from this script

set -e -x

pushd sensors-demo
  ./mvnw package
popd

cp sensors-demo/target/boot-demo-0.0.1-SNAPSHOT.jar build-sensor-output

