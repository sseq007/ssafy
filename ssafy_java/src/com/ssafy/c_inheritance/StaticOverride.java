package com.ssafy.c_inheritance;

class Parent2 {
    static void method() {
        System.out.println("parent method");
    }
}

class Child2 extends Parent2 {
    // TODO: Parent2의 메서드를 재정의 해보자.
    // END:
}

public class StaticOverride {
    public static void main(String[] args) {
        Child2 obj = new Child2();
        obj.method();
    }
}
