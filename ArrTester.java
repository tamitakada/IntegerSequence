import java.util.Random;
import java.util.NoSuchElementException;


public class ArrTester {
  public static void main(String[] args) {
    testFirstInit();
  }

  public static void testFirstInit() {
    boolean[] results = new boolean[4];

    int[] one = new int[] {
      0, 1212, -93, 23, 74, 2, 900, -111, 53, 44
    };

    ArraySequence arrOne = new ArraySequence(one);
    results[0] = (arrOne.length() == 10);
    results[1] = helperTestLoop(arrOne, one);

    int[] two = {1,3,5,0,-1,3,9};

    ArraySequence arrTwo = new ArraySequence(two);
    results[2] = (arrTwo.length() == 7);
    results[3] = helperTestLoop(arrTwo, two);

    printResults(results, "Test first constructor");
  }

  public static void printResults(boolean[] results, String testName) {
    for (int i = 0; i < results.length; i++) {
      char toShow = 'T';
      if (!results[i]) toShow = 'F';
      System.out.println(testName + " TEST #" + i + ": " + toShow);
    }
  }

  private static boolean helperTestLoop(ArraySequence r, int[] expected) {
    for (int i = 0; i < r.length(); i++) {
      try {
        int got = r.next();
        if (expected[i] != got) return false;
      } catch (NoSuchElementException e) {
        return false;
      }
    }
    return true;
  }
}
