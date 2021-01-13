public class Radix{
  public static int nth(int n, int col){
    int last = (n % (int) Math.pow(10, (col+1)));
    return last/((int) Math.pow(10, col));
  }
  public static int length(int n){
    if(n == 0){
      return 1;
    }
    return (int)Math.log10(Math.abs(n)) + 1;
  }
}
