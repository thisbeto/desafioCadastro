package src.main;

import src.model.PetAddress;
import src.repository.FileRepository;
import src.services.CadastrarPet;
import src.services.PrintMenu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FileRepository file = new FileRepository();
        PetAddress petAddress = new PetAddress();
        file.createFile();
        file.readFile();
        PrintMenu printMenu = new PrintMenu();
        int option = printMenu.printarMenuPrincipal();
        Scanner input = new Scanner(System.in);
        CadastrarPet cadastrarPet = new CadastrarPet();
        do {
            if (option == 1) {
               cadastrarPet.cadastrarPet();

            }
            option = printMenu.printarMenuPrincipal();
        } while (option != 6);
    }
}



