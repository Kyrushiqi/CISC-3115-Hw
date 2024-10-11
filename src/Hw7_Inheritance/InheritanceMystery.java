package Hw7_Inheritance;// adapted from the excellent CodeStepByStep website: https://www.codestepbystep.com/problem/view/java/inheritance/inheritanceMystery1

class C {
    @Override
    public String toString() {
        return "c";
    }

    public void method1() {
        System.out.print("c 1 ");
    }

    public void method2() {
        System.out.print("c 2 ");
    }
}

class B extends C {
    @Override
    public String toString() {
        return "b";
    }

    @Override
    public void method2() {
        System.out.print("b 2 ");
        super.method2();
    }
}

class A extends B {
    @Override
    public void method2() {
        System.out.print("a 2 ");
        method1();
    }
}

class D extends B {
    @Override
    public void method1() {
        System.out.print("d 1 ");
        method2();
    }
}

public class InheritanceMystery {
    public static void main(String[] args) {
        C[] elements = {new A(), new B(), new C(), new D()};

        for (int i = 0; i < elements.length; i++) {
            System.out.print(elements[i] + " ");
            elements[i].method1();
            elements[i].method2();
            System.out.println();
        }
    }
}