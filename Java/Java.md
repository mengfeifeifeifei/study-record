### 学习路线

- javaSE基础
- java8
- 练手一些项目

#### 巩固基础（可以跳过）

#### 企业开发（之后开发自己系统）

#### 进阶 

- 缓存
- 微服务
- 容器
- ......

#### 高级

- 并发
- jvm
- 分布式
- DDD
- 服务网格



### Java

#### JRE和JDK

- JVM , java虚拟机

- JRE， java运行环境，包含了JVM和java的核心类库

- JDK 称为java开发工具，包含了JRE和开发工具

  ![image-20220310105108941](/Users/zhaoheng/Library/Application Support/typora-user-images/image-20220310105108941.png)



#### 标识符

- java所有组成部分都需要名字。类名、变量名以及方法名都被称为标识符



#### 变量 常量

> 类变量

```
static String name = 'zhang';  // 不用实例化 可以直接在下面函数中调用  从属于当前类
```

> 常量

```
final static double PI = 3.14; // final定义常量。static 类变量 不需要实例化直接调用
```

#### 方法

- 修饰符 可选的，定义了方法的访问类型
- 返回值类型
- 方法名
- 参数类型
- 方法体
- 多个方法名可以相同，但是参数的个数或者类型必须不同



### JDBC

```
包
java.sql
javax.sql
```

还需要数据库驱动包



spring 调用过程 

> Controller-->service接口-->serviceImpl-->dao接口-->daoImpl-->reposotory接口-->repositoryImpl-->mapper-->db



@Override 一般出现在servicelmpl实现类的方法上，要实现接口中定义的方法，通过类重写，加上此注解，会帮助检测方法重写的正确性。

例如 ： 方法名是否和接口中一致 方法的传参是否一致等

```
- 下面的文件定义的方法名参数等要和父类一样 检测
AssistaneRepo.java
public interface AssistantRepo {
    List<Assistant> findByCondition(SearchAssistantOption option);

    long countByCondition(SearchAssistantOption option);
}

AssistantRepoImpl.java
public class AssistantRepoImpl implements AssistantRepo {

    @Override
    public List<Assistant> findByCondition(SearchAssistantOption option) {
        return assistantMapper.findByCondition(option);
    }

    @Override
    public long countByCondition(SearchAssistantOption option) {
        return assistantMapper.countByCondition(option);
    }
}
```



### 二进制转换



### 关键字 标识符

`关键字就是java自己保留的单词，例如 public class 等`

`标识符就是自己定义的类名 方法名 变量名等`

### 数据类型

| 四大类 | 八种基本数据类型 | 所占字节       |
| ------ | ---------------- | -------------- |
| 小数   | float            | 4              |
|        | Double           | 8              |
| 布尔   | Boolean          | 1              |
| 字符   | Char             | 2              |
| 整形   | byte             | 1   (-128-127) |
|        | short            | 2              |
|        | Int              | 4              |
|        | Long             | 8              |

### 类型转换

#### 自动类型转换

```java
// 小类型转大类型
byte a = 10;
int b = a;
```

#### 表达式类型转换

```java
// 表达式中最终结果数据类型是由最高类型决定的
// byte short char是自动转成int类型进行计算的
byte a = 10;
int b = 20;
double c = 1.0;
double d = a + b + c;  // 用double类型接
System.out.println(d);
```

#### 强制类型转换

```java

// 转换过程：
// int占4个字节 一共32bit  强转成byte时， 因为byte占1字节，所以取最后8位
// 最后8位中 第一位为0是正数 第一位为1是负数，负数的话就反码 补码 计算出来的值就是最后的结果
int a = 200;
byte b = (byte) b;
System.out.println(b);  // -56

// 浮点数转整形 丢掉小数部分
double score = 99.5;
int it = (int) score;
System.out.println(it);  // 99
```

### 运算符

#### 算数运算符

`+ - * / %`

`自增 自减`

#### 赋值运算符

`+= -+ *= /= %=`

#### 关系运算符

`==  !=  >  >=  <  <=`

#### 逻辑运算符

`& | ! ^`

`^： 两个条件都是false或者都是true则结果是false， 两个条件不同结果是true`

#### 三元运算符

`条件表达式? 值1:值2`

```java
int i = 40;
int j = 50;
int k = 60;
int temp = i > j ? i : j;
int temp1 = temp > k ? temp : k;
System.out.println(temp1);

int max = i > j ? i > k? i : k :j > k ? j : k;
System.out.println(max);
```

### 键盘录入

`java.util.Scanner`

### 流程控制语句

#### 分支结构

`if switch`

```
switch 表达式类型 不支持double float long 
// switch (表达式类型)
注意：要加break。否则会造成switch穿透
```

#### 循环结构

`for while`

### 随机数

`Random`

```java
Random random = new Random();
int num = random.nextInt(10);  // 0-9
int num = random.nextInt(10)+1;  // 1-10
```

### 数组(堆内存)

> 数据类型[] 变量名 = new 数据类型[]{数据}
>
> 数据类型[] 变量名 = new 数据类型[长度]

#### 遍历

```java
int[] age = {20,30,40};
for (int i = 0; i < age.length; i++) {
  System.out.println(i);
}
```

### 内存分配介绍

- 栈内存

> 方法运行时所进入的内存(例如main方法)，变量也是在这里

- 堆内存

> new出来的东西会在这块内存中开辟空间并产生地址

- 方法区

> 字节码文件加载时进入的内存  （ *.class文件）

<font color="red" size=4>⭐️重点</font>

![](https://github.com/qingjiaowonanshenfei/image/raw/main/WechatIMG100.jpeg)

![](https://github.com/qingjiaowonanshenfei/image/raw/main/WechatIMG101.png)

### 构造器（重载）

- 类中默认存在构造器
- 当自定义新构造器并且传参字段时，默认构造器失效

```java
public class Demo {
		// 默认的构造器
		public Demo() {}
		// 自定义传参构造器
		public Demo(int id) {
			System.out.println(id);
		}
}
```

- Main 方法只是入口方法， new类的时候main方法不会自动执行

#### this

### 封装

JavaBean

> 成员变量使用private私有
>
> Get set 方法
>
> 提供无参构造器

### 变量

![image-20220421175935707](/Users/zhaoheng/Library/Application Support/typora-user-images/image-20220421175935707.png)

![image-20220421181035687](/Users/zhaoheng/Library/Application Support/typora-user-images/image-20220421181035687.png)



- 字符串对象是不可变的对象的理解，字符串存储的也是地址，只不过结果是地址的结果

![image-20220421190742368](/Users/zhaoheng/Library/Application Support/typora-user-images/image-20220421190742368.png)

![image-20220421190855201](/Users/zhaoheng/Library/Application Support/typora-user-images/image-20220421190855201.png)

- 双引号方式的字符串对象，在常量池中相同内容只存储一份

![image-20220421192118904](/Users/zhaoheng/Library/Application Support/typora-user-images/image-20220421192118904.png)



![image-20220421192255913](/Users/zhaoheng/Library/Application Support/typora-user-images/image-20220421192255913.png)

![image-20220421192525209](/Users/zhaoheng/Library/Application Support/typora-user-images/image-20220421192525209.png)

![image-20220421192659872](/Users/zhaoheng/Library/Application Support/typora-user-images/image-20220421192659872.png)





### ArrayLIst

- 可变长的原理：

- 底层基于数组，默认首次创建长度为10 的数组
- 每次插入的时候与总长度相等了，就会进入到扩容中，每次扩容‘到’1.5倍 乘1.5

#### 遍历（三种方式）

```
ArrayList<Movie1> objects = new ArrayList<Movie1>();
for (Movie1 object : objects) {

}
```

```
ArrayList<Movie1> objects = new ArrayList<Movie1>();
Iterator<String> iterator = objects.iterator();
while (iterator.hasNext()) {
			String next = iterator.next();
}
```

```
// lambda 表达式
objects2.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {

            }
        });
或
objects2.forEach(s -> {
            System.out.println(s);
        });
```



![image-20220630155516643](/Users/zhaoheng/Library/Application Support/typora-user-images/image-20220630155516643.png)



### LinkList

- 队列和栈的操作

### 数据结构

#### 栈

- 后进先出，先进后出

- 压栈（进栈）
- 弹栈（出栈）

#### 队列

- 先进先出，后进后出

#### 数组

- 连续内存区域
- 查询速度快（查询任意数据耗时相同，查索引）
- 删除效率低（删了数据之后，其他数据需要往前移）
- 添加效率低

#### 链表

- 元素在内存中不连续存储，每个元素节点包含树值和下一个元素的地址
- ![image-20220630161726151](/Users/zhaoheng/Library/Application Support/typora-user-images/image-20220630161726151.png)
- 查询比较慢（因为查询要从头开始找）
- ![image-20220630161817829](/Users/zhaoheng/Library/Application Support/typora-user-images/image-20220630161817829.png)
- 增删相对较快

![image-20220630162017557](/Users/zhaoheng/Library/Application Support/typora-user-images/image-20220630162017557.png)

#### 双链表

![image-20220630162218881](/Users/zhaoheng/Library/Application Support/typora-user-images/image-20220630162218881.png)

#### 二叉树、二叉查找树

![image-20220630162846950](/Users/zhaoheng/Library/Application Support/typora-user-images/image-20220630162846950.png)

- 根节点、左子树、右子树
- 每个节点最后支持两个字节点

#### 平衡二叉树

- 二叉树可能存在问题，比如所有的数据都比根节点大，那么数据都放在右子树了，不够平衡
- 树尽量矮小，数据查询效率提高
- 当数不平衡时 通过左旋和右旋来平衡数
- 两边节点相差度为1

#### 红黑树

![image-20220630165823928](/Users/zhaoheng/Library/Application Support/typora-user-images/image-20220630165823928.png)

### 泛型

- 

### Hash

#### 底层原理

![image-20220701154627203](/Users/zhaoheng/Library/Application Support/typora-user-images/image-20220701154627203.png)

### ...可变参数

```
public static void run(int... nums) {} // nums为数组 
```

### HashMap

> 无序、 不重复、 无索引。 跟hashSet原理相同， hashSet是用的hashmap底层
>
> hashSet是根据map的键去重复的
>
> HashMap依赖hashcode和equals判断键的唯一

### LinkedHashMap

> 有序、 不重复、 无索引

### TreeMap

> 不重复、 无索引、 必须排序（只能按照键排序，会自动排序， 当排序的时候有两个相同的就会只保留一个） 

### 不可变集合

- jdk9之后貌似才有

- 不可变集合，就是不可修改的集合
- 在创建的时候提供

```
List.of("");
map.of("k1", "v1", "k2", "v2", ...);
set.of("");
```

### stream流

![image-20220705153457458](/Users/zhaoheng/Library/Application Support/typora-user-images/image-20220705153457458.png)



-  终结方法不会放回stream流 所以终结

### 异常

![image-20220705172811030](/Users/zhaoheng/Library/Application Support/typora-user-images/image-20220705172811030.png)

- 默认的异常处理流程

![image-20220705174748026](/Users/zhaoheng/Library/Application Support/typora-user-images/image-20220705174748026.png)

### File

```java
// File创建对象 可以使用绝对路径 也可以使用相对路径(定位模块中的文件),相对路径相对到工程下
File file = new File("文件路径") 
```

```java
// 查找目录下的某个文件位置
public static void main(String[] args) {
        File f = new File("/Users/zhaoheng/working");
        searchFile(f, "Vue.md");
    }

    public static void searchFile(File dir, String fileName) {
        // 如果文件夹不存在返回null
        // 如果文件夹存在但是文件夹中是空的 那么返回 []
        if (dir != null && dir.isDirectory()) {
            File[] fileList = dir.listFiles();
            if (fileList != null && fileList.length > 0) {
                for (File file : fileList) {
                    if (file != null && file.isFile()) {
                        if (file.getName().contains(fileName)) {
                            System.out.println("文件路径:" + file.getAbsoluteFile());
                            return;
                        }
                    } else {
                        searchFile(file, fileName);
                    }
                }
            }
        } else {
            System.out.println("文件操作有误，不支持!");
        }
    }
```



### 字符集

- Ascii  unicode gbk
- ascii是美国研究，不包含中文，只有数字和英文
- unicode下常用的utf-8，兼容了中英文，中文以3个字节表示
- gbk为中国研究，中文以2字节保存
- 所有的字符和数字都是一个字节

### IO输入输出流

- 字节
- 字符

### 缓冲流

- 可以提高读写的性能

![image-20220713174255268](/Users/zhaoheng/Library/Application Support/typora-user-images/image-20220713174255268.png)

