/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.course.gyropokerclient.view;

import by.bsuir.course.gyropokerclient.connection.Connection;
import by.bsuir.course.gyropokerclient.logic.FramesHandler;
import java.util.ArrayList;
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
    }
    
    private void initPlayerCards(int place, String firstCard, String secondCard,
            JLabel firstCardL, JLabel secondCardL){
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
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        Player1Nick.setText("jLabel1");

        Player1Cash.setText("jLabel2");

        Player1Seat.setText("Seat");
        Player1Seat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Player1SeatActionPerformed(evt);
            }
        });

        Player1Bets.setText("jLabel1");

        Player2Bets.setText("jLabel1");

        Player2Nick.setText("jLabel1");

        Player2Cash.setText("jLabel2");

        Player2Seat.setText("Seat");
        Player2Seat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Player2SeatActionPerformed(evt);
            }
        });

        Player3Bets.setText("jLabel1");

        Player3Nick.setText("jLabel1");

        Player3Cash.setText("jLabel2");

        Player3Seat.setText("Seat");
        Player3Seat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Player3SeatActionPerformed(evt);
            }
        });

        Player4Bets.setText("jLabel1");

        Player4Nick.setText("jLabel1");

        Player4Cash.setText("jLabel2");

        Player4Seat.setText("Seat");
        Player4Seat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Player4SeatActionPerformed(evt);
            }
        });

        Player5Bets.setText("jLabel1");

        Player5Nick.setText("jLabel1");

        Player5Cash.setText("jLabel2");

        Player5Seat.setText("Seat");
        Player5Seat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Player5SeatActionPerformed(evt);
            }
        });

        Player6Bets.setText("jLabel1");

        Player6Nick.setText("jLabel1");

        Player6Cash.setText("jLabel2");

        Player6Seat.setText("Seat");
        Player6Seat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Player6SeatActionPerformed(evt);
            }
        });

        standUpBtn.setText("StandUp");
        standUpBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                standUpBtnActionPerformed(evt);
            }
        });

        card1.setText("jLabel1");

        card2.setText("jLabel1");

        card3.setText("jLabel1");

        card4.setText("jLabel1");

        card5.setText("jLabel1");

        foldBtn.setText("FOLD");
        foldBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                foldBtnActionPerformed(evt);
            }
        });

        callBtn.setText("check/call");
        callBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                callBtnActionPerformed(evt);
            }
        });

        raiseBtn.setText("Raise");
        raiseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                raiseBtnActionPerformed(evt);
            }
        });

        pot.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Player5Bets)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Player5Cash)
                                            .addComponent(Player5Nick))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Player5Card1)
                                            .addComponent(Player5Card2)))))
                            .addComponent(Player5Seat))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(standUpBtn)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Player4Card1)
                                    .addComponent(Player4Card2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Player3Card1)
                                    .addComponent(Player3Card2))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(14, 14, 14)
                                        .addComponent(card1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(card2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(card3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(card4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(card5)
                                        .addGap(70, 70, 70))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(Player4Cash)
                                                    .addComponent(Player4Nick)
                                                    .addComponent(Player4Bets)))
                                            .addComponent(Player4Seat))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(Player3Cash)
                                                    .addComponent(Player3Nick)
                                                    .addComponent(Player3Bets)))
                                            .addComponent(Player3Seat))
                                        .addGap(12, 12, 12)))))
                        .addGap(66, 66, 66))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(Player6Cash)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(Player1Card1))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(Player6Nick)
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(Player6Card1)
                                                    .addComponent(Player6Card2)))
                                            .addComponent(Player6Bets)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(388, 388, 388)
                                                .addComponent(Player1Bets)
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(10, 10, 10)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(Player1Cash)
                                                            .addComponent(Player1Nick)))
                                                    .addComponent(Player1Seat))))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Player6Seat)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Player1Card2)
                                .addGap(107, 107, 107)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Player2Card1)
                            .addComponent(Player2Card2))
                        .addGap(123, 123, 123))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Player2Bets)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Player2Cash)
                                    .addComponent(Player2Nick)))
                            .addComponent(Player2Seat)))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(foldBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(callBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(raiseField)
                            .addComponent(raiseBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(148, 148, 148))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(pot)
                        .addGap(349, 349, 349))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 186, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Player1Card1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(Player1Card2)
                                        .addGap(35, 35, 35)
                                        .addComponent(Player2Card1))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(Player3Bets)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(Player2Nick)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(Player2Cash)
                                                    .addComponent(Player2Bets))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Player2Seat)))
                                        .addGap(17, 17, 17)
                                        .addComponent(Player3Nick)
                                        .addGap(0, 0, 0)
                                        .addComponent(Player3Cash)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Player3Seat)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Player2Card2)
                                .addGap(108, 108, 108))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Player3Card1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Player3Card2)
                                .addGap(107, 107, 107))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Player6Card1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Player6Card2)
                                .addGap(286, 286, 286))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(standUpBtn)
                                .addGap(123, 123, 123)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(card1)
                                    .addComponent(card2)
                                    .addComponent(card3)
                                    .addComponent(card4)
                                    .addComponent(card5))
                                .addGap(34, 34, 34)
                                .addComponent(pot)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Player6Bets)
                                .addGap(17, 17, 17)
                                .addComponent(Player6Nick)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(Player1Nick)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(Player1Cash)
                                            .addComponent(Player1Bets))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Player1Seat))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(Player6Cash)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Player6Seat)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(Player5Bets)))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(17, 17, 17)
                                        .addComponent(Player5Nick)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Player5Cash))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Player5Card1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Player5Card2)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Player5Seat)
                                .addGap(15, 15, 15)
                                .addComponent(Player4Card1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Player4Card2)
                                .addGap(113, 113, 113))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Player4Bets)
                                .addGap(17, 17, 17)
                                .addComponent(Player4Nick)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Player4Cash)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Player4Seat)
                                .addGap(29, 29, 29)
                                .addComponent(raiseField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(foldBtn)
                                    .addComponent(callBtn)
                                    .addComponent(raiseBtn))
                                .addGap(36, 36, 36))))))
        );

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
