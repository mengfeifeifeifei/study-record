#### Linux 文件系统的结构

![](https://raw.githubusercontent.com/mengfeifeifeifei/image/main/img/20230110112107.png)

##### /bin /sbin

- bin是Binary的缩写，存放着可执行的二进制文件，比如cp,cat等命令 Linux不按后缀识别文件类型
- sbin目录是System Binary的缩写，存放的是对系统配置进行操作的命令（ifconfig等）

##### /boot

- 存放系统启动需要的文件，常见的开机引导程序。尽量不动这里文件

##### /dev

- dev是device缩写，存放所有的设备文件，在linux中，所有东西都是以文件形式存在，包括硬件设备（鼠标、键盘、硬盘分区等）

##### /etc

- 存放很多程序的配置信息，比如yum等

##### /lib

- library的缩写，类似于window系统中存在dll文件的库，包括bin和sbin中可执行文件的依赖，lib32和lib64这样的目录和lib差不多，只是操作系统位数不同

##### /media

- 会有一个以你用户名命名的文件夹，里面是自动挂载的设备，比如u盘、移动硬盘 网络设备等

##### /mnt

- 和media类似，也是设备挂载相关的文件夹，区别是这是手动挂载的地方，madia是自动挂载设备的地方

##### /opt

option的缩写，这个文件夹使用比较随意，一般来说在浏览器下载软件，安装在这里比较好，包管理工具下载的软件也可能存放在这里

##### /proc

- process的缩写，存在的是全部正在运行程序的状态信息，里面会有一堆数字命名的文件夹，数据是Process Id（PID）
- 这里的文件也不是真正的文件，是程序和内核交流的的一些信息

##### /run和/sys

- 用来存储某些程序运行时信息和系统需要的一些信息

##### /src

- service的缩写，用来存放服务数据
- web服务或ftp文件服务的资源可以存放在这里

##### /tmp

- temporary的缩写，存储一些临时文件。 在系统重启后会自动被清空

##### /usr

- 存放一些非系统必须的资源，比如用户安装的应用程序
- `/usr` 和 `/usr/local` 目录中又含有 `bin` 和 `sbin` 目录，也是存放可执行文件（命令），但和根目录的 `bin` 和 `sbin` 不同的是，这里大都是用户使用的工具，而非系统必须使用的

##### /var

- `var` 是 `variable` 的缩写， 现在该目录最主要的作用是存储日志（log）信息，比如说程序崩溃，系统异常等等信息都会记录在这里，日志文件不会自动删除，也就是说随着系统使用时间的增长，你的 `var` 目录占用的磁盘空间会越来越大，也许需要适时清理一下

##### 最后总结

如果修改系统配置，就去 `/etc` 找，如果修改用户的应用程序配置，就在用户家目录的隐藏文件里找。

你在命令行里可以直接输入使用的命令，其可执行文件一般就在以下几个位置：

```bash
/bin    
/sbin
/usr/bin
/usr/sbin
/usr/local/bin
/usr/local/sbin
/home/USER/.local/bin
/home/USER/.local/sbin
```

如果你写了一个脚本/程序，想在任何时候都能直接调用，可以把这个脚本/程序添加到上述目录中。

如果某个程序崩溃了，可以到 `/val/log` 中尝试寻找出错信息，到 `/tmp` 中寻找残留的临时文件。

设备文件在 `/dev` 目录，但是一般来说系统会自动帮你挂载诸如 U 盘之类的设备，可以到 `/media` 文件夹访问设备内容

#### 进程

- 抽线来看 计算机就是
- ![](https://raw.githubusercontent.com/mengfeifeifeifei/image/main/img/20230110140808.png)

`大矩形表示计算机内存空间，其中的小矩形代表进程，左下角的圆形表示磁盘，右下角的图形表示一些输入输出设备（鼠标、键盘等）。内存空间被分成了两块，上半部分表示用户空间，下半部分表示内核空间`

`用户空间表示用户进程需要的资源，比如在代码中new一个数组，数组肯定存在用户空间；内核空间存放内核进程需要加载的资源，一般不允许用户访问。但有些用户进程会共享一些内核空间的资源，比如动态链路库等`

`编辑代码输出hello world： 在操作系统层面，就是新建了一个进程，这个进程讲我们编译出来的可执行文件读入内存空间，然后执行，退出。`

`编译出来的可执行程序只是一个文件，不是进程，可执行文件必须要载入内存，包装成一个进程才能跑起来。进程是依赖操作系统创建的，每个进程都有它的固定属性（进程号PID、进程状态、打开的文件等），进程创建好之后，读入程序代码，才会执行`

- 进程的创建（linux源码），对于操作系统，进程就是一个数据结构

```c
struct task_struct {
	// 进程状态
	long			  state;
	// 虚拟内存结构体
	struct mm_struct  *mm;
	// 进程号
	pid_t			  pid;
	// 指向父进程的指针
	struct task_struct __rcu  *parent;
	// 子进程列表
	struct list_head		children;
	// 存放文件系统信息的指针
	struct fs_struct		*fs;
	// 一个数组，包含该进程打开的文件指针
	struct files_struct		*files;
};
```

`task_struct` 就是 Linux 内核对于一个进程的描述，也可以称为「进程描述符」。源码比较复杂，我这里就截取了一小部分比较常见的。

其中比较有意思的是 `mm` 指针和 `files` 指针。`mm` 指向的是进程的虚拟内存，也就是载入资源和可执行文件的地方；`files` 指针指向一个数组，这个数组里装着所有该进程打开的文件的指针

`files`

- 是一个文件指针数组，一般来说，一个进程会从files[0]读取输入，将输出写入files[1]，将错误信息写入files[2]
- 举例：向命令行打印字符，从进程角度来看，就是向files[1]写入数据. java的scanner函数就是进程试图从files[0]文件中读取数据
- 每个进程被创建时，files的前三位被填入默认值，分别指向标准输入流，标准输出流，标准错误流。常说的 [文件描述符] 就是指这个文件指针数组的索引（linux定时任务中经常出现的 2>1& 就是对应的这里的索引）
- ![](https://raw.githubusercontent.com/mengfeifeifeifei/image/main/img/20230110143758.png)

`输入重定向理解`：程序想要读取数据的时候就会从files[0]读取，所以只需要把files[0]指向一个文件，那么程序就会从文件中读取数据，而不是键盘

![](https://raw.githubusercontent.com/mengfeifeifeifei/image/main/img/20230110144237.png)

`输出重定向理解`：同理的，输出重定向就是把files[1]指向一个文件，那么程序的输出就不会到显示器，而是到文件中

```
command > file.txt
```

![](https://raw.githubusercontent.com/mengfeifeifeifei/image/main/img/20230110144429.png)

`2 > 1&`

```shell
 # 定时任务 错误输出和标准输出都重定向到文件中
 0 7 * * * python3 /wechat-push/start.py >> /wechat-push.log 2>&1
```

这里用图来解释下这个写法：

![](https://raw.githubusercontent.com/mengfeifeifeifei/image/main/img/20230110145329.png)

`管道符`是把一个进程的输出流和另一个进程的输入流建立起一条[管道]，数据就在其中传递

![](https://raw.githubusercontent.com/mengfeifeifeifei/image/main/img/20230110145722.png)

到这里就可以看出「Linux 中一切皆文件」设计思路的高明了，不管是设备、另一个进程、socket 套接字还是真正的文件，全部都可以读写，统一装进一个简单的 `files` 数组，进程通过简单的文件描述符访问相应资源，具体细节交于操作系统，有效解耦，优美高效

#### 线程

- 首先多进程和多线程都是并发，可以提高处理器效率，所以现在看他们的区别
- 从Linux内核角度来看，并没有把进程和线程区别对待

`系统调用fork()可以创建一个子进程，函数pthread()可以新建一个线程。但无论进程还是线程，都是用task_struct结构表示的，唯一的区别就是共享的数据区域不同`

`线程看起来跟进程没有区别，只是线程的某些数据区域和父进程是共享的，而子进程是拷贝副本，而不是共享。比如说，上面的mm结构和files结构在线程中是共享数据的`

![](https://raw.githubusercontent.com/mengfeifeifeifei/image/main/img/20230110150453.png)

![](https://raw.githubusercontent.com/mengfeifeifeifei/image/main/img/20230110150535.png)

`所以这里多线程程序要利用锁机制，避免多个线程同时往同一区域写入数据，否则可能造成数据错乱。多线程的使用为什么比多进程多？ 因为现实数据中共享的并发更普遍，比如10个人从同一账户取10元，那么希望共享账户的余额-100， 而不是每个人获取一个拷贝的账户，每个拷贝账户减10元`

- 对于新建进程内存区域拷贝的问题，Linux采用了copy-on-write的策略优化，也就是并不真正复制父进程的内存空间，而是等到需要写操作的时候才去复制，所以新建进程和线程都是很迅速的



`以上引用文章`[labuladong] (https://labuladong.gitee.io/algo/di-si-zhan-4baf4/linux-de-j-5a108/)