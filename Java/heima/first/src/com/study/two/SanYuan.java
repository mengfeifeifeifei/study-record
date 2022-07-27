package com.study.two;

public class SanYuan {
    public static void main(String[] args) {
        int i = 40;
        int j = 50;
        int k = 60;
        int temp = i > j ? i : j;
        int temp1 = temp > k ? temp : k;
        System.out.println(temp1);

        int max = i > j ? i > k? i : k :j > k ? j : k;
        System.out.println(max);

        SanYuan sanYuan = new SanYuan();
        sanYuan.test();
    }

    public void test() {
        System.out.println(1);
    }
}
