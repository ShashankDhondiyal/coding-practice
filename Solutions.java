public class Solutions {

    /*
    * Given an array of scores, return true if each score is equal or greater than the one before.
    * The array will be length 2 or more.
    */
    public boolean scoresIncreasing(int[] scores) {
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] < scores[i-1]) {
                return false;
            }
        }
        return true;
    }

    /*
    * Given an array of scores, return true if there are scores of 100 next to each other in the array.
    * The array length will be at least 2.
    */
    public boolean scores100(int[] scores) {
        for (int i = 0; i < (scores.length - 1); i++) {
            if ((scores[i] == 100) && (scores[i+1] == 100)) {
                return true;
            }
        }
        return false;
    }

    /*
     * Given an array of scores, compute the int average of the first half and the second half, and return whichever is larger. 
     * We'll say that the second half begins at index length/2. 
     * The array length will be at least 2.
     */
    public int scoresAverage(int[] scores) {
        int firstAverage = 0;
        int secondAverage = 0;
        int i = 0;

        while (i < (scores.length / 2)) {
            firstAverage += scores[i++];
        }
        firstAverage /= (scores.length / 2);

        while (i < scores.length) {
            secondAverage += scores[i++];
        }
        secondAverage /= (scores.length / 2);

        return firstAverage > secondAverage ? firstAverage : secondAverage;
    }

    /*
     * Given an array of strings, return the count of the number of strings with the given length.
     */
    public int wordsCount(String[] words, int len) {
        int count = 0;
        for (String word : words) {
            if (word.length() == len) {
                count++;
            }
        }
        return count;
    }

    /*
     * Given an array of strings, return a new array containing the first N strings. 
     * N will be in the range 1..length
     */
    public String[] wordsFront(String[] words, int n) {
        String[] ans = new String[n];
        for (int i = 0; i < n; i++) {
            ans[i] = words[i];
        }
        return ans;
    }

    /*
     * We'll say that a positive int n is "endy" if it is in the range 0..10 or 90..100 (inclusive). 
     * Given an array of positive ints, return a new array of length "count" containing the first endy numbers from the original array.
     * The original array will contain at least "count" endy numbers.
     */
    public int[] copyEndy(int[] nums, int count) {
        int[] ans = new int[count];
        int ans_iterator = 0;
        for (int i = 0; i < nums.length; i++) {
            if (((nums[i] >= 0) && (nums[i] <= 10)) || ((nums[i] >= 90) && (nums[i] <= 100))) {
                ans[ans_iterator++] = nums[i];
                if (ans_iterator == count) {
                    break;
                }
            }
        }
        return ans;
    }
    
}
