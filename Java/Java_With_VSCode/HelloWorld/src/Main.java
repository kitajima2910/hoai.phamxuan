class Swap {

  int a, b;

  Swap(int a, int b) {
    this.a = b;
    this.b = a; 
  }

}

public class Main {
  
  private static int getItself(int itself, int dummy)
  {
    return itself;
  }

  public static void main(String[] args) {
    int a = 5;
    int b = 6;

    a = getItself(b, b = a);
    
    // Swap swap = new Swap(a, b);
    // a = swap.a;
    // b = swap.b;

    System.out.printf("%d - %d", a, b);
  }

}
