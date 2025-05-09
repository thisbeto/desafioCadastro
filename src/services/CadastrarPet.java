package src.services;

import src.model.Pet;
import src.model.PetAddress;
import src.repository.FileRepository;
import src.utils.ValidatorUtils;
import java.util.Scanner;

public class CadastrarPet {
    public void cadastrarPet() {
        Scanner input = new Scanner(System.in);
        Pet pet = new Pet();
        PetAddress petAddress = new PetAddress();
        ValidatorUtils validatorUtils = new ValidatorUtils();

        // PERGUNTA 1 - NOME E SOBRENOME
        FileRepository.readSpecifyLineFile(1);
        pet.setPetName(validatorUtils.lerNomeValido(input));

        // PERGUNTA 2 - TIPO ANIMAL
        FileRepository.readSpecifyLineFile(2);
        System.out.println("1 = Cachorro | 2 = Gato");
        pet.setPetTypeChoose(validatorUtils.lerUmOuDoisValido(input));

        // PERGUNTA 3 - GENERO ANIMAL
        FileRepository.readSpecifyLineFile(3);
        System.out.println("1 = Macho | 2 = Fêmea");
        pet.setPetGenderChoose(validatorUtils.lerUmOuDoisValido(input));


        // PERGUNTA 4 - ENDEREÇO ENCONTRADO
        FileRepository.readSpecifyLineFile(4);
        System.out.println("Número da casa: ");
        petAddress.setHouseNumber(validatorUtils.lerNumeroCasaValido(input));

        System.out.println("Cidade: ");
        petAddress.setCity(input.nextLine());

        System.out.println("Rua: ");
        petAddress.setStreet(input.nextLine());


        // PERGUNTA 5 - IDADE APROXIAMDA
        FileRepository.readSpecifyLineFile(5);
        pet.setPetAge(validatorUtils.lerIdadeValido(input));

        // PERGUNTA 6 - PESO
        FileRepository.readSpecifyLineFile(6);
        pet.setPetWeight(validatorUtils.lerPesoValido(input));

        // PERGUNTA 7 - RAÇA
        FileRepository.readSpecifyLineFile(7);
        input.nextLine();
        pet.setPetBreed(input.nextLine());


        pet.setAddress(petAddress);
        pet.savePetFile();

    }


}
