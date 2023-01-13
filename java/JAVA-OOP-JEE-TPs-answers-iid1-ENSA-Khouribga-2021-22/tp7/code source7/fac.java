package tp7;
import java.util.InputMismatchException;
import java.util.Scanner;
class ExceptionHandlerFactorial {
    private static Scanner console = new Scanner(System.in);
    private static int userInput = 0;
    private static boolean acceptableUserInput = false;
    public static void main(String[] args) {
        do{
            System.out.println("Please enter initial value");
            try{
                userInput = console.nextInt();
                if (userInput < 0){
                    throw new NegNumberException();
                }
                else
                {
                    System.out.println(getFactorial(userInput));
                    acceptableUserInput = true;
                }
            }
            catch(InputMismatchException e){
                System.err.println("Caught InputMismatchExcpection," + 
                        " please enter a valid integer");
                //clear buffer
                console.next();
                //retry
                continue;
            }
            catch(NegNumberException e)
            {
                System.err.println("Caught NegNumberException," +
                        " now ending the program");
                break;
            }
        }while(!(acceptableUserInput));
    }
    static class NegNumberException extends Exception {
        public NegNumberException() {
        }
    }
   
}

public class fac {

	public static void main(String[] args) {
System.out.println(getFactorial(20));
	}
	 static int getFactorial(int input){
	        int fact = 1;
	        for(int x = input; x > 1; x--){
	           fact *= x;
	        }
	        return fact;
	    }
}
