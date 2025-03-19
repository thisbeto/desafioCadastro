package src.repository;

import java.io.File;

public class FileDelete {
    public void deletarArquivoAntigo(String nomeAntigoPet) {
        File file = new File("C:\\Users\\Alberto\\Desktop\\Java\\desafioCadastro\\src\\petsCadastrados");
        File[] arquivos = file.listFiles();


        String nomeFormatado = nomeAntigoPet.replaceAll("\\s+", "").toUpperCase();

        for (File arquivo : arquivos) {
            if (arquivo.getName().toUpperCase().contains("-" + nomeFormatado + ".TXT")) {
                System.out.println("Arquivo encontrado: " + arquivo.getName()); // Debug
                if (arquivo.delete()) {
                    System.out.println("Arquivo deletado com sucesso: " + arquivo.getName());
                } else {
                    System.out.println("Erro ao deletar: " + arquivo.getName());
                }
                return;
            }
        }


    }
}
