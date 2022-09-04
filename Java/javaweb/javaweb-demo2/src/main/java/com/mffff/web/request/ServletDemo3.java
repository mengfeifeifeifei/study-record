package com.mffff.web.request;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet(urlPatterns = "/servlet3", loadOnStartup = 1)
public class ServletDemo3 implements Servlet {
    // 声明一个成员变量，方便下面get的使用
    private ServletConfig config;
    /**
     * 初始化方式
     * 调用时期：
     * 默认情况下，servlet第一次被访问时调用
     * loadonstartup  写上之后在启动tomcat的时候就会调用， 不用访问servlet
     * @param config
     *            a <code>ServletConfig</code> object containing the servlet's
     *            configuration and initialization parameters
     *
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
        this.config = config;
        // 刷新页面多次 只调用一次
        System.out.println("init......");
    }

    @Override
    public ServletConfig getServletConfig() {
        return this.config;
//        return null;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("servlet hello world");
    }

    /**
     * 获取信息
     * @return
     */
    @Override
    public String getServletInfo() {
        return null;
    }

    /**
     * 销毁方法
     * 当内存释放或服务器关闭的时候，会被销毁调用
     * 只会执行一次
     */
    @Override
    public void destroy() {
        System.out.println("destory...");
    }
}
