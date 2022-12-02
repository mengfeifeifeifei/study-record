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

#### 文件复制

```
# 将主机/www/file文件夹复制到容器的/www目录下
docker cp /www/file 容器id:/www/
# 将主机/www/file文件夹复制到容器中并重命名为www
docker cp /www/file 容器id:/www
# 将容器的/www目录拷贝到主机中的/tmp中
docker cp 容器id:/www /tmp/
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

```
NETWORK ID     NAME              DRIVER    SCOPE
6cab44e7f02a   bridge            bridge    local
16d63e6c819a   compose_default   bridge    local
7fc4b9d73b58   host              host      local
4128105bac13   none              null      local
```

- NETWORK ID  --> 网络的ID号
- DRIVER           --> 驱动
- SCOPE            --> 网络作用范围

运行镜像创建容器时，默认使用bridge网络模式，可以使用 docker run --network=选项进行指定

--network选项值有四种，分别是

1. bridge模式表示容器使用独立的network namespace空间，默认模式下，容器连接到docker0虚拟网卡。 通过docker0网桥以及iptables表配置与宿主机通信

2. host模式表示容器不会虚拟出自己的网卡，配置自己的IP地址等，而是使用宿主机的网卡和IP地址，与宿主机在同一个网络中，IP地址就是宿主机的IP地址
3. container模式表示新创建的容器和已经存在的容器共享一个network namespace，而不是和宿主机共享，新创建的容器不会创建自己的网卡，配置自己的IP，而是和指定的容器共享IP、端口范围等，两个容器除了网络方面，其他如文件系统、进程列表等还是隔离的，container模式适合两个容器频繁通信的场景
4. none模式表示将容器放置在它自己的网络栈中，不对网络进行任何配置，关闭了容器的网络功能，通常用在容器并不需要网络的场景中，如磁盘卷的批处理任务。

![docker0虚拟网卡](https://raw.githubusercontent.com/mengfeifeifeifei/image/main/img/20221119105624.png)

#### ssh服务

- 安装ssh服务，允许远程用户使用用户名和密码登录服务器

```
docker pull centos:7
# -d作用是容器进程和当前的终端无关
# -it 的作用是启动一个和容器交互的终端，这样容器才会一直保持运行，否则会因为没有运行的应用而关闭
docker run --name=centos7 -itd Image ID /bin/bash
docker exec -it Container ID /bin/bash
# 安装openssh服务的服务端 客户端和相关依赖
yum install openssh-server openssh-clients -y
# 生成ssh服务文件
sshd-keygen
# 设置root用户和密码
passwd root
# 运行ssh服务 -D是以非后台守护进程方式运行，否则容器就退出了
/usr/sbin/sshd -D
# 宿主机访问ssh服务
docker inspect 容器ID
ssh root@容器IP
# 打包成镜像
docker commit 容器ID centos_ssh:v1
# 测试ssh服务镜像
docker run --name=ssh -p 23:22 centos_ssh:v1 /usr/sbin/sshd -D
```

#### Dockerfile

指令可以分为两种： 构建指令和设置指令，构建指令用于构建镜像，其指定的操作不会在运行镜像的容器上执行，设置指令的操作将在运行镜像的容器中执行

1. FROM  - 指定基础镜像

> FROM构建指令，必须制定且需要在Dockerfile其他指令前面，后续的指令都依赖该指定镜像。可以是官方远程仓库，也可以位于本地仓库

2. MAINTAINER

> 构建指令，指定镜像创建者的信息，格式MAINTAINER<>

3. RUN

> RUN构建指令，RUN可以运行任何基础镜像支持的命令。 两种格式：
>
> 1）shell脚本执行格式:
>
> ​		RUN 命令
>
> 2）执行文件格式:
>
> ​		RUN ["executable", "param1", "param2"]

4. EXPOSE

> 设置指令，指令会将容器中的端口映射成宿主机中的某个端口。需要访问容器的时候，可以使用宿主机的IP地址和映射后的端口访问容器应用。
>
> 首先在Dockerfile使用EXPOSE设置需要映射的容器端口，然后在运行容器的时候指定-p选项加上宿主机端口和EXPOSE设置的端口， EXPOSE可以一次性设置多个端口，同样-p页可以使用多次。
>
> 格式：
>
> EXPOSE 端口1
>
> EXPOSE 端口1 端口2 端口3

5. ENV

> ENV构建指令，在镜像中设置一个环境变量
>
> 格式：
>
> ENV key value
>
> 设置后，后续的RUN命令都可以使用，容器启动后，可以通过docker inspect查看这个环境变量，也可以通过在运行docker run --env key=value时设置和修改环境变量

6. ADD

> ADD构建指令可以从src路径复制文件到容器的dest路径
>
> 格式：
>
> ADD src desc
>
> src是被构建的源目录的相对路径，可以是文件或目录的路径，也可以是一个远程的文件url
>
> dest是容器中的绝对路径
>
> 注意：
>
> 1). 如果源路径是个文件，并且目标路径是以'/'结尾， 则Doker会把目标路径当作一个目录，把源文件复制到该目录下。如果目标路径不存在，则会自动创建目标路径
>
> 2). 如果源路径是个文件，且目标路径不是以'/'结尾，则Docker会把目标路径到做一个文件。如果目标路径不存在，会以目标路径为名创建一个文件，内容同源文件；如果目标文件是个存在的文件，会用源文件覆盖它，只是覆盖内容。 如果目标文件实际是个存在的目录，则源文件会复制到该目录下，这种情况下，最好以'/'结尾目标文件，避免混淆
>
> 3). 如果源路径是个目录，且目标路径不存在，则Docker会自动以目标路径创建一个目录，把源路径下的所有内容复制进来，如果目标路径是个已存在的目录，则Docker会把源路径目录下的文件复制到该目录下
>
> 4). 如果源文件是个归档文件（压缩文件），则Docker会自动将其解压

7. COPY

> COPY指令同样能够将主机本地的文件或目录复制到镜像文件系统
>
> exec用法:
>
> ​		COPY ["src", "dest"]
>
> shell用法:
>
> ​		COPY src dest
>
> COPY指令和ADD指令的区别在于欧是否支持从远程URL获取资源，COPY指令只能从所在的主机上读取资源并复制到镜像中，而ADD指令还支持通过URL从远程服务器读取资源复制到镜像中，ADD还能够实现复制时解压文件

8. VOLUMN

> VOLUMN设置指令，使容器中的一个目录具有持久化存储数据的功能，容器使用的是AUFS系统不能持久化数据。当容器关闭后，所有的更改都会丢失。当容器中的应用具有持久化数据的需求时，可以在Dockerfile中使用该指令
>
> 格式：
>
> FROM baseVOLUMN ["/tmp"]
>
> 运行镜像后，在容器关闭后，/tmp目录中的数据持久化到宿主机中

9. WORKDIR

> WORKDIR设置指令，可以切换目录（相当于cd目录）
>
> 格式：
>
> WORKDIR /path

10. CMD

> CMD设置指令，用于设置容器启动时指定的操作。该操作可以是执行自定义脚本，也可以是执行系统命令。 指令只能在文件中存在一次，如果有多个，执行最后一个
>
> 格式：
>
> CMD ["executable", "param1", "param2"]
>
> CMD command param1 param2
>
> CMD ["param1", "param2"]. --> 当Dockerfile指定了ENTRYPOINT，使用该格式，这种格式是作为ENTRYPOINT命令的参数，param1和param2作为参数执行

11. ENTRYPOINT

> 设置指令，指定容器启动时执行的命令，可以多次设置，但是只有最后一个有效。
>
> 格式：
>
> ENTRYPOINT ["executable", "param1", "param2"]
>
> ENTRYPOINT command param1 param2
>
> 当独立使用时，同时使用了CMD和ENTRYPOINT指令，那么只有最后一个CMD或ENTRYPOINT指令有效
>
> 和CMD结合使用时，格式：
>
> FROM centos
>
> ENTRYPOINT ["tail"]
>
> CMD ["-f", "/etc/passwd"]

12. USER

> USER设置指令，设置启动容器的用户，默认时root用户	

