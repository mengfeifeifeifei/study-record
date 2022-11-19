### 编写一个SSH镜像

- 因为每一行RUN指令默认生成一个镜像层， && 连接可以减少镜像的层数，换行用 '\\' 

```dockerfile
FROM centos:7
# 安装ssh服务，生成必备文件，设置root密码
RUN yum install openssh-server openssh-clients -y && sshd-keygen && \
echo "1" | passwd --stdin root
# 暴露22端口
EXPOSE 22
# 设置容器启动时的命令
CMD ["/usr/sbin/sshd", "-D"]
```

