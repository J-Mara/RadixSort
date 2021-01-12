public class Radix{
  public static int nth(int n, int col){
    int last = (n % (int) Math.pow(10, (col+1)));
    return last/((int) Math.pow(10, col));
  }
}
