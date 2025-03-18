package src.services;

import src.utils.MenuOption;

import java.util.Scanner;

public class PrintMenu {
    public int printarMenuPrincipal(){
        Scanner input = new Scanner(System.in);
        System.out.println("\n1. Cadastrar um novo pet");
        System.out.println("2. Listar pets por algum critério (idade, nome, raça)");
        System.out.println("3. Deletar um pet cadastrado");
        System.out.println("4. Listar todos os pets cadastrados");
        System.out.println("5. Alterar os dados do pet cadastrados");
        System.out.println("6. Sair");
        System.out.println("Escolha uma opção: ");
        int escolha = Integer.parseInt(MenuOption.numberInRange(input.nextLine()));
        return escolha;
    }

}
