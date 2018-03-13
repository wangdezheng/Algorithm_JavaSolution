package DFS;

/**
 * Given an integer n, print all possible blocks for it.
 * Say n = 2, output should be:
 *  if {
 *
 *  }
 *  if {
 *
 *  }
 *  if {
 *      if {
 *
 *      }
 *  }
 */
//Time: O(n ^ 2) Space: O(n)
public class PrintAllPossibleBlocks {
    public void printBlocks(int n) {
        if (n <= 0) {
            return;
        }
        char[] array = new char[n * 2];
        findAllPermutations(0, 0, 0, array);
    }

    private void findAllPermutations(int left, int right, int cur, char[] array) {
        //base case, put all ‘{‘ and ‘}’ in array;
        if (left + right == array.length) {
            print(array);
            return;
        }
        if (left < array.length / 2) {
            array[cur] = '{';
            findAllPermutations(left + 1, right, cur + 1, array);
        }
        if (right < left) {
            array[cur] = '}';
            findAllPermutations(left, right + 1, cur + 1, array);
        }
    }

    private void print(char[] array) {
        int heading = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == '{') {
                printEmpty(heading);
                System.out.println("if {");
                heading += 2;

            } else {
                heading -= 2;
                printEmpty(heading);
                System.out.println("}");
            }
        }
        System.out.println();
    }

    private void printEmpty(int heading) {
        for (int i = 0; i < heading; i++) {
            System.out.print(" ");
        }
    }
}
