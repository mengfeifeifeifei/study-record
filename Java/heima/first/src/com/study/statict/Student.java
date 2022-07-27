package com.study.statict;

public class Student {
    private String name;

    /**
     * static 静态关键字
     * 属于类 可以共享访问
     * @return
     */
    public static int getMax(int a, int b) {
        return a > b ? a : b;
    }

    // 实例对象可以调用
    public void study() {
        System.out.println("study");
        System.out.println(this.name + "xxxxxx");
    }

    public static void main(String[] args) {
        // 类名 可以不写
        getMax(10,20);
        System.out.println(Student.getMax(10, 3));
    }
}
