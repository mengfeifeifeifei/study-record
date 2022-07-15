#### 语法

#### 在标签中的叫插值语法

```Vue
<div id="test">
        <h1>Hello, World!, {{name}}</h1>
</div>
// 创建一个实例
    // 只传一个参数，传对象
    // el: element
    new Vue({
        el: '#test', // el用于指定当前vue实例为哪个容器
        data: {      // 数据供el所对应的容器使用， 值暂时先写成一个对象
            name: 'fei'
        }
    });
```

#### v-bind语法(指令语法)， 单向绑定

```vue
<div id="url-1">
        <a v-bind:href="url">点击跳转</a>
</div>

new Vue({
        el: '#url-1',
        data: {
            url: 'http://itguigu.com'
        }
    })
```

#### v-model 双向绑定（简写为 v-model="name"）

- 只能用在表单类元素上（输入框元素）（input select 单选框 多选框等 ），它们都有一个值 value

#### el和data的两种写法

##### Data

```vue
# 之前写法
new Vue({
        el: "#root",
        data: {
            name: '单项绑定',
            name1: '双向绑定'
        }
    })

# 简化写法
new Vue({
        el: "#root",
        data() {
            return {
                name1: '双向绑定'
            }
        }
    })
```

##### el

```vue
var a = new Vue({
        data() {
            return {
                name1: '双向绑定'
            }
        }
    })
a.$mount('#root')
```

#### MVVM

> M：模型Model，对应data中的数据
>
> V：视图（View）， 模版
>
> VM：视图模型：vue实例对象

![image-20220707152010145](/Users/zhaoheng/Library/Application Support/typora-user-images/image-20220707152010145.png)

![image-20220707152207558](/Users/zhaoheng/Library/Application Support/typora-user-images/image-20220707152207558.png)

- vm中的属性 在{{}}中都可以使用

#### 数据代理

- getter
- setter

![image-20220707162951731](/Users/zhaoheng/Library/Application Support/typora-user-images/image-20220707162951731.png)

#### 数据劫持

- 在vue实例中的_data中运用的是数据劫持

#### 事件处理

- v-on 简写成 @

#### 事件修饰符

常用三个

- prevent - 阻止默认事件
- stop - 阻止事件冒泡
- once - 只执行一次

#### 键盘事件

事件别名

event.key // 获取键盘的key，可以把下面的enter换成打印出来的key

event.keyCode // 键盘的code代码

```
@keyup.enter=""  // 回车的时候触发后面的函数
```

- 自定义配置vue键盘别名事件

```vue
vue.config.keyCodes.huiche = 13  // 13是keycode
@keyup.huiche=""
```

#### 计算属性

- computed

- 属性：指的是data中的数据
- 所谓的计算属性就是拿着data中的数据去计算

```vue
<script>
new Vue({
        el: "#root",
        data: {
            firstName: "张",
            lastName: "三"
        },
        computed:{
            fullName: {
                // get作用：当读取fullName时 get就会被调用，且返回值就作为fullName的值
                // 此时的this是vm对象
                // get什么时候被调用？ 1.初次读取fullName时 2.所依赖的数据发生变化时
                get(){
                    return this.firstName + '-' + this.lastName
                },
                // set被调用时候：当fullName被修改时 
                set(value){
                    this.firstName = value.split('-')[0]
                    this.lastName = value.split('-')[1]
                }
            }
        }
    })
</script>
```

> 简写

```vue
<div id="root">
  姓：<input type="text" v-model="firstName"> 
  <br/>
  名：<input type="text" v-model="lastName">
  <br/>
  姓名：<span>{{fullName}}</span>
</div>
<script>
new Vue({
        el: "#root",
        data: {
            firstName: "张",
            lastName: "三"
        },
        computed:{
            // 只考虑读取 不考虑修改可以简写，也就是set被省略的
            fullName(){
                return this.firstName + '-' + this.lastName
            }
        }
    })
</script>
```

#### 监视属性-深度监视

#### 绑定class样式

```vue
<body>
    <div id="root" :class="classType" @click="changeColor">
        test
    </div>
</body>
<script>
    new Vue({
        el: "#root",
        data: {
            classType: "t1"
        },
        methods: {
            changeColor(){
                const arr  = ['t1', 't2', 't3']
                this.classType = arr[Math.floor(Math.random()*3)]
            }
        },
    })
</script>
```

#### 绑定style样式

```vue
<body>
    <div id="root" :class="arr" :style="styleObj">
        test
    </div>
</body>
<script>
    new Vue({
        el: "#root",
        data: {
            classType: "t1",
            arr : ['t1', 't2'],
            styleObj: {
                fontSize: '30px'
            }
        }
    })
</script>
```

#### 条件渲染(v-if)

- template模版语法

```vue
<body>
    <div id="root">
        <p>n的值是: {{n}}</p>
        <button @click="n++">点击加1</button>
        <div v-if="n === 1">1</div>
        <div v-else-if="n === 2">2</div>
        <div v-else-if="n === 3">3</div>
        <div v-else>0</div>
        <span v-if="testing">testing</span>
        <!-- template模版语法 在页面展示的时候就去除了模版 -->
        <!-- 改动多的用v-show ，v-show是用的css格式将页面隐藏了   v-if在页面上是直接就清除了 -->
        <template v-if="n === 1">
            <div>ok1</div>
            <div>ok2</div>
        </template>
    </div>
</body>
<script>
    new Vue({
        el: "#root",
        data: {
            ok: true,
            n:0,
            testing: true
        }
    })
</script>
```

#### 列表渲染

- <font style="color:red">重点</font>: ':key'一定要存在 为唯一标识， 在一些输入框中新加元素时可能会出错 原理如下图：

![image-20220714140139280](/Users/zhaoheng/Library/Application Support/typora-user-images/image-20220714140139280.png)

![image-20220714140212132](/Users/zhaoheng/Library/Application Support/typora-user-images/image-20220714140212132.png)

​	![image-20220714140220347](/Users/zhaoheng/Library/Application Support/typora-user-images/image-20220714140220347.png)

```vue
<body>
    <div id="root">
        <ul>
            <!-- <li v-for="p in persons" :key="p.id">
                {{p.name}}-{{p.age}}
            </li> -->

            <li v-for="(p,index) in persons" :key="index">
                {{p.name}}-{{p.age}}
            </li>
        </ul>
    </div>
</body>
<script>
    new Vue({
        el: "#root",
        data: {
            persons: [
                {name:'张', age:18, id:'001'},
                {name:'梦', age:19, id:'002'},
                {name:'飞', age:20, id:'003'},
            ]
        }
    })
</script>
```

