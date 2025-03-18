package src.repository;


import src.model.Pet;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileRepository {

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

    public void savePetFile(Pet pet) {
        // Formatando o nome do pet para maiúsculas e removendo espaços
        String nomeFormatado = pet.getPetName().replace(" ", "").toUpperCase();

        // Pegando a data e hora atual
        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmm");
        String dataHoraFormatada = agora.format(formatter);

        String nomeArquivo = dataHoraFormatada + "-" + nomeFormatado + ".txt";

        File diretorio = new File("C:\\Users\\Alberto\\Desktop\\Java\\desafioCadastro\\src\\petsCadastrados");
        if (!diretorio.exists()) {
            if (diretorio.mkdirs()) {
                System.out.println("Diretório criado com sucesso");
            } else {
                System.out.println("Falha ao criar diretório.");
                return;
            }
        } else {
            System.out.println("");
        }


        try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Alberto\\Desktop\\Java\\desafioCadastro\\src\\petsCadastrados\\" + nomeArquivo))) {
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

    }


}

