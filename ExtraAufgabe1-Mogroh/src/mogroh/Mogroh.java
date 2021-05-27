package mogroh;

import java.util.Scanner;

public class Mogroh {

    private boolean[] doors;

    public Mogroh() {
        Scanner scanner = new Scanner(System.in);
        int numberOfDoors = scanner.nextInt();
        doors = new boolean[numberOfDoors];
        closeAllDoors();
    }

    public void run() {
        for (int i = 1; i <= doors.length; i++) {
            flipDoors(i);
        }
        printDoors();
    }

    private void flipDoors(int stepSize) {
        for (int i = stepSize-1; i < doors.length; i += stepSize) {
            doors[i] = !doors[i];
        }
    }

    private void closeAllDoors() {
        for (int i = 0; i < doors.length; i++) {
            doors[i] = false;
        }
    }

    private void printDoors() {
        int openDoors = 0;
        int closedDoors = 0;
        for (int i = 0; i < doors.length; i++) {
            if (doors[i]) {
                System.out.println("Door nr." + (i + 1) + ": Open");
                openDoors++;
            } else {
                closedDoors++;
            }
        }
        System.out.println("Open doors: " + openDoors);
        System.out.println("Closed doors: " + closedDoors);
    }

    public static void main(String[] args) {
        Mogroh m = new Mogroh();
        m.run();
    }

}
