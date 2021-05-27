package binarysearch;


public class BinarySearch {

    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        int a[] = bs.getSortedList(100000000);
        System.out.println(">"+System.nanoTime());
        System.out.println(bs.findRecursively(a, 0));
        System.out.println(">"+System.nanoTime());
        System.out.println(bs.findIteratively(a, 0));
        System.out.println(">"+System.nanoTime());
    }

    public BinarySearch() {

    }

    public int[] getSortedList(int len) {
        if (len > 100000000) {
            return null;
        }
        int a[] = new int[len];
        for (int i = 1; i <= len; i++) {
            a[i - 1] = i;
        }
        return a;
    }

    public int findRecursively(int a[], int key) {
        return findRecursively(a, 0, a.length - 1, key);
    }

    public int findRecursively(int a[], int start, int end, int key) {
        if(start > end) return -1;
        int currentElementIndex = (start + end) / 2;
        if (a[currentElementIndex] == key) {
            return currentElementIndex;
        } else if (a[currentElementIndex] < key) {
            return findRecursively(a, currentElementIndex + 1, end, key);
        } else {
            return findRecursively(a, start, currentElementIndex - 1, key);
        }
    }

    int findIteratively(int[] a, int k) {
        int l = 0, r = a.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            int e = a[m];
            if (k == e) {
                return m;
            }
            if (k < e) {
                r = m - 1;
            }
            if (k > e) {
                l = m + 1;
            }
        }
        return -1;
    }

}
