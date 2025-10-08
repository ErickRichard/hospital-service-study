#!/bin/bash
set -e

echo "waiting LocalStack..."
until awslocal dynamodb list-tables; do
  sleep 2
done

echo "creating patient table..."
awslocal dynamodb create-table \
    --table-name patient \
    --attribute-definitions AttributeName=id,AttributeType=S \
    --key-schema AttributeName=id,KeyType=HASH \
    --billing-mode PAY_PER_REQUEST \
    --table-class STANDARD \
    --region us-east-1 || true
