package src.repository;


import src.model.Pet;
import src.services.BuscarPet;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileRepository {
    static Path pathForm = Paths.get("src\\data\\formulario.txt");
    static Path pathCadastrar = Paths.get("src\\petsCadastrados");

    public void createFile() {
        File file = new File(String.valueOf(pathForm.toAbsolutePath()));
        try (FileWriter fw = new FileWriter(file);
             BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write("1 - Qual o nome e sobrenome do pet?\n2 - Qual o tipo do pet (Cachorro/Gato)\n3 - Qual o sexo do animal?\n4 - Qual endereço e bairro que ele foi encontrado?\n5 - Qual a idade aproximada do pet?\n6 - Qual o peso aproximado do pet?\n7 - Qual a raça do pet?");
            bw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void readFile() {
        File file = new File(String.valueOf(pathForm.toAbsolutePath()));
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
        File file = new File(String.valueOf(pathForm.toAbsolutePath()));
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

    public void savePetFile(Pet pet) {
        String nomeFormatado = pet.getPetName().replace(" ", "").toUpperCase();
        BuscarPet buscarPet = new BuscarPet();
        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmm");
        String dataHoraFormatada = agora.format(formatter);

        String nomeArquivo = dataHoraFormatada + "-" + nomeFormatado + ".txt";

        File diretorio = new File(String.valueOf(pathCadastrar.toAbsolutePath()));
        File arquivo = new File(diretorio, nomeArquivo);
        if (!diretorio.exists()) {
            if (diretorio.mkdirs()) {
                System.out.println("Diretório criado com sucesso");
            } else {
                System.out.println("Falha ao criar diretório.");
            }
        }


        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo))) {
            bw.write("1 - " + pet.getPetName());
            bw.newLine();
            bw.write("2 - " + pet.getPetType());
            bw.newLine();
            bw.write("3 - " + pet.getPetGender());
            bw.newLine();
            bw.write("4 - " + pet.getAddress().getStreet() + ", " + pet.getAddress().getHouseNumber() + ", " + pet.getAddress().getCity());
            bw.newLine();
            bw.write("5 - " + pet.getPetAge() + " anos");
            bw.newLine();
            bw.write("6 - " + pet.getPetWeight() + "kg");
            bw.newLine();
            bw.write("7 - " + pet.getPetBreed());
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Erro ao criar ou escrever no arquivo: " + e.getMessage());
        }

        System.out.println("Pet salvo! Atualizando lista de pets...");
        buscarPet.buscarPet();
    }


}

