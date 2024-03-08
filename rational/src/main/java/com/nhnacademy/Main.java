package com.nhnacademy;

public class Main {
    public static void main(String[] args) {
        try {
            Rational rational = new Rational(5,2);
            System.out.println(rational);//자동으로 tostring 해서 출력해준다.
            System.out.println(new Rational(5,4));
            System.out.println(new Rational(0,5));
            System.out.println(Rational.subtract(new Rational(5,4),new Rational(0,5)));//자동으로 tostring 해서 출력해준다.
            
        } catch (ArithmeticException e) {
            System.err.println(e.getMessage());
        }
        

    }
}