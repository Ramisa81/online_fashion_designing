
package Online_Fashion;


import static Online_Fashion.whom.email;
import javax.swing.JButton;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Men3 extends javax.swing.JFrame {
    
    private static final String TABLE_NAME = "purchase";
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/client";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "database1";

    public static String email;
    public Men3(String a) {
        this.email=a;
        initComponents();
        addButtonsToActionListener();
    }
    
     private void addButtonsToActionListener() {
        for (java.awt.Component component : getContentPane().getComponents()) {
            if (component instanceof JButton) {
                JButton button = (JButton) component;
                button.addActionListener(this::buttonActionPerformed);
            }
        }
    }

    private void buttonActionPerformed(java.awt.event.ActionEvent evt) {
        if (evt.getSource() instanceof JButton) {
            JButton clickedButton = (JButton) evt.getSource();
            String buttonName = clickedButton.getText();
            saveButtonNameToDatabase(buttonName);
            Colour s=new Colour(email);
            s.show();
            dispose();
        }
    }

   private void saveButtonNameToDatabase(String buttonName) {
    try {
        Connection connection = java.sql.DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

        // Check if a record with the given email already exists
        if (recordExists(connection)) {
            // Record exists, perform update
            updateRecord(connection, buttonName);
        } else {
            // Record doesn't exist, perform insert
            insertRecord(connection, buttonName);
        }

        connection.close();
    } catch (java.sql.SQLException e) {
        e.printStackTrace();
    }
}

private boolean recordExists(Connection connection) throws java.sql.SQLException {
    String sql = "SELECT COUNT(*) FROM " + TABLE_NAME + " WHERE email=?";
    try (java.sql.PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
        preparedStatement.setString(1, email);
        try (ResultSet resultSet = preparedStatement.executeQuery()) {
            resultSet.next();
            int count = resultSet.getInt(1);
            return count > 0;
        }
    }
}

private void updateRecord(Connection connection, String buttonName) throws java.sql.SQLException {
    // Prepare the SQL update statement
    String sql = "UPDATE " + TABLE_NAME + " SET model=IFNULL(model, ?) WHERE email=?";
    
    try (java.sql.PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
        // Set the parameters with appropriate values
        preparedStatement.setString(1, buttonName);
        preparedStatement.setString(2, email);

        // Execute the update
        int rowsAffected = preparedStatement.executeUpdate();

        if (rowsAffected > 0) {
            System.out.println("Update successful: Email = " + email + ", model = " + buttonName);
        } else {
            System.out.println("No rows updated");
        }
    }
}

private void insertRecord(Connection connection, String buttonName) throws java.sql.SQLException {
    // Prepare the SQL insert statement
    String sql = "INSERT INTO " + TABLE_NAME + " (email, model) VALUES (?, ?)";
    
    try (java.sql.PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
        // Set the parameters with appropriate values
        preparedStatement.setString(1, email);
        preparedStatement.setString(2, buttonName);

        // Execute the insert
        int rowsAffected = preparedStatement.executeUpdate();

        if (rowsAffected > 0) {
            System.out.println("Insert successful: Email = " + email + ", model = " + buttonName);
        } else {
            System.out.println("No rows inserted");
        }
    }
}
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        VanguardSculpt = new javax.swing.JButton();
        NebulaPulse = new javax.swing.JButton();
        ArcticVortex = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        next = new javax.swing.JButton();
        main = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MenImage/images (4).jpeg"))); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 210, 210));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MenImage/images (5).jpeg"))); // NOI18N
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 208, -1, 210));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MenImage/images.jpeg"))); // NOI18N
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 210, -1, -1));

        VanguardSculpt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        VanguardSculpt.setText("Epoch");
        VanguardSculpt.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 102, 102)));
        VanguardSculpt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VanguardSculptActionPerformed(evt);
            }
        });
        getContentPane().add(VanguardSculpt, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 430, 210, 30));

        NebulaPulse.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        NebulaPulse.setText("Blossom");
        NebulaPulse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NebulaPulseActionPerformed(evt);
            }
        });
        getContentPane().add(NebulaPulse, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 420, 210, 30));

        ArcticVortex.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ArcticVortex.setText("Aurora");
        ArcticVortex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ArcticVortexActionPerformed(evt);
            }
        });
        getContentPane().add(ArcticVortex, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 420, 210, 30));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/rsz_1e__1_-removebg-preview.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 30, 220, 90));

        next.setBackground(new java.awt.Color(0, 102, 102));
        next.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        next.setForeground(new java.awt.Color(255, 255, 255));
        next.setText("Go Back");
        next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextActionPerformed(evt);
            }
        });
        getContentPane().add(next, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 40, 120, 50));

        main.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        main.setText("Previous");
        main.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 102, 102)));
        main.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainActionPerformed(evt);
            }
        });
        getContentPane().add(main, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 130, 50));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/six-colored-best-ipad-11thxkwrdfmyi0cd.jpg"))); // NOI18N
        jLabel5.setToolTipText("");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1240, 584));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void VanguardSculptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VanguardSculptActionPerformed
        
        Colour r=new Colour(email);
        r.show();
        dispose();
    }//GEN-LAST:event_VanguardSculptActionPerformed

    private void NebulaPulseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NebulaPulseActionPerformed
        
        Colour r=new Colour(email);
        r.show();
        dispose();
    }//GEN-LAST:event_NebulaPulseActionPerformed

    private void ArcticVortexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ArcticVortexActionPerformed
        
        Colour r=new Colour(email);
        r.show();
        dispose();
    }//GEN-LAST:event_ArcticVortexActionPerformed

    private void mainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainActionPerformed
        // TODO add your handling code here:
        Men2 s=new Men2(email);
        s.show();
        dispose();
    }//GEN-LAST:event_mainActionPerformed

    private void nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextActionPerformed
        // TODO add your handling code here:
        Men s=new Men(email);
        s.show();
        dispose();
    }//GEN-LAST:event_nextActionPerformed

    
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Men3(email).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ArcticVortex;
    private javax.swing.JButton NebulaPulse;
    private javax.swing.JButton VanguardSculpt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton main;
    private javax.swing.JButton next;
    // End of variables declaration//GEN-END:variables
}
