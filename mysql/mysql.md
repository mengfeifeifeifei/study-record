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

### 主键约束 primary key (PK)

### 外键约束 foreign key (FK)

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



```
在mysql中。可以source sql文件路径 来直接执行sql脚本文件
```

