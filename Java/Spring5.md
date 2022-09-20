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
  
  ```xml
  <bean id="userService" class="com.mffff.spring.service.UserService">
          <property name="userDao" ref="userDaoImpl"></property>
  </bean>
  <bean id="userDaoImpl" class="com.mffff.spring.dao.UserDaoImpl"></bean>
  ```
  
  