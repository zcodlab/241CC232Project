/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package uni.aed.maxmin;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author hp
 */
public class MaxMinTest {
    
    public MaxMinTest() {
    }

    @org.junit.jupiter.api.Test
    public void testGetMaxValor() {
        System.out.println("getMaxValor");
        Integer[] X = {15,1,25,60,69,86,3,78,2,10};
        MaxMin instance = new MaxMin();
        Integer expResult = 86;
        Integer result = instance.getMaxValor(X);
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }

    @org.junit.jupiter.api.Test
    public void testGetMinValor() {
        System.out.println("getMinValor");
        Integer[] X = {15,1,25,60,69,86,3,78,2,10};
        MaxMin instance = new MaxMin();
        Integer expResult = 1;
        Integer result = instance.getMinValor(X);
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }
    
}
