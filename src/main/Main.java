package src.main;

import src.repository.File;
import src.repository.MenuOption;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File file = new File();
        file.createFile();
        file.readFile();
        Scanner input;
        int option = 0;
        boolean validInput;
        do {
            input = new Scanner(System.in);
            System.out.println("\n1. Cadastrar um novo pet");
            System.out.println("2. Alterar os dados do pet cadastrado");
            System.out.println("3. Deletar um pet cadastrado");
            System.out.println("4. Listar todos os pets cadastrados");
            System.out.println("5. Listar pets por algum critério (idade, nome, raça)");
            System.out.println("6. Sair");
            System.out.println("Escolha uma opção: ");

            do {
                validInput = true;
                try {
                    option = MenuOption.isInRange(input, input.nextInt());

                } catch (Exception ex) {
                    validInput = false;
                    System.out.println("Por favor, digite um valor válido.");
                    break;
                }
            } while (!validInput);

            if (option == 1) {
                System.out.println();
                file.readFile();
                System.out.println("Funfou");
            }

        } while (option != 6);




    }
}



