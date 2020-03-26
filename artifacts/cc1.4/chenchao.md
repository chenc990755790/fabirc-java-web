
cryptogen generate --config=./crypto-config.yaml

configtxgen -profile TwoOrgsOrdererGenesis  -outputBlock ./channel-artifacts/genesis.block


configtxgen -profile TwoOrgsChannel -outputCreateChannelTx ./channel-artifacts/bhfaechannel.tx -channelID bhfaechannel

configtxgen -profile TwoOrgsChannel -outputAnchorPeersUpdate ./channel-artifacts/Org1MSPanchors.tx -channelID bhfaechannel -asOrg Org1MSP

configtxgen -profile TwoOrgsChannel -outputAnchorPeersUpdate ./channel-artifacts/Org2MSPanchors.tx -channelID bhfaechannel -asOrg Org2MSP
