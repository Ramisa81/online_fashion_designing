
package Online_Fashion;

import static Online_Fashion.editprofile.em;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

public class Congratulation extends javax.swing.JFrame {
    
    private static final String TABLE_NAME = "delivery";
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/invoice";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "database1";

    static public String email;
    public Congratulation(String a) {
        this.email=a;
        initComponents();
        updateTrackingCode();
    }
    
    private void updateTrackingCode() {
           try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
        // Generate a random tracking code
        String trackingCode = generateRandomCode();

        // Update the 'code' field in the 'delivery' table
        String updateSql = "UPDATE " + TABLE_NAME + " SET code=?, email=? WHERE email=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(updateSql)) {
            preparedStatement.setString(1, trackingCode);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, email); // Added this line to set the value for the third parameter

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Tracking code updated successfully for email: " + email);

                jLabel2.setText("Your tracking code: " + trackingCode);
            } else {
                System.out.println("No rows updated");
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    }

    private String generateRandomCode() {
        // Generate a random 6-character tracking code
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder code = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            code.append(characters.charAt(random.nextInt(characters.length())));
        }
        return code.toString();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 255, 255));
        jLabel1.setText("CONGRATULATIONS");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 180, 570, 90));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Your order is placed.Track your order ......");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 290, -1, -1));

        jButton1.setFont(new java.awt.Font("Candara", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 51, 51));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/login.png"))); // NOI18N
        jButton1.setText("T r a c k   O r d e r");
        jButton1.setAlignmentX(0.5F);
        jButton1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jButton1.setIconTextGap(10);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 460, 200, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/solid-color-topaz-blue-sb6va4wcexirzy3e.jpg"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1230, 610));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Order s=new Order(email);
        s.show();
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

 
    public static void main(String args[]) {
 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Congratulation(email).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
