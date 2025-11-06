public class Main {
    public static void main(String[] args) {
        Solutions sol = new Solutions();

        int[] result = sol.copyEndy(new int[] {9, 11, 90, 22, 6}, 2);
        for (int e : result) {
            System.out.print(e + " ");
        }
        System.out.println();

        result = sol.copyEndy(new int[] {9, 11, 90, 22, 6}, 3);
        for (int e : result) {
            System.out.print(e + " ");
        }
        System.out.println();

        result = sol.copyEndy(new int[] {12, 1, 1, 13, 0, 20}, 2);
        for (int e : result) {
            System.out.print(e + " ");
        }
        System.out.println();
    }
}
