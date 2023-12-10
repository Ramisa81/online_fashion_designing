
package Online_Fashion;

import javax.swing.JButton;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Men extends javax.swing.JFrame {

    private static final String TABLE_NAME = "purchase";
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/client";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "database1";
    
    static public String email;
    
    public Men(String a) {
        this.email=a;
        initComponents();
        addButtonsToActionListener();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        next = new javax.swing.JButton();
        main = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        ShadowRogue = new javax.swing.JButton();
        NightshadeBlaze = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        next.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        next.setText("Next");
        next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextActionPerformed(evt);
            }
        });

        main.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        main.setText("Main Menu");
        main.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(main)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 708, Short.MAX_VALUE)
                .addComponent(next, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(main)
                    .addComponent(next))
                .addGap(28, 28, 28))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 970, 90));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MenImage/11111111111111111.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 500, 490));

        ShadowRogue.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ShadowRogue.setText("SPARTAN");
        ShadowRogue.setName("SPARTAN"); // NOI18N
        ShadowRogue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShadowRogueActionPerformed(evt);
            }
        });
        getContentPane().add(ShadowRogue, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 620, 500, -1));

        NightshadeBlaze.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        NightshadeBlaze.setText("MAVERICK");
        NightshadeBlaze.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NightshadeBlazeActionPerformed(evt);
            }
        });
        getContentPane().add(NightshadeBlaze, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 620, 470, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MenImage/embroidered-clothing-men-shirt-vyshyvanka-three-snails_421.jpg"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 30, -1, 540));

        jLabel1.setBackground(new java.awt.Color(0, 204, 204));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("550");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 570, 80, -1));

        jLabel3.setBackground(new java.awt.Color(0, 204, 204));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel3.setText("500");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 570, 80, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

private boolean recordExists(Connection connection) throws SQLException {
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

private void updateRecord(Connection connection, String buttonName) throws SQLException {
    // Prepare the SQL update statement
    String sql = "UPDATE " + TABLE_NAME + " SET model=IFNULL(model, ?) WHERE email=?";
    
    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
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

private void insertRecord(Connection connection, String buttonName) throws SQLException {
    // Prepare the SQL insert statement
    String sql = "INSERT INTO " + TABLE_NAME + " (email, model) VALUES (?, ?)";
    
    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
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
    
    private void ShadowRogueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShadowRogueActionPerformed
        // TODO add your handling code here:
        Colour r=new Colour(email);
        r.show();
        dispose();
    }//GEN-LAST:event_ShadowRogueActionPerformed

    private void NightshadeBlazeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NightshadeBlazeActionPerformed
        
        Colour r=new Colour(email);
        r.show();
        dispose();
    }//GEN-LAST:event_NightshadeBlazeActionPerformed

    private void mainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainActionPerformed

        whom a=new whom();
        a.show();
        dispose();
    }//GEN-LAST:event_mainActionPerformed

    private void nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextActionPerformed
        Men2 s=new Men2(email);
        s.show();
        dispose();
    }//GEN-LAST:event_nextActionPerformed

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Men(email).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton NightshadeBlaze;
    private javax.swing.JButton ShadowRogue;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton main;
    private javax.swing.JButton next;
    // End of variables declaration//GEN-END:variables
}
