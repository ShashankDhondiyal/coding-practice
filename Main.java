import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solutions sol = new Solutions();

        String[] test = {"a", "b", "c", "d"};

        System.out.println(Arrays.toString(sol.wordsFront(test, 1)));
        System.out.println(Arrays.toString(sol.wordsFront(test, 2)));
        System.out.println(Arrays.toString(sol.wordsFront(test, 3)));
    }
}
