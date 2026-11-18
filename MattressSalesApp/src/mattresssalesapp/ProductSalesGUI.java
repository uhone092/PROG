/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mattresssalesapp;
import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Asus
 */




public class ProductSalesGUI extends JFrame {

    private JTextField txtCustomerName;
    private JTextField txtPrice;
    private JComboBox<String> cmbProduct;

    private JButton btnProcess;

    public ProductSalesGUI() {

        setTitle("Product App");
        setSize(550, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create menu bar
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenu toolsMenu = new JMenu("Tools");

        JMenuItem exitItem = new JMenuItem("Exit");
        JMenuItem processItem = new JMenuItem("Process");
        JMenuItem clearItem = new JMenuItem("Clear");

        fileMenu.add(exitItem);

        toolsMenu.add(processItem);
        toolsMenu.add(clearItem);

        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);

        setJMenuBar(menuBar);

        // Create form components
        JLabel lblCustomerName = new JLabel("Customer Name:");
        JLabel lblProduct = new JLabel("Select Product:");
        JLabel lblPrice = new JLabel("Enter Price:");

        txtCustomerName = new JTextField(20);
        txtPrice = new JTextField(20);

        String[] products = {
            "Cozy Nights Monarch",
            "Restonic Barbados",
            "Sealy Phuket"
        };

        cmbProduct = new JComboBox<>(products);

        btnProcess = new JButton("PROCESS");

        // Create panel
        JPanel panel = new JPanel(new GridLayout(4, 2, 15, 20));

        panel.setBorder(
            BorderFactory.createEmptyBorder(30, 30, 30, 30)
        );

        panel.add(lblCustomerName);
        panel.add(txtCustomerName);

        panel.add(lblProduct);
        panel.add(cmbProduct);

        panel.add(lblPrice);
        panel.add(txtPrice);

        panel.add(new JLabel(""));
        panel.add(btnProcess);

        add(panel);

        // Process button
        btnProcess.addActionListener(e -> processSale());

        // Process menu item
        processItem.addActionListener(e -> processSale());

        // Clear menu item
        clearItem.addActionListener(e -> clearForm());

        // Exit menu item
        exitItem.addActionListener(e -> System.exit(0));
    }

    // Process sales information
    private void processSale() {

        String customerName = txtCustomerName.getText().trim();

        String productName =
                cmbProduct.getSelectedItem().toString();

        String priceText = txtPrice.getText().trim();

        if (customerName.isEmpty()) {

            JOptionPane.showMessageDialog(
                this,
                "Please enter customer name."
            );

            return;
        }

        double price;

        try {

            price = Double.parseDouble(priceText);

            if (price <= 0) {
                JOptionPane.showMessageDialog(
                    this,
                    "Please enter a price greater than zero."
                );
                return;
            }

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                this,
                "Please enter a valid price."
            );

            return;
        }

        // Create ProductCalculations object
        ProductCalculations calculation =
                new ProductCalculations(price);

        // Calculate amounts
        double vat = calculation.GetVat();

        double commission = calculation.GetCommission();

        double total = calculation.GetTotal();

        // Display results
        String message =
                "Customer Name: " + customerName +
                "\nProduct: " + productName +
                "\nVAT: R " + vat +
                "\nCOMMISSION: R " + commission +
                "\nTOTAL: R " + total;

        JOptionPane.showMessageDialog(
            this,
            message,
            "Sales Information",
            JOptionPane.INFORMATION_MESSAGE
        );

        // Save information to data.txt
        saveData(customerName, productName,
                vat, commission, total);
    }

    // Save information to file
    private void saveData(
            String customerName,
            String productName,
            double vat,
            double commission,
            double total) {

        try {

            PrintWriter writer = new PrintWriter(
                new FileWriter("data.txt", true)
            );

            writer.println("DATA LOG");
            writer.println("************************************");

            writer.println("Customer Name: " + customerName);

            writer.println("Product: " + productName);

            writer.println("VAT: R " + vat);

            writer.println("COMMISSION: R " + commission);

            writer.println("TOTAL: R " + total);

            writer.println("************************************");

            writer.println();

            writer.close();

        } catch (IOException e) {

            JOptionPane.showMessageDialog(
                this,
                "Error saving data to file."
            );
        }
    }

    
    private void clearForm() {

        txtCustomerName.setText("");

        txtPrice.setText("");

        cmbProduct.setSelectedIndex(0);
    }
}