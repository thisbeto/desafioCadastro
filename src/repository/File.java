package src.repository;

import java.io.*;

public class File {
    public static void createFile(){
    java.io.File file = new java.io.File("C:\\Users\\Alberto\\Desktop\\Java\\desafioCadastro\\src\\data\\formulario.txt");
        try (FileWriter fw = new FileWriter(file);
             BufferedWriter bw = new BufferedWriter(fw)){
            bw.write("1 - Qual o nome e sobrenome do pet?\n2 - Qual o tipo do pet (Cachorro/Gato)\n3 - Qual o sexo do animal?\n4 - Qual endereço e bairro que ele foi encontrado?\n5 - Qual a idade aproximada do pet?\n6 - Qual o peso aproximado do pet?\n7 - Qual a raça do pet??");
            bw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try(FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr)){
            String linha;
            while((linha = br.readLine()) != null) {
                System.out.println(linha);
            }
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
