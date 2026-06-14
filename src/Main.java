import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        String[] options = {"Easy", "Medium", "Hard"};
        int choice = JOptionPane.showOptionDialog(null,
                "Choose Level:", "PathMaster 3000",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null, options, options[0]);
        int size;
        
        if(choice == 0){
            size = 5;
        }else if (choice == 1){
            size = 7;
        } else{
            size = 9;
        }
        String[] modes = {"Normal", "Limited Moves"};

        int modeChoice = JOptionPane.showOptionDialog(null,
                "Choose Game Mode:",
                "PathMAster 3000",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                modes,
                modes[0]);

        Statistics statistics = new Statistics();
        boolean limited = (modeChoice == 1);

        if (limited){
            JOptionPane.showMessageDialog(
                    null, "You only have 12 moves!"
            );
        }
        Game game = new Game(statistics, limited);
        new Grid(game, statistics, size, limited);
    }
}