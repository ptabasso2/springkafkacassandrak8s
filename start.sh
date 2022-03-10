#!/bin/bash
# http://redsymbol.net/articles/unofficial-bash-strict-mode/
set -euo pipefail
IFS=$'\n\t'

CQL="DESCRIBE keyspace;"
until cqlsh -k recommendation_service --execute="$CQL" product-recommendation-db; do
  echo "Waiting for cassandra to start..."
  sleep 1
done

./gradlew --no-daemon --parallel bootRun
