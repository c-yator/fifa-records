package fifa;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lenovo
 */
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.Border;
public class Login_form extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login_form() {
        initComponents();
        //centre the form
        this.setLocationRelativeTo(null);
        //create a green border for the jpanel_title
        Border jpanel_title_border=BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GREEN);
        jpanel_title.setBorder(jpanel_title_border);
        // Border color=BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK);
        //jLabel_exit.setBorder(color);
        //jLabel_minimise.setBorder(color);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jpanel_title = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel_user = new javax.swing.JLabel();
        jLabel_password = new javax.swing.JLabel();
        jTextField_username = new javax.swing.JTextField();
        jPasswordField = new javax.swing.JPasswordField();
        jButton_login = new javax.swing.JButton();
        jLabel_signup = new javax.swing.JLabel();
        jLabel_exit = new javax.swing.JLabel();
        jLabel_minimise = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(51, 255, 51));

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));

        jLabel1.setBackground(new java.awt.Color(102, 102, 0));
        jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 24)); // NOI18N
        jLabel1.setText("  LOGIN");

        javax.swing.GroupLayout jpanel_titleLayout = new javax.swing.GroupLayout(jpanel_title);
        jpanel_title.setLayout(jpanel_titleLayout);
        jpanel_titleLayout.setHorizontalGroup(
            jpanel_titleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanel_titleLayout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        jpanel_titleLayout.setVerticalGroup(
            jpanel_titleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_titleLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 10, Short.MAX_VALUE))
        );

        jLabel_user.setText("username:");

        jLabel_password.setText("password:");

        jTextField_username.setForeground(new java.awt.Color(153, 153, 153));
        jTextField_username.setText("username");
        jTextField_username.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_usernameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField_usernameFocusLost(evt);
            }
        });

        jPasswordField.setText("password");
        jPasswordField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPasswordFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jPasswordFieldFocusLost(evt);
            }
        });

        jButton_login.setBackground(new java.awt.Color(0, 0, 204));
        jButton_login.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton_login.setText("LOGIN");
        jButton_login.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton_loginMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton_loginMouseExited(evt);
            }
        });
        jButton_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_loginActionPerformed(evt);
            }
        });

        jLabel_signup.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel_signup.setText("Don't have an account? Sign up here.");
        jLabel_signup.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_signup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_signupMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel_signupMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel_signupMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_user)
                            .addComponent(jLabel_password))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton_login, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                            .addComponent(jTextField_username)
                            .addComponent(jPasswordField)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(jLabel_signup, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_user, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_password, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(jButton_login)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_signup)
                .addContainerGap(60, Short.MAX_VALUE))
        );

        //set icon into the jlabel
        //jLabel_user.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com.icons/usernameicon.png")));
        //set icon into the jlabel
        //jLabel_user.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com.icons/usernameicon.png")));

        jLabel_exit.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel_exit.setText("X");
        jLabel_exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_exitMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel_exitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel_exitMouseExited(evt);
            }
        });

        jLabel_minimise.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel_minimise.setText("-");
        jLabel_minimise.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_minimiseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel_minimiseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel_minimiseMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(151, 151, 151)
                .addComponent(jpanel_title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 153, Short.MAX_VALUE)
                .addComponent(jLabel_minimise, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel_exit, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpanel_title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel_minimise, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel_exit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(49, 49, 49)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField_usernameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_usernameFocusGained
        if(jTextField_username.getText().trim().toLowerCase().equals("username")){
            jTextField_username.setText("");
            jTextField_username.setForeground(Color.BLACK);
        }
        Border user=BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GREEN);
        jLabel_user.setBorder(user);
    }//GEN-LAST:event_jTextField_usernameFocusGained

    private void jTextField_usernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_usernameFocusLost
        if(jTextField_username.getText().trim().equals("") || jTextField_username.getText().trim().toLowerCase().equals("username")){
            jTextField_username.setText("username");
             jTextField_username.setForeground(Color.GRAY);   
        }
        jLabel_user.setBorder(null);
    }//GEN-LAST:event_jTextField_usernameFocusLost

    private void jPasswordFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPasswordFieldFocusGained
       String pass=String.valueOf(jPasswordField.getPassword());
        if(pass.trim().toLowerCase().equals("password")){
            jPasswordField.setText("");
            jPasswordField.setForeground(Color.BLACK);
        }
        Border user=BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GREEN);
        jLabel_password.setBorder(user);
    }//GEN-LAST:event_jPasswordFieldFocusGained

    private void jPasswordFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPasswordFieldFocusLost
         String pass=String.valueOf(jPasswordField.getPassword());
        if(pass.trim().equals("") || pass.trim().toLowerCase().equals("password")){
            jPasswordField.setText("password");
             jPasswordField.setForeground(Color.GRAY);   
        }
        jLabel_password.setBorder(null);
    }//GEN-LAST:event_jPasswordFieldFocusLost

    private void jButton_loginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_loginMouseEntered
       jButton_login.setBackground(Color.CYAN);
    }//GEN-LAST:event_jButton_loginMouseEntered

    private void jButton_loginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_loginMouseExited
         jButton_login.setBackground(Color.BLUE);
    }//GEN-LAST:event_jButton_loginMouseExited

    private void jLabel_exitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_exitMouseEntered
        jLabel_exit.setForeground(Color.WHITE);
    }//GEN-LAST:event_jLabel_exitMouseEntered

    private void jLabel_exitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_exitMouseExited
        jLabel_exit.setForeground(Color.BLACK);
    }//GEN-LAST:event_jLabel_exitMouseExited

    private void jLabel_exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_exitMouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel_exitMouseClicked

    private void jLabel_minimiseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_minimiseMouseEntered
        jLabel_minimise.setForeground(Color.WHITE);
    }//GEN-LAST:event_jLabel_minimiseMouseEntered

    private void jLabel_minimiseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_minimiseMouseExited
        jLabel_minimise.setForeground(Color.BLACK);
    }//GEN-LAST:event_jLabel_minimiseMouseExited

    private void jLabel_minimiseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_minimiseMouseClicked
         this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jLabel_minimiseMouseClicked

    private void jLabel_signupMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_signupMouseEntered
      jLabel_signup.setForeground(Color.blue);
    }//GEN-LAST:event_jLabel_signupMouseEntered

    private void jLabel_signupMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_signupMouseExited
        jLabel_signup.setForeground(Color.black);
    }//GEN-LAST:event_jLabel_signupMouseExited

    private void jLabel_signupMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_signupMouseClicked
        Register_Form form=new Register_Form();
        form.setVisible(true);
        form.pack();
        form.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jLabel_signupMouseClicked

    private void jButton_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_loginActionPerformed
    PreparedStatement st;
    ResultSet rs;
    //get username and password
    String username=jTextField_username.getText();
    String password=String.valueOf(jPasswordField.getPassword());
    //create a select query to check if the username and the password exist in the database
    //String query="SELECT* FROM 'user' WHERE 'username'=? AND 'password'=?";
    String query="Select* from users where username=? and password=?";
        try {
           st=My_Cnx.getConnection().prepareStatement(query);
            st.setString(1,username);
            st.setString(2,password);
            rs=st.executeQuery();
            if(rs.next()){
              Home_Page form=new Home_Page();
        form.setVisible(true);
        form.pack();
        form.setLocationRelativeTo(null);
        this.dispose();  
            }else{
                JOptionPane.showMessageDialog(null,"Invalid username/password.","login error",2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login_form.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
     
    }//GEN-LAST:event_jButton_loginActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login_form().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_login;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel_exit;
    private javax.swing.JLabel jLabel_minimise;
    private javax.swing.JLabel jLabel_password;
    private javax.swing.JLabel jLabel_signup;
    private javax.swing.JLabel jLabel_user;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JTextField jTextField_username;
    private javax.swing.JPanel jpanel_title;
    // End of variables declaration//GEN-END:variables
}
