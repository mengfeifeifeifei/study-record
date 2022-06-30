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

#### 上传到自己的DockerHub上

```
```

