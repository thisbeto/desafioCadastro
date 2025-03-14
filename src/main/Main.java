package src.main;

import src.Exception.InvalidPetException;
import src.model.Pet;
import src.model.PetType;
import src.repository.File;
import src.repository.MenuOption;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File file = new File();
        file.createFile();
        file.readFile();
        Scanner input;
        int option;
        do {
            input = new Scanner(System.in);
            System.out.println("\n1. Cadastrar um novo pet");
            System.out.println("2. Alterar os dados do pet cadastrado");
            System.out.println("3. Deletar um pet cadastrado");
            System.out.println("4. Listar todos os pets cadastrados");
            System.out.println("5. Listar pets por algum critério (idade, nome, raça)");
            System.out.println("6. Sair");
            System.out.println("Escolha uma opção: ");
            option = Integer.parseInt(MenuOption.numberInRange(input.nextLine()));


            if (option == 1) {
                Pet pet = new Pet();
                File.readSpecifyLineFile(1);
                try {
                    pet.setPetName(input.nextLine());
                } catch (InvalidPetException e) {
                    System.out.println("Erro ao cadastrar o pet: " + e.getMessage());
                    continue;
                }
                System.out.println("Nome cadastrado: " + pet.getPetName());
                File.readSpecifyLineFile(2);
                System.out.println("1 = Cachorro | 2 = Gato");
                try {
                    pet.setPetType(input.nextInt());
                    System.out.println(pet.getPetType());
                } catch (InputMismatchException | InvalidPetException e) {
                    System.out.println("Erro ao cadastrar o pet: " + e.getMessage());
                }
            }
        } while (option != 6);
    }
}



