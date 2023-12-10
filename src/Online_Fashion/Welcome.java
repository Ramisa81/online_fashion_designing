package Online_Fashion;

import java.util.prefs.Preferences;

public class Welcome extends javax.swing.JFrame {
    
    static public String email;
    static public String password;

     public Welcome(String loggedInUser, String a, String b) {
        initComponents();
        loadUserDataFromPreferences();
        this.email=a;
        this.password=b;
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setFont(new java.awt.Font("Georgia", 0, 36)); // NOI18N
        jButton1.setText("CONTINUE");
        jButton1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 500, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/video/ezgif.com-gif-maker.gif"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 690));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        whom s=new whom(email,password);
        s.show();
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void loadUserDataFromPreferences() {
        UserData.getName();
        Preferences preferences = Preferences.userNodeForPackage(UserData.class);

        UserData.setName(preferences.get("name", ""));
        UserData.setPhone(preferences.get("phone", ""));
        UserData.setDob(preferences.get("dob", ""));
        UserData.setId(preferences.get("id", ""));
        UserData.setAddress(preferences.get("address", ""));
    }
    public static void main(String args[]) {
      java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                String loggedInUser = null;
                Welcome welcomeFrame = new Welcome(loggedInUser,email,password);
                welcomeFrame.setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
