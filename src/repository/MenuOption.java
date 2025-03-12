package src.repository;

import java.util.Scanner;

public class MenuOption {
    public static int isInRange(Scanner scanner, int num) {
        if(num<1 || num>6) {
            System.out.println("Digite um digito valido (Do 1 ao 6)");
            num = scanner.nextInt();
            num = isInRange(scanner, num);
        }
        return num;
    }
}
