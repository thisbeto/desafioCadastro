package src.repository;

import src.main.Main;
import src.model.Pet;
import src.model.PetAddress;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class File {

    public void createFile() {
        java.io.File file = new java.io.File("C:\\Users\\Alberto\\Desktop\\Java\\desafioCadastro\\src\\data\\formulario.txt");
        try (FileWriter fw = new FileWriter(file);
             BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write("1 - Qual o nome e sobrenome do pet?\n2 - Qual o tipo do pet (Cachorro/Gato)\n3 - Qual o sexo do animal?\n4 - Qual endereço e bairro que ele foi encontrado?\n5 - Qual a idade aproximada do pet?\n6 - Qual o peso aproximado do pet?\n7 - Qual a raça do pet?");
            bw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void readFile() {
        java.io.File file = new java.io.File("C:\\Users\\Alberto\\Desktop\\Java\\desafioCadastro\\src\\data\\formulario.txt");
        try (FileReader fr = new FileReader(file);
             BufferedReader br = new BufferedReader(fr)) {
            String linha;
            while ((linha = br.readLine()) != null) {
                System.out.println(linha);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String readSpecifyLineFile(int line) {
        java.io.File file = new java.io.File("C:\\Users\\Alberto\\Desktop\\Java\\desafioCadastro\\src\\data\\formulario.txt");
        try (FileReader fr = new FileReader(file);
             BufferedReader br = new BufferedReader(fr)) {
            String linha;
            int cont = 1;
            while ((linha = br.readLine()) != null) {
                if (cont == line) {
                    System.out.println(linha);
                    return linha;
                }
                cont++;
            }
            return linha;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void savePetFile(Pet pet, PetAddress petAddress) {
        Main main = new Main();
        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmm");
        String dataHoraFormatada = agora.format(formatter);

        String name = pet.getPetName();
        String type = String.valueOf(pet.getPetType());
        String gender = String.valueOf(pet.getPetGender());
        String address = String.valueOf(pet.getAddress());
        String age = String.valueOf(pet.getPetAge());
        String weight = String.valueOf(pet.getPetWeight());
        String breed = String.valueOf(pet.getPetBreed());


        System.out.println("Nome do pet: " + name);
        System.out.println("Tipo do pet: " + type);
        System.out.println("Gênero do pet: " + gender);
        System.out.println("Endereço do pet: " + address);
        System.out.println("Idade do pet: " + age);
        System.out.println("Peso do pet: " + weight);
        System.out.println("Raça do pet: " + breed);

    }


}

