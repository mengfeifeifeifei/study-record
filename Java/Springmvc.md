ThyMeleafView什么时候被创建？

- 当请求的转发没有前缀的时候  return "view名称";

转发视图 forward  （不能直接转发到页面） - InternalResourceView

- return "forward:/其他的RequestMapping名称"

重定向视图 redirect （实现页面跳转） - RedirectView ，浏览器发送的请求

- 当视图名称以 Redirect:开头时候创建重定向view





用了view-controller之后 必须开启mvn注解驱动，否则之前配置的所有@RequestMapping都会失效

```xml
<mvc:view-controller path="/testview" view-name="ThyMeleaf视图名称"></mvc:view-controller>
```

```xml
<mvc:annotation-driven />
```



jsp方式 解析上下文路径用${pageContext.request.contextPath}