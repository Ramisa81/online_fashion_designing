package Online_Fashion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Colour extends javax.swing.JFrame {
    
    private static final String TABLE_NAME = "purchase";
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/client";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "database1";
    
    static public String email;
    public Colour(String a) {
        this.email=a;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jColorChooser1 = new javax.swing.JColorChooser();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jColorChooser1.setBackground(new java.awt.Color(0, 102, 102));
        jColorChooser1.setForeground(new java.awt.Color(0, 153, 153));
        getContentPane().add(jColorChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 1230, 440));

        jButton2.setBackground(new java.awt.Color(204, 255, 255));
        jButton2.setText("GO BACK");
        jButton2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 520, 150, 43));

        jButton1.setBackground(new java.awt.Color(153, 255, 255));
        jButton1.setText("OKAY");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1068, 520, 140, 43));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/solid-color-topaz-blue-sb6va4wcexirzy3e.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1230, 620));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        whom a=new whom();
        a.show();
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
         java.awt.Color selectedColor = jColorChooser1.getColor();

        // Convert color to a format suitable for database storage
        String colorHex = Integer.toHexString(selectedColor.getRGB()).substring(2).toUpperCase();

        // Update the purchase table
        updatePurchaseTable(colorHex);
        
        // Move to the next page (size page)
        size s = new size(email);
        s.show();
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void updatePurchaseTable(String colorHex) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            // Check if a record with the given primary key exists
            if (recordExists(connection, email)) {
                // Record exists, perform update
                updateRecord(connection, email, colorHex);
            } else {
                // Record doesn't exist, perform insert
                insertRecord(connection, email, colorHex);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private boolean recordExists(Connection connection, String email) throws SQLException {
        String sql = "SELECT COUNT(*) FROM " + TABLE_NAME + " WHERE email=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, email);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                resultSet.next();
                int count = resultSet.getInt(1);
                return count > 0;
            }
        }
    }

    private void updateRecord(Connection connection, String email, String colorHex) throws SQLException {
        // Prepare the SQL update statement
        String sql = "UPDATE " + TABLE_NAME + " SET color=IFNULL(color, ?) WHERE email=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            // Set the parameters with appropriate values
            preparedStatement.setString(1, colorHex);
            preparedStatement.setString(2, email);

            // Execute the update
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Update successful");
            } else {
                System.out.println("No rows updated");
            }
        }
    }

    private void insertRecord(Connection connection, String email, String colorHex) throws SQLException {
        // Prepare the SQL insert statement
        String sql = "INSERT INTO " + TABLE_NAME + " (email, color) VALUES (?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            // Set the parameters with appropriate values
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, colorHex);

            // Execute the insert
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Insert successful");
            } else {
                System.out.println("No rows inserted");
            }
        }
    }

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Colour(email).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JColorChooser jColorChooser1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
