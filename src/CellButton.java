import javax.swing.*;
import java.awt.*;

class CellButton extends JButton {

    private Cell cell;
    private int row;
    private int col;

    public CellButton(Cell cell, int row, int col) {
        this.cell = cell;
        this.row = row;
        this.col = col;

        setText(cell.getDisplayText());

        if (cell instanceof BonusCell) {
            setBackground(Color.GREEN);
        } else if (cell instanceof StartCell || cell instanceof EndCell) {
            setBackground(Color.LIGHT_GRAY);
        } else {
            setBackground(Color.MAGENTA);
        }
    }
    public Cell getCell() {
        return cell;
    }
    public int getRow(){
        return row;
    }
    public int getCol(){
        return col;
    }
}
