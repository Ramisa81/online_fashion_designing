package Online_Fashion;



import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Invoice extends JFrame {

    private static final String INVOICE_HEADER = "Invoice Details";
    private static final String PRINT_BUTTON_LABEL = "Print Invoice";
    private static final String OKAY_BUTTON_LABEL = "Okay";
    private static final String NEW_LINE = "\n";

    private static final String CLIENT_DB_URL = "jdbc:mysql://localhost:3306/client";
    private static final String INVOICE_DB_URL = "jdbc:mysql://localhost:3306/invoice";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "database1";

    private String name;
    private String phone;
    private String district;
    private String city;
    private String postal;
    private String house;
    private String model;
    private String quantity;
    private String size;
    private String gsm;
    private String fabric;
    private String code;
    static private String email;

    public Invoice(String a) {
        this.email = a;
        fetchDataFromDatabases();
        initializeUI();
    }

    private void fetchDataFromDatabases() {
        fetchClientData();
        fetchInvoiceData();
    }

    private void fetchClientData() {
        try (Connection connection = DriverManager.getConnection(CLIENT_DB_URL, JDBC_USER, JDBC_PASSWORD)) {
            String sql = "SELECT model, quantity, size, gsm, fabric FROM purchase WHERE email=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, email);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        model = resultSet.getString("model");
                        quantity = resultSet.getString("quantity");
                        size = resultSet.getString("size");
                        gsm = resultSet.getString("gsm");
                        fabric = resultSet.getString("fabric");
                    } else {
                        System.out.println("No purchase data found for email: " + email);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void fetchInvoiceData() {
        try (Connection connection = DriverManager.getConnection(INVOICE_DB_URL, JDBC_USER, JDBC_PASSWORD)) {
            String sql = "SELECT * FROM delivery WHERE email=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, email);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        name = resultSet.getString("name");
                        phone = resultSet.getString("phone");
                        district = resultSet.getString("district");
                        city = resultSet.getString("city");
                        postal = resultSet.getString("postal");
                        house = resultSet.getString("house");
                        code = resultSet.getString("code");
                        email = resultSet.getString("email");
                    } else {
                        JOptionPane.showMessageDialog(this, "No data found for the email: " + email);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private void addNonNullLabel(JPanel panel, String labelText, String value, Font font) {
    JLabel label = new JLabel(labelText);
    label.setFont(font);
    panel.add(label);

    JLabel valueLabel = new JLabel(value != null ? value : ""); // Display an empty string if the value is null
    valueLabel.setFont(font);
    panel.add(valueLabel);
}
    
    
    private void initializeUI() {
    setTitle("Invoice");
    setSize(1588, 2246); // A4 paper size in pixels
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Creating panels
    JPanel jPanel1 = new JPanel();
    JPanel jPanel2 = new JPanel(new GridLayout(0, 2));
    JPanel jPanel3 = new JPanel();
    JPanel jPanel4 = new JPanel(new GridLayout(0, 2));

    // Setting backgrounds
    jPanel1.setBackground(Color.WHITE);
    jPanel2.setBackground(Color.WHITE);
    jPanel3.setBackground(Color.WHITE);
    jPanel4.setBackground(Color.WHITE);

    // Font for labels
    Font labelFont = new Font("Candara", Font.PLAIN, 36);

    // Panel 1 - INVOICE
    JLabel invoiceLabel = new JLabel("INVOICE");
    invoiceLabel.setFont(new Font("Arial", Font.BOLD, 36));
    jPanel1.add(invoiceLabel);

    // Panel 2 - Labels for name, phone, district, city, postal, house
    addLabel(jPanel2, "Name:", name, labelFont);
    addLabel(jPanel2, "Phone:", phone, labelFont);
    addLabel(jPanel2, "District:", district, labelFont);
    addLabel(jPanel2, "City:", city, labelFont);
    addLabel(jPanel2, "Postal Code:", postal, labelFont);
    addLabel(jPanel2, "House No:", house, labelFont);

    // Panel 3 - Buttons for print and okay
     JButton printButton = new JButton(PRINT_BUTTON_LABEL);
        printButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add printing logic here
                createPDF();
                JOptionPane.showMessageDialog(Invoice.this, "Invoice Printed and Saved as PDF!");
            }
        });
        
        
        printButton.setFont(labelFont);
        jPanel3.add(printButton);
        printButton.setFont(labelFont);
        jPanel3.add(printButton);
    printButton.setFont(labelFont); // Set font for the button
    jPanel3.add(printButton);

    JButton okayButton = new JButton(OKAY_BUTTON_LABEL);
    okayButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Close the current window
            dispose();
            Order order = new Order(code);
            Congratulation s = new Congratulation(email);
            s.show();
            dispose();
        }
    });
    okayButton.setFont(labelFont); // Set font for the button
    jPanel3.add(okayButton);

    // Panel 4 - Show to retrieve data
addNonNullLabel(jPanel4, "Model:", model, labelFont);
addNonNullLabel(jPanel4, "Quantity:", quantity, labelFont);
addNonNullLabel(jPanel4, "Size:", size, labelFont);
addNonNullLabel(jPanel4, "GSM:", gsm, labelFont);
addNonNullLabel(jPanel4, "Fabric:", fabric, labelFont);
addNonNullLabel(jPanel4, "Code:", code, labelFont);
addNonNullLabel(jPanel4, "Email:", email, labelFont);

    // Create a layout for the main frame
    GroupLayout layout = new GroupLayout(getContentPane());
    getContentPane().setLayout(layout);

    layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                            .addGap(30, 30, 30)
                                            .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jPanel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 22, Short.MAX_VALUE))
                                    .addComponent(jPanel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addContainerGap())
    );

    layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                            .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(28, 28, 28)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0))
    );

    pack();
    setLocationRelativeTo(null); 

}
    
   private void createPDF() {
    Document document = new Document();

    try {
        
        String savePath = System.getProperty("user.home") + "/Desktop/";
        String fileName = "invoice.pdf";

        PdfWriter.getInstance(document, new FileOutputStream(savePath + fileName));

        document.open();

        // Add content to the PDF
        document.add(new Paragraph("INVOICE"));
addNonNullParagraph(document, "Name:", name);
addNonNullParagraph(document, "Phone:", phone);
addNonNullParagraph(document, "District:", district);
addNonNullParagraph(document, "City:", city);
addNonNullParagraph(document, "Postal Code:", postal);
addNonNullParagraph(document, "House No:", house);
addNonNullParagraph(document, "Model:", model);
addNonNullParagraph(document, "Quantity:", quantity);
addNonNullParagraph(document, "Size:", size);
addNonNullParagraph(document, "GSM:", gsm);
addNonNullParagraph(document, "Fabric:", fabric);
addNonNullParagraph(document, "Code:", code);
addNonNullParagraph(document, "Email:", email);

    } catch (DocumentException | FileNotFoundException e) {
        e.printStackTrace();
    } finally {
        document.close();
    }
}

private void addLabel(JPanel panel, String labelText, String value, Font font) {
    JLabel label = new JLabel(labelText);
    label.setFont(font);
    panel.add(label);

    JLabel valueLabel = new JLabel(value != null ? value : ""); // Display an empty string if the value is null
    valueLabel.setFont(font);
    panel.add(valueLabel);
}
private void addNonNullParagraph(Document document, String label, String value) throws DocumentException {
    // Add content to the PDF only if the value is not null
    if (value != null) {
        document.add(new Paragraph(label + " " + value));
    }
}

    public static void main(String[] args) {
        // Sample usage
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Invoice(email).setVisible(true);
            }
        });
    }
    
    private javax.swing.JLabel jLabelModel;
    private javax.swing.JLabel jLabelQuantity;
    private javax.swing.JLabel jLabelSize;
    private javax.swing.JLabel jLabelGSM;
    private javax.swing.JLabel jLabelFabric;
}

