package src.services;

import src.exception.InvalidPetException;
import src.model.Pet;
import src.repository.FileDelete;
import src.utils.ValidatorUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class EditarPet {
    public void editarPet(List<Pet> listaFiltrada) throws InvalidPetException {
        if (listaFiltrada.isEmpty()) {
            System.out.println("Nenhum pet encontrado para editar.");
            return;
        }

        Scanner input = new Scanner(System.in);
        BuscarPet buscarPet = new BuscarPet();
        ValidatorUtils validatorUtils = new ValidatorUtils();
        FileDelete fileDelete = new FileDelete();

        buscarPet.formatarListaPets(listaFiltrada);
        System.out.print("Digite o número do pet que deseja editar: ");
        int escolhaPetEditar = validatorUtils.lerNValido(input);

        if (escolhaPetEditar < 1 || escolhaPetEditar > listaFiltrada.size()) {
            System.out.println("Número inválido! Tente novamente.\n");
            editarPet(listaFiltrada);
        }

        Pet petSelecionado = listaFiltrada.get(escolhaPetEditar - 1);
        String nomeAntigoPet = petSelecionado.getPetName();

        System.out.println("Editando o pet: " + petSelecionado.getPetName());


        System.out.print("Novo nome (ou pressione Enter para manter): ");
        String novoNome = input.nextLine();

        if (novoNome.isBlank()) {
            System.out.println("Nome mantido: " + petSelecionado.getPetName());
        } else {
            petSelecionado.setPetName(novoNome);
            System.out.println("Nome atualizado para: " + novoNome);
        }

        System.out.print("Novo endereço (Rua, Número, Cidade) ou pressione Enter para manter: ");
        String novoEndereco = input.nextLine();
        if (!novoEndereco.isBlank()) {
            String[] partes = novoEndereco.split(",");
            petSelecionado.getAddress().setStreet(partes[0].trim());
            petSelecionado.getAddress().setHouseNumber(Integer.parseInt(partes[1].trim()));
            petSelecionado.getAddress().setCity(partes[2].trim());
        }

        System.out.print("Nova idade (anos) ou pressione Enter para manter: ");
        String novaIdade = input.nextLine();


        if (novaIdade.isBlank()) {
            System.out.println("Idade mantida: " + petSelecionado.getPetAge() + " anos");
        } else {
            petSelecionado.setPetAge(Float.parseFloat(novaIdade));
            System.out.println("Idade atualizada para: " + novaIdade + " anos");
        }

        System.out.print("Novo peso (kg) ou pressione Enter para manter: ");
        String novoPeso = input.nextLine();


        if (novoPeso.isBlank()) {
            System.out.println("Peso mantido: " + petSelecionado.getPetWeight() + " kg");
        } else {
            petSelecionado.setPetWeight(Float.parseFloat(novoPeso));
            System.out.println("Peso atualizado para: " + novoPeso + " kg");
        }

        System.out.print("Nova raça ou pressione Enter para manter: ");
        String novaRaca = input.nextLine();


        if (novaRaca.isBlank()) {
            System.out.println("Raça mantida: " + petSelecionado.getPetBreed());
        } else {
            petSelecionado.setPetBreed(novaRaca);
            System.out.println("Raça atualizada para: " + novaRaca);
        }

        System.out.println("Pet atualizado com sucesso!");

        fileDelete.deletarArquivoAntigo(nomeAntigoPet);
        System.out.println(nomeAntigoPet);

        // Formatando o nome do pet para maiúsculas e removendo espaços
        String nomeFormatado = petSelecionado.getPetName().replace(" ", "").toUpperCase();

        // Pegando a data e hora atual
        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmm");
        String dataHoraFormatada = agora.format(formatter);

        String nomeArquivo = dataHoraFormatada + "-" + nomeFormatado + ".txt";


        try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Alberto\\Desktop\\Java\\desafioCadastro\\src\\petsCadastrados\\" + nomeArquivo))) {
            bw.write("1 - " + petSelecionado.getPetName());
            bw.newLine();
            bw.write("2 - " + petSelecionado.getPetType());
            bw.newLine();
            bw.write("3 - " + petSelecionado.getPetGender());
            bw.newLine();
            bw.write("4 - " + petSelecionado.getAddress().getStreet() + ", " + petSelecionado.getAddress().getHouseNumber() + ", " + petSelecionado.getAddress().getCity());
            bw.newLine();
            bw.write("5 - " + petSelecionado.getPetAge() + " anos");
            bw.newLine();
            bw.write("6 - " + petSelecionado.getPetWeight() + "kg");
            bw.newLine();
            bw.write("7 - " + petSelecionado.getPetBreed());
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Erro substituir o arquivo: " + e.getMessage());
        }

    }
}
