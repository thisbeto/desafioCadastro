package src.services;

import src.model.Pet;
import src.model.PetAddress;
import src.model.PetGender;
import src.model.PetType;
import src.repository.FileRepository;
import src.utils.ValidatorUtils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CadastrarPet {
    public void cadastrarPet() {
        Scanner input = new Scanner(System.in);
        Pet pet = new Pet();
        FileRepository fileRepository = new FileRepository();
        PetAddress petAddress = new PetAddress();
        ValidatorUtils validatorUtils = new ValidatorUtils();

        // PERGUNTA 1 - NOME E SOBRENOME
        FileRepository.readSpecifyLineFile(1);
        pet.setPetName(validatorUtils.lerNomeValido(input));


        // PERGUNTA 2 - TIPO ANIMAL
        FileRepository.readSpecifyLineFile(2);
        while (true) {
            try {
                System.out.println("1 = Cachorro | 2 = Gato");
                int escolha = validatorUtils.lerNValido(input);
                if (escolha == 1) {
                    pet.setPetType(PetType.CACHORRO);
                    break;
                } else if (escolha == 2) {
                    pet.setPetType(PetType.GATO);
                    break;
                } else {
                    System.out.println("Opção inválida! Digite apenas 1 ou 2.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada inválida! Digite um número.");
            }
        }

        // PERGUNTA 3 - GENERO ANIMAL
        FileRepository.readSpecifyLineFile(3);
        while (true) {
            System.out.println("1 = Macho | 2 = Fêmea");
            int escolha = validatorUtils.lerNValido(input);

            if (escolha == 1) {
                pet.setPetGender(PetGender.MACHO);
                break;
            } else if (escolha == 2) {
                pet.setPetGender(PetGender.FEMEA);
                break;
            } else {
                System.out.println("Opção inválida! Digite apenas 1 ou 2.");
            }
        }


        // PERGUNTA 4 - ENDEREÇO ENCONTRADO
        FileRepository.readSpecifyLineFile(4);
        System.out.println("Número da casa: ");

        try {
            petAddress.setHouseNumber(validatorUtils.lerNValido(input));

        } catch (InputMismatchException e) {
            System.out.println("Erro ao cadastrar o pet: " + e.getMessage());
        }

        System.out.println("Cidade: ");
        try {
            petAddress.setCity(input.nextLine());

        } catch (InputMismatchException e) {
            System.out.println("Erro ao cadastrar o pet: " + e.getMessage());
        }

        System.out.println("Rua: ");
        try {
            petAddress.setStreet(input.nextLine());

        } catch (InputMismatchException e) {
            System.out.println("Erro ao cadastrar o pet: " + e.getMessage());
        }

        // PERGUNTA 5 - IDADE APROXIAMDA
        FileRepository.readSpecifyLineFile(5);
        try {
            pet.setPetAge(validatorUtils.lerIdadeValido(input));
        } catch (InputMismatchException e) {
            System.out.println("Erro ao cadastrar o pet: " + e.getMessage());
        }

        // PERGUNTA 6 - PESO
        FileRepository.readSpecifyLineFile(6);
        try {
            pet.setPetWeight(validatorUtils.lerPesoValido(input));
        } catch (IllegalArgumentException | InputMismatchException e) {
            System.out.println("Erro ao cadastrar o pet: " + e.getMessage());
        }

        // PERGUNTA 7 - RAÇA
        FileRepository.readSpecifyLineFile(7);
        try {
            input.nextLine();
            String breed = input.nextLine();
            pet.setPetBreed(breed);
        } catch (IllegalArgumentException | InputMismatchException e) {
            System.out.println("Erro ao cadastrar o pet: " + e.getMessage());
        }

        pet.setAddress(petAddress);

        fileRepository.savePetFile(pet);

    }


}
