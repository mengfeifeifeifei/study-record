package com.study.duotai;
import javax.swing.*;
import java.util.Arrays;

class Income {
    protected double income;

    public Income(double income) {
        this.income = income;
        System.out.println(this.income);
    }

    public double getTax() {
        return income * 0.1;
    }
}

class Salary extends Income {
    public Salary(double income) {
        super(income);
//        System.out.println(super.income);
    }

    @Override
    public double getTax() {
        if (income <= 5000) {
            return 0;
        }
        return (income - 5000) * 0.2;
    }
}

class StateCouncilSpecialAllowance extends Income {
    public StateCouncilSpecialAllowance(double income) {
        super(income);
//        System.out.println(super.income);
    }

    @Override
    public double getTax() {
        return 0;
    }
}


public class Main {
    /**
     * 多态的用法，不需要修改父类。直接调用就可以计算三个
     * 调用各自的getTax 互不影响
     */
    public static void main(String[] args) {
        Income[] income = new Income[]{new Income(3000), new Salary(5000), new StateCouncilSpecialAllowance(15000)};
//        System.out.println(income.getClass().getSimpleName());
//        System.out.println(Arrays.toString(income));
        System.out.println(totalMax(income));
    }

    //    public static double totalMax(Income[] incomes) {
    public static double totalMax(Income... incomes) {
        double total = 0;
        for (Income income : incomes) {
            total = total + income.getTax();
        }
        return total;
    }
}
