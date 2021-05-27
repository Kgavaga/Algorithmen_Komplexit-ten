package collatzproblem;

public class CollatzProblem {

    public static void main(String[] args) {
        new CollatzProblem().start(55321);
    }

    public void start(int zahl) {
        while (zahl > 1) {
            if (zahl % 2 == 1) {
                zahl = zahl * 3 + 1;
            } else {
                zahl /= 2;
            }
            System.out.println(zahl);
        }
    }
}
