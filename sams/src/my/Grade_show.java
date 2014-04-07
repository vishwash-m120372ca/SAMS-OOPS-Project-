/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package my;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author SUJAY
 */
public class Grade_show extends javax.swing.JFrame {

    /**
     * Creates new form Grade_show
     */
    public Grade_show() {
        initComponents();
    }

    public void DoConnect1 ()
     {        
        try {
            Class driver_class;
            driver_class = Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex){
            System.out.println("Mysql JDBC driver not found");
            System.exit(1);
        }
        
        
        String url = "jdbc:mysql://localhost:3306/sams_db";
        String user = "sams_user";
        String password= "m120361ca";
        Connection connection = null;
        ResultSet result = null;
        Statement st = null;
        
        try {
            connection = DriverManager.getConnection(url, user, password);
            st = connection.createStatement(); 
            st.execute("SELECT * from grade WHERE semester='"+jComboBox1.getSelectedItem().toString() +"'");
            result = st.getResultSet();
            if(result.next()==false)
            {
                jTextArea1.setText("No Record Found For "+ jComboBox1.getSelectedItem().toString() +" !");
            }
            else
            {
                result.previous();
                int total_credit = 0, total_point = 0, point=0 ;
                float sgpa=0;
                while(result.next())
                {
                    total_credit= total_credit + result.getInt("credit");
                    if (result.getString("grade").matches("S"))
                        point= 10;
                    else if (result.getString("grade").matches("A"))
                        point= 9;
                    else if (result.getString("grade").matches("B"))
                        point= 8;
                    else if (result.getString("grade").matches("C"))
                        point= 7;
                    else if (result.getString("grade").matches("D"))
                        point= 6;
                    else if (result.getString("grade").matches("E"))
                        point= 5;
                    else if (result.getString("grade").matches("F"))
                        point= 0;
                    total_point = total_point + point * result.getInt("credit");
                }                
                if(total_credit != 0)
                    sgpa= (float)total_point / total_credit;
                jTextArea1.setText(" SGPA for  "+ jComboBox1.getSelectedItem().toString() +"  ->   "+ (float)Math.round(sgpa * 100)/100 +" ");
            }
        } catch (SQLException ex){
            Logger.getLogger(login.class.getName()).log(Level.SEVERE,null,ex);
        } finally {
            if (result!= null)
            {
                try {
                    result.close();
                } catch (SQLException ex) {
                    Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
                }
                if(st!=null)
                {
                    try {
                        st.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if(connection != null)
                {
                    try {
                        connection.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
     }
    
    public void DoConnect2 ()
     {        
        try {
            Class driver_class;
            driver_class = Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex){
            System.out.println("Mysql JDBC driver not found");
            System.exit(1);
        }
        
        
        String url = "jdbc:mysql://localhost:3306/sams_db";
        String user = "sams_user";
        String password= "m120361ca";
        Connection connection = null;
        ResultSet result = null;
        Statement st = null;
        
        try {
            connection = DriverManager.getConnection(url, user, password);
            st = connection.createStatement(); 
            st.execute("SELECT * from grade WHERE semester='"+jComboBox1.getSelectedItem().toString() +"'");
            result = st.getResultSet();
            if(result.next()==false)
            {
                jTextArea1.setText("No Record Found For "+ jComboBox1.getSelectedItem().toString() +" !");
            }
            else
            {
                result.previous();
                String rslt = ""; 
                while(result.next())
                {
                    rslt= rslt + result.getString("subject")+ "  ->  "+ result.getString("grade")+"\n";
                } 
                jTextArea1.setText(rslt);
            }
        } catch (SQLException ex){
            Logger.getLogger(login.class.getName()).log(Level.SEVERE,null,ex);
        } finally {
            if (result!= null)
            {
                try {
                    result.close();
                } catch (SQLException ex) {
                    Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
                }
                if(st!=null)
                {
                    try {
                        st.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if(connection != null)
                {
                    try {
                        connection.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
     }
    
    public void DoConnect3 ()
     {        
        try {
            Class driver_class;
            driver_class = Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex){
            System.out.println("Mysql JDBC driver not found");
            System.exit(1);
        }
        
        
        String url = "jdbc:mysql://localhost:3306/sams_db";
        String user = "sams_user";
        String password= "m120361ca";
        Connection connection = null;
        ResultSet result = null;
        Statement st = null;
        
        try {
            connection = DriverManager.getConnection(url, user, password);
            st = connection.createStatement(); 
            st.execute("SELECT * from grade WHERE semester='"+jComboBox1.getSelectedItem().toString() +"' AND subject='"+ jTextField1.getText() +"'");
            result = st.getResultSet();
            if(result.next()==false)
            {
                jTextArea1.setText("No Record Found For "+ jTextField1.getText() +" in "+ jComboBox1.getSelectedItem().toString() +" !");
            }
            else
            {
                jTextArea1.setText("Grade in "+ jTextField1.getText()+ " is "+ result.getString("grade"));
            }
        } catch (SQLException ex){
            Logger.getLogger(login.class.getName()).log(Level.SEVERE,null,ex);
        } finally {
            if (result!= null)
            {
                try {
                    result.close();
                } catch (SQLException ex) {
                    Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
                }
                if(st!=null)
                {
                    try {
                        st.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if(connection != null)
                {
                    try {
                        connection.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
     }
    
    public void DoConnect4 ()
     {        
        try {
            Class driver_class;
            driver_class = Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex){
            System.out.println("Mysql JDBC driver not found");
            System.exit(1);
        }
        
        
        String url = "jdbc:mysql://localhost:3306/sams_db";
        String user = "sams_user";
        String password= "m120361ca";
        Connection connection = null;
        ResultSet result = null;
        Statement st = null;
        
        try {
            connection = DriverManager.getConnection(url, user, password);
            st = connection.createStatement(); 
            st.execute("SELECT * from grade WHERE grade='"+jComboBox2.getSelectedItem().toString() +"'");
            result = st.getResultSet();
            if(result.next()==false)
            {
                jTextArea1.setText("No Subject Found with grade "+ jComboBox2.getSelectedItem().toString()+" !");
            }
            else
            {
                result.previous();
                String rslt = ""; 
                while(result.next())
                {
                    rslt= rslt + result.getString("subject")+ "\n";
                } 
                jTextArea1.setText(rslt);
            }
        } catch (SQLException ex){
            Logger.getLogger(login.class.getName()).log(Level.SEVERE,null,ex);
        } finally {
            if (result!= null)
            {
                try {
                    result.close();
                } catch (SQLException ex) {
                    Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
                }
                if(st!=null)
                {
                    try {
                        st.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if(connection != null)
                {
                    try {
                        connection.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
     }
    
    public void DoConnect5 ()
     {        
        try {
            Class driver_class;
            driver_class = Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex){
            System.out.println("Mysql JDBC driver not found");
            System.exit(1);
        }
        
        
        String url = "jdbc:mysql://localhost:3306/sams_db";
        String user = "sams_user";
        String password= "m120361ca";
        Connection connection = null;
        ResultSet result = null;
        Statement st = null;
        
        try {
            connection = DriverManager.getConnection(url, user, password);
            st = connection.createStatement(); 
            st.execute("SELECT * from grade");
            result = st.getResultSet();
            if(result.next()==false)
            {
                jTextArea1.setText("No Record Found  !");
            }
            else
            {
                result.previous();
                int total_credit = 0, total_point = 0, point=0 ;
                float cgpa=0;
                while(result.next())
                {
                    total_credit= total_credit + result.getInt("credit");
                    if (result.getString("grade").matches("S"))
                        point= 10;
                    else if (result.getString("grade").matches("A"))
                        point= 9;
                    else if (result.getString("grade").matches("B"))
                        point= 8;
                    else if (result.getString("grade").matches("C"))
                        point= 7;
                    else if (result.getString("grade").matches("D"))
                        point= 6;
                    else if (result.getString("grade").matches("E"))
                        point= 5;
                    else if (result.getString("grade").matches("F"))
                        point= 0;
                    total_point = total_point + point * result.getInt("credit");
                }                
                if(total_credit != 0)
                    cgpa= (float)total_point / total_credit;
                jTextArea1.setText(" CGPA   ->   "+ (float)Math.round(cgpa * 100)/100 +" ");
            }
        } catch (SQLException ex){
            Logger.getLogger(login.class.getName()).log(Level.SEVERE,null,ex);
        } finally {
            if (result!= null)
            {
                try {
                    result.close();
                } catch (SQLException ex) {
                    Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
                }
                if(st!=null)
                {
                    try {
                        st.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if(connection != null)
                {
                    try {
                        connection.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        jLabel1.setText("Semester    :");

        jComboBox1.setMaximumRowCount(6);
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SEMESTER 1", "SEMESTER 2", "SEMESTER 3", "SEMESTER 4", "SEMESTER 5", "SEMESTER 6" }));

        jButton1.setText("SEMESTER GRADE POINT AVERAGE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Subject       :");

        jButton2.setText("GRADE IN THE SUBJECT");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setText("Grade         :");

        jComboBox2.setMaximumRowCount(7);
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "S", "A", "B", "C", "D", "E", "F" }));

        jButton3.setText("SUBJECTS HAVING THE GRADE");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("RESULT");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("CUMULATIVE GRADE POINT AVERAGE");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(30, 30, 30)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jButton3)
                                            .addComponent(jButton2)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(50, 50, 50)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jButton4)
                                            .addComponent(jButton1)))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(233, 233, 233)))
                        .addGap(0, 12, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addGap(22, 22, 22)
                .addComponent(jButton5)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(539, 453));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         jTextArea1.setText("");
         DoConnect1();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
         jTextArea1.setText("");
         DoConnect2();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         jTextArea1.setText("");
         DoConnect3();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
         jTextArea1.setText("");
         DoConnect4();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
         jTextArea1.setText("");
         DoConnect5();
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(Grade_show.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Grade_show.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Grade_show.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Grade_show.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Grade_show().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
