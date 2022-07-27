package com.study.ArrayLists;

public class Account {
    private String account;
    private String password;
    private double money;
    private double limitMoney;
    private String cardId;

    public Account(String account, String password, double money, double limitMoney, String cardId) {
        this.account = account;
        this.password = password;
        this.money = money;
        this.limitMoney = limitMoney;
        this.cardId = cardId;
    }

    public Account() {
    }

    public String getAccount() {
        return this.account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getLimitMoney() {
        return limitMoney;
    }

    public void setLimitMoney(double limitMoney) {
        this.limitMoney = limitMoney;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }
}
