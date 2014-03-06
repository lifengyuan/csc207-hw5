
public class Expt {
	  /**
	   * Compute x^n.
	   *
	   * @pre n >= 1.
	   */
	  public double expt(double x, int n)
	  {
		  if(n < 1){
			  throw new IllegalArgumentException();
		  }
		  
		  if(n == 1){
			  return x;
		  }
		  
		  double result = 1;
		  if(n % 2 == 0){
			  result = expt(x, n/2) * expt(x, n/2);
		  }else{
			  result = x * expt(x, n - 1);
		  }
		  
		  return result;
	  } // expt(double, int)
	  
	  public static void main(String[] args) {
		Expt expt = new Expt();
		System.out.println(expt.expt(2.1, 2));
	}
}
