import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Grid {
    private Game game;
    private JButton[][] buttons;


    public Grid(Game game, Statistics statistics) {
        this.game = game;
        this.buttons = new JButton[7][7];

        Random random = new Random();
        final int n = 7;
        final JFrame frame = new JFrame("PathMaster3000");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridLayout(n, n));
        JLabel labels = new JLabel("Score: 0.0", JLabel.CENTER);
        frame.add(labels, BorderLayout.NORTH);

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                JButton button = new JButton();
                final int randomNum;

                if (i == 0 && j == 0) {
                    button = new JButton("Start");
                    button.setBackground(Color.lightGray);
                } else if (i == n - 1 && j == n - 1) {
                    button = new JButton("End");
                    button.setBackground(Color.lightGray);
                } else {
                    randomNum = random.nextInt(10);
                    button.setText(String.valueOf(randomNum));
                    button.setBackground(Color.magenta);
                }

                final int row = i;
                final int col = j;
                final JButton finalButton = button;

                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {

                        String buttonText = finalButton.getText();

                        if (buttonText.equals("Start")) {
                            return;
                        }else if (buttonText.equals("End")) {
                            JOptionPane.showMessageDialog(frame, "You have finished the game!");
                            System.exit(0);
                            return;
                        }

                            int fieldValue = Integer.parseInt(finalButton.getText());

                            labels.setText("Score: " + game.getSumValues());

                            if (game.validMove(row, col, fieldValue)) {
                                game.currentRow = row;
                                game.currentCol = col;
                                game.visited.add(game.currentRow + " " + game.currentCol);
                                finalButton.setBackground(Color.YELLOW);

                                labels.setText("Score: " + game.getSumValues());
                                if (game.currentRow == n - 1 && game.currentCol == n - 1) {
                                    JOptionPane.showMessageDialog(frame, "You have finished the game!");

                                    System.exit(0);
                                }
                            }
                        }
                });
                panel.add(button);
            }
        }
        JPanel statisticsPanel = new JPanel(new GridLayout(3, 1));
        statisticsPanel.add(statistics.getMovesLabel());
        statisticsPanel.add(statistics.getSumSelectedFields());
        statisticsPanel.add(statistics.getTimeLabel());

        frame.add(statisticsPanel, BorderLayout.SOUTH);

        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}