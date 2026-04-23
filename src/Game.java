import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.HashSet;
import java.util.Set;

public class Game {
        int currentRow = 0;
        int currentCol = 0;
        int moveCount = 0;
        Set<String> visited = new HashSet<>(); //stores the visited buttons
        private Score score;
        private Statistics statistics;

    public Game(Statistics statistics) {
            this.statistics = statistics;
            this.visited.add("0 0");
            this.score = new Score();
        }

        public boolean validMove ( int newRow, int newCol, int fieldValue){
            if (Math.abs(newRow - this.currentRow) + Math.abs(newCol - this.currentCol) != 1) {
                return false;
            }

            if (!this.visited.contains("" + newRow + " " + newCol)) {
                visited.add("" + newRow + " " + newCol);
                score.addFieldValue(fieldValue);
                this.currentRow = newRow;
                this.currentCol = newCol;

                moveCount++;

                statistics.updateMoves(moveCount);
                statistics.updateSum(score.getTotalSumValues());

                return true;
            }
            return false;
        }

        public double getSumValues () {
            return score.getSumValues();
        }
    }