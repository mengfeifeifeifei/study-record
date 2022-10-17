package com.mffff.spring;

import org.springframework.stereotype.Component;

@Component
public class OrderImpl implements Order{

    private String name;
    private String address;

    public OrderImpl() {}

    public OrderImpl(String name, String address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Order{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
