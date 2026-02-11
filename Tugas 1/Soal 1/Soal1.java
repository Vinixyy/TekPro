import java.util.Scanner;
import java.math.BigInteger;

class Soal1
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        BigInteger[] N = new BigInteger[T];
       for (int i = 0; i < T; i++)
        {
            N[i] = input.nextBigInteger();
        } 
        
        for (int i = 0; i < T; i++)
        {
            if (N[i].compareTo(BigInteger.valueOf(-9223372036854775808L)) >= 0 && N[i].compareTo(BigInteger.valueOf(9223372036854775807L)) <= 0)
            {
            System.out.println(N[i] + " can be fitted in:");
            }
            System.out.println();
            if (N[i].compareTo(BigInteger.valueOf(-128)) >= 0 && N[i].compareTo(BigInteger.valueOf(127)) <= 0) 
            {
                System.out.println("* " + "byte");
            } 
            if (N[i].compareTo(BigInteger.valueOf(-32768)) >= 0 && N[i].compareTo(BigInteger.valueOf(32767)) <= 0) 
            {
                System.out.println("* " + "short");
            } 
            if (N[i].compareTo(BigInteger.valueOf(-2147483648L)) >= 0 && N[i].compareTo(BigInteger.valueOf(2147483647L)) <= 0) 
            {
                System.out.println("* " + "int");
            } 
            if (N[i].compareTo(BigInteger.valueOf(-9223372036854775808L)) >= 0 && N[i].compareTo(BigInteger.valueOf(9223372036854775807L)) <= 0)
            {
                System.out.println("* " + "long");
            }
            else
            {
                System.out.println(N[i] + " can't be fitted anywhere.");
            }
            System.out.println();
        }
        input.close();
    }
}