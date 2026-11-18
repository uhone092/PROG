/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mattresssalesapp;

/**
 *
 * @author Asus
 */


public class ProductCalculations implements IProductCalculations {

    private double productPrice;

    public ProductCalculations(double productPrice) {
        this.productPrice = productPrice;
    }

    @Override
    public double GetVat() {
        return productPrice * 0.15;
    }

    @Override
    public double GetCommission() {
        return productPrice * 0.05;
    }

    @Override
    public double GetTotal() {
        return productPrice + GetVat() + GetCommission();
    }
}
