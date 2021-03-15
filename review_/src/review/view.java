
package review;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class view extends javax.swing.JFrame {
    void clearTable() {
x=table.getRowCount(); x--;
for( ;x>=0;x--)
dtm.removeRow(x); }
    
    Connection con;
    Statement stmt; ResultSet rs;
String query; DefaultTableModel dtm; int x;


public view() throws SQLException {
initComponents();

do{

dtm=(DefaultTableModel)table.getModel();
try {
con=DriverManager.getConnection("jdbc:mysql://localhost/review_system","root","");
stmt=con.createStatement();
query="select coursecode,facultyname,review from review"; 
rs=stmt.executeQuery(query);
while(rs.next())
{
dtm.addRow(new
Object[]{rs.getString("coursecode"),rs.getString("facultyname"),rs.getString("review")}); }
int row=table.getRowCount(); if(row==0)
{
JOptionPane.showMessageDialog(null,"No Review Posted"); new view_post_feedback().setVisible(true);
this.dispose();
} }
catch (Exception e) {
JOptionPane.showMessageDialog(null,e.getMessage()); }
}while(rs.next());

}    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("View Feedback");

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Course Code", "Faculty Name", "Feedback"
            }
        ));
        jScrollPane1.setViewportView(table);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 582, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new view().setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(view.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
