package com.study.shopping;

import java.util.Arrays;
import java.util.Scanner;

public class ShopCar {
    /**
     * 购物车案例demo
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Goods[] shopCars = new Goods[2];
        while (true) {
            System.out.println("请输入要操作的命令");
            System.out.println("查询请输入: query");
            System.out.println("添加请输入: add");
            System.out.println("修改请输入: update");
            System.out.println("结算请输入: pay");
            String command = scanner.next();
            switch (command) {
                case "add":
                    add(shopCars, scanner);
                    break;
                case "query":
                    query(shopCars, scanner);
                    break;
                case "update":
                    update(shopCars, scanner);
                    break;
                case "pay":
                    pay(shopCars);
                    break;
                default:
                    System.out.println("退出");
                    head();
                    for (int i = 0; i < shopCars.length; i++) {
                        if (shopCars[i] != null) {
                            System.out.println(shopCars[i].id+"\t\t"+shopCars[i].name+"\t\t"+shopCars[i].price+"\t\t"+shopCars[i].buyNumber);
                        }
                    }
            }
        }

    }

    public static void add(Goods[] shopCars, Scanner scanner) {
        Goods goods = new Goods();
        System.out.println("请输入要添加的商品id：");
        goods.id = scanner.nextInt();
        System.out.println("请输入要添加的商品名称：");
        goods.name = scanner.next();
        System.out.println("请输入要添加的商品价格：");
        goods.price = scanner.nextDouble();
        System.out.println("请输入要添加的商品数量：");
        goods.buyNumber = scanner.nextInt();
        boolean flag = false;
        for (int i = 0; i < shopCars.length; i++) {
            if (shopCars[i] == null) {
                shopCars[i] = goods;
                flag = true;
                break;
            }
        }
        if (!flag) {
            System.out.println("购物车已经满了，赶紧剁手吧！");
            return;
        }
        System.out.println("商品" + goods.name + "添加成功");
    }

    public static void query(Goods[] shopCars, Scanner scanner) {
        System.out.println("请输入要查询的商品id：");
        int id = scanner.nextInt();
        head();
        boolean flag = false;
        int len = 0;
        for (int i = 0; i < shopCars.length; i++) {
            if (shopCars[i] != null) {
                if (shopCars[i].id == id) {
                    flag = true;
                    System.out.println(shopCars[i].id+"\t\t"+shopCars[i].name+"\t\t"+shopCars[i].price+"\t\t"+shopCars[i].buyNumber);
                    break;
                } else {
                    len = i+1;
                }
            } else {
                len = i;
                break;
            }
        }
        if (!flag) {
            System.out.println(len);

            for (int i = 0; i < len; i++) {
                System.out.println(shopCars[i].id+"\t\t"+shopCars[i].name+"\t\t"+shopCars[i].price+"\t\t"+shopCars[i].buyNumber);
            }
        }
    }

    public static void pay(Goods[] shopCars) {
        int num = 0;
        head();
        for (int i = 0; i < shopCars.length; i++) {
            System.out.println(shopCars[i].id+"\t\t"+shopCars[i].name+"\t\t"+shopCars[i].price+"\t\t"+shopCars[i].buyNumber);
            num+=shopCars[i].price * shopCars[i].buyNumber;
        }
        System.out.println("总价\t\t\t\t\t\t\t\t" + num);
    }

    public static void update(Goods[] shopCars, Scanner scanner) {
        System.out.println("请输入您要修改的商品id:");
        int id = scanner.nextInt();
        for (int i = 0; i < shopCars.length; i++) {
            if (shopCars[i].id == id) {
                System.out.println("请输入名称要修改为:");
                shopCars[i].name = scanner.next();
                System.out.println("请输入价格要修改为:");
                shopCars[i].price = scanner.nextDouble();
                System.out.println("请输入数量要修改为:");
                shopCars[i].buyNumber = scanner.nextInt();
                break;
            }
        }
    }

    public static void head() {
        System.out.println("id\t\t名称\t\t价格\t\t数量\t\t");
    }
}
