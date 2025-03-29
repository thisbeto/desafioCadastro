package src.main;

import src.model.Pet;
import src.repository.FileRepository;
import src.services.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        FileRepository file = new FileRepository();
        file.createFile();
        file.readFile();
        PrintMenu printMenu = new PrintMenu();
        int option = printMenu.printarMenuPrincipal();
        CadastrarPet cadastrarPet = new CadastrarPet();
        BuscarPet buscarPet = new BuscarPet();
        EditarPet editarPet = new EditarPet();
        ExcluirPet excluirPet = new ExcluirPet();
        ArrayList<Pet> pets = buscarPet.buscarPet();
        do {
            if (option == 1) {
               cadastrarPet.cadastrarPet();
            }
            if (option == 2) {
                buscarPet.rodarMenuBusca();
            }
            if (option == 3) {
                excluirPet.excluirPet();
            }
            if (option == 4) {
                buscarPet.printarListaPets();
            }
            if (option == 5) {
                editarPet.editarPet();
            }
            option = printMenu.printarMenuPrincipal();
        } while (option != 6);
    }
}




