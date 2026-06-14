import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.HashSet;
import java.util.Set;

class Game {
        private int currentRow = 0;
        private int currentCol = 0;
        private int moveCount = 0;

        private boolean limitedMoves;
        private int remainingMoves = 12;

        private Set<Position> visited = new HashSet<>();

        private final Score score;
        private final Statistics statistics;

    public void addMoves(int amount) {
        remainingMoves += amount;
        statistics.updateRemainingMoves(remainingMoves);
    }

    public Game(Statistics statistics, boolean limitedMoves) {
            this.statistics = statistics;
            this.limitedMoves = limitedMoves;
            this.visited.add(new Position(0, 0));
            this.score = new Score();
        }

    public boolean validMove ( int newRow, int newCol, Cell cell) {
        if (Math.abs(newRow - this.currentRow)
                + Math.abs(newCol - this.currentCol) != 1) {
            return false;
        }
        Position position = new Position(newRow, newCol);

        if (visited.contains(position)){
            return false;
        }
        if (limitedMoves && remainingMoves <= 0) {
            JOptionPane.showMessageDialog(null,
                    "No more moves allowed! Game Over!");
            return false;
        }

        visited.add(position);

        currentRow = newRow;
        currentCol = newCol;
        moveCount++;

        if(limitedMoves){
            remainingMoves--;
        }

        cell.applyEffect(this);

        score.addFieldValue(cell.getValue());

        statistics.updateMoves(moveCount);
        statistics.updateSum(score.getTotalSumValues());
        statistics.updateRemainingMoves(remainingMoves);

        return true;
    }
    public double getAverageScore(){
        return score.getSumValues();
    }
}