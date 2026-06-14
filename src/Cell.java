abstract class Cell implements Effect{
    private final int value;

    public Cell(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void applyEffect(Game game){
    }

    public String getDisplayText(){
        return String.valueOf(value);
    }
}
