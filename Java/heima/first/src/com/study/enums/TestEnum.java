package com.study.enums;

enum TestEnum {

    TEST("zz", 10),TESTS("ff", 20);

    private String name;

    private Integer age;

    private TestEnum(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "TestEnum{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}