配置kafka环境步骤：
前提:安装go环境，docker,docker-compose环境,下载镜像，生成节点证书，通道配置文件
机器：
      2 10.0.15.35  212.129.164.210 组织1 :2 peer , 1 couchdb,1 ca, 1 cli , mysql(root,root)
      3 10.0.15.23  212.129.164.71 组织2  :2 peer , 1 couchdb,1 ca, 1 cli，  
      4 10.0.15.37  211.159.241.222 order+zookeeper+kafka ,postgres + block-explorer
mysql: https://blog.csdn.net/qq_37598011/article/details/93489404 


notes:
1 configtx.yaml
   1.1 OrdererType: kafka
   1.2 Kafka:
      # Brokers: A list of Kafka brokers to which the orderer connects
      # NOTE: Use IP:port notation
      Brokers:
        - 10.2.0.2:9092
2 peer-base.yaml
    - CORE_VM_DOCKER_HOSTCONFIG_NETWORKMODE=`kafka`（目录名称）_byfn
  其他内容参照配置文件
接口调用步骤：
1 用户注册peerOrg1
2 创建通道（必须与生成的通道配置文件一致），此步骤已加入通道
3 安装链码
4 实例化链码（升级）{如果不是第一次，就是安装升级}
5 数据上链
6 查询
7 用户注册peerOrg2
8 节点加入通道
9 安装链码
10 peerOrg2查询（此过程实例化链码，速度较慢）

安装命令（部分）：
peer channel update -o orderer.example.com:7050 -c bhfaechannel -f channel-artifacts/Org1MSPanchors.tx

peer chaincode install -n java0521 -v 1.0 -p /opt/gopath/src/github.com/chaincode/chaincode_java06/ -l java

peer chaincode instantiate -o orderer.example.com:7050  -C bhfaechannel -n java0521 -v 1.0 -c '{"Args":["init"]}' -P "AND('Org1MSP.peer','Org2MSP.peer')"

 
 %Ojos.kAw7GV
 
 0,<j5cILt%Mg
