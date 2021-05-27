package aufgabe3_1;

public class Aufgabe3_1 {

    public static int f(int n) {
        if(n <= 2){
            return 1;
        }
        return (1+f(n / 3) + f(n / 3) + f(n-2*(n / 3)));
    }

    public static void main(String[] args) {
        for (int i = 3; i <= Math.pow(3, 15); i*=3) {
            System.out.println(i + ": " + f(i));
        }
    }

}
