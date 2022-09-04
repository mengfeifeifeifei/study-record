package com.mffff.web.request;

import javax.servlet.annotation.WebServlet;

/**
 *
 */
@WebServlet(urlPatterns = "/servlet6")
public class ServletDemo6 extends ServletDemo5 {
    @Override
    protected void doGet() {
        System.out.println("get6.....");
    }

    @Override
    protected void doPost() {
        System.out.println("post6.....");
    }
}
