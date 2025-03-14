package src.main;

import src.Exception.InvalidPetException;
import src.model.Pet;
import src.model.PetAddress;
import src.model.PetGender;
import src.model.PetType;
import src.repository.File;
import src.repository.MenuOption;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File file = new File();
        PetAddress petAddress = new PetAddress();
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
                    PetType.fromCodigo(input.nextInt());
                } catch (IllegalArgumentException | InvalidPetException | InputMismatchException e) {
                    System.out.println("Erro ao cadastrar o pet: " + e.getMessage());
                }

                File.readSpecifyLineFile(3);
                System.out.println("1 = Macho | 2 = Fêmea");
                try {
                    PetGender.fromCodigo(input.nextInt());
                } catch (IllegalArgumentException | InvalidPetException | InputMismatchException e) {
                    System.out.println("Erro ao cadastrar o pet: " + e.getMessage());
                }
                File.readSpecifyLineFile(4);
                System.out.println("Número da casa: ");

                try {
                    petAddress.setHouseNumber(input.nextInt());
                    input.nextLine();

                } catch (IllegalArgumentException | InputMismatchException e) {
                    System.out.println("Erro ao cadastrar o pet: " + e.getMessage());
                }

                System.out.println("Cidade: ");
                try {
                    petAddress.setCity(input.nextLine());
                    input.nextLine();

                } catch (IllegalArgumentException | InputMismatchException e) {
                    System.out.println("Erro ao cadastrar o pet: " + e.getMessage());
                }

                System.out.println("Rua: ");
                try {
                    petAddress.setStreet(input.nextLine());
                    input.nextLine();

                } catch (IllegalArgumentException | InputMismatchException e) {
                    System.out.println("Erro ao cadastrar o pet: " + e.getMessage());
                }


            }
        } while (option != 6);
    }
}



