import java.util.NoSuchElementException;


public class ArraySequence implements IntegerSequence{
  int currentIndex;
  int[] data;

  public ArraySequence(int [] other){
    data = new int[other.length];
    for (int i = 0; i < other.length; i++) {
      data[i] = other[i];
    }
  }

  public void reset(){
    currentIndex = 0;
  }
  public int length(){
    return data.length;
  }
  public boolean hasNext(){
    return currentIndex < data.length;
  }

  public int next() throws NoSuchElementException {
    if (currentIndex == data.length) throw new NoSuchElementException("You've reached the end.");
    else {
      currentIndex++;
      return data[currentIndex - 1];
    }
  }

}
