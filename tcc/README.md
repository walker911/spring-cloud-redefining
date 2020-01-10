# tcc

```text
├─tcc
   ├─inventory-service          库存微服务模块
   ├─order-service              订单微服务模块
   ├─tcc-coordinator-atomikos   使用atomikos的transactions-tcc-rest作为coordinator服务的实现
   ├─tcc-coordinator-example    演示了如何使用REST TCC进行分布式事务管理
   └─tcc-rest-participant-api   规范了事务参与者所需提供的REST API
```

tcc-coordinator-atomikos: 用来协调参与者，进行事务的confirm与cancel;       
tcc-rest-participant-api: 规范参与者的try, cancel, confirm的REST API;
