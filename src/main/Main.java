package src.main;

import src.exception.InvalidPetException;
import src.model.Pet;
import src.model.PetAddress;
import src.repository.FileDelete;
import src.repository.FileRepository;
import src.services.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InvalidPetException {
        FileRepository file = new FileRepository();
        file.createFile();
        file.readFile();
        PrintMenu printMenu = new PrintMenu();
        int option = printMenu.printarMenuPrincipal();
        CadastrarPet cadastrarPet = new CadastrarPet();
        BuscarPet buscarPet = new BuscarPet();
        EditarPet editarPet = new EditarPet();
        ExcluirPet excluirPet = new ExcluirPet();
        List<Pet> pets = buscarPet.buscarPet();
        do {
            if (option == 1) {
               cadastrarPet.cadastrarPet();
            }
            if (option == 2) {
                buscarPet.rodarMenuBusca();
            }
            if (option == 3) {
                excluirPet.excluirPet(pets);
            }
            if (option == 4) {
                buscarPet.formatarListaPets(pets);
            }
            if (option == 5) {
                editarPet.editarPet(pets);

            }
            option = printMenu.printarMenuPrincipal();
        } while (option != 6);
    }
}




