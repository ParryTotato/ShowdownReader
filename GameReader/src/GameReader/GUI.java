package GameReader;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import java.awt.Color;

public class GUI {

    private JFrame frame;
    private JTextField textField;
    private JLabel lblPlayer1_Name,lblPlayer2_Name,lblWinLoose,lblWinnerP1,lblWinnerP2,lblFailure,lblZoroark;
    private JTextPane textPane1,textPane2, csvTextPane;
    private String csvString;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                GUI window = new GUI();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the application.
     */
    private GUI() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame("ShowdownReader");
        frame.setBounds(100, 100, 1600, 480);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblLinkHere = new JLabel("Link Here:");
        lblLinkHere.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblLinkHere.setBounds(10, 11, 72, 14);
        frame.getContentPane().add(lblLinkHere);

        textField = new JTextField();
        textField.setBounds(10, 30, 1451, 25);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        JButton btnNewButton = new JButton("Apply");
        btnNewButton.addActionListener(arg0 -> {
            try {
                Player[] game = Spielauswertung.werteAus(textField.getText());
                frame.setTitle("ShowdownReader: '" + game[0].getNickname() + "' vs. '" + game[1].getNickname() + "'");
                csvString = game[0].getNickname() + "," + game[1].getNickname() + ",";

                lblFailure.setVisible(false);
                lblZoroark.setVisible(false);
                lblPlayer1_Name.setVisible(true);
                lblPlayer2_Name.setVisible(true);
                textPane1.setVisible(true);
                textPane2.setVisible(true);
                csvTextPane.setVisible(true);
                lblWinLoose.setVisible(true);
                lblWinnerP1.setVisible(true);
                lblWinnerP2.setVisible(true);

                lblPlayer1_Name.setText(game[0].getNickname());
                lblPlayer2_Name.setText(game[1].getNickname());

                textPane1.setText("Kills|Pokemon, dead/alive \r\n");
                textPane2.setText("Kills|Pokemon, dead/alive \r\n");

                int deadP1=0;
                int deadP2=0;
                for (Pokemon p : game[0].getMons()) {//Hallo Dieter\r\nTest\r\nDrei\r\nVier\r\nF\u00FCnf\r\nSechs
                    textPane1.setText(textPane1.getText()+p.getKills()+"|"+p.getPokemon()+", "+p.DeadToString()+"\r\n");
                    if(p.isDead())deadP1++;
                }
                for (Pokemon p : game[1].getMons()) {
                    textPane2.setText(textPane2.getText()+p.getKills()+"|"+p.getPokemon()+", "+p.DeadToString()+"\r\n");
                    if(p.isDead())deadP2++;
                }

                lblWinLoose.setText((6-deadP1)+":"+(6-deadP2));

                if(game[0].isWinner()) {
                    csvString = csvString + game[0].getNickname() + ",";
                    if(deadP2<6) {
                        lblWinnerP1.setText("Winner");
                        lblWinnerP2.setText("ffd. Loser");
                    } else {
                        lblWinnerP1.setText("Winner");
                        lblWinnerP2.setText("Loser");
                    }
                } else {
                    csvString = csvString + game[1].getNickname() + ",";
                    if(deadP1<6) {
                        lblWinnerP1.setText("Loser ffd.");
                        lblWinnerP2.setText("Winner");
                    } else {
                        lblWinnerP1.setText("Loser");
                        lblWinnerP2.setText("Winner");
                    }
                }


                for(Player pl:game) {
                    for(Pokemon p:pl.getMons()) {
                        switch (p.getPokemon()) {
                            case "Zoroark":
                                lblZoroark.setText("Watch out, Zoroark is in a Team! It doesn't work with Zoroark!");
                                lblZoroark.setVisible(true);
                                break;
                            case "Zoroark-Hisui":
                                lblZoroark.setText("Watch out, Zoroark-Hisui is in a Team! It doesn't work with Zoroark-Hisui!");
                                lblZoroark.setVisible(true);
                                break;
                            case "Zoroa":
                                lblZoroark.setText("Watch out, Zoroa is in a Team! It doesn't work with Zoroa!");
                                lblZoroark.setVisible(true);
                                break;
                            case "Zoroa-Hisui":
                                lblZoroark.setText("Watch out, Zoroa-Hisui is in a Team! It doesn't work with Zoroa-Hisui!");
                                lblZoroark.setVisible(true);
                                break;
                        }
                        int dead = p.isDead() ? 1 : 0;
                        csvString = csvString + p.getPokemon() + "," + p.getKills() + ",0," + dead + ",";
                    }
                }
                csvTextPane.setText(csvString);
            } catch (ArithmeticException e) {
                lblFailure.setVisible(true);
            }

        });
        btnNewButton.setBounds(1470, 30, 89, 25);
        frame.getContentPane().add(btnNewButton);

        lblPlayer1_Name = new JLabel("Player 1:");
        lblPlayer1_Name.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblPlayer1_Name.setBounds(10, 66, 742, 25);
        frame.getContentPane().add(lblPlayer1_Name);
        lblPlayer1_Name.setVisible(false);

        lblPlayer2_Name = new JLabel("Player 2:");
        lblPlayer2_Name.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblPlayer2_Name.setBounds(799, 66, 742, 25);
        frame.getContentPane().add(lblPlayer2_Name);
        lblPlayer2_Name.setVisible(false);

        textPane1 = new JTextPane();
        textPane1.setFont(new Font("Tahoma", Font.PLAIN, 17));
        textPane1.setText("");
        textPane1.setBounds(10, 102, 742, 158);
        frame.getContentPane().add(textPane1);
        textPane1.setVisible(false);

        textPane2 = new JTextPane();
        textPane2.setText("");
        textPane2.setFont(new Font("Tahoma", Font.PLAIN, 17));
        textPane2.setBounds(799, 102, 742, 158);
        frame.getContentPane().add(textPane2);
        textPane2.setVisible(false);

        csvTextPane = new JTextPane();
        csvTextPane.setText("");
        csvTextPane.setFont(new Font("Tahoma", Font.PLAIN, 12));
        csvTextPane.setBounds(10, 370, 1540, 40);
        frame.getContentPane().add(csvTextPane);
        csvTextPane.setVisible(false);

        lblWinLoose = new JLabel("0:0");
        lblWinLoose.setFont(new Font("Tahoma", Font.PLAIN, 61));
        lblWinLoose.setHorizontalAlignment(SwingConstants.CENTER);
        lblWinLoose.setBounds(701, 271, 142, 59);
        frame.getContentPane().add(lblWinLoose);
        lblWinLoose.setVisible(false);

        lblWinnerP1 = new JLabel("Loser");
        lblWinnerP1.setHorizontalAlignment(SwingConstants.LEFT);
        lblWinnerP1.setFont(new Font("Tahoma", Font.PLAIN, 61));
        lblWinnerP1.setBounds(10, 271, 796, 59);
        frame.getContentPane().add(lblWinnerP1);
        lblWinnerP1.setVisible(false);

        lblWinnerP2 = new JLabel("Loser");
        lblWinnerP2.setHorizontalAlignment(SwingConstants.RIGHT);
        lblWinnerP2.setFont(new Font("Tahoma", Font.PLAIN, 61));
        lblWinnerP2.setBounds(1200, 271, 348, 59);
        frame.getContentPane().add(lblWinnerP2);
        lblWinnerP2.setVisible(false);

        lblFailure = new JLabel("Failure!");
        lblFailure.setForeground(Color.RED);
        lblFailure.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblFailure.setBounds(88, 11, 72, 14);
        frame.getContentPane().add(lblFailure);
        lblFailure.setVisible(false);

        JLabel lblByicelimo = new JLabel("By Icelimo");
        lblByicelimo.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblByicelimo.setBounds(1470, 11, 72, 14);
        frame.getContentPane().add(lblByicelimo);

        lblZoroark = new JLabel("Watch out, Zoroark is in a Team! It doesn't work with Zoroark!");
        lblZoroark.setForeground(Color.RED);
        lblZoroark.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblZoroark.setBounds(160, 11, 500, 14);
        frame.getContentPane().add(lblZoroark);
        lblZoroark.setVisible(false);
    }
}
