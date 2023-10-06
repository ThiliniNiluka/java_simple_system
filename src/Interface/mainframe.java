
package Interface;

import code.DBconnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class mainframe extends javax.swing.JFrame {
    
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs =null;

    /**
     * Creates new form mainframe
     */
    public mainframe() {
        initComponents();
        conn = DBconnect.connect();
        tableload();
    }

    public void tableload(){
        
        try
        {
            String sql = "Select id AS ID, sname AS NAME, sage AS AGE, sgrade AS GRADE From student";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            table1.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void tabledata(){
        
        int r = table1.getSelectedRow();
        
        String id = table1.getValueAt(r, 0).toString();
        String name = table1.getValueAt(r, 1).toString();
        String age = table1.getValueAt(r, 2).toString();
        String grade= table1.getValueAt(r, 3).toString();
        
        idbox.setText(id);
        namebox.setText(name);
        agebox.setText(age);
        gradebox.setSelectedItem(grade);
    }
    
    public void search(){
        
        String srch = serachbox.getText();
        
        try{
            String sql = "Select * from student where sname LIKE  '%"+srch+"%' OR id LIKE '%"+srch+"%'";
            pst =conn.prepareStatement(sql);
            rs = pst.executeQuery();
            table1.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void update(){
        
        String id= idbox.getText();
        String name = namebox.getText();
        String age = agebox.getText();
        String grade = gradebox.getSelectedItem().toString();
        
        try
        {
            String sql = "Update student SET sname='"+name+"', sage='"+age+"', sgrade='"+grade+"' Where id='"+id+"'";
            pst =conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Succesfully Updated!");
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void clear(){
        
        serachbox.setText("");
        idbox.setText("ID");
        namebox.setText("");
        agebox.setText("");
        gradebox.setSelectedIndex(0);
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        serachbox = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        agebox = new javax.swing.JTextField();
        gradebox = new javax.swing.JComboBox();
        namebox = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        insertbtn = new javax.swing.JButton();
        updatebtn = new javax.swing.JButton();
        deletebtn = new javax.swing.JButton();
        clearbtn = new javax.swing.JButton();
        exitbtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        idbox = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(153, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(0, 204, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        serachbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                serachboxActionPerformed(evt);
            }
        });
        serachbox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                serachboxKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(serachbox, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(serachbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 24, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 320, 70));

        jPanel4.setBackground(new java.awt.Color(204, 153, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Name");
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Age");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Grade");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        agebox.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        agebox.setToolTipText("Enter your age");
        agebox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ageboxActionPerformed(evt);
            }
        });
        jPanel4.add(agebox, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 220, -1));

        gradebox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        gradebox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13" }));
        gradebox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gradeboxActionPerformed(evt);
            }
        });
        jPanel4.add(gradebox, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 80, 30));

        namebox.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        namebox.setToolTipText("Enter your name");
        namebox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameboxActionPerformed(evt);
            }
        });
        jPanel4.add(namebox, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 220, -1));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 320, 230));

        jPanel5.setBackground(new java.awt.Color(255, 204, 102));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        insertbtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        insertbtn.setText("Insert");
        insertbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertbtnActionPerformed(evt);
            }
        });
        jPanel5.add(insertbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        updatebtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        updatebtn.setText("Update");
        updatebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatebtnActionPerformed(evt);
            }
        });
        jPanel5.add(updatebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(199, 20, -1, -1));

        deletebtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        deletebtn.setText("Delete");
        deletebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletebtnActionPerformed(evt);
            }
        });
        jPanel5.add(deletebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        clearbtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        clearbtn.setText("Clear");
        clearbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearbtnActionPerformed(evt);
            }
        });
        jPanel5.add(clearbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, 80, -1));

        exitbtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        exitbtn.setText("Exit");
        exitbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitbtnActionPerformed(evt);
            }
        });
        jPanel5.add(exitbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 80, -1));

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, 320, 150));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("ID");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, -1));

        idbox.setText("ID");
        jPanel2.add(idbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 610));

        table1.setBackground(new java.awt.Color(255, 204, 255));
        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table1MouseClicked(evt);
            }
        });
        table1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                table1KeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(table1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, 670, 610));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 610));

        setSize(new java.awt.Dimension(1064, 649));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void serachboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_serachboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_serachboxActionPerformed

    private void gradeboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gradeboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gradeboxActionPerformed

    private void nameboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameboxActionPerformed

    private void ageboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ageboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ageboxActionPerformed

    private void deletebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletebtnActionPerformed
        // TODO add your handling code here:
        int check = JOptionPane.showConfirmDialog(null, "Do you want to delete!");
        
        if(check==0)
        {
            String id = idbox.getText();
            
            try
            {
                String sql = "Delete from student where id='"+id+"'";
                pst = conn.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(null, "Succesfully Deleted!");
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, "");
            }
            
        }
            tableload();
            clear();

    }//GEN-LAST:event_deletebtnActionPerformed

    private void clearbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearbtnActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_clearbtnActionPerformed

    private void exitbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitbtnActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_exitbtnActionPerformed

    private void insertbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertbtnActionPerformed
        // TODO add your handling code here:
        String name;
        int age;
        int grade;
        
        name = namebox.getText();
        age = Integer.parseInt(agebox.getText());
        grade = Integer.parseInt(gradebox.getSelectedItem().toString());
        
        try
        {
            String sql = "Insert into student(sname,sage,sgrade) Values('"+name+"','"+age+"','"+grade+"')";
            pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Succesfully inserted!");
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        
        tableload();
        
    }//GEN-LAST:event_insertbtnActionPerformed

    private void updatebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatebtnActionPerformed
        // TODO add your handling code here:
        update();
        tableload();
    }//GEN-LAST:event_updatebtnActionPerformed

    private void table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table1MouseClicked
        // TODO add your handling code here:
        tabledata();
    }//GEN-LAST:event_table1MouseClicked

    private void table1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_table1KeyReleased
        // TODO add your handling code here:
        tabledata();
    }//GEN-LAST:event_table1KeyReleased

    private void serachboxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_serachboxKeyReleased
        // TODO add your handling code here:
        search();
    }//GEN-LAST:event_serachboxKeyReleased

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
            java.util.logging.Logger.getLogger(mainframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainframe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField agebox;
    private javax.swing.JButton clearbtn;
    private javax.swing.JButton deletebtn;
    private javax.swing.JButton exitbtn;
    private javax.swing.JComboBox gradebox;
    private javax.swing.JLabel idbox;
    private javax.swing.JButton insertbtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField namebox;
    private javax.swing.JTextField serachbox;
    private javax.swing.JTable table1;
    private javax.swing.JButton updatebtn;
    // End of variables declaration//GEN-END:variables
}
