package Online_Fashion;

import static Online_Fashion.size.email;
import static Online_Fashion.sizes.email;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.prefs.Preferences;
import javax.swing.JButton;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class GSM extends javax.swing.JFrame {
 
    private static final String TABLE_NAME = "purchase";
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/client";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "database1";

    public static String email;
    private int selectedGSM = 0;
    
    public GSM(String a) {
        this.email=a;
        initComponents();
        addCustomListeners();
    }
    
    private void addCustomListeners() {
        // Add action listeners to radio buttons to update the selectedGSM variable
        jRadioButton7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                selectedGSM = 100;
            }
        });

        jRadioButton8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                selectedGSM = 110;
            }
        });

        jRadioButton9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                selectedGSM = 120;
            }
        });

        jRadioButton10.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                selectedGSM = 150;
            }
        });

        jRadioButton11.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                selectedGSM = 180;
            }
        });

        jRadioButton12.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                selectedGSM = 220;
            }
        });

        // Add action listener to the "NEXT" button to update GSM in the database
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
    }

    private void updateGSMInDatabase() {
        try {
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

            // Update the GSM field in the purchase table
            String sql = "UPDATE " + TABLE_NAME + " SET gsm = ? WHERE email = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, selectedGSM);
                preparedStatement.setString(2, email);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButton7 = new javax.swing.JRadioButton();
        jRadioButton8 = new javax.swing.JRadioButton();
        jRadioButton9 = new javax.swing.JRadioButton();
        jRadioButton10 = new javax.swing.JRadioButton();
        jRadioButton11 = new javax.swing.JRadioButton();
        jRadioButton12 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jRadioButton7.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jRadioButton7.setText("100");
        getContentPane().add(jRadioButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 143, 98, -1));

        jRadioButton8.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jRadioButton8.setText("110");
        getContentPane().add(jRadioButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 193, 98, -1));

        jRadioButton9.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jRadioButton9.setText("120");
        getContentPane().add(jRadioButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 253, 98, -1));

        jRadioButton10.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jRadioButton10.setText("150");
        getContentPane().add(jRadioButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 303, 104, -1));

        jRadioButton11.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jRadioButton11.setText("180");
        getContentPane().add(jRadioButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 363, 104, -1));

        jRadioButton12.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jRadioButton12.setText("220");
        getContentPane().add(jRadioButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 413, 104, -1));

        jButton1.setText("NEXT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 470, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images.jpeg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 180, 290));

        jPanel2.setBackground(new java.awt.Color(181, 82, 36));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel2.setText("           GSM");
        jPanel2.add(jLabel2, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, 110));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        updateGSMInDatabase(); 
        Waist s=new Waist(email);
        s.show();
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GSM(email).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton10;
    private javax.swing.JRadioButton jRadioButton11;
    private javax.swing.JRadioButton jRadioButton12;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JRadioButton jRadioButton8;
    private javax.swing.JRadioButton jRadioButton9;
    // End of variables declaration//GEN-END:variables
}
