import java.util.Random;
import java.util.NoSuchElementException;


public class RangeTester {

  public static void main(String[] args) {
    testNext();
  }

  public static void testNext() {
    boolean[] results = new boolean[4];

    Range one = new Range(0, 13);
    results[0] = helperTestLoop(0, 13, one);

    one = new Range(-30, 21);
    results[1] = helperTestLoop(-30, 21, one);

    try {
      one.next();
      results[2] = false;
    } catch (NoSuchElementException e) {
      results[2] = true;
    }

    results[3] = true;

    for (int i = 0; i < 100; i++) {
      Random rng = new Random();

      int numOne = rng.nextInt(500);
      int numTwo = rng.nextInt(500);

      int flip = rng.nextInt(3);
      if (flip == 0) numOne *= -1;
      else if (flip == 1) numTwo *= -1;
      else if (flip == 2) {
        numOne *= -1;
        numTwo *= -1;
      }

      int bigger = numOne;
      int smaller = numTwo;
      if (numTwo > numOne) {
        bigger = numTwo;
        smaller = numOne;
      }

      Range test = new Range(smaller, bigger);
      if (!helperTestLoop(smaller, bigger, test)) {
        results[3] = false;
        break;
      }
    }

    printResults(results, "Test next");
  }

  public static boolean helperTestLoop(int s, int b, Range r) {
    for (int i = s; i <= b; i++) {
      int ans = s - 1;
      try {
        ans = r.next();
        if (ans != i) return false;
      } catch (NoSuchElementException e) {
        return false;
      }
    }
    return true;
  }

  public static void printResults(boolean[] results, String testName) {
    for (int i = 0; i < results.length; i++) {
      char toShow = 'T';
      if (!results[i]) toShow = 'F';
      System.out.println(testName + " TEST #" + i + ": " + toShow);
    }
  }

}
