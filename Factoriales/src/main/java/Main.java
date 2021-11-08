import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el número: ");
        int n = sc.nextInt();
        String[] numFact = (factorial(n));
        System.out.println(numFact[numFact.length-1]);

    }


    public static String[] factorial(int n)
    {
        String[]fact= new String[n+1];
        int i = 0;
        fact[0]=1+"";
        for( i=1; i<=n ; i++) 
        {
            BigInteger bigInt= new BigInteger(i + "");
            fact[i] = bigInt.multiply(new BigInteger(fact[i-1])) + ""; 
        }
        return fact;
    }
}
