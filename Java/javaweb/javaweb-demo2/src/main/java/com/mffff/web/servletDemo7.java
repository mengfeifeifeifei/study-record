package com.mffff.web;

import javax.servlet.annotation.WebServlet;

/**
 *
 */
@WebServlet(urlPatterns = {"/servlet7", "/servlet8"})
public class servletDemo7 extends ServletDemo5 {
    @Override
    protected void doGet() {
        System.out.println("get6.....");
    }

    @Override
    protected void doPost() {
        System.out.println("post6.....");
    }
}
