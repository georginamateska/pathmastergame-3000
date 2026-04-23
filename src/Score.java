public class Score {
    private int sumValues;
    private int pathTaken;

   public void addFieldValue(int value) {
        sumValues += value;
        pathTaken++;
   }
   public double getSumValues() {
        if (pathTaken == 0) return 0;
        return (double) sumValues / pathTaken;
   }
   public int getTotalSumValues() {
       return sumValues;
   }
}
