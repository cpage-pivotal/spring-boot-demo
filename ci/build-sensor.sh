#!/bin/bash
#
# All CF_* variables are provided externally from this script

set -e -x

pushd spring-boot-demo
  ./mvnw package
popd

cp spring-boot-demo/target/boot-demo-0.0.1-SNAPSHOT.jar build-sensor-output

