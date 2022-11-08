### string

![](https://raw.githubusercontent.com/mengfeifeifeifei/image/main/img/20221107152341.png)

| 命令 |              行为              |
| :--: | :----------------------------: |
| GET  |       获取存储在键中的值       |
| SET  |       设置存储在键中的值       |
| DEL  | 删除给定的键（适用于所有类型） |



### hash

![image-20221107153756189](/Users/zhaoheng/Library/Application Support/typora-user-images/image-20221107153756189.png)

| 命令    | 行为                                 |
| ------- | ------------------------------------ |
| HSET    | 在散列里面设置键值对                 |
| HGET    | 获取指定散列键的值                   |
| HGETALL | 获取散列包含的所有键值对             |
| HDEL    | 如果给定的键存在于散列中，移除这个键 |



### list

![](https://raw.githubusercontent.com/mengfeifeifeifei/image/main/img/20221107153026.png)

|  命令  |                 行为                 |
| :----: | :----------------------------------: |
| RPUSH  |        将给定值推入列表的右端        |
| LRANGE |     获取列表在给定范围上的所有值     |
| LINDEX |    获取列表在给定位置上的单个元素    |
|  LPOP  | 从列表的左端弹出一个值，返回弹出的值 |



### set

![](https://raw.githubusercontent.com/mengfeifeifeifei/image/main/img/20221107153320.png)

无序，不重复

|   命令    |                     行为                     |
| :-------: | :------------------------------------------: |
|   SADD    |             将给定的值添加到集合             |
| SMEMBERS  |            返回集合包含的所有元素            |
| SISMEMBER |         检查给定元素是否存在于集合中         |
|   SREM    | 如果给定的元素存在于集合中，那么移除这个元素 |



### zset

![image-20221107154113627](/Users/zhaoheng/Library/Application Support/typora-user-images/image-20221107154113627.png)

有序，键不重复

| 命令        | 行为                                                       |
| ----------- | ---------------------------------------------------------- |
| ZADD        | 将一个带有给定分数值的成员添加到有序集合里面               |
| ZRANGE      | 根据元素在有序排列中所处的位置，从有序集合里面获取多个元素 |
| ZRANGESCORE | 获取有序集合在给定分值范围内的所有元素                     |
| ZREM        | 如果给定成员存在有序集合中，那么移除这个成员               |

