/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;
import mattresssalesapp.ProductCalculations;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Asus
 */




public class ProductCalculationsTest {

   
    @Test
    public void GetVat_WithValidData_ReturnsCorrectValue() {

        ProductCalculations product =
                new ProductCalculations(3500);

        assertEquals(
                525.0,
                product.GetVat(),
                0.01
        );
    }

    
    @Test
    public void GetCommission_WithValidData_ReturnsCorrectValue() {

        ProductCalculations product =
                new ProductCalculations(3500);

        assertEquals(
                175.0,
                product.GetCommission(),
                0.01
        );
    }

    
    @Test
    public void GetTotal_WithValidData_ReturnsCorrectValue() {

        ProductCalculations product =
                new ProductCalculations(3500);

        assertEquals(
                4200.0,
                product.GetTotal(),
                0.01
        );
    }
}
