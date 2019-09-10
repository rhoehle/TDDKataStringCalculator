package com.robertleehoehle;

import junit.framework.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Robert Hoehle
 */
public class TDDKataStringCalculatorTest {

    @Test
    public void addEmptyString() {
        Assert.assertEquals((0), TDDKataStringCalculator.add(""));
    }

    @Test
    public void addOneNumber() {
        Assert.assertEquals((5), TDDKataStringCalculator.add("5"));
        Assert.assertEquals((66), TDDKataStringCalculator.add("66"));
    }

    @Test
    public void addTwoNumbers() {
        Assert.assertEquals((3), TDDKataStringCalculator.add("1,2"));
    }

    @Test
    public void addThreeNumbers() {
        Assertions.assertEquals(6, TDDKataStringCalculator.add("1,2,3"));
    }

    @Test
    public void addNumbersWithDelimiterNewLine() {
        Assert.assertEquals(3, TDDKataStringCalculator.add("1\n2"));
    }

    @Test
    public void addNumbersWithDelimiterAndComma() {
        Assert.assertEquals(6, TDDKataStringCalculator.add("1,2\n3"));
    }

    @Test
    public void addNumbersWithDifferentDelimiters() {
        Assert.assertEquals(10, TDDKataStringCalculator.add(";\n1;2;3;4"));
    }

    @Test
    public void negativeNotSupported() {
        try {
            TDDKataStringCalculator.add("-1,4");
            Assert.fail("exception should have been thrown");
        }
        catch (IllegalArgumentException e) {
            Assert.assertEquals("negatives not allowed -1", e.getMessage());
        }
    }

    @Test
    public void numbersAbove1000() {
        Assert.assertEquals(9, TDDKataStringCalculator.add("3,1000,1001,6,1234"));
    }

}
