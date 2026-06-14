import javax.swing.*;

class BonusCell extends Cell{

    public BonusCell(int value){
        super(value);
    }

    @Override
    public void applyEffect(Game game){
        game.addMoves(2);

        JOptionPane.showMessageDialog(null, "Bonus! +1 move");
    }

    @Override
    public String getDisplayText(){
        return "+1";
    }
}
