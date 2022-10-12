## DQL

1. from
2. where
3. Group by
4. having
5. select
6. order by
7. limit

#### distinct

> distinct只能出现在语句的最开始的位置 - select distinct x 
>
> distinct后面多个字段的时候，是对多个字段去重（后面多个字段的值完全相同时才会去重）

#### 笛卡尔积

- 两个表关联的时候，没有加条件就会出现笛卡尔积现象，表中每一条记录和另一个表的每一条记录去匹配
- 例 A表有数据10条， B表有数据5条，此时会匹配10 * 5 = 50条数据

```sql
select * from a,b;
```

- 当表加on或where条件时，也会出现笛卡尔积现象，当on后的条件成立后，不会停止查找，会继续查找满足on或where条件的数据

#### 自连接

- 自己连接自己，看作两张表来关联
- 用于查找父级，省份等数据

#### 多表关联

```sql
select * from a join b on a.x = b.x join c on a.x = c.x
```

- a和b关联后的结果去关联c，依次类推

子查询

##### where中的子查询

- select 语句中嵌套子查询
- where子句中不能直接分组函数 （min() 等）
- 子查询出现在where中，先执行子查询，然后执行整条sql语句

##### from后的子查询

- from后的子查询可以把结果当作一张临时表

##### select后出现的子查询

- select后的子查询不能超过一条记录，只能返回一条结果

#### union

- 进行结果集合并的时候，要求列数相同，数据类型可以不同

#### limit

- 在order by之后



## DDL

- 建表语句

```sql
create table 表名 (
	字段名 数据类型，
	字段名 数据类型,
	...
)
```

- varchar 最长255长度，超过后用clob字符大对象存储，clob最大存储4g字符串
- char最长也是255字符长度
- blob 二进制大对象，存储视频、音乐、图片等流，插入数据的时候需要使用IO流
- date 短日期类型 （年月日）
- datetime 长日期类型 （年月日时分秒）
- float 浮点类型
- double 双精度浮点类型
- clob 大字符对象

## DML

- 插入、修改、删除语句

- Str_to_date 字符串转成日期类型 str_to_date('2020-11-02', '%y-%m-%d')
- Date_format(日期类型数据，‘日期格式’)。  把日期类型数据转换成想要的日期格式。一般用于查询
- Now()函数获取当前时间，格式是datetime

## 快速复制表

```
create table xxx as select * from xxx;
insert into xxx select * from xxx;
```

## 快速删除表

- delete删除表的原理：之前的数据空间不会释放，只会清除这些数据，好处是数据还可以恢复（开启事务，删除了后不commit，rollback就回滚回来了），数据在硬盘的真实存储空间不会被释放
- truncate 直接把存储空间全部清空

## 约束

__constraint__

### 非空约束 not null

### 唯一约束 unique

- 唯一索引不约束 null，有多个null的可以插入成功

- 两个字段联合唯一索引，字段名1和字段名2联合起来唯一索引

  ```SQL
  create table xx(
  	...,
      unique (字段名1， 字段名2)
  )
  ```

  - 当一个字段同时not null 并且 unique的话，那这个约束自动成主键约束

### 主键约束 primary key (PK)

### 外键约束 foreign key (FK)

- 外键值可以为NULL
- 引用的父表的键名，父表的字段不一定非是主键，但是要具有唯一性（unique）

```mysql
alter table 表名 add constraint 外键名称 foreign key (列名) references 主表名 (主表列名);
```

```mysql
create table employee
(
    id           int unsigned auto_increment
        primary key,
    name         varchar(128) not null comment '姓名',
    salary       int          not null comment '工资',
    departmentId int unsigned not null,
    remark       varchar(255) null,
    constraint department_id
        foreign key (departmentId) references department (id)
)
    comment '工资表';
```

## 执行sql脚本的命令

```
在mysql中。可以source sql文件路径 来直接执行sql脚本文件
```

## 存储引擎

#### InnoDb

- 在数据库目录中以.ibd格式文件存储
- 支持事务，安全性高，支持回滚，恢复

## 事务(理解了事务隔离级别)

- 一个完整的业务逻辑
- 只有DML语句才有事务（insert update delete）

- 如何支持事务： 提供了一组用来记录事务性活动的日志文件。
- 事务执行过程中，每条DML操作都会记录到事务性活动的日志文件中
- 提交事务： 清空事务性活动的日志文件，持久化到数据库中
- 回滚事务： 将之前DML操作全部撤销，且清空事务性活动的日志文件

> 提交事务
>
> mysql默认情况下是自动提交事务的
>
> start transaction; // 关闭自动提交事务

- ACID

> I:隔离性
>
> 事务和事务之间的隔离级别有四个：
>
> 1.读未提交：read uncommited（最低的隔离级别）
>
> ​	事务A可以读取到事务B未提交的数据
>
> ​	存在的问题：脏读现象，读到了脏数据
>
> 2.读已提交: read commited
>
> ​	事务A只能读取到事务B提交之后的数据，解决了脏读现象
>
> ​	存在的问题：不可重复读取数据，事务开启之后，第一次读取到的数据是3条，当前事务还没有结束，可能第二次再读取的时候，读取的数据是4条，3不等于4称为不可重复读
>
> 3.可重复读: repeatable read
>
> ​	事务A开启之后，不管是多久，每一次再事务A中读取到的数据都是一致的，即使事务B将数据改变，事务A读取到的数据还是没有发生改变，这就是可重复读.
>
> ​	存在的问题：幻读，每一次读取到的数据都是幻象，不够真实
>
> ​	例如：事务二插入了一条数据，但是此时事务一又插入了一条id相等的数据，造成插入失败。但是事务一看不到事务二所插入的数据
>
> ​	* mysql中默认的隔离级别就是可重复读
>
> 4.序列化/串行化: serializable (最高的隔离级别)
>
> ​	解决上面所有的问题，效率最低，事务队列 

- 查看当前事务的隔离级别

```sql
select @@tx_isolation;
或
show variables like 'transaction_isolation';
```

- 修改全局事务的隔离级别

```sql
# 全局级别，相当于修改配置文件
set global transaction isolation level repeatable read
# 会话级别
set session transaction isolation level repeatable read;
```

## 索引

- 索引相当于一本书的目录，是为了缩小扫描范围存在的机制
- 底层就类似于java的treeset，平衡二叉树，索引也是需要排序的，在mysql中是B-tree数据结构

`实现原理`

> 1.主键和unique都会自动添加索引
>
> 2.任何一张表的一条记录在硬盘存储上都有一个硬盘的物理存储编号
>
> 3.索引是一个单独的对象，不同的存储引擎以不同的形式存在，myisam中，索引存储在一个.MYI文件中。在Innodb中索引存储在一个逻辑名称叫tableplace当中。Memory存储引擎中，索引存储在内存中， 无论索引存储在哪，都是以一个数的形式存在的（自平衡二叉树： B-tree）

<font color="red">重要</font>(原理图)



- DML语句后，索引字段需要重新排序，所以索引不要添加到经常增删改的字段上

`添加索引`

```sql
create index 索引名称 on 表名(字段名);
```

`删除索引`

```sql
drop index 索引名称 on 表名;
```

## 视图

`创建视图`

```sql
create view xxx as select * from xxx;
```

- 对试图的操作会更改原表的数据
- 视图as后面的语句只能是DQL语句
- 视图为了简化sql语句，把结构先统计出来，之后直接查询视图就可以

## 锁机制

#### 行锁

- 开销大，加快慢；会出现死锁，锁定粒度最小，锁冲突概率最低，并发度最高

#### 表锁

- 开销小，加锁快；不会出现死锁，锁定粒度大，发生锁冲突的概率高，并发度最低

#### 页锁

- 开销和加锁时间界于表锁和行锁之间；会出现死锁；锁定粒度界于表锁和行锁之间，并发度一般

```sql
#	查看数据库所有的存储引擎类型
show ENGINES
```

#### 锁冲突和死锁理解

```
为什么行级锁会出现死锁而表级锁不会
表级锁一般是指的 MyISAM 存储引擎，因为它会一次性获取所有需要的锁，所以要么全部都满足，要不就一个都没有，因此不会产生死锁。而行锁就不同了，如果 A 操作先对记录 1 加锁，然后对 2 加锁，B操作先对记录 2 加锁，后对1 加锁，这样就会产生一种情况，A 对 1 加锁，B 对 2 加锁，然后 A 等待 B 释放记录 2 的锁，B 则等待 A 释放 1 的锁，互相等待，就产生死锁了。

为什么行级锁发生锁冲突低而表级锁高，怎么理解
行锁只对操作的记录加锁，而同时操作同一条记录的概率是很低的，因此出现索冲突的概率也是很低的，而表锁不一样了，同时访问一个表的概率一般会很高，一次把整个表都锁了，所有对同一个表的操作都只能等待其它操作释放锁，因此冲突比较高

死锁与锁冲突概念如何理解？区别是啥？
死锁是两个锁互相等待，互不相让，然后大家就都僵持在那里了。锁冲突则是一种正常现象，我需要加锁，但是现在别人持有锁，我无法完成加锁操作，这就是冲突，但是我可以等待别人释放了之后重新加锁。
```



锁又分为乐观锁和悲观锁

#### 乐观锁

```
最常见的是以数据版本记录机制实现(version), 一般是通过为数据库表增加一个数字类型的 “version” 字段来实现。当读取数据时，将version字段的值一同读出，数据每更新一次，对此version值加1.  当我们提交更新的时候，判断数据库表对应记录的当前版本信息与第一次取出来的version值进行比对，如果数据库表当前版本号与第一次取出来的version值相等，则予以更新，否则认为是过期数据
```

**举例：**

1、数据库表三个字段，分别是id、value、version
 `select id,value,version from TABLE where id = #{id}`
 2、每次更新表中的value字段时，为了防止发生冲突，需要这样操作

```sql
update TABLE
set value=2,version=version+1
where id=#{id} and version=#{version}
```

#### 悲观锁

```
悲观锁就是在操作数据时，认为此操作会出现数据冲突，所以在进行每次操作时都要通过获取锁才能进行对相同数据的操作，这点跟java中的synchronized很相似，所以悲观锁需要耗费较多的时间。另外与乐观锁相对应的，悲观锁是由数据库自己实现了的，要用的时候，我们直接调用数据库的相关语句就可以了,悲观锁涉及到的另外两个锁概念就出来了，它们就是共享锁与排它锁。共享锁和排它锁是悲观锁的不同的实现，它俩都属于悲观锁的范畴
```

##### 共享锁

```
共享锁又称读锁 (read lock)，是读取操作创建的锁。其他用户可以并发读取数据，但任何事务都不能对数据进行修改，直到已释放所有共享锁。
```

```
在查询语句后面增加 LOCK IN SHARE MODE ，Mysql会对查询结果中的每行都加共享锁，当没有其他线程对查询结果集中的任何一行使用排他锁时，可以成功申请共享锁，否则会被阻塞。 其他线程也可以读取使用了共享锁的表，而且这些线程读取的是同一个版本的数据,加上共享锁后，对于update，insert，delete语句会自动加排它锁
```

##### 排他锁

```
排他锁 exclusive lock（也叫writer lock）又称写锁.
若某个事物对某一行加上了排他锁，只能这个事务对其进行读写，在此事务结束之前，其他事务不能对其进行加任何锁，其他进程可以读取,不能进行写操作，需等待其释放。 排它锁是悲观锁的一种实现
```



## 权限相关

#### 添加用户

```sql
# CREATE USER ‘username‘@’host’ IDENTIFIED BY ‘password’;
# username	登陆用户名
# host	指定可访问的 ip，如果指定所有 ip 都能访问，将其设为通配符 % 即可。
# password	登陆密码，如果密码为空则无需密码

# 创建用户且可远程登录
create user 'mffff'@'%' identified by 'Baby980915';
```

#### 添加权限

```sql
# grant privileges on database.tablename to “username”@’host’;
# privileges	用户的操作权限，如 SELECT，INSERT，UPDATE 等，如果要授予所的权限则使用 ALL。
# database	如果不指定数据库，直接 *.* 即可，如果指定数据库但不指定表名，则 database.* 即可。
# username	登陆的用户名
# host	给予授权的主机 ip，例如我想让用户A的ip使用joytom用户所授予的权限，但是不想让用户B的ip来使用joytom用户的权限

# 给用户添加插入 修改权限，所有数据库都可看到
grant insert,update on *.* to 'mffff'@'%'
```

#### 撤销权限

```sql
# 撤销（revoke）的和授予（grant）的基本一样，除了 revoke（对应 grant）和 from（对应 to）

# 撤销mffff账号的插入权限
revoke insert on *.* from "mffff"@'%';
flush privileges;
```

#### 删除用户

```sql
# 
drop user mffff@'%'
```

#### 修改用户的密码

```sql
# set PASSWORD FOR ‘username‘@’%’ = PASSWORD (‘要修改的密码’)

SET PASSWORD FOR 'mffff'@'%' = PASSWORD('123123');
```

#### 权限常用关键字

![](https://raw.githubusercontent.com/mengfeifeifeifei/image/main/img/20221012191534.png)
