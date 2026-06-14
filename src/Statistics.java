import javax.swing.*;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Statistics {

    JLabel moves;
    JLabel sumSelectedFields;
    JLabel time;
    JLabel remainingMoves;

    private Timer timer;
    private int seconds = 0;

    public Statistics() {
        moves = new JLabel("The number of moves is: 0" );
        sumSelectedFields = new JLabel("The sum of the selected fields: 0");
        time = new JLabel("Timer: 0", JLabel.CENTER);
        remainingMoves = new JLabel("Remaining: 12");

            timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                seconds++;
                time.setText("Timer: "+ seconds + " seconds");
            }
        });
        timer.start();
    }
    public JLabel getTimeLabel() {
        return time;
    }
    public void updateMoves(int moveCount){
        moves.setText("Number of moves: " + moveCount);
    }

    public void updateSum(int sum){
        sumSelectedFields.setText("Sum of selected fields: " + sum);
    }

    public JLabel getMovesLabel(){
        return moves;
    }

    public JLabel getSumSelectedFields() {
        return sumSelectedFields;
    }
    public JLabel getRemainingMoves() {
        return remainingMoves;
    }
    public void updateRemainingMoves(int movesLeft){
        remainingMoves.setText("Remaining: " + movesLeft);
    }
}
