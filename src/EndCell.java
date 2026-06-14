import javax.swing.*;

class EndCell extends Cell {

    public EndCell() {
        super(0);
    }

    @Override
    public void applyEffect(Game game) {
        JOptionPane.showMessageDialog(null, "You finished the game!");
        System.exit(0);
    }

    @Override
    public String getDisplayText() {
        return "END";
    }
}