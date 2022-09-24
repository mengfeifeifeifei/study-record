ctrl+h 再idea中打开类的实现类

## Spring5

- 轻量级 开源的javaee框架
- 核心部分： IOC AOP

`IOC`：控制反转，把创建对象的过程交给spring管理

`AOP`：面向切面，不修改源代码进行功能增强

#### 下载spring5

- spring.io
- ga稳定版本
- 下载 安装jar包

#### IOC

- 控制反转，目的：为了耦合度降低
- 底层逻辑：xml解析、工厂模式、反射

![image-20220919170311281](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20220919170311281.png)

`IOC（接口）`

- IOC思想基于IOC容器完成，IOC容器底层就是对象工厂
- Spring提供两种方式：（两个接口）
- 1. BeanFactory： IOC容器基本实现，是Spring内部的使用接口，不提供开发人员使用
     * 加载配置文件的时候不会创建对象，再获取对象或使用对象的时候才会去创建对象
  2. ApplicationContext：BeanFactory接口的子接口，提供更强大的功能，一般由开发人员进行使用
     * 加载配置文件的时候就会创建对象

```java
// classpath 类路径 src下
// 加载spring配置文件
ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");

// 获取配置创建的对象 ”User“为xml中配置的id名
User user = context.getBean("User", User.class);
```



#### IOC操作BEAN管理

##### 基于XML方式

- bean管理：

  两个操作

  1. spring创建对象
  2. spring注入属性

- 两种方式：

  
  
  1. 基于xml配置文件方式实现
  2. 基于注解方式实现
  
- `基于xml方式的bean管理`

  执行参数的时候，默认也是执行`无参数构造方法`完成对象创建

  ```java
  <bean id="User" class="com.mffff.spring.User"></bean>
  ```

  	1. 使用bean标签，添加属性就可以实现对象创建
  	2. 属性有：

  > // 别名，唯一标识
  >
  > id属性
  >
  > // 类全路径（包全路径）
  >
  > class属性
  >
  > // 和id功能相似，很少用，可以有特殊符号
  >
  > name属性

  `DI：依赖注入，就是注入属性`

  - set注入（name为bean的属性名，value为值）
  - 当xml的对象创建完成的时候，会自动依赖注入到bean的属性中的值（xml注入）

  ```java
  <bean id="User" class="com.mffff.spring.User">
      <property name="name" value="注入写入">					</property>
  </bean>
  ```

  `有参构造器注入`

  ```xml
  <bean id="order" class="com.mffff.spring.Order">
          <constructor-arg name="name" value="1243"></constructor-arg>
          <constructor-arg name="address" value="河北省石家庄"></constructor-arg>
  </bean>
  ```

  `p名称空间注入`（简化bean的属性值注入，了解）

  > 使用p名称空间注入，可以简化xml注入方式
  >
  > 1. 添加p名称空间再xml文件中（顶部的约束中）
  >
  >    ```
  >    xmlns:p="http://www.springframework.org/schema/p"
  >    ```
  >
  > 2. ```
  >    <bean id="order" class="com.mffff.spring.Order" p:属性名=“属性值”>
  >    </bean>
  >    ```
  >    
  
  `注入空值`
  
  ```xml
   <bean id="order" class="com.mffff.spring.Order">
          <constructor-arg name="name" value="1243"></constructor-arg>
          <constructor-arg name="address">
              <null/>
          </constructor-arg>
  </bean>
  ```
  
  `注入特殊字符`
  
  ```xml
  <bean id="User" class="com.mffff.spring.User">
          <property name="name">
              <value><![CDATA[<<测试>>]]></value>
          </property>
  </bean>
  ```
  
  `注入外部bean（注入其他的java文件）`
  
  - service注入DaoImpl方法(用ref引入)
  - 属性名userDao注入userDaoImpl
  
  ```xml
  <bean id="userService" class="com.mffff.spring.service.UserService">
          <property name="userDao" ref="userDaoImpl"></property>
  </bean>
  <bean id="userDaoImpl" class="com.mffff.spring.dao.UserDaoImpl"></bean>
  ```
  
  

- spring bean默认是单实例对象，多次获取getbean得到的对象是相同的
- <bean id="xx" class="xx.x.x" scope = "prototype"> 配置多实例对象
- singleton表示单实例（默认），prototype代表多实例
- 单实例是加载配置文件的时候就会创建对象，多实例是代码中getbean的时候去创建对象

`声明周期`

- 从对象创建到销毁

> 1. 通过构造器创建对象（无参构造器）
> 2. 为bean属性设置值和对其他bean引用（set方法）
> 3. 调用bean的初始化方法（需要进行配置）
> 4. bean可以使用了（对象获取到了）
> 5. 容器关闭时，调用bean的销毁方法（需要进行配置销毁）

- 加上前置后置操作一共7步，前置后置操纵需要在xml配置文件中配置  配置文件中配置的所有bean都会走前置和后置操作

`xml中自动装配`

- 根据指定装配规则，自动将匹配的属性值进行注入

```java
<bean id="dept" class="com.mffff.autowire.Dept"></bean>
<!--    自动装配    -->
<!--    这里要注意，bean id的名称和要和注入的属性名是一样的，也就是Emp对象中属性名是dept，上面定义的bean id的名称也同样是dept-->
<!--    byType根据类型自动注入-->
<bean id="emp" class="com.mffff.autowire.Emp" autowire="byName"></bean>
```

`引入外部属性文件`（举例数据库连接池druid的配置，可以通过变量来获取配置，而不是固定写死的）

-  在bean xml中顶部加入context上下文配置
- 引入外部属性文件 (classpath代表的是src目录，下面的druid的配置文件，property文件格式为key=value)

```xml
<context:property-placeholder localtion="classpath:jdbc.properties"></context>
```

- 实现用外部属性文件来配置数据库连接池

```xml
<bean id="xx" class="com.alibaba.druid.pool.DruidDataSource">
	<property name="driverClassName" value="${外部属性文件的key}"></property>
</bean>
```



##### 基于注解方式

- 格式： @注解名称(属性名称=属性值, 属性名称=属性值)
- 可以作用在 类、方法、属性上面

> spring针对bean管理创建对象提供的注解
>
> 1. @Component
> 2. @Service：一般用在业务逻辑层
> 3. @Controller
> 4. @Repository：一般用在DAO层、持久层

这四种注解的功能都是相同的

`创建`

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:p="http://www.springframework.org/schema/p"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
                           http://www.springframework.org/schema/context http://www.springframework.org/schema/beans/spring-context.xsd">
    <!--    开启组件扫描，要扫描哪个包下的注解,扫描mffff包下的所有package  scan扫描   -->
    <context:component-scan base-package="com.mffff"></context:component-scan>
</beans>
```

```java
// 相当于在xml文件中配置了当前类的<bean>
@Component(value = "user")
public class User {
    public void add() {
        System.out.println("user add");
    }
}
```

`属性注入`

> @autowired : 基于类型注入(用的最多，在需要注入的属性名上面添加此注解)
>
> @Qualifier : 根据属性名称注入
>
> @Resource: 可以根据类型注入，可以根据名称注入
>
> @Value：注入普通类型

`完全注解开发，替换了之前xml配置开启组件扫描`

```java
// 作为配置类，替换xml配置文件
@Configuration
// 组件扫描
@ComponentScan(basePackages = {"com.mffff"})
public class SpringConfig {

}
```

之前的

```java
ApplicationContext Context = new ClassPathXmlApplicationContext("bean2.xml");
替换为
ApplicationContext Context = new AnnotationConfigApplication(SpringConfig.class);
来加载配置文件
```

