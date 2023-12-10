package Online_Fashion;


import static Online_Fashion.Men.email;
import javax.swing.JButton;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Men2 extends javax.swing.JFrame {
    private static final String TABLE_NAME = "purchase";
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/client";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "database1";

    public static String email;
    public Men2(String a) {
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
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        OnyxSpecter = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        IronMonarch = new javax.swing.JButton();
        ZenithElite = new javax.swing.JButton();
        next = new javax.swing.JButton();
        main = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        CelestialNova = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MenImage/images (1).jpeg"))); // NOI18N
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 3));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(342, 182, 210, 210));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MenImage/download.jpeg"))); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153), 3));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, -1, 210));

        OnyxSpecter.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        OnyxSpecter.setText("Vanguard");
        OnyxSpecter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OnyxSpecterActionPerformed(evt);
            }
        });
        getContentPane().add(OnyxSpecter, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, 210, 40));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MenImage/images (2).jpeg"))); // NOI18N
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 3));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 180, -1, 210));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MenImage/images (3).jpeg"))); // NOI18N
        jLabel4.setText("jLabel4");
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 3));
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 180, 210, 210));

        IronMonarch.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        IronMonarch.setText("Apex");
        IronMonarch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IronMonarchActionPerformed(evt);
            }
        });
        getContentPane().add(IronMonarch, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 390, 210, 40));

        ZenithElite.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ZenithElite.setText("Havoc");
        ZenithElite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ZenithEliteActionPerformed(evt);
            }
        });
        getContentPane().add(ZenithElite, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 390, 210, 40));

        next.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        next.setText("Next");
        next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextActionPerformed(evt);
            }
        });
        getContentPane().add(next, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 40, 90, 40));

        main.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        main.setText("Previous");
        main.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainActionPerformed(evt);
            }
        });
        getContentPane().add(main, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 100, 40));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/rsz_1e__1_-removebg-preview.png"))); // NOI18N
        jLabel5.setText("jLabel5");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 30, 250, 80));

        CelestialNova.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        CelestialNova.setText("Vortex");
        CelestialNova.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CelestialNovaActionPerformed(evt);
            }
        });
        getContentPane().add(CelestialNova, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 390, 210, 40));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/solid-color-rainbow-palette-2qazhxjvr6qfvh02.jpg"))); // NOI18N
        jLabel6.setText("jLabel6");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1250, 710));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OnyxSpecterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OnyxSpecterActionPerformed
        // TODO add your handling code here:
        Colour r=new Colour(email);
        r.show();
        dispose();
    }//GEN-LAST:event_OnyxSpecterActionPerformed

    private void CelestialNovaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CelestialNovaActionPerformed
        // TODO add your handling code here:
        Colour r=new Colour(email);
        r.show();
        dispose();
    }//GEN-LAST:event_CelestialNovaActionPerformed

    private void IronMonarchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IronMonarchActionPerformed
        // TODO add your handling code here:
        Colour r=new Colour(email);
        r.show();
        dispose();
    }//GEN-LAST:event_IronMonarchActionPerformed

    private void ZenithEliteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ZenithEliteActionPerformed
        // TODO add your handling code here:
        Colour r=new Colour(email);
        r.show();
        dispose();
    }//GEN-LAST:event_ZenithEliteActionPerformed

    private void nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextActionPerformed
        
        Men3 s=new Men3(email);
        s.show();
        dispose();
    }//GEN-LAST:event_nextActionPerformed

    private void mainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainActionPerformed
        
        Men s=new Men(email);
        s.show();
        dispose();
    }//GEN-LAST:event_mainActionPerformed

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Men2(email).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CelestialNova;
    private javax.swing.JButton IronMonarch;
    private javax.swing.JButton OnyxSpecter;
    private javax.swing.JButton ZenithElite;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton main;
    private javax.swing.JButton next;
    // End of variables declaration//GEN-END:variables
}
