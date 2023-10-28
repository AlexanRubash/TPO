package org.example;


import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;


public class CalculatorTests {
    //сложение
    @Test
    public void testAdd() {
        double number1 = 5;
        double number2 = 3;
        double expected = 8;

        double received = Calculator.add(number1, number2);

        assertEquals(expected,received , 0.0001);
    }
    //вычтание
    @Test
    public void testSub() {
        double number1 = 5;
        double number2 = 3;
        double expected = 2;

        double received = Calculator.sub(number1, number2);

        assertEquals(expected,received , 0.0001);
    }

    //умножение
    @Test
    public void testMult() {
        double number1 = 5;
        double number2 = 3;
        double expected = 15;

        double received = Calculator.mult(number1, number2);

        assertEquals(expected,received , 0.0001);
    }

    //деление
    @Test
    public void testDiv() {
        double number1 = 6;
        double number2 = 3;
        double expected = 2;

        double received = Calculator.div(number1, number2);

        assertEquals(expected,received , 0.0001);
    }
    //степень
    @Test
    public void testPow() {
        double number1 = 2;
        int number2 = 3;
        double expected = 8;

        double received = Calculator.pow(number1, number2);

        assertEquals(expected,received , 0.0001);
    }
    //нулевая степень
    @Test
    public void testPowWithDegreeZero() {
        double number1 = 2;
        int number2 = 0;
        double expected = 1;

        double received = Calculator.pow(number1, number2);

        assertEquals(expected,received , 0.0001);
    }
    //корень числа
    @Test
    public void testFindSquareRoot() {
        double number1 = 25;
        double number2 = 2;
        double expected = 5.0;

        double received = Calculator.findSquareRoot(number1, number2);

        assertEquals(expected,received , 0.1);
    }

    @Test
    public void testFindSquareRootZero() {
        double number1 = 9;
        double number2 = 0.0001;
        double expected = 3;

        double received = Calculator.findSquareRoot(number1, number2);

        assertEquals(expected,received , 0.01);
    }
    @Test
    public void testDivByZero() {
      assertThrows(ArithmeticException.class, () -> Calculator.div(5.0, 0.0));
    }
    @Test
    public void testSquareRootNegativeNumber() {
      assertThrows(ArithmeticException.class, () -> Calculator.findSquareRoot(-1, 0.01));
    }





}
