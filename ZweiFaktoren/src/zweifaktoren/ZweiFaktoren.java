package zweifaktoren;

import java.util.ArrayList;

public class ZweiFaktoren {
    
    //Methode von http://www.solvium.de/programmierung/java/primfaktorzerlegung/
    public long[] primeFactors (long n) {

        int maxFactors = (int) Math.ceil(Math.log10(n)/Math.log10(2));

        long[] tmp = new long[maxFactors];

        int anzahlFaktoren = 0;
        for (long j = 2; j <= n; j++ ) {
            if (n % j == 0) {
                tmp[anzahlFaktoren++] = j;
                n = n/j;
                j = 1;
            }
        }
        long[] prf = new long[anzahlFaktoren];
        for (int i = 0; i < anzahlFaktoren; i++) {
            prf[i] = tmp[i];
        }
        return prf;
    }

    public ZweiFaktoren(){    
        long[] prime = primeFactors(1000000);
        long selectedNumber = prime[0];
        long faktor = 1;
        for(int i = 0; i < prime.length; i++)
        {
            if(selectedNumber != prime[i])
            {
                System.out.println(faktor);
                faktor = prime[i];
                selectedNumber = prime[i];
            }else{
                faktor*=prime[i];
            }
        }
        System.out.println(faktor); 
    }
    
    public static void main(String[] args) {
        new ZweiFaktoren();
    }
}
