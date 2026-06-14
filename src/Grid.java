import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

class Grid {
    private Game game;
    private CellButton[][] buttons;

    private JFrame frame;
    private JPanel boardPanel;
    private JPanel statisticsPanel;
    private JLabel scoreLabel;
    private JButton restartButton;
    private boolean limitedMoves;

    private int size;

    public Grid(Game game, Statistics statistics, int size, boolean limitedMoves) {
        this.game = game;
        this.size = size;
        this.buttons = new CellButton[size][size];
        this.limitedMoves = limitedMoves;

        restartButton = new JButton("Restart");
        restartButton.addActionListener(e -> restartGame());

        createFrame();
        createTopPanel();
        createBoard();
        createStatisticsPanel(statistics);

        frame.setVisible(true);
    }

        private void createFrame() {
            frame = new JFrame("PathMaster3000");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(500, 500);
            frame.setLayout(new BorderLayout());
        }

        private void createTopPanel() {
            scoreLabel = new JLabel("Score: 0.0", JLabel.CENTER);
            frame.add(scoreLabel, BorderLayout.NORTH);
        }

    private void createBoard() {

        boardPanel = new JPanel(new GridLayout(size, size));
        Random random = new Random();

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {

                Cell cell = createCell(row, col, random);
                CellButton button = new CellButton(cell, row, col);

                buttons[row][col] = button;
                addButtonListener(button);
                boardPanel.add(button);
            }
        }
        frame.add(boardPanel, BorderLayout.CENTER);
    }

    private Cell createCell(int row, int col, Random random) {

        if (row == 0 && col == 0) {
            return new StartCell();
        }
        if (row == size - 1 && col == size - 1) {
            return new EndCell();
        }
        int value = random.nextInt(10);

        if (limitedMoves && random.nextInt(10) == 0){
            return new BonusCell(value);
        }
        return  new NormalCell(value);
    }

    private void addButtonListener(CellButton button) {
        button.addActionListener(e -> handleClick(button));
    }

    private void handleClick(CellButton button) {

        Cell cell = button.getCell();

        boolean moved = game.validMove(
                button.getRow(),
                button.getCol(),
                cell
        );

        if (moved) {
            button.setBackground(Color.CYAN);
            scoreLabel.setText("Score: " + game.getAverageScore());
        }
    }

    private void createStatisticsPanel(Statistics statistics){
        if (limitedMoves) {
            statisticsPanel = new JPanel(new GridLayout(5, 1));
        } else {
            statisticsPanel = new JPanel(new GridLayout(4, 1));
        }
        statisticsPanel.add(statistics.getMovesLabel());
        statisticsPanel.add(statistics.getSumSelectedFields());
        statisticsPanel.add(statistics.getTimeLabel());
        statisticsPanel.add(statistics.getRemainingMoves());

        statisticsPanel.add(restartButton);
        frame.add(statisticsPanel, BorderLayout.SOUTH);
 }
    private void restartGame() {
        try {
            frame.dispose();
            Main.main(null);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame,
                    "Error restarting game!");
            e.printStackTrace();
        }
    }
}