/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem;


/**
 *
 * @author Hamza
 */
public class UIreg extends javax.swing.JFrame {

    /**
     * Creates new form Registration
     */
    public UIreg() {
        initComponents();
         jcbcourse.setVisible(false);
         jLabel9.setVisible(false);
          Admin adm= new Admin();
          adm.fillcombobox();
       for(int i=0;i<adm.fcb.length;i++)
       {
           if(adm.fcb[i]!=null)
           {
               jcbcourse.addItem(adm.fcb[i]);
           }
       }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jCheckBox3 = new javax.swing.JCheckBox();
        jPanel1 = new javax.swing.JPanel();
        jcbregister = new javax.swing.JComboBox<>();
        jtxtname = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jtxtpassport = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jcbcourse = new javax.swing.JComboBox<>();
        jbtnback = new javax.swing.JButton();
        jbtnsave = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtxtphone = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        jCheckBox7 = new javax.swing.JCheckBox();
        jCheckBox8 = new javax.swing.JCheckBox();
        jCheckBox9 = new javax.swing.JCheckBox();
        jCheckBox10 = new javax.swing.JCheckBox();
        jLabel9 = new javax.swing.JLabel();

        jRadioButton2.setText("jRadioButton2");

        jRadioButton1.setText("jRadioButton1");

        jCheckBox3.setText("jCheckBox3");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registration");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jcbregister.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Student", "Lecturer" }));
        jcbregister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbregisterActionPerformed(evt);
            }
        });
        jPanel1.add(jcbregister, new org.netbeans.lib.awtextra.AbsoluteConstraints(173, 102, 118, -1));

        jtxtname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtnameActionPerformed(evt);
            }
        });
        jPanel1.add(jtxtname, new org.netbeans.lib.awtextra.AbsoluteConstraints(173, 160, 118, -1));

        jLabel1.setText("Name:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(173, 140, -1, -1));

        jtxtpassport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtpassportActionPerformed(evt);
            }
        });
        jPanel1.add(jtxtpassport, new org.netbeans.lib.awtextra.AbsoluteConstraints(173, 218, 118, -1));

        jLabel2.setText("Password:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(173, 198, -1, -1));

        jLabel3.setText("Course:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 436, -1, -1));

        jcbcourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbcourseActionPerformed(evt);
            }
        });
        jPanel1.add(jcbcourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 520, 118, -1));

        jbtnback.setBackground(new java.awt.Color(0, 153, 153));
        jbtnback.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jbtnback.setForeground(new java.awt.Color(255, 255, 255));
        jbtnback.setText("Back");
        jbtnback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnbackActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnback, new org.netbeans.lib.awtextra.AbsoluteConstraints(302, 569, 100, -1));

        jbtnsave.setBackground(new java.awt.Color(0, 153, 153));
        jbtnsave.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jbtnsave.setForeground(new java.awt.Color(255, 255, 255));
        jbtnsave.setText("Save");
        jbtnsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnsaveActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnsave, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 569, 100, -1));

        jLabel4.setText("User:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(173, 82, -1, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 0, 102));
        jLabel5.setText("Sign-up");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(173, 11, -1, -1));

        jLabel6.setText("Phone Num：");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(173, 256, -1, -1));
        jPanel1.add(jtxtphone, new org.netbeans.lib.awtextra.AbsoluteConstraints(173, 276, 118, -1));

        jLabel7.setText("Semester: ");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(173, 320, -1, -1));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(173, 340, 118, -1));

        jLabel8.setText("Address: ");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(173, 378, -1, -1));
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 398, 308, -1));

        jCheckBox1.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox1.setText("OOP");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 436, -1, -1));

        jCheckBox2.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox2.setText("MVC");
        jPanel1.add(jCheckBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(208, 436, -1, -1));

        jCheckBox4.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox4.setText("Discrete Maths");
        jCheckBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox4ActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckBox4, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 436, -1, -1));

        jCheckBox5.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox5.setText("Pak Studies");
        jPanel1.add(jCheckBox5, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 459, -1, -1));

        jCheckBox6.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox6.setText("OOP Lab");
        jPanel1.add(jCheckBox6, new org.netbeans.lib.awtextra.AbsoluteConstraints(208, 459, -1, -1));

        jCheckBox7.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox7.setText("Digital Logic Design");
        jPanel1.add(jCheckBox7, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 459, -1, -1));

        jCheckBox8.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox8.setText("DLD Lab");
        jPanel1.add(jCheckBox8, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 482, -1, -1));

        jCheckBox9.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox9.setText("Calculus");
        jPanel1.add(jCheckBox9, new org.netbeans.lib.awtextra.AbsoluteConstraints(208, 482, -1, -1));

        jCheckBox10.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox10.setText("English");
        jPanel1.add(jCheckBox10, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 482, -1, -1));

        jLabel9.setText("Course To Teach:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 520, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 631, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(523, 669));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnsaveActionPerformed
           Admin admin = new Admin();
            switch((String)jcbregister.getSelectedItem()){
            case "Student":
                admin.registerstu((String)jcbregister.getSelectedItem(),jtxtname.getText(), jtxtpassport.getText(),jTextField2.getText(),jTextField1.getText(),jtxtphone.getText(),jCheckBox1.isSelected()
                ,jCheckBox2.isSelected(),jCheckBox4.isSelected(),jCheckBox5.isSelected(),jCheckBox6.isSelected(),jCheckBox7.isSelected(),jCheckBox8.isSelected(),jCheckBox9.isSelected(),jCheckBox10.isSelected());
             break;
            case "Lecturer":
                admin.registerlect((String)jcbregister.getSelectedItem(),jtxtname.getText(), jtxtpassport.getText(),jTextField2.getText(),jTextField1.getText(),jtxtphone.getText(),(String)jcbcourse.getSelectedItem());
                break;
       
       }
   if(admin.check==false)
   {
        dispose();
   }  
    }//GEN-LAST:event_jbtnsaveActionPerformed

    private void jbtnbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnbackActionPerformed
        dispose();
    }//GEN-LAST:event_jbtnbackActionPerformed

    private void jcbregisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbregisterActionPerformed
        // TODO add your handling code here:
         if(jcbregister.getSelectedItem().equals("Lecturer")){
        jCheckBox1.setVisible(false);
        jCheckBox2.setVisible(false);
        jCheckBox4.setVisible(false);
        jCheckBox5.setVisible(false);
        jCheckBox6.setVisible(false);
        jCheckBox7.setVisible(false);
        jCheckBox8.setVisible(false);
        jCheckBox9.setVisible(false);
        jCheckBox10.setVisible(false);
        jLabel3.setVisible(false);
        jcbcourse.setVisible(true);
        jLabel9.setVisible(true);}
        else{
        jCheckBox1.setVisible(true);
        jCheckBox2.setVisible(true);
        jCheckBox4.setVisible(true);
        jCheckBox5.setVisible(true);
        jCheckBox6.setVisible(true);
        jCheckBox7.setVisible(true);
        jCheckBox8.setVisible(true);
        jCheckBox9.setVisible(true);
        jCheckBox10.setVisible(true);
        jLabel3.setVisible(true);
        jcbcourse.setVisible(false);
        jLabel9.setVisible(false);
        }
        
    }//GEN-LAST:event_jcbregisterActionPerformed

    private void jcbcourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbcourseActionPerformed
        // TODO add your handling code here:
      
       
    }//GEN-LAST:event_jcbcourseActionPerformed

    private void jtxtnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtnameActionPerformed

    private void jtxtpassportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtpassportActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtpassportActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jCheckBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox4ActionPerformed


    
    
    
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
            java.util.logging.Logger.getLogger(UIreg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UIreg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UIreg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UIreg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
           java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UIreg().setVisible(true);
            }
        });
   
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox10;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JCheckBox jCheckBox9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JButton jbtnback;
    private javax.swing.JButton jbtnsave;
    private javax.swing.JComboBox<String> jcbcourse;
    private javax.swing.JComboBox<String> jcbregister;
    private javax.swing.JTextField jtxtname;
    private javax.swing.JTextField jtxtpassport;
    private javax.swing.JTextField jtxtphone;
    // End of variables declaration//GEN-END:variables
}
