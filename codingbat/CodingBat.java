public class CodingBat {

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

    /*
     * Given n of 1 or more, return the factorial of n, which is n * (n-1) * (n-2) ... 1. 
     * Compute the result recursively
     */
    public int factorial(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    /*
     * We have a number of bunnies and each bunny has two big floppy ears. 
     * We want to compute the total number of ears across all the bunnies recursively.
     */
    public int bunnyEars(int bunnies) {
        if (bunnies == 0) {
            return 0;
        }
        return 2 + bunnyEars(bunnies - 1);
    }

    /*
     * Define a recursive fibonacci(n) method that returns the nth fibonacci number, with n=0 representing the start of the sequence.
     */
    public int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    /*
     * We have bunnies standing in a line, numbered 1, 2, ... The odd bunnies (1, 3, ..) have the normal 2 ears. 
     * The even bunnies (2, 4, ..) we'll say have 3 ears, because they each have a raised foot. 
     * Recursively return the number of "ears" in the bunny line 1, 2, ... n
     */
    public int bunnyEars2(int bunnies) {
        if (bunnies == 0) {
            return 0;
        }
        return (bunnies % 2 == 1) ? (2 + bunnyEars2(bunnies - 1)) : (3 + bunnyEars2(bunnies - 1));
    }

    /*
     * Start with two arrays of strings, A and B, each with its elements in alphabetical order and without duplicates.
     * Return a new array containing the first N elements from the two arrays.
     * The result array should be in alphabetical order and without duplicates.
     * A and B will both have a length which is N or more
     */
    public String[] mergeTwo(String[] a, String[] b, int n) {
        int i = 0;
        int j = 0;
        String[] fin = new String[n];
        int k = 0;

        while (k < n) {
            if (a[i].compareTo(b[j]) == 0) {
                fin[k++] = a[i++];
                j++;
            }
            else if (a[i].compareTo(b[j]) < 0) {
                fin[k++] = a[i++];
            }
            else {
                fin[k++] = b[j++];
            }
        }
        return fin;
    }

    /*
     * (A variation on the sumHeights problem.)
     * We have an array of heights, representing the altitude along a walking trail.
     * Given start/end indexes into the array, return the number of "big" steps for a walk starting at the start index and ending at the end index.
     * We'll say that step is big if it is 5 or more up or down.
     * The start end end index will both be valid indexes into the array with start <= end.
     */
    public int bigHeights(int[] heights, int start, int end) {
        int steps = 0;
        while (start < end) {
            if (Math.abs(heights[start] - heights[++start]) >= 5) {
                steps++;
            }
        }
        return steps;
    }

    /* We have triangle made of blocks.
     * The topmost row has 1 block, the next row down has 2 blocks, the next row has 3 blocks, and so on. 
     * Compute recursively (no loops or multiplication) the total number of blocks in such a triangle with the given number of rows. 
     */
    public int triangle(int rows) {
        return rows == 0 ? 0 : rows-- + triangle(rows);
    }

    /* Given a non-negative int n, return the sum of its digits recursively.
     */
    public int sumDigits(int n) {
        return n == 0 ? 0 : ((n % 10) + sumDigits(n / 10));
    }
}