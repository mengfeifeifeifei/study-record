### Java原生上线

- 前端ant design pro
- 后端spring boot

#### 前端

- 设置上线后访问的地址

```typescript
export const request: RequestConfig = {
  prefix: process.env.NODE_ENV === 'development' ? 'http://60.205.216.24:8080': undefined
  // timeout: 3000
};
```

执行build打包

- 安装nginx服务器

```shell
# -o 执行要下载的url地址  nginx-1.20.2.tar.gz代表下载下来的文件名
curl -o  nginx-1.20.2.tar.gz http://nginx.org/download/nginx-1.20.2.tar.gz
# 解压
tar -zxvf nginx-1.20.2.tar.gz
# 编译
cd nginx-1.20.2/ && ./configure 
# 安装一些依赖
yum install pcre pcre-devel
yum initall openssl openssl-devel -y
yum install openssl openssl-devel -y
# 重新编译
./configure --with-http_ssl_module --with-http_v2_module --with-stream
# 安装
make && make install
# 环境变量设置
vi ~/.bash_profile
PATH=$PATH:$HOME:/usr/local/nginx/sbin
export PATH
# 环境变量生效
source ~/.bash_profile
# 启动nginx
nginx
# 查看网络状态
netstat -ntlp
# 修改nginx配置文件指向地址为ant-design-pro地址
# 可能出现nginx服务不是root用户 出现nobody用户，去nginx配置文件顶部可以修改启动为root用户
```



#### 后端

- 下载java、maven(需要就下，如果本地打包好了就不用)

```shell
yum install  -y java-1.8.0-openjdk*
curl -o maven xxxxxx
```

- 配置maven环境变量

```shell
export PATH=$PATH:/maven地址
```

- 本地maven clean， maven package -DskipTests（跳过单元测试，就是不需要执行测试就可以打包了，否则之前的测试可能有错的，就打包失败。正式环境基本都会跑一遍单元测试才打包）

- 把打包好的jar包放到服务器上

运行java程序 (后台守护进程启动  设置环境为prod，读取prod配置文件)

```shell
nohup java -jar [jar包地址] spring.profiles.active=prod &  
```

扩展命令

```shell
# 查看网络PID
netstat ntlp 
# 停止java程序进程
kill PID 
# 查看进程
ps -ef | grep xxxx
# 查看java运行状态
jobs
- [1]+  运行中               nohup java -jar mffff-yupi-user-center-0.0.1-SNAPSHOT.jar --spring.profiles.active=pord &
# 查看运行PID和程序
jps
# zip文件解压
unzip 文件名 -d 要放的文件夹名称
# 文本数据处理工具
awk [选项] '脚本命令' 文件名
选项	含义
-F fs	指定以 fs 作为输入行的分隔符，awk 命令默认分隔符为空格或制表符。
-f file	从脚本文件中读取 awk 脚本指令，以取代直接在命令行中输入指令。
-v var=val	在执行处理过程之前，设置一个变量 var，并给其设备初始值为 val
awk 会将如下变量分配给它在文本行中发现的数据字段：
$0 代表整个文本行；
$1 代表文本行中的第 1 个数据字段；
$2 代表文本行中的第 2 个数据字段；
$n 代表文本行中的第 n 个数据字段。
举例：
# 先获取yum下所有安装的包，之后从列表中找出带有java字符的结果行，awk '{print $1}'从以上的结果中获取第一列内容
yum list installed | grep java | awk '{print $1}'

#自定义终止符, EOF是END Of File的缩写，表示自定义终止符，用于多行文本输出，可以随便起名（<<BBB -开始    BBB -结束）
<<EOF  #开始
...
EOF    #结束
举例：(配合cat使用 把中间输入的命令都输出到文件test.sh中，用自定义终止符的目的就是为了可以多行文本输出)
cat <<EOF > test.sh
> 123456
> 23456
> xxxxx
>EOF
# 查看test.sh文件
cat test.sh
123456
23456
xxxxx
```



### Dockerfile

#### 前端

- Dockerfile

```dockerfile
FROM 
```



#### 后端

`扩展--from=上面的镜像别名 来完全多阶构建。 这里后面可以重要了解一下`

- Dockerfile

```dockerfile
FROM maven:3.8.1-jdk-8-slim as builder

# Copy local code to the container image.
WORKDIR /app
COPY pom.xml .
COPY src ./src

# Build a release artifact.
RUN mvn package -DskipTests

# Run the web service on container startup.
CMD ["java", "-jar", "/app/target/mffff-yupi-user-center-0.0.1-SNAPSHOT.jar", "--spring.profiles.active=prod"]
```

- 把代码上传到服务器

- 跟目录下执行 docker构建镜像

```shell
docker build -t mffff-yupi-user-center:0.0.1 .
```

```shell
# 杀掉docker容器
docker kill containerId
```



### 跨域

1. 前后端用相同的域名 根据nginx反向代理实现
2. nginx网关 添加响应头设置
3. springboot注解
4. 添加web全局请求拦截器
5. 定义新的cors bean
