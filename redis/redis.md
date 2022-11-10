### string

![](https://raw.githubusercontent.com/mengfeifeifeifei/image/main/img/20221107152341.png)

|    命令     |                       行为                       |
| :---------: | :----------------------------------------------: |
|     GET     |                获取存储在键中的值                |
|     SET     |                设置存储在键中的值                |
|     DEL     |          删除给定的键（适用于所有类型）          |
|    INCR     |                 将键存储的值加1                  |
|    DECR     |                 将键存储的值减1                  |
|   INCRBY    |      将键存储的值加自定义数 INCRBY KEY num       |
|   DECRBY    |      将键存储的值减自定义数 DECRBY KEY num       |
| INCRBYFLOAT | 将键存储的值加自定义浮点数 INCRBYFLOAT KEY float |

| 命令     | 行为                                                         |
| -------- | ------------------------------------------------------------ |
| APPEND   | 将值value追加到给定键的值末尾(APPEND KEY value)              |
| GETRANGE | 获取一个由偏移量start至end范围内的所有字符组成的子串，包括start和end (GETRANGE KEY start end) |
| SETRANGE | 将从offset偏移量开始的字符串设置为给定值 (SETRANGE KEY offset value) |



### hash

![image-20221107153756189](/Users/zhaoheng/Library/Application Support/typora-user-images/image-20221107153756189.png)

| 命令    | 行为                                                         |
| ------- | ------------------------------------------------------------ |
| HSET    | 在散列里面设置键值对                                         |
| HGET    | 获取指定散列键的值                                           |
| HGETALL | 获取散列包含的所有键值对 (hgetall key-name)                  |
| HDEL    | 如果给定的键存在于散列中，移除这个键                         |
| HLEN    | 返回散列包含的键值对数量 (hlen key-name)                     |
| HEXISTS | 检查给定的键是否存在散列中 (hexists key-name field)          |
| HKEYS   | 获取散列包含的所有键 (hkeys key-name)                        |
| HVALS   | 获取散列包含的所有值 (hvals key-name)                        |
| HINCRBY | 将键key存储的值加上整数increment (hincrby key-name field increment) (hincrbyfloat key-name field increment) |



### list

![](https://raw.githubusercontent.com/mengfeifeifeifei/image/main/img/20221107153026.png)

|   命令    |                             行为                             |
| :-------: | :----------------------------------------------------------: |
|   RPUSH   |                    将给定值推入列表的右端                    |
|  LRANGE   |                 获取列表在给定范围上的所有值                 |
|  LINDEX   |                获取列表在给定位置上的单个元素                |
|   LPOP    |             从列表的左端弹出一个值，返回弹出的值             |
|  LINDEX   |     返回列表中偏移量为offset的元素（LIINDEX KEY offset）     |
|   LTRIM   | 对列表进行修剪 只保留从start偏移量到end偏移量范围内的元素，其实偏移量为start和偏移量为end的元素会被保留(LTRIM KEY start end) |
|   BLPOP   | 移出并获取列表的第一个元素， 如果列表没有元素会阻塞列表直到等待超时或发现可弹出元素为止(BLPOP LIST [LIST1] TIMEOUT) |
|   BRPOP   | 移出并获取列表的最右端元素， 如果列表没有元素会阻塞列表直到等待超时或发现可弹出元素为止(BLPOP LIST [LIST1] TIMEOUT) |
| RPOPLPUSH | 从source-key列表中弹出最右端的元素，然后将和这个元素推入到dest-key列表的最左端，并向用户返回这个元素(RPOPLPUSH source-key dest-key) |

| BRPOPLPUSH | 从source-key列表中弹出最右端元素，然后将这个元素推入到dest-key列表的最左端，并向用户返回这个元素； 如果source-key为空，那么在timeout秒之内阻塞并等待可弹出的元素出现 |
| ---------- | ------------------------------------------------------------ |



### set

![](https://raw.githubusercontent.com/mengfeifeifeifei/image/main/img/20221107153320.png)

无序，不重复

|    命令     |                             行为                             |
| :---------: | :----------------------------------------------------------: |
|    SADD     |                     将给定的值添加到集合                     |
|  SMEMBERS   |                    返回集合包含的所有元素                    |
|  SISMEMBER  |                 检查给定元素是否存在于集合中                 |
|    SREM     |         如果给定的元素存在于集合中，那么移除这个元素         |
|    SCARD    |                    返回集合包含的元素数量                    |
| SRANDMEMBER | 从集合里面随机返回一个或多个元素，当count为正数时，命令返回的随机元素不会重复；当count为负数时，命令返回的随机元素可能出重复(srandmember key-name [count]) |
|    SPOP     | 随机移除集合中一个元素，并返回被移除的元素（spop key-name）  |
|    SMOVE    | 如果集合source-key包含元素item，那么从集合source-key里面移除元素item，并将元素item添加到集合dest-key中，如果item被成功移除，那么命令返回1，否则返回0 (smove source-key dest-key item) |
|    SDIFF    | 返回哪些存在于第一个集合，但不存在于其他集合中的元素 (sdiff key-name [key-name...]) |

|    命令     |                             行为                             |
| :---------: | :----------------------------------------------------------: |
| SDIFFSTORE  | 将那些存在于第一个集合但不存在于其他集合中的元素 存储到dest-key键里面a (sdiffstore dest-key key-name [key-name ...]) |
|   SINTER    | 返回那些同时存在于所有集合中的元素 (sinter key-name [key-name ...]) |
| SINTERSTORE | 将那些同时存在于所有集合的元素保存到dest-key的键里面 (sinterstore dest-ket key-name [key-name ...]) |
|   SUNION    | 返回那些至少存在于一个集合中的元素，相当于数学的并集 (sunion key-name [key-name ...]) |
| SUNIONSTORE | 返回那些至少存在于一个集合中的元素，并将其存到键dest-key的键里面 (sunionstore dest-key key-name [key-name ...]) |



### zset

![image-20221107154113627](/Users/zhaoheng/Library/Application Support/typora-user-images/image-20221107154113627.png)

有序，键不重复

| 命令        | 行为                                                         |
| ----------- | ------------------------------------------------------------ |
| ZADD        | 将一个带有给定分数值的成员添加到有序集合里面                 |
| ZRANGE      | 根据元素在有序排列中所处的位置，从有序集合里面获取多个元素   |
| ZRANGESCORE | 获取有序集合在给定分值范围内的所有元素                       |
| ZREM        | 如果给定成员存在有序集合中，那么移除这个成员                 |
| ZCARD       | 返回有序集合包含的成员数量                                   |
| ZINCRBY     | 将member成员的分值加上increment (zincrby key-name increment member) |
| ZCOUNT      | 返回分值介于min和max之间的成员数量 (zcount key-name min max) |
| ZRANK       | 返回成员member在有序集合中的排名 (zrank key-name member)     |
| ZSCORE      | 返回成员member的分值 (zscore key-name member)                |

| 命令             | 行为                                                         |
| ---------------- | ------------------------------------------------------------ |
| ZREVRANK         | 返回有序集合里成员member的排名，成员按照分值从大到小排序 (zrevrank key-name member) |
| ZREVRANGE        | 返回有序集合给定排名范围内的成员，成员按照分值从大到小排序 (zrevrange key-name start stop [withscores]) |
| ZRANGEBYSCORE    | 返回有序集合中，分值位于min和max之间的所有成员 (zrangebyscore key-name min max [withscores] [limit offset count]) |
| ZREVRANGEBYSCORE | 获取有序集合中分值位于min和max之间的所有成员，并按照分值从大到小的顺序来返回它们 (zrevrangebyscoore key-name max min [withscores] [limit offset count] ) |
| ZREMRANGEBYRANK  | 移除有序集合中排名介于start和stop之间的所有成员 (zremrangebyrank key-name start stop) |
| ZREMRANGEBYSCORE | 移除有序集合中分值介于min和max之间的所有成员 (zremrangebyscore key-name min max) |
| ZINTERSTORE      | 计算给定的一个或多个有序集的交集，其中给定 key 的数量必须以 numkeys 参数指定，并将该交集(结果集)储存到 destination ( ZINTERSTORE destination numkeys key [key ...] ) |



### 发布与订阅

| 命令         | 行为                                                         |
| ------------ | ------------------------------------------------------------ |
| SUBSCRIBE    | 订阅给定的一个或多个频道 (subscribe channel [channel ...])   |
| UNSUBSCRIBE  | 退订给定的一个或多个频道，如果没有给定任何频道，那么退订所有频道 (unsubscribe [channel [channel ...]]) |
| PUBLISH      | 向给定频道发送消息 (publish channel message)                 |
| PSUBSCRIBE   | 订阅与给定模式相匹配的所有频道 (psubscribe pattern [pattern ...]) |
| PUNSUBSCRIBE | 退订给定的模式，如果没有给定任何模式，那么退订所有频道 (punsubscribe [pattren [pattren ...]]) |



### 排序

| 命令 | 行为                                                         |
| ---- | ------------------------------------------------------------ |
| SORT | 根据跟定的选项，对列表、集合或者有序集合进行排序 （sort source-key ） |