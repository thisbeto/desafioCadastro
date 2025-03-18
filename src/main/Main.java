package src.main;

import src.model.Pet;
import src.model.PetAddress;
import src.repository.FileRepository;
import src.services.BuscarPet;
import src.services.CadastrarPet;
import src.services.PrintMenu;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        FileRepository file = new FileRepository();
        PetAddress petAddress = new PetAddress();
        file.createFile();
        file.readFile();
        PrintMenu printMenu = new PrintMenu();
        int option = printMenu.printarMenuPrincipal();
        CadastrarPet cadastrarPet = new CadastrarPet();
        BuscarPet buscarPet = new BuscarPet();
        List<Pet> pets = buscarPet.buscarPet();
        do {
            if (option == 1) {
               cadastrarPet.cadastrarPet();
            }
            if (option == 2) {
                buscarPet.rodarMenuBusca();
            }
            if (option == 4) {
                buscarPet.formatarListaPets(pets);
            }
            option = printMenu.printarMenuPrincipal();
        } while (option != 6);
    }
}




