package com.mffff.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
public class FilterDemo implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("filter demo.....");
        // 过滤器放行
        chain.doFilter(request, response);

        // 放行前可以对request处理
        // 执行完资源之后还会走回来

        // 执行放行后的代码
        // 放行后可以对response处理
        System.out.println("放行后的代码");
    }

    @Override
    public void destroy() {

    }
}
