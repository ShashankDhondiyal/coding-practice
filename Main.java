public class Main {
    public static void main(String[] args) {
        Solutions sol = new Solutions();

        int[][] tests = {
            {2,2,4,4},
            {4,4,4,2,2,2},
            {3,4,5,1,2,3},
            {1,2},
        };
        
        for (int[] test : tests) {
            System.out.println(sol.scoresAverage(test));
        }
    }
}
