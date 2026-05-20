package com.mycompany.gymmanagementsystem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import database.ConnectionProvider;
import javax.swing.JOptionPane;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class home extends javax.swing.JFrame {

    private JPanel sidebar;
    private JPanel mainPanel;
    private JLabel title;
    private JLabel subtitle;

    private JButton btnDashboard;
    private JButton btnAddMember;
    private JButton btnManageMember;
    private JButton btnTrainer;
    private JButton btnPayments;
    private JButton btnMemberList;
    private JButton btnLogout;

    private JPanel card1;
    private JPanel card2;
    private JPanel card3;
    private JPanel card4;

    public home() {
        initComponents();
    }

    private void initComponents() {

        setTitle("Gym Dashboard");
        setSize(1400, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // ================= COLORS =================

        Color background = Color.WHITE;
        Color green = new Color(0, 120, 215);

        // ================= SIDEBAR =================

        sidebar = new JPanel();
        sidebar.setBorder(
                BorderFactory.createMatteBorder(0, 0, 0, 2, Color.BLACK)
        );
        sidebar.setPreferredSize(new Dimension(250, 800));
        sidebar.setLayout(null);
        sidebar.setBackground(new Color(245, 245, 245));

        JLabel logo = new JLabel("GYM");
        logo.setBounds(80, 40, 150, 50);
        logo.setForeground(green);
        logo.setFont(new Font("Segoe UI", Font.BOLD, 36));

        sidebar.add(logo);

        // ================= BUTTONS =================

        btnDashboard = createButton("Dashboard", 140);
        btnAddMember = createButton("Add Member", 210);
        btnManageMember = createButton("Manage Member", 280);
        btnTrainer = createButton("Trainers", 350);
        btnPayments = createButton("Payments", 420);
        btnMemberList = createButton("Member List", 490);
        btnLogout = createButton("Logout", 620);

        sidebar.add(btnDashboard);
        sidebar.add(btnAddMember);
        sidebar.add(btnManageMember);
        sidebar.add(btnTrainer);
        sidebar.add(btnPayments);
        sidebar.add(btnMemberList);
        sidebar.add(btnLogout);

        // ================= MAIN PANEL =================

        mainPanel = new JPanel();
        mainPanel.setBackground(background);
        mainPanel.setLayout(null);

        title = new JLabel("WELCOME BACK");
        title.setBounds(380, 50, 500, 50);
        title.setForeground(Color.BLACK);
        title.setFont(new Font("Segoe UI", Font.BOLD, 42));

        subtitle = new JLabel("GYM MANAGEMENT SYSTEM");
        subtitle.setBounds(300, 110, 700, 50);
        subtitle.setForeground(green);
        subtitle.setFont(new Font("Segoe UI", Font.BOLD, 36));

        mainPanel.add(title);
        mainPanel.add(subtitle);

        // ================= CARDS =================

        card1 = createCard("TOTAL MEMBERS", getTotalMembers(), 180, 220);
        card2 = createCard("ACTIVE PAYMENTS", getActivePayments(), 530, 220);
        card3 = createCard("TRAINERS", getTotalTrainers(), 180, 450);
        card4 = createCard("MONTHLY REVENUE", getRevenue(), 530, 450);

        mainPanel.add(card1);
        mainPanel.add(card2);
        mainPanel.add(card3);
        mainPanel.add(card4);

        // ================= BUTTON ACTIONS =================

        btnAddMember.addActionListener(e -> {

            try {

                setVisible(false);

                new newMember().setVisible(true);

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(null, ex);

                ex.printStackTrace();
            }
        });

        btnManageMember.addActionListener(e -> {

            try {

                setVisible(false);

                new editMember().setVisible(true);

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(null, ex);

                ex.printStackTrace();
            }
        });

        btnTrainer.addActionListener(e -> {

            try {

                setVisible(false);

                new trainer().setVisible(true);

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(null, ex);

                ex.printStackTrace();
            }
        });

        btnPayments.addActionListener(e -> {

            try {

                setVisible(false);

                new payment().setVisible(true);

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(null, ex);

                ex.printStackTrace();
            }
        });

        btnMemberList.addActionListener(e -> {

            try {

                setVisible(false);

                new memberList().setVisible(true);

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(null, ex);

                ex.printStackTrace();
            }
        });

        btnLogout.addActionListener(e -> {

            int logout = JOptionPane.showConfirmDialog(
                    null,
                    "Do you want to logout?",
                    "Logout",
                    JOptionPane.YES_NO_OPTION
            );

            if (logout == JOptionPane.YES_OPTION) {

                setVisible(false);

                new login().setVisible(true);
            }
        });

        // ================= ADD PANELS =================

        add(sidebar, BorderLayout.WEST);
        add(mainPanel, BorderLayout.CENTER);
    }

    // ================= BUTTON METHOD =================

    private JButton createButton(String text, int y) {

        JButton btn = new JButton(text);

        btn.setBounds(20, y, 210, 50);

        btn.setBackground(Color.WHITE);
        btn.setForeground(Color.BLACK);

        btn.setFocusPainted(false);

        btn.setFont(new Font("Segoe UI", Font.BOLD, 18));

        btn.setBorder(new LineBorder(Color.BLACK, 2));

        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        return btn;
    }

    // ================= CARD METHOD =================

    private JPanel createCard(String title, String value, int x, int y) {

        JPanel panel = new JPanel();

        panel.setLayout(null);

        panel.setBounds(x, y, 280, 170);

        panel.setBackground(Color.WHITE);

        panel.setBorder(new LineBorder(Color.BLACK, 2));

        JLabel lblTitle = new JLabel(title);

        lblTitle.setBounds(30, 30, 220, 30);

        lblTitle.setForeground(Color.BLACK);

        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 20));

        JLabel lblValue = new JLabel(value);

        lblValue.setBounds(30, 80, 220, 50);

        lblValue.setForeground(new Color(0, 255, 180));

        lblValue.setFont(new Font("Segoe UI", Font.BOLD, 38));

        panel.add(lblTitle);

        panel.add(lblValue);

        return panel;
    }

    // ================= DATABASE METHODS =================

    private String getTotalMembers() {

        String total = "0";

        try {

            Connection con = ConnectionProvider.getConnection();

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(
                    "SELECT COUNT(*) FROM member"
            );

            if (rs.next()) {

                total = rs.getString(1);
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e);

            e.printStackTrace();
        }

        return total;
    }

    private String getActivePayments() {

        String total = "0";

        try {

            Connection con = ConnectionProvider.getConnection();

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(
                    "SELECT COUNT(*) FROM payment WHERE status='Paid'"
            );

            if (rs.next()) {

                total = rs.getString(1);
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e);

            e.printStackTrace();
        }

        return total;
    }

    private String getTotalTrainers() {

        String total = "0";

        try {

            Connection con = ConnectionProvider.getConnection();

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(
                    "SELECT COUNT(*) FROM trainer"
            );

            if (rs.next()) {

                total = rs.getString(1);
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e);

            e.printStackTrace();
        }

        return total;
    }

    private String getRevenue() {

        String total = "$0";

        try {

            Connection con = ConnectionProvider.getConnection();

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(
                    "SELECT SUM(amountPay) FROM payment WHERE status='Paid'"
            );

            if (rs.next()) {

                String amount = rs.getString(1);

                if (amount != null) {

                    total = "$" + amount;
                }
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e);

            e.printStackTrace();
        }

        return total;
    }

    // ================= MAIN METHOD =================

    public static void main(String args[]) {

        try {

            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName()
            );

        } catch (Exception e) {

            e.printStackTrace();
        }

        java.awt.EventQueue.invokeLater(() -> {

            new home().setVisible(true);
        });
    }
}