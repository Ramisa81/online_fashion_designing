package Online_Fashion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
        
public class Otp extends javax.swing.JFrame {
    private String email;
    private int otp; 
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/registration";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "database1";
    private static final String USERS_TABLE = "users";
    private static final String OTP_TABLE = "otp";
    
    
    public void setOtp(int otp) {
        this.otp = otp;
    }
    public Otp() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jPasswordField2 = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 255, 204));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/rsz_1e__1_-removebg-preview.png"))); // NOI18N

        jLabel2.setText("New Password");

        jLabel3.setText("Confirm Password");

        jPasswordField1.setText("jPasswordField1");

        jPasswordField2.setText("jPasswordField2");

        jLabel4.setText("OTP");

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setText("Confirm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("GO BACK");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel5.setText("Please enter your new password and otp to confirm the change.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(492, 492, 492)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(390, 390, 390)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(470, 470, 470)
                        .addComponent(jLabel2)
                        .addGap(73, 73, 73)
                        .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(470, 470, 470)
                        .addComponent(jLabel3)
                        .addGap(53, 53, 53)
                        .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(470, 470, 470)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(85, 85, 85)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(470, 470, 470)
                        .addComponent(jButton1)
                        .addGap(201, 201, 201)
                        .addComponent(jButton2)))
                .addContainerGap(292, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(jLabel5)
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel2))
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel3))
                    .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String newPassword = new String(jPasswordField1.getPassword());
        String confirmPassword = new String(jPasswordField2.getPassword());
        String enteredOtp = jTextField1.getText();

        if (validateOtp(enteredOtp)) {
            if (newPassword.equals(confirmPassword)) {
                if (updatePasswordInDatabase(email, newPassword, enteredOtp)) {
                    System.out.println("Password updated successfully.");
                    NewJFrame1 s = new NewJFrame1();
                    s.setVisible(true);
                    dispose();
                } else {
                    System.out.println("Failed to update password in the database.");
                    javax.swing.JOptionPane.showMessageDialog(this, "Failed to update password.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                }
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "Password and confirm password do not match.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Incorrect OTP.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        NewJFrame1 s=new NewJFrame1();
        s.show();
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private boolean validateOtp(String enteredOtp) {
        return enteredOtp.equals(String.valueOf(otp));
    }

    private boolean updatePasswordInDatabase(String email, String password, String enteredOtp) {
        if (validateOtp(enteredOtp)) {
            try {
                Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
                String updateQuery = "UPDATE " + USERS_TABLE + " SET password = ? WHERE email = ?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
                    preparedStatement.setString(1, password);
                    preparedStatement.setString(2, email);

                    int rowsAffected = preparedStatement.executeUpdate();

                    // Check if the update was successful
                    if (rowsAffected > 0) {
                        System.out.println("Password updated successfully in the database.");
                        return true;
                    } else {
                        System.out.println("Failed to update password in the database.");
                        return false;
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
       
    }
    
    private boolean updatePassword(String phoneNumber, String newPassword) {
       try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://DESKTOP-V685SN2:3306/registration",
                    "root",
                    "@tashdid12@"
            );

            // Check if the entered OTP matches in the OTP table
            if (checkOtpInDatabase(phoneNumber, otp, connection)) {
                // Update the password in the users table
                String updateQuery = "UPDATE users SET password = ? WHERE phone_number = ?";
                try (PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {
                    updateStatement.setString(1, newPassword);
                    updateStatement.setString(2, phoneNumber);
                    int rowsAffected = updateStatement.executeUpdate();

                    return rowsAffected > 0;
                }
            } else {
                return false; // Incorrect OTP
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
     private boolean checkOtpInDatabase(String phoneNumber, int enteredOtp, Connection connection) throws SQLException {
        String selectQuery = "SELECT * FROM otp WHERE phone_number = ? AND otp_value = ?";
        try (PreparedStatement selectStatement = connection.prepareStatement(selectQuery)) {
            selectStatement.setString(1, phoneNumber);
            selectStatement.setInt(2, enteredOtp);

            try (ResultSet resultSet = selectStatement.executeQuery()) {
                return resultSet.next(); // If next() returns true, the OTP is valid
            }
        }
    }
    
    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Otp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

    public void setPhoneNumber(String email) {
        this.email = email;
    }

   
    
}
