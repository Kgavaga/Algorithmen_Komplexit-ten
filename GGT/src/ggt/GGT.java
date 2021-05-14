package ggt;

public class GGT {

    public static final int FIRST_NUMBER = 1632;
    public static final int SECOND_NUMBER = 112;
    public static int counter = 0;

    public static void main(String[] args) {
        new GGT();
    }

    public GGT() {
//        System.out.println(getGGT(FIRST_NUMBER, SECOND_NUMBER));
        System.out.println(getFastGGT(FIRST_NUMBER, SECOND_NUMBER));
//        System.out.println(getRecursiveGGT(FIRST_NUMBER, SECOND_NUMBER));

        System.out.println(counter);

        //System.out.println(getRecursiveBinaryGCD(FIRST_NUMBER, SECOND_NUMBER, 0));
    }

    private int getGGT(int num1, int num2) {
        counter = 0;
        while (num1 != 0 && num2 != 0) {
            if (num1 > num2) {
                num1 -= num2;
            } else {
                num2 -= num1;
            }
            counter++;
        }
        if (num1 > 0) {
            return num1;
        } else {
            return num2;
        }
    }

    private int getFastGGT(int num1, int num2) {
        counter = 0;
        while (num1 != 0 && num2 != 0) {
            if (num1 > num2) {
                num1 %= num2;
            } else {
                num2 %= num1;
            }
            counter++;
        }
        if (num1 > 0) {
            return num1;
        } else {
            return num2;
        }
    }

    private int getRecursiveGGT(int num1, int num2) {
        System.out.println(num1 + "\n" + num2 + "\n");
        if (num1 == 0 || num2 == 0) {
            return num1 + num2;
        }
        return (num1 > num2) ? getRecursiveGGT(num1 - num2, num2) : getRecursiveGGT(num1, num2 - num1);
    }

    private int getFastRecursiveGGT(int num1, int num2) {
        System.out.println(num1 + "\n" + num2 + "\n");
        if (num1 == 0 || num2 == 0) {
            return num1 + num2;
        }
        return (num1 > num2) ? getRecursiveGGT(num1 % num2, num2) : getRecursiveGGT(num1, num2 % num1);
    }

    private int getBinaryGCD(int num1, int num2) {

        counter = 0;
        int k = 0;
        while (num1 != num2) {
            if (num1 % 2 == 0 && num2 % 2 == 0) {
                num1 /= 2;
                num2 /= 2;

                k++;
            } else if (num1 % 2 == 0) {
                num1 /= 2;
            } else if (num2 % 2 == 0) {
                num2 /= 2;
            } else {
                if (num1 > num2) {
                    num1 = (num1 - num2) / 2;
                } else {
                    num2 = (num2 - num1) / 2;
                }
            }
            counter++;
            System.out.println(num1 + ":" + num2);
        }
        return (int) Math.pow(2, k) * num1;
    }

    private int getRecursiveBinaryGCD(int num1, int num2, int k) {

        System.out.println(num1 + ":" + num2);

        if (num1 == num2) {
            return (int) Math.pow(2, k) * num1;
        } else if (num1 % 2 == 0 && num2 % 2 == 0) {
            num1 /= 2;
            num2 /= 2;
            k++;
            return getRecursiveBinaryGCD(num1, num2, k);

        } else if (num1 % 2 == 0) {
            num1 /= 2;
            return getRecursiveBinaryGCD(num1, num2, k);
        } else if (num2 % 2 == 0) {
            num2 /= 2;
            return getRecursiveBinaryGCD(num1, num2, k);
        } else {
            if (num1 > num2) {
                num1 = (num1 - num2) / 2;
            } else {
                num2 = (num2 - num1) / 2;
            }
            return getRecursiveBinaryGCD(num1, num2, k);
        }
    }
}
