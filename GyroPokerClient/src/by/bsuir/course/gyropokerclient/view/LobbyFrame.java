/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.course.gyropokerclient.view;

import by.bsuir.course.gyropokerclient.connection.Connection;
import by.bsuir.course.gyropokerclient.entity.Player;
import by.bsuir.course.gyropokerclient.entity.Table;
import by.bsuir.course.gyropokerclient.entity.TableHeaders;
import by.bsuir.course.gyropokerclient.logic.FramesHandler;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Admin
 */
public class LobbyFrame extends javax.swing.JFrame {

    Player player;
    ArrayList<Table> tablesList;
    Connection con;

    /**
     * Creates new form LobbyFrame
     *
     * @param con
     * @param nick
     * @param surename
     * @param name
     * @param phone
     * @param address
     * @param email
     * @param balance
     * @param playMoney
     */
    public LobbyFrame(Connection con, Player player, ArrayList<Table> tables) {
        this.con = con;
        this.player = player;
        this.tablesList = tables;
        initComponents();
        setTableNames();
    }

    private void setTableNames() {
        TableHeaders th = new TableHeaders();
        ArrayList<String> header = th.getHeaders();
        for (int i = 0; i < this.tables.getColumnCount(); i++) {
            TableColumn column = this.tables.getTableHeader().getColumnModel().getColumn(i);
            column.setHeaderValue(header.get(i));
        }
        for (Table table : this.tablesList) {
            DefaultTableModel model = (DefaultTableModel) this.tables.getModel();
            model.addRow(new Object[]{table.name, table.limits, table.players});
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

        cashierBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tables = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cashierBtn.setLabel("Cashier");
        cashierBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cashierBtnActionPerformed(evt);
            }
        });

        tables.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Заголовок 1", "Заголовок 2", "Заголовок 3"
            }
        ));
        tables.setToolTipText("");
        tables.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tables.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tables);
        tables.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(198, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cashierBtn)
                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(cashierBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cashierBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cashierBtnActionPerformed

        CashierFrame cf = new CashierFrame(player);
        cf.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        cf.setVisible(true);

    }//GEN-LAST:event_cashierBtnActionPerformed

    private void tablesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablesMouseClicked
        int row = this.tables.rowAtPoint(evt.getPoint());
        String name = (String) this.tables.getModel().getValueAt(row, 0);
        boolean flag = false;
        for (TableFrame table : FramesHandler.getInstance().tables) {
            if (table.getTableName().equals(name)) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            StringBuilder sb = new StringBuilder();
            sb.append("TableInfo:")
                    .append(name);
            con.getSender().SendToServer(sb.toString());
        }

    }//GEN-LAST:event_tablesMouseClicked

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
            java.util.logging.Logger.getLogger(LobbyFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LobbyFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LobbyFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LobbyFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cashierBtn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tables;
    // End of variables declaration//GEN-END:variables
}
