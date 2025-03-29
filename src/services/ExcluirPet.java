package src.services;

import src.model.Pet;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExcluirPet {
    static Path pathCadastrados = Paths.get("src\\petsCadastrados");
    public void excluirPet() {
        Scanner input = new Scanner(System.in);
        BuscarPet buscarPet = new BuscarPet();
        ArrayList<Pet> resultadosBusca = buscarPet.buscarPet();

        buscarPet.formatarListaPets(resultadosBusca);

        int escolha = -1;
        while (escolha < 1 || escolha > resultadosBusca.size()) {
            System.out.print("\nDigite o número do pet que deseja deletar: ");
            if (input.hasNextInt()) {
                escolha = input.nextInt();
                input.nextLine();
                if (escolha < 1 || escolha > resultadosBusca.size()) {
                    System.out.println("Número inválido! Escolha um número da lista.");
                }
            } else {
                input.nextLine();
                System.out.println("Entrada inválida! Digite um número válido.");
            }
        }

        Pet petSelecionado = resultadosBusca.get(escolha - 1);
        String nomePetSelecionado = petSelecionado.getPetName().replaceAll("\\s+", "").toUpperCase();

        System.out.println("\nTem certeza que deseja excluir o pet '" + petSelecionado.getPetName() + "'? (SIM / NÃO)");
        String confirmacao = input.nextLine().trim().toUpperCase();

        if (!confirmacao.equals("SIM")) {
            System.out.println("Exclusão cancelada.");
            return;
        }

        File pasta = new File(String.valueOf(pathCadastrados.toAbsolutePath()));
        File[] arquivos = pasta.listFiles();

        if (arquivos != null) {
            for (File arquivo : arquivos) {
                String nomeArquivo = arquivo.getName().toUpperCase();
                if (nomeArquivo.contains("-" + nomePetSelecionado + ".TXT")) {
                    if (arquivo.delete()) {
                        System.out.println("Pet '" + petSelecionado.getPetName() + "' deletado com sucesso!");
                    } else {
                        System.out.println("Erro ao deletar o pet '" + petSelecionado.getPetName() + "'.");
                    }
                    return;
                }
            }
        }

        System.out.println("Arquivo do pet não encontrado para exclusão.");
    }
}
