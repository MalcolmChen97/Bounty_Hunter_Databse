/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Leaderboard;

import static Main.Connector.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author omar
 */
public class LeaderBoardPanel extends javax.swing.JPanel {

    /**
     * Creates new form LeaderBoardPanel
     */
    public LeaderBoardPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mLeaderBoardTabs = new javax.swing.JTabbedPane();
        mHunterLeaderboardPanel = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        mHunterSortbyCombo = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        mHunterSearchText = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        mHunterLeaderboardTable = new javax.swing.JTable();
        mTeamLeaderboardPanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        mTeamLeaderboardTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        mTeamSearchText = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        mTeamSortbyCombo = new javax.swing.JComboBox<>();
        mItemLeaderboardPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        mItemSortbyCombo = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        mItemLeaderboardTable = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(800, 600));

        mHunterLeaderboardPanel.setPreferredSize(new java.awt.Dimension(800, 600));

        jLabel10.setText("Sort by:");

        mHunterSortbyCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Experience", "GoldBalance" }));
        mHunterSortbyCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mHunterSortbyComboActionPerformed(evt);
            }
        });

        jLabel11.setText("Find Hunter:");

        mHunterSearchText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mHunterSearchTextActionPerformed(evt);
            }
        });

        mHunterLeaderboardTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "Name", "Age", "Gender", "Exp", "Gold"
            }
        ));
        jScrollPane2.setViewportView(mHunterLeaderboardTable);

        javax.swing.GroupLayout mHunterLeaderboardPanelLayout = new javax.swing.GroupLayout(mHunterLeaderboardPanel);
        mHunterLeaderboardPanel.setLayout(mHunterLeaderboardPanelLayout);
        mHunterLeaderboardPanelLayout.setHorizontalGroup(
            mHunterLeaderboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mHunterLeaderboardPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mHunterLeaderboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1038, Short.MAX_VALUE)
                    .addGroup(mHunterLeaderboardPanelLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mHunterSearchText, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(mHunterSortbyCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        mHunterLeaderboardPanelLayout.setVerticalGroup(
            mHunterLeaderboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mHunterLeaderboardPanelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(mHunterLeaderboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(mHunterSearchText, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mHunterSortbyCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        mLeaderBoardTabs.addTab("Hunters", mHunterLeaderboardPanel);

        mTeamLeaderboardTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "Ranking", "Team Name", "Team Captain", "Avg Exp", "Level", "Members"
            }
        ));
        jScrollPane3.setViewportView(mTeamLeaderboardTable);

        jLabel1.setText("Find Team:");

        mTeamSearchText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mTeamSearchTextActionPerformed(evt);
            }
        });

        jLabel2.setText("Sort by:");

        mTeamSortbyCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Avg Exp", "Level" }));
        mTeamSortbyCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mTeamSortbyComboActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mTeamLeaderboardPanelLayout = new javax.swing.GroupLayout(mTeamLeaderboardPanel);
        mTeamLeaderboardPanel.setLayout(mTeamLeaderboardPanelLayout);
        mTeamLeaderboardPanelLayout.setHorizontalGroup(
            mTeamLeaderboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mTeamLeaderboardPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mTeamLeaderboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1038, Short.MAX_VALUE)
                    .addGroup(mTeamLeaderboardPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mTeamSearchText, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(mTeamSortbyCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        mTeamLeaderboardPanelLayout.setVerticalGroup(
            mTeamLeaderboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mTeamLeaderboardPanelLayout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addGroup(mTeamLeaderboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(mTeamSearchText, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(mTeamSortbyCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        mLeaderBoardTabs.addTab("Teams", mTeamLeaderboardPanel);

        jLabel3.setText("Hunters with all ");

        jLabel4.setText("rank items");

        mItemSortbyCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "S", "A", "B", "C", "D" }));
        mItemSortbyCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mItemSortbyComboActionPerformed(evt);
            }
        });

        mItemLeaderboardTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Ranking", "Name", "Exp", "Level", "Gold", "Age", "Gender"
            }
        ));
        jScrollPane4.setViewportView(mItemLeaderboardTable);

        javax.swing.GroupLayout mItemLeaderboardPanelLayout = new javax.swing.GroupLayout(mItemLeaderboardPanel);
        mItemLeaderboardPanel.setLayout(mItemLeaderboardPanelLayout);
        mItemLeaderboardPanelLayout.setHorizontalGroup(
            mItemLeaderboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mItemLeaderboardPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4)
                .addContainerGap())
            .addGroup(mItemLeaderboardPanelLayout.createSequentialGroup()
                .addGap(348, 348, 348)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mItemSortbyCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addContainerGap(454, Short.MAX_VALUE))
        );
        mItemLeaderboardPanelLayout.setVerticalGroup(
            mItemLeaderboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mItemLeaderboardPanelLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(mItemLeaderboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(mItemSortbyCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE)
                .addContainerGap())
        );

        mLeaderBoardTabs.addTab("Items", mItemLeaderboardPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mLeaderBoardTabs, javax.swing.GroupLayout.PREFERRED_SIZE, 1067, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mLeaderBoardTabs, javax.swing.GroupLayout.DEFAULT_SIZE, 607, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void mHunterSortbyComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mHunterSortbyComboActionPerformed
        String selection = (String) mHunterSortbyCombo.getSelectedItem();
        Connection con = getConnection();
        Statement stmt;
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(
                    "SELECT H.NAME, H.AGE, H.GENDER, H.EXPERIENCE, H.GOLDBALANCE " +
                    "FROM HUNTER H " +
                    "ORDER BY H." +  selection + " DESC");
            DefaultTableModel tableModel = (DefaultTableModel) mHunterLeaderboardTable.getModel();
            tableModel.setRowCount(0);
            while(rs.next()){
                String[] data = new String[5];
                data[0] = rs.getString(1); //NAME
                data[1] = rs.getString(2); //AGE
                data[2] = rs.getString(3); //GENDER
                data[3] = rs.getString(4); //EXPERIENCE
                data[4] = rs.getString(5); //GOLDBALANCE
                tableModel.addRow(data);
            }
            tableModel.fireTableDataChanged();
        } catch (SQLException ex) {
            Logger.getLogger(LeaderBoardPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        closeConnection();
    }//GEN-LAST:event_mHunterSortbyComboActionPerformed

    private void mHunterSearchTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mHunterSearchTextActionPerformed
        // TODO add your handling code here:
        String searchText = (String) mHunterSearchText.getText();
        System.out.println(searchText);
        String selection = (String) mHunterSortbyCombo.getSelectedItem();
        Connection con = getConnection();
        Statement stmt;
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(
                    "SELECT H.NAME, H.AGE, H.GENDER, H.EXPERIENCE, H.GOLDBALANCE " +
                    "FROM HUNTER H " +
                    "WHERE H.NAME LIKE '%" + searchText + "%' " +
                    "ORDER BY H." +  selection + " DESC");
            DefaultTableModel tableModel = (DefaultTableModel) mHunterLeaderboardTable.getModel();
            tableModel.setRowCount(0);
            while(rs.next()){
                String[] data = new String[5];
                data[0] = rs.getString(1); //NAME
                data[1] = rs.getString(2); //AGE
                data[2] = rs.getString(3); //GENDER
                data[3] = rs.getString(4); //EXPERIENCE
                data[4] = rs.getString(5); //GOLDBALANCE
                tableModel.addRow(data);
            }
            tableModel.fireTableDataChanged();
        } catch (SQLException ex) {
            Logger.getLogger(LeaderBoardPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        closeConnection();
        
    }//GEN-LAST:event_mHunterSearchTextActionPerformed

    private void mTeamSearchTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mTeamSearchTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mTeamSearchTextActionPerformed

    private void mTeamSortbyComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mTeamSortbyComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mTeamSortbyComboActionPerformed

    private void mItemSortbyComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItemSortbyComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mItemSortbyComboActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPanel mHunterLeaderboardPanel;
    private javax.swing.JTable mHunterLeaderboardTable;
    private javax.swing.JTextField mHunterSearchText;
    private javax.swing.JComboBox<String> mHunterSortbyCombo;
    private javax.swing.JPanel mItemLeaderboardPanel;
    private javax.swing.JTable mItemLeaderboardTable;
    private javax.swing.JComboBox<String> mItemSortbyCombo;
    private javax.swing.JTabbedPane mLeaderBoardTabs;
    private javax.swing.JPanel mTeamLeaderboardPanel;
    private javax.swing.JTable mTeamLeaderboardTable;
    private javax.swing.JTextField mTeamSearchText;
    private javax.swing.JComboBox<String> mTeamSortbyCombo;
    // End of variables declaration//GEN-END:variables
}
