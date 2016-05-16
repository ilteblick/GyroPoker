/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.course.gyropokerclient.view;

import by.bsuir.course.gyropokerclient.connection.Connection;
import by.bsuir.course.gyropokerclient.logic.FramesHandler;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author Admin
 */
public class TableFrame extends javax.swing.JFrame {

    private String name;
    private Integer place = 0;
    private Integer buttonPosition = 0;

    public String getTableName() {
        return this.name;
    }

    private int sb;
    private int bb;
    private String blinds;
    private String nick;
    private Connection con;

    /**
     * Creates new form TableFrame
     *
     * @param con
     * @param info
     * @param nick
     */
    public TableFrame(Connection con, ArrayList<String> info, String nick) {
        this.con = con;
        this.nick = nick;
        this.name = info.get(1);
        this.blinds = info.get(2);
        this.setTitle(name + " " + blinds + "logged as " + nick);
        initComponents();
        this.initPlayers(info);
        this.standUpBtn.setVisible(false);
        this.initLbls();
    }
    
    private void initLbls(){
        this.Player1Card1.setLocation(460, 50);
        this.Player1Card2.setLocation(500, 50);
        
        this.Player2Card1.setLocation(560, 240);
        this.Player2Card2.setLocation(600, 240);
        
        this.Player3Card1.setLocation(470, 380);
        this.Player3Card2.setLocation(510, 380);
        
        this.Player4Card1.setLocation(300, 400);
        this.Player4Card2.setLocation(340, 400);
        
        this.Player5Card1.setLocation(60, 260);
        this.Player5Card2.setLocation(100, 260);
        
        this.Player6Card1.setLocation(170, 20);
        this.Player6Card2.setLocation(210, 20);
    }
    
    private void initPlayerCards(int place, String firstCard, String secondCard,
            JLabel firstCardL, JLabel secondCardL){
        firstCardL.setVisible(true);
        secondCardL.setVisible(true);
        if(this.place == place){
            firstCardL.setText(firstCard);
            secondCardL.setText(secondCard);
        }else{
            if(firstCard.equals("Z")){
                firstCardL.setText("");
                secondCardL.setText("");
            }else{
                firstCardL.setText("X");
                secondCardL.setText("X");
            }
            
        }
    }

    public void drawPreFlop(ArrayList<String> info){
        this.card1.setText("");
        this.card2.setText("");
        this.card3.setText("");
        this.card4.setText("");
        this.card5.setText("");
        
        this.initPlayerCards(1, info.get(2), info.get(3),
                this.Player1Card1, this.Player1Card2);
        this.initPlayerCards(2, info.get(4), info.get(5),
                this.Player2Card1, this.Player2Card2);
        this.initPlayerCards(3, info.get(6), info.get(7),
                this.Player3Card1, this.Player3Card2);
        this.initPlayerCards(4, info.get(8), info.get(9),
                this.Player4Card1, this.Player4Card2);
        this.initPlayerCards(5, info.get(10), info.get(11),
                this.Player5Card1, this.Player5Card2);
        this.initPlayerCards(6, info.get(12), info.get(13),
                this.Player6Card1, this.Player6Card2);
    }
    
    public void drawFlop(ArrayList<String> info){
        this.card1.setText(info.get(1));
        this.card2.setText(info.get(2));
        this.card3.setText(info.get(3));
    }
    
    public void drawTurn(ArrayList<String> info){
        this.card4.setText(info.get(1));
    }
    
    public void drawRiver(ArrayList<String> info){
        this.card5.setText(info.get(1));
    }
    
    
    private void initPlayer(String nick, String cash, String bets, JLabel nickL,
            JLabel cashL, JLabel betsL, JButton seat) {

        if (!nick.equals("0")) {
            seat.setVisible(false);
            nickL.setVisible(true);
            betsL.setVisible(true);
            cashL.setVisible(true);
            nickL.setText(nick);
            betsL.setText(bets);
            cashL.setText(cash);
        } else {
            if (this.place == 0) {
                seat.setVisible(true);
            }else{
                seat.setVisible(false);
            }
            nickL.setVisible(false);
            betsL.setVisible(false);
            cashL.setVisible(false);
        }

    }

    private void seatHandler(Integer place) {
        StringBuilder stringBuilder = new StringBuilder();
        this.place = place;
        stringBuilder.append("Seat")
                .append(":")
                .append(this.name)
                .append(":")
                .append(this.nick)
                .append(":")
                .append(Integer.toString(place))
                .append(":")
                .append("100");
        this.con.getSender().SendToServer(stringBuilder.toString());
    }
    
    private void showActions(int place){
        if(this.place == place){
            this.foldBtn.setVisible(true);
            this.callBtn.setVisible(true);
            this.raiseBtn.setVisible(true);
            this.raiseField.setVisible(true);
        }else{
            this.foldBtn.setVisible(false);
            this.callBtn.setVisible(false);
            this.raiseBtn.setVisible(false);
            this.raiseField.setVisible(false);
        }
    }

    public void drawTable(ArrayList<String> info) {
        if(info.get(6).equals("false")){
            this.Player1Card1.setVisible(false);
            this.Player1Card2.setVisible(false);
        }
        if(info.get(10).equals("false")){
            this.Player2Card1.setVisible(false);
            this.Player2Card2.setVisible(false);
        }
        if(info.get(14).equals("false")){
            this.Player3Card1.setVisible(false);
            this.Player3Card2.setVisible(false);
        }
        if(info.get(18).equals("false")){
            this.Player4Card1.setVisible(false);
            this.Player4Card2.setVisible(false);
        }
        if(info.get(22).equals("false")){
            this.Player5Card1.setVisible(false);
            this.Player5Card2.setVisible(false);
        }
        if(info.get(26).equals("false")){
            this.Player6Card1.setVisible(false);
            this.Player6Card2.setVisible(false);
        }
        if (this.place == 0) {
            this.standUpBtn.setVisible(false);
            this.hideBtns();
        } else {
            this.standUpBtn.setVisible(true);
        }
        this.initPlayers(info);
        this.showActions(Integer.parseInt(info.get(28)));
        this.pot.setText(info.get(27));
        
    }

    private void initPlayers(ArrayList<String> info) {
        this.initPlayer(info.get(3), info.get(4), info.get(5),
                Player1Nick, Player1Cash, Player1Bets, Player1Seat);
        this.initPlayer(info.get(7), info.get(8), info.get(9),
                Player2Nick, Player2Cash, Player2Bets, Player2Seat);
        this.initPlayer(info.get(11), info.get(12), info.get(13),
                Player3Nick, Player3Cash, Player3Bets, Player3Seat);
        this.initPlayer(info.get(15), info.get(16), info.get(17),
                Player4Nick, Player4Cash, Player4Bets, Player4Seat);
        this.initPlayer(info.get(19), info.get(20), info.get(21),
                Player5Nick, Player5Cash, Player5Bets, Player5Seat);
        this.initPlayer(info.get(23), info.get(24), info.get(25),
                Player6Nick, Player6Cash, Player6Bets, Player6Seat);
    }

    private void hideBtns() {
        this.Player1Seat.setVisible(false);
        this.Player2Seat.setVisible(false);
        this.Player3Seat.setVisible(false);
        this.Player4Seat.setVisible(false);
        this.Player5Seat.setVisible(false);
        this.Player6Seat.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Player1Nick = new javax.swing.JLabel();
        Player1Cash = new javax.swing.JLabel();
        Player1Seat = new javax.swing.JButton();
        Player1Bets = new javax.swing.JLabel();
        Player2Bets = new javax.swing.JLabel();
        Player2Nick = new javax.swing.JLabel();
        Player2Cash = new javax.swing.JLabel();
        Player2Seat = new javax.swing.JButton();
        Player3Bets = new javax.swing.JLabel();
        Player3Nick = new javax.swing.JLabel();
        Player3Cash = new javax.swing.JLabel();
        Player3Seat = new javax.swing.JButton();
        Player4Bets = new javax.swing.JLabel();
        Player4Nick = new javax.swing.JLabel();
        Player4Cash = new javax.swing.JLabel();
        Player4Seat = new javax.swing.JButton();
        Player5Bets = new javax.swing.JLabel();
        Player5Nick = new javax.swing.JLabel();
        Player5Cash = new javax.swing.JLabel();
        Player5Seat = new javax.swing.JButton();
        Player6Bets = new javax.swing.JLabel();
        Player6Nick = new javax.swing.JLabel();
        Player6Cash = new javax.swing.JLabel();
        Player6Seat = new javax.swing.JButton();
        standUpBtn = new javax.swing.JButton();
        card1 = new javax.swing.JLabel();
        card2 = new javax.swing.JLabel();
        card3 = new javax.swing.JLabel();
        card4 = new javax.swing.JLabel();
        card5 = new javax.swing.JLabel();
        Player1Card1 = new javax.swing.JLabel();
        Player1Card2 = new javax.swing.JLabel();
        Player2Card1 = new javax.swing.JLabel();
        Player2Card2 = new javax.swing.JLabel();
        Player3Card1 = new javax.swing.JLabel();
        Player3Card2 = new javax.swing.JLabel();
        Player4Card1 = new javax.swing.JLabel();
        Player4Card2 = new javax.swing.JLabel();
        Player5Card1 = new javax.swing.JLabel();
        Player5Card2 = new javax.swing.JLabel();
        Player6Card1 = new javax.swing.JLabel();
        Player6Card2 = new javax.swing.JLabel();
        foldBtn = new javax.swing.JButton();
        callBtn = new javax.swing.JButton();
        raiseBtn = new javax.swing.JButton();
        raiseField = new javax.swing.JTextField();
        pot = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1000, 600));
        setMinimumSize(new java.awt.Dimension(1000, 600));
        setPreferredSize(new java.awt.Dimension(1000, 600));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        Player1Nick.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        Player1Nick.setForeground(new java.awt.Color(51, 0, 255));
        Player1Nick.setText("jLabel1");
        Player1Nick.setOpaque(true);
        getContentPane().add(Player1Nick);
        Player1Nick.setBounds(590, 50, 45, 17);

        Player1Cash.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        Player1Cash.setForeground(new java.awt.Color(51, 153, 0));
        Player1Cash.setText("jLabel2");
        Player1Cash.setOpaque(true);
        getContentPane().add(Player1Cash);
        Player1Cash.setBounds(590, 80, 40, 17);

        Player1Seat.setText("Seat");
        Player1Seat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Player1SeatActionPerformed(evt);
            }
        });
        getContentPane().add(Player1Seat);
        Player1Seat.setBounds(580, 100, 90, 23);

        Player1Bets.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        Player1Bets.setForeground(new java.awt.Color(255, 51, 51));
        Player1Bets.setText("jLabel1");
        Player1Bets.setOpaque(true);
        getContentPane().add(Player1Bets);
        Player1Bets.setBounds(500, 120, 54, 22);

        Player2Bets.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        Player2Bets.setForeground(new java.awt.Color(255, 51, 51));
        Player2Bets.setText("jLabel1");
        Player2Bets.setOpaque(true);
        getContentPane().add(Player2Bets);
        Player2Bets.setBounds(550, 310, 54, 22);

        Player2Nick.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        Player2Nick.setForeground(new java.awt.Color(51, 0, 255));
        Player2Nick.setText("jLabel1");
        Player2Nick.setOpaque(true);
        getContentPane().add(Player2Nick);
        Player2Nick.setBounds(660, 260, 45, 17);

        Player2Cash.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        Player2Cash.setForeground(new java.awt.Color(51, 153, 0));
        Player2Cash.setText("jLabel2");
        Player2Cash.setOpaque(true);
        getContentPane().add(Player2Cash);
        Player2Cash.setBounds(660, 290, 40, 17);

        Player2Seat.setText("Seat");
        Player2Seat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Player2SeatActionPerformed(evt);
            }
        });
        getContentPane().add(Player2Seat);
        Player2Seat.setBounds(650, 320, 100, 23);

        Player3Bets.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        Player3Bets.setForeground(new java.awt.Color(255, 51, 51));
        Player3Bets.setText("jLabel1");
        Player3Bets.setOpaque(true);
        getContentPane().add(Player3Bets);
        Player3Bets.setBounds(440, 350, 54, 22);

        Player3Nick.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        Player3Nick.setForeground(new java.awt.Color(51, 0, 255));
        Player3Nick.setText("jLabel1");
        Player3Nick.setOpaque(true);
        getContentPane().add(Player3Nick);
        Player3Nick.setBounds(512, 433, 45, 17);

        Player3Cash.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        Player3Cash.setForeground(new java.awt.Color(51, 153, 0));
        Player3Cash.setText("jLabel2");
        Player3Cash.setOpaque(true);
        getContentPane().add(Player3Cash);
        Player3Cash.setBounds(512, 450, 40, 17);

        Player3Seat.setText("Seat");
        Player3Seat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Player3SeatActionPerformed(evt);
            }
        });
        getContentPane().add(Player3Seat);
        Player3Seat.setBounds(502, 473, 70, 23);

        Player4Bets.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        Player4Bets.setForeground(new java.awt.Color(255, 51, 51));
        Player4Bets.setText("jLabel1");
        Player4Bets.setOpaque(true);
        getContentPane().add(Player4Bets);
        Player4Bets.setBounds(290, 350, 54, 22);

        Player4Nick.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        Player4Nick.setForeground(new java.awt.Color(51, 0, 255));
        Player4Nick.setText("jLabel1");
        Player4Nick.setOpaque(true);
        getContentPane().add(Player4Nick);
        Player4Nick.setBounds(300, 440, 45, 17);

        Player4Cash.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        Player4Cash.setForeground(new java.awt.Color(51, 153, 0));
        Player4Cash.setText("jLabel2");
        Player4Cash.setOpaque(true);
        getContentPane().add(Player4Cash);
        Player4Cash.setBounds(300, 460, 40, 17);

        Player4Seat.setText("Seat");
        Player4Seat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Player4SeatActionPerformed(evt);
            }
        });
        getContentPane().add(Player4Seat);
        Player4Seat.setBounds(290, 480, 100, 23);

        Player5Bets.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        Player5Bets.setForeground(new java.awt.Color(255, 51, 51));
        Player5Bets.setText("jLabel1");
        Player5Bets.setOpaque(true);
        getContentPane().add(Player5Bets);
        Player5Bets.setBounds(160, 300, 54, 22);

        Player5Nick.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        Player5Nick.setForeground(new java.awt.Color(51, 0, 255));
        Player5Nick.setText("jLabel1");
        Player5Nick.setOpaque(true);
        getContentPane().add(Player5Nick);
        Player5Nick.setBounds(70, 310, 45, 17);

        Player5Cash.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        Player5Cash.setForeground(new java.awt.Color(51, 153, 0));
        Player5Cash.setText("jLabel2");
        Player5Cash.setOpaque(true);
        getContentPane().add(Player5Cash);
        Player5Cash.setBounds(70, 330, 40, 17);

        Player5Seat.setText("Seat");
        Player5Seat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Player5SeatActionPerformed(evt);
            }
        });
        getContentPane().add(Player5Seat);
        Player5Seat.setBounds(60, 350, 80, 23);

        Player6Bets.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        Player6Bets.setForeground(new java.awt.Color(255, 51, 51));
        Player6Bets.setText("jLabel1");
        Player6Bets.setOpaque(true);
        getContentPane().add(Player6Bets);
        Player6Bets.setBounds(170, 100, 54, 20);

        Player6Nick.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        Player6Nick.setForeground(new java.awt.Color(51, 0, 255));
        Player6Nick.setText("jLabel1");
        Player6Nick.setOpaque(true);
        getContentPane().add(Player6Nick);
        Player6Nick.setBounds(100, 20, 45, 20);

        Player6Cash.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        Player6Cash.setForeground(new java.awt.Color(51, 153, 0));
        Player6Cash.setText("jLabel2");
        Player6Cash.setOpaque(true);
        getContentPane().add(Player6Cash);
        Player6Cash.setBounds(100, 50, 40, 20);

        Player6Seat.setText("Seat");
        Player6Seat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Player6SeatActionPerformed(evt);
            }
        });
        getContentPane().add(Player6Seat);
        Player6Seat.setBounds(90, 70, 70, 20);

        standUpBtn.setText("StandUp");
        standUpBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                standUpBtnActionPerformed(evt);
            }
        });
        getContentPane().add(standUpBtn);
        standUpBtn.setBounds(800, 10, 73, 23);

        card1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        card1.setForeground(new java.awt.Color(0, 0, 255));
        card1.setText("ab");
        card1.setOpaque(true);
        getContentPane().add(card1);
        card1.setBounds(220, 180, 50, 42);

        card2.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        card2.setForeground(new java.awt.Color(0, 0, 255));
        card2.setText("ab");
        card2.setOpaque(true);
        getContentPane().add(card2);
        card2.setBounds(280, 180, 50, 42);

        card3.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        card3.setForeground(new java.awt.Color(0, 0, 255));
        card3.setText("ab");
        card3.setOpaque(true);
        getContentPane().add(card3);
        card3.setBounds(340, 180, 50, 42);

        card4.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        card4.setForeground(new java.awt.Color(0, 0, 255));
        card4.setText("ab");
        card4.setOpaque(true);
        getContentPane().add(card4);
        card4.setBounds(400, 180, 50, 42);

        card5.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        card5.setForeground(new java.awt.Color(0, 0, 255));
        card5.setText("ab");
        card5.setOpaque(true);
        getContentPane().add(card5);
        card5.setBounds(460, 180, 50, 42);

        Player1Card1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Player1Card1.setForeground(new java.awt.Color(0, 0, 255));
        Player1Card1.setText("card");
        getContentPane().add(Player1Card1);
        Player1Card1.setBounds(460, 50, 40, 22);

        Player1Card2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Player1Card2.setForeground(new java.awt.Color(0, 0, 255));
        Player1Card2.setText("card");
        getContentPane().add(Player1Card2);
        Player1Card2.setBounds(500, 50, 60, 22);

        Player2Card1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Player2Card1.setForeground(new java.awt.Color(0, 0, 255));
        Player2Card1.setText("card");
        getContentPane().add(Player2Card1);
        Player2Card1.setBounds(500, 240, 40, 22);

        Player2Card2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Player2Card2.setForeground(new java.awt.Color(0, 0, 255));
        Player2Card2.setText("card");
        getContentPane().add(Player2Card2);
        Player2Card2.setBounds(540, 240, 60, 22);

        Player3Card1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Player3Card1.setForeground(new java.awt.Color(0, 0, 255));
        Player3Card1.setText("card");
        getContentPane().add(Player3Card1);
        Player3Card1.setBounds(470, 380, 40, 22);

        Player3Card2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Player3Card2.setForeground(new java.awt.Color(0, 0, 255));
        Player3Card2.setText("card");
        getContentPane().add(Player3Card2);
        Player3Card2.setBounds(510, 380, 60, 22);

        Player4Card1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Player4Card1.setForeground(new java.awt.Color(0, 0, 255));
        Player4Card1.setText("card");
        getContentPane().add(Player4Card1);
        Player4Card1.setBounds(300, 400, 40, 22);

        Player4Card2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Player4Card2.setForeground(new java.awt.Color(0, 0, 255));
        Player4Card2.setText("card");
        getContentPane().add(Player4Card2);
        Player4Card2.setBounds(340, 400, 60, 22);

        Player5Card1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Player5Card1.setForeground(new java.awt.Color(0, 0, 255));
        Player5Card1.setText("card");
        getContentPane().add(Player5Card1);
        Player5Card1.setBounds(60, 260, 40, 22);

        Player5Card2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Player5Card2.setForeground(new java.awt.Color(0, 0, 255));
        Player5Card2.setText("card");
        getContentPane().add(Player5Card2);
        Player5Card2.setBounds(100, 260, 60, 22);

        Player6Card1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Player6Card1.setForeground(new java.awt.Color(0, 0, 255));
        Player6Card1.setText("card");
        getContentPane().add(Player6Card1);
        Player6Card1.setBounds(170, 20, 40, 22);

        Player6Card2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Player6Card2.setForeground(new java.awt.Color(0, 0, 255));
        Player6Card2.setText("card");
        getContentPane().add(Player6Card2);
        Player6Card2.setBounds(210, 20, 60, 22);

        foldBtn.setBackground(new java.awt.Color(255, 0, 0));
        foldBtn.setText("FOLD");
        foldBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                foldBtnActionPerformed(evt);
            }
        });
        getContentPane().add(foldBtn);
        foldBtn.setBounds(619, 510, 70, 23);

        callBtn.setBackground(new java.awt.Color(255, 0, 0));
        callBtn.setText("check/call");
        callBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                callBtnActionPerformed(evt);
            }
        });
        getContentPane().add(callBtn);
        callBtn.setBounds(700, 510, 80, 23);

        raiseBtn.setBackground(new java.awt.Color(255, 0, 0));
        raiseBtn.setText("Raise");
        raiseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                raiseBtnActionPerformed(evt);
            }
        });
        getContentPane().add(raiseBtn);
        raiseBtn.setBounds(790, 510, 70, 23);

        raiseField.setBackground(new java.awt.Color(255, 0, 0));
        getContentPane().add(raiseField);
        raiseField.setBounds(790, 480, 70, 20);

        pot.setText("jLabel1");
        pot.setOpaque(true);
        getContentPane().add(pot);
        pot.setBounds(340, 250, 34, 14);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Player1SeatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Player1SeatActionPerformed
        this.seatHandler(1);
    }//GEN-LAST:event_Player1SeatActionPerformed

    private void Player2SeatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Player2SeatActionPerformed
        this.seatHandler(2);
    }//GEN-LAST:event_Player2SeatActionPerformed

    private void Player3SeatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Player3SeatActionPerformed
        this.seatHandler(3);
    }//GEN-LAST:event_Player3SeatActionPerformed

    private void Player4SeatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Player4SeatActionPerformed
        this.seatHandler(4);
    }//GEN-LAST:event_Player4SeatActionPerformed

    private void Player5SeatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Player5SeatActionPerformed
        this.seatHandler(5);
    }//GEN-LAST:event_Player5SeatActionPerformed

    private void Player6SeatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Player6SeatActionPerformed
        this.seatHandler(6);
    }//GEN-LAST:event_Player6SeatActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if (place != 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("StandUP")
                    .append(":")
                    .append(this.name)
                    .append(":")
                    .append(Integer.toString(this.place));
            place = 0;
            con.getSender().SendToServer(stringBuilder.toString());
        }
        for (TableFrame table : FramesHandler.getInstance().tables) {
            if (table.name.equals(this.name)) {
                FramesHandler.getInstance().tables.remove(table);
                break;
            }
        }
    }//GEN-LAST:event_formWindowClosing

    private void standUpBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_standUpBtnActionPerformed
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("StandUP")
                .append(":")
                .append(this.name)
                .append(":")
                .append(Integer.toString(this.place));
        place = 0;
        con.getSender().SendToServer(stringBuilder.toString());
    }//GEN-LAST:event_standUpBtnActionPerformed

    private void foldBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_foldBtnActionPerformed
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Fold")
                .append(":")
                .append(this.name)
                .append(":")
                .append(Integer.toString(this.place));
        con.getSender().SendToServer(stringBuilder.toString());
    }//GEN-LAST:event_foldBtnActionPerformed

    private void callBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_callBtnActionPerformed
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Call")
                .append(":")
                .append(this.name)
                .append(":")
                .append(Integer.toString(this.place));
        con.getSender().SendToServer(stringBuilder.toString());
    }//GEN-LAST:event_callBtnActionPerformed

    private void raiseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_raiseBtnActionPerformed
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Raise")
                .append(":")
                .append(this.name)
                .append(":")
                .append(Integer.toString(this.place))
                .append(":")
                .append(this.raiseField.getText());
        con.getSender().SendToServer(stringBuilder.toString());
    }//GEN-LAST:event_raiseBtnActionPerformed

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
            java.util.logging.Logger.getLogger(TableFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TableFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TableFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TableFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Player1Bets;
    private javax.swing.JLabel Player1Card1;
    private javax.swing.JLabel Player1Card2;
    private javax.swing.JLabel Player1Cash;
    private javax.swing.JLabel Player1Nick;
    private javax.swing.JButton Player1Seat;
    private javax.swing.JLabel Player2Bets;
    private javax.swing.JLabel Player2Card1;
    private javax.swing.JLabel Player2Card2;
    private javax.swing.JLabel Player2Cash;
    private javax.swing.JLabel Player2Nick;
    private javax.swing.JButton Player2Seat;
    private javax.swing.JLabel Player3Bets;
    private javax.swing.JLabel Player3Card1;
    private javax.swing.JLabel Player3Card2;
    private javax.swing.JLabel Player3Cash;
    private javax.swing.JLabel Player3Nick;
    private javax.swing.JButton Player3Seat;
    private javax.swing.JLabel Player4Bets;
    private javax.swing.JLabel Player4Card1;
    private javax.swing.JLabel Player4Card2;
    private javax.swing.JLabel Player4Cash;
    private javax.swing.JLabel Player4Nick;
    private javax.swing.JButton Player4Seat;
    private javax.swing.JLabel Player5Bets;
    private javax.swing.JLabel Player5Card1;
    private javax.swing.JLabel Player5Card2;
    private javax.swing.JLabel Player5Cash;
    private javax.swing.JLabel Player5Nick;
    private javax.swing.JButton Player5Seat;
    private javax.swing.JLabel Player6Bets;
    private javax.swing.JLabel Player6Card1;
    private javax.swing.JLabel Player6Card2;
    private javax.swing.JLabel Player6Cash;
    private javax.swing.JLabel Player6Nick;
    private javax.swing.JButton Player6Seat;
    private javax.swing.JButton callBtn;
    private javax.swing.JLabel card1;
    private javax.swing.JLabel card2;
    private javax.swing.JLabel card3;
    private javax.swing.JLabel card4;
    private javax.swing.JLabel card5;
    private javax.swing.JButton foldBtn;
    private javax.swing.JLabel pot;
    private javax.swing.JButton raiseBtn;
    private javax.swing.JTextField raiseField;
    private javax.swing.JButton standUpBtn;
    // End of variables declaration//GEN-END:variables
}
