/*
AIM:
Write a Java program using four different packages to demonstrate the use of access specifiers.
● Package apack:
o Define a class A with three variables:
▪ public int pubVar
▪ protected int protVar
▪ private int privVar
o Provide a constructor to initialize them.
● Package bpack:
o Define a class B that extends A.
o Create a display() method that tries to access variables of A using inheritance.
● Package cpack:
o Define a class C with a display() method.
o Inside display(), create an object of class A and try to access its variables.
● Package dpack:
o Define a class ProtectedDemo with main().
o Create objects of class B and class C.
o Call their respective display() methods to show which variables are saccessible and which are
not.
*/

/* -------------------- PACKAGE apack -------------------- */
package apack;

public class A {

    public int pubVar;
    protected int protVar;
    private int privVar;

    public A(int pubVar, int protVar, int privVar) {
        this.pubVar = pubVar;
        this.protVar = protVar;
        this.privVar = privVar;
    }

    public int getPrivVar() {
        return privVar;
    }
}

/* -------------------- PACKAGE bpack -------------------- */
package bpack;

import apack.A;

public class B extends A {

    public B(int a, int b, int c) {
        super(a, b, c);
    }

    public void display() {

        System.out.println("\nB class (Inheritance):");
        System.out.println("Public Variable: " + pubVar);
        System.out.println("Protected Variable: " + protVar);
        System.out.println("Private Variable: NOT accessible directly");
        System.out.println("Private via getter: " + getPrivVar());
    }
}

/* -------------------- PACKAGE cpack -------------------- */
package cpack;

import apack.A;
import java.util.Scanner;

public class C {

    public void display() {

        Scanner sc = new Scanner(System.in);

        System.out.println("\nEnter values for class A (C package):");

        System.out.print("Public: ");
        int a = sc.nextInt();

        System.out.print("Protected: ");
        int b = sc.nextInt();

        System.out.print("Private: ");
        int cVal = sc.nextInt();

        A obj = new A(a, b, cVal);

        System.out.println("\nC class (Object access):");
        System.out.println("Public Variable: " + obj.pubVar);
        System.out.println("Protected Variable: NOT accessible");
        System.out.println("Private Variable: NOT accessible");
    }
}

/* -------------------- PACKAGE dpack -------------------- */
package dpack;

import bpack.B;
import cpack.C;
import java.util.Scanner;

public class PR20 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter values for class B:");

        System.out.print("Public: ");
        int a = sc.nextInt();

        System.out.print("Protected: ");
        int b = sc.nextInt();

        System.out.print("Private: ");
        int cVal = sc.nextInt();

        B objB = new B(a, b, cVal);
        objB.display();

        System.out.println();

        C objC = new C();
        objC.display();
    }
}

/* Output:

Enter values for class B:
Public: 100
Protected: 200
Private: 300

B class (Inheritance):
Public Variable: 100
Protected Variable: 200
Private Variable: NOT accessible directly
Private via getter: 300

Enter values for class A (C package):
Public: 10
Protected: 20
Private: 30

C class (Object access):
Public Variable: 10
Protected Variable: NOT accessible
Private Variable: NOT accessible

*/