package Hunter;

import static Main.Connector.getConnection;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.xml.transform.Result;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class TeamExists extends JFrame {
    private JPanel mainWindow;
    private JPanel teamInfoPanel;
    private JLabel teamNameLabel;
    private JLabel teamName;
    private JLabel teamRank;
    private JLabel teamRankLabel;
    private JLabel currentMissionLabel;
    private JPanel currentMissionsPanel;
    private JScrollPane currentMissionPane;
    private JList currentMissionList;
    private JScrollPane teamMemberPane;
    private JLabel teamMemberLabel;
    private JPanel teamMemberPanel;
    private JList teamMemberList;
    private JPanel memberInfoPanel;
    private JLabel memberNameLabel;
    private JLabel memberLevelLabel;
    private JLabel memberRankLabel;
    private JLabel memberExpLabel;
    private JLabel memberName;
    private JLabel memberLevel;
    private JLabel memberRank;
    private JLabel memberExp;
    private JLabel teamLeadLabel;
    private JLabel teamLeadName;


    public TeamExists(int id) {
        // GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
        Connection connection = getConnection();
        ResultSet rs;
        Statement statement;
        ArrayList idList = new ArrayList();
        DefaultListModel<String> teamListModel = new DefaultListModel<>();
        DefaultListModel<String> missionListModel = new DefaultListModel<>();
        teamMemberList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        currentMissionList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        teamMemberList.setModel(teamListModel);
        currentMissionList.setModel(missionListModel);
        teamMemberList.addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent e) {
                Connection connection = getConnection();
                ResultSet rs;
                try {
                    Statement statement = connection.createStatement();
                    rs = statement.executeQuery("SELECT * FROM HUNTER WHERE HUNTERID = " + idList.get(e.getFirstIndex()));
                    rs.next();
                    memberName.setText(rs.getString(2));
                    memberRank.setText(rs.getString());

                } catch (SQLException excp) {
                    excp.printStackTrace();
                }

            }
        });

        /*TODO
        With the passed in Result set (should be just singleton) find out Name,Rank and the missions they are on. Oh fuck
         */
        /*
            1) SELECT * FROM Team WHERE hunterID = id;
                rs[0] = teamName
                rs[1] = teamRank
                rs[2] = hunterID

            2) SELECT * FROM Hunter WHERE hunterID = getIndexOfSelected():
                rs[0] = hunterID
                rs[1] = name
                rs[2] = age
                rs[3] = gender
                rs[4] = exp
                rs[5] = goldBalance
                rs[6] = teamName

            3) SELECT * FROM Hunting_missions, Item_Foraging_Mission WHERE teamName = (this team name);
                rs[0] = missionID
                rs[1] = hunterID
                rs[2] = teamName
                rs[3] = missionHolderID
                rs[4] = exp
                rs[5] = gold
                rs[6] = description
                rs[7] = deadline
                rs[8] = startTime
                rs[9] = accept
                rs[10] = completion
                rs[11] = forefeit
         */

        try {
            statement = connection.createStatement();
            //TODO Make method here: getTeamInfo
            rs = statement.executeQuery("SELECT * FROM Team WHERE hunterID = " + id);

            rs.next();
            teamName.setText(rs.getString(1));
            teamRank.setText(rs.getString(2));

            String teamNameString = teamName.getText();

            //TODO Make method here: getTeamMembers
            rs = statement.executeQuery("SELECT * FROM Hunter WHERE teamName = '" + teamNameString + "'");
            while (rs.next()) {
                String hunterName = rs.getString(2);
                teamLeadName.setText(hunterName);
                teamListModel.addElement(hunterName);
                idList.add(rs.getInt(1));
            }

            rs = statement.executeQuery("SELECT * FROM Hunting_missions h WHERE h.teamName = '" + teamNameString + "'");
            while (rs.next()) {
                missionListModel.addElement("Hunting Mission: " + rs.getInt(1));
            }

            rs = statement.executeQuery("SELECT  * FROM Item_Foraging_Mission WHERE teamName = '" + teamNameString + "'");
            while (rs.next()) {

                missionListModel.addElement("Item Mission: " + rs.getInt(1));
            }

        } catch (Exception e) {
            //TODO Proper logger message
            e.printStackTrace();
        }
        this.add(mainWindow);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(434, 550);
        this.setResizable(false);
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        mainWindow = new JPanel();
        mainWindow.setLayout(new GridBagLayout());
        mainWindow.setPreferredSize(new Dimension(400, 550));
        mainWindow.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), null));
        teamInfoPanel = new JPanel();
        teamInfoPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        gbc.weightx = 1.0;
        gbc.weighty = 0.1;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainWindow.add(teamInfoPanel, gbc);
        teamNameLabel = new JLabel();
        teamNameLabel.setText("Team Name:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        teamInfoPanel.add(teamNameLabel, gbc);
        teamRankLabel = new JLabel();
        teamRankLabel.setText("Team Rank:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        teamInfoPanel.add(teamRankLabel, gbc);
        teamName = new JLabel();
        teamName.setText("<team name>");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        teamInfoPanel.add(teamName, gbc);
        teamRank = new JLabel();
        teamRank.setText("<team rank>");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        teamInfoPanel.add(teamRank, gbc);
        teamLeadLabel = new JLabel();
        teamLeadLabel.setText("Team Leader:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 3;
        gbc.anchor = GridBagConstraints.WEST;
        teamInfoPanel.add(teamLeadLabel, gbc);
        teamLeadName = new JLabel();
        teamLeadName.setText("<team lead name>");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        teamInfoPanel.add(teamLeadName, gbc);
        final JPanel spacer1 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.VERTICAL;
        teamInfoPanel.add(spacer1, gbc);
        final JPanel spacer2 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.VERTICAL;
        teamInfoPanel.add(spacer2, gbc);
        currentMissionsPanel = new JPanel();
        currentMissionsPanel.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 0;
        gbc.gridheight = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        mainWindow.add(currentMissionsPanel, gbc);
        currentMissionLabel = new JLabel();
        currentMissionLabel.setText("Current Missions ");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        currentMissionsPanel.add(currentMissionLabel, gbc);
        currentMissionPane = new JScrollPane();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        currentMissionsPanel.add(currentMissionPane, gbc);
        currentMissionList = new JList();
        currentMissionList.setSelectionMode(0);
        currentMissionPane.setViewportView(currentMissionList);
        teamMemberPanel = new JPanel();
        teamMemberPanel.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        mainWindow.add(teamMemberPanel, gbc);
        teamMemberPane = new JScrollPane();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        teamMemberPanel.add(teamMemberPane, gbc);
        teamMemberList = new JList();
        teamMemberList.setSelectionMode(1);
        teamMemberPane.setViewportView(teamMemberList);
        teamMemberLabel = new JLabel();
        teamMemberLabel.setText("Team Members:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        teamMemberPanel.add(teamMemberLabel, gbc);
        memberInfoPanel = new JPanel();
        memberInfoPanel.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainWindow.add(memberInfoPanel, gbc);
        memberNameLabel = new JLabel();
        memberNameLabel.setText("Member Name:");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        memberInfoPanel.add(memberNameLabel, gbc);
        memberLevelLabel = new JLabel();
        memberLevelLabel.setText("Member Level:");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        memberInfoPanel.add(memberLevelLabel, gbc);
        memberRankLabel = new JLabel();
        memberRankLabel.setText("Member Rank:");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        memberInfoPanel.add(memberRankLabel, gbc);
        memberExpLabel = new JLabel();
        memberExpLabel.setText("Member Exp:");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        memberInfoPanel.add(memberExpLabel, gbc);
        memberName = new JLabel();
        memberName.setText("<member name>");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        memberInfoPanel.add(memberName, gbc);
        memberLevel = new JLabel();
        memberLevel.setText("<member level>");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        memberInfoPanel.add(memberLevel, gbc);
        memberRank = new JLabel();
        memberRank.setText("<member rank>");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        memberInfoPanel.add(memberRank, gbc);
        memberExp = new JLabel();
        memberExp.setText("<member exp>");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        memberInfoPanel.add(memberExp, gbc);
        final JPanel spacer3 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        memberInfoPanel.add(spacer3, gbc);
        final JPanel spacer4 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainWindow.add(spacer4, gbc);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return mainWindow;
    }
}
