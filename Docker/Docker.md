#### 拉取镜像

```
docker pull nginx
```

#### 运行镜像

```
docker run -d --name nginx-v1 -p 80:80 nginx:latest
```

#### 进入容器

```
docker exec -it nginx-v1 /bin/sh
```

#### 更新apt-get

```
# 因为不能tab补全，没有vi vim等命令，需要先update
apt-get update
```

#### 安装vi vim等

```
# 补全的包
apt-get install bash-completion
# vi
apt-get install vi
```

#### 登录

```
# $CI_HARBOR_PASSWORD 是密码 
# $CI_HARBOR_USER 是用户账号
# 都是配置的环境变量 stdin方式输入密码（安全，历史命令中看不到密码输入的是什么）
# echo $CI_HARBOR_PASSWORD 会自动补充到密码那里
# registry.cn-beijing.aliyuncs.com 阿里云镜像仓库
echo $CI_HARBOR_PASSWORD | docker login -u $CI_HARBOR_USER --password-stdin registry.cn-beijing.aliyuncs.com
```

#### 标签

```
# ImageId 镜像ID 或者 镜像名称
# registry.cn-beijing.aliyuncs.com/zhangmf/pythondemo:release-0.1 命名规范-仓库地址/命名空间/仓库名称（镜像名）:版本
# 如果不填仓库地址 默认是docker仓库
# 本地的镜像名要设置成 仓库地址/命名空间/仓库名称（镜像名）:版本号 格式
# 之后再推送
docker tag ImageId registry.cn-beijing.aliyuncs.com/zhangmf/pythondemo:release-0.1
```

#### 推送

```
# 阿里云推送
# registry.cn-beijing.aliyuncs.com/zhangmf/pythondemo:release-0.1 是本地的docker镜像名称
# 按照 阿里云仓库地址/命名空间/仓库名称:版本号 来命名
docker push registry.cn-beijing.aliyuncs.com/zhangmf/pythondemo:release-0.1
```

#### EXPOSE和PORT区别

Docker-compose中

```
port暴露容器端口到主机的任意端口或指定端口
ports:
	- "80:80"  # 前面的代表主机端口，后面代表容器端口

expose暴露给link到当前容器的容器，或者暴露给同一个network的容器
expose:
	- "3000"
	- "8000"
```

Dockerfile中

```
Expose声明了哪些端口是将要开放的,是标记信息，不能直接打开端口，只是一种文档表述方式，规范。
如果docker run -P 启动，会用到docker build 这个dockerfile中的expose，把expose的端口随机映射到宿主机的任意高阶端口（值大的端口）， 但是如果要想宿主机的某一个固定端口和容器的端口建立连接，还是需要docker run -p 宿主机端口:容器端口 方式来启动，且容器端口是这个容器中启动的服务的端口，比如redis，那容器端口我要写6379.  docker run -p 会覆盖expose暴露的端口
```

#### 数据卷挂载

##### 容器卷挂载

数据的覆盖问题

1. 如果挂载一个空的数据卷到容器中的一个非空目录中，那么容器中的这个目录下的文件会被复制到数据卷中
2. 如果挂载一个非空的数据卷到容器的一个目录中，那么容器中的目录中会显示数据卷中的数据。如果容器原来的目录中有数据，那么这些原始数据会被隐藏

```
数据卷可以保证数据在容器删除或停止后数据不会丢失，保存到宿主机中
多个容器间共享数据，共享数据卷中的数据
```

```docker
创建数据卷：docker volumn creare 
查询数据卷：docker volumn ls
查看数据卷详细信息：docker volumn inspect 
删除数据卷：docker volumn rm
```

Mysql举例

```
# 创建mysql数据卷
docker volumn create mysql 
# 查看创建的数据卷
docker volumn ls
# 运行mysql同时挂载数据卷
docker run --name=mysql -v mysql:/var/lib/mysql -d -p 3306:3306 -e MYSQL_ROOT_PASSWORD=1 容器名
# 此时宿主机mysql数据卷中会存在容器中/var/lib/mysql下的文件，因为宿主机mysql数据卷是空的。
```

##### 绑定挂载

1. 数据卷挂载存在两个问题， 一不能够挂载自己创建的宿主机上的目录，二是不能挂载宿主机的某个文件到容器

- 绑定挂载和数据卷挂载不同在于 数据卷是可以实现宿主机到容器以及容器到宿主机的双向挂载，而绑定挂载只能实现宿主机到容器的挂载，是单向的

```
-v 宿主机目录:容器目录
```

#### Docker网络

> 安装docker服务后，默认会创建3种网络模式，分别是bridge host none，命令docker network ls
