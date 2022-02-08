# spring boot + dubbo + zookeeper + seata 整合示例

## 整合server环境部署
请参考本人近期开源的一键docker部署项目

[一键部署springboot + dubbo + zookeeper + seata-searver整合server环境](https://github.com/nyl1001/onekey-zk-seata-server-docker)



## 启动所有的sample模块
  启动 samples-account、samples-order、samples-storage、samples-business
  
  在zk的客户端查看注册情况。
  
  我们可以看到上面的服务都已经注册成功。
  
## 测试

### 成功测试
使用postman 发送 ：<http://localhost:8104/business/dubbo/buy>

参数：

```
{
    "userId":"1",
    "commodityCode":"C201901140001",
    "name":"fan",
    "count":50,
    "amount":"100"
}
```

返回
```

{
    "status": 200,
    "message": "成功",
    "data": null
}
```

或者执行curl命令：

curl http://localhost:8104/business/dubbo/buy -d "{\"userId\":\"1\",\"commodityCode\":\"C201901140001\",\"name\":\"fan\",\"count\":50,\"amount\":\"100\"}" -H "Content-Type:application/json" 

 
### 回滚测试
将samples-business项目BusinessServiceImpl中 handleBusiness2 接口下面的代码去掉注释

if (!flag) {
  throw new RuntimeException("测试抛异常后，分布式事务回滚！");
}

使用postman 发送 ：http://localhost:8104/business/dubbo/buy2

.响应结果：

{
    "timestamp": "2019-09-05T04:29:34.178+0000",
    "status": 500,
    "error": "Internal Server Error",
    "message": "测试抛异常后，分布式事务回滚！",
    "path": "/business/dubbo/buy"
}

或者执行curl命令：

curl http://localhost:8104/business/dubbo/buy2 -d "{\"userId\":\"1\",\"commodityCode\":\"C201901140001\",\"name\":\"fan\",\"count\":50,\"amount\":\"100\"}" -H "Content-Type:application/json"

curl http://localhost:8104/business/dubbo/buy2 -d "{\"userId\":\"1\",\"commodityCode\":\"C201901140001\",\"name\":\"fan\",\"count\":2000,\"amount\":\"100\"}" -H "Content-Type:application/json" 
 
