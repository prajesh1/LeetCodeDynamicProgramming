
public class Solution {

  public int[] countBits(int num) {
    int[] arr = new int[num + 1];

    arr[0] = 0;
    int index = 0;
    while (index * 2 <= num) {
      arr[index * 2] = arr[index];
      if (index * 2 + 1 <= num)
        arr[index * 2 + 1] = arr[index] + 1;
      index++;
    }
    return arr;
  }

  public Solution() {
    // TODO Auto-generated constructor stub
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
