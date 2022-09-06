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

推送

```
# 阿里云推送
# registry.cn-beijing.aliyuncs.com/zhangmf/pythondemo:release-0.1 是本地的docker镜像名称
# 按照 阿里云仓库地址/命名空间/仓库名称:版本号 来命名
docker push registry.cn-beijing.aliyuncs.com/zhangmf/pythondemo:release-0.1
```

