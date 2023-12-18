package com.hillel.lesson_06.thisVSsuper;

public class Constr {
    public static void main(String[] args) {
        D d = new D();
    }
}

class A {
    public A() {
        super();
        System.out.println("A");
    }
}
class B extends A{
    public B() {
        super();
        System.out.println("B");
    }
}
class C extends B {
    public C() {
        super();
        System.out.println("C");
    }
}
class D extends C {
    public D() {
        super();
        System.out.println("D");
    }
}
