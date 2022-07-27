package com.study.array;

public class ArrayDemo {
    public static void main(String[] args) {
//        int[][] a = {
//                {1, 2}, {3, 4}, {5, 6}
//        };
//        int[] b = {111};
//        int c[] = {222};

        Base b = new Derived();
        b.methodOne();
    }

}


class Base
{
    public void methodOne()
    {
        System.out.print("A");
        methodTwo();
    }

    public void methodTwo()
    {
        System.out.print("B");
    }
}

class Derived extends Base
{
    public void methodOne()
    {
        super.methodOne();
        System.out.print("C");
    }

    public void methodTwo()
    {
        super.methodTwo();
        System.out.print("D");
    }
}

