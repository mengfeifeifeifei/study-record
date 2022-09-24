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

- 键表语句

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

- 外键值可以为NULl
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

- 在数据库目录中以.frm格式文件存储
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
> ​	事务A开启之后，不管是多久，每一次再事务A中读取到的数据都是一致的，即使事务B将数据改变，事务A读取到的数据还是没有发生改变，这就是可重复读
>
> ​	存在的问题：幻读，每一次读取到的数据都是幻象，不够真实
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
set global transaction isolation level repeatable read
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
