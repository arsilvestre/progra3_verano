import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        int numero = 5;
        System.out.println("El factorial de " + numero + " es: " + factorial(numero));
    }

    public static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }
}