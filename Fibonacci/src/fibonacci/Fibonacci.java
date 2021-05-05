package fibonacci;

public class Fibonacci {

    public static void main(String[] args) {
        new Fibonacci();
    }
    
    public Fibonacci() {
        printFib(50);
        for(int i = 1; i <= 50; i++)
        {
            System.out.println(printRecursiveFib(i));
        }
    }
    
    public void printFib(int rounds) {
        int firstNumber = 0;
        int secondNumber = 1;

        for(int i = 0; i < rounds; i++) {
            secondNumber = firstNumber + secondNumber;
            firstNumber = secondNumber - firstNumber;
            System.out.println(firstNumber);
        }
    }
    
    public long printRecursiveFib(int bound) {
        return (bound == 0 || bound == 1) ? bound : printRecursiveFib(bound-1)+ printRecursiveFib(bound - 2);
    }
    
}
