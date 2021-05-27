package fibonacci;

public class Fibonacci {

    public static void main(String[] args) {
        new Fibonacci();
    }
    
    static int counter = 0;
    
    public Fibonacci() {
        System.out.println(">"+System.nanoTime());
        printFib(20);
        System.out.println(">"+System.nanoTime());
        for(int i = 1; i <= 20; i++)
        {
            System.out.println(printRecursiveFib(i));
        }
        System.out.println(">"+System.nanoTime());
        System.out.println(">"+counter);
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
    
    public long printRecursiveFib(int x) {
        counter++;
        return (x == 0 || x == 1) ? x : printRecursiveFib(x-1)+ printRecursiveFib(x - 2);
    }
    
}
