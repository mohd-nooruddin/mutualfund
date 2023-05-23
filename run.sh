#!/bin/bash

# Function to build and run a microservice
build_and_run_microservice() {
    cd "$1"
    echo "Building $1..."
    mvn clean install
    echo "Running $1..."
    nohup java -jar target/*.jar &
    cd -
}

# Absolute paths to microservices
details_service="/home/ubuntu/mutual-fund/mutualfund/details"
gateway_service="/home/ubuntu/mutual-fund/mutualfund/gateway"
registration_service="/home/ubuntu/mutual-fund/mutualfund/registration"
search_service="/home/ubuntu/mutual-fund/mutualfund/search"
server_service="/home/ubuntu/mutual-fund/mutualfund/server"
wallet_service="/home/ubuntu/mutual-fund/mutualfund/wallet"

# Build and run each microservice
build_and_run_microservice "$details_service"
build_and_run_microservice "$gateway_service"
build_and_run_microservice "$registration_service"
build_and_run_microservice "$search_service"
build_and_run_microservice "$server_service"
build_and_run_microservice "$wallet_service"
