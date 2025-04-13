package src.utils;

import src.model.Pet;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ValidatorUtils {
    public static final String NAO_INFORMADO = "Nao Informado";

    public String lerNomeValido(Scanner input) {
        try {
            String nomeFornecido = input.nextLine();
            Pet pet = new Pet();
            return pet.setPetName(nomeFornecido);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage() + " Tente novamente.");
            return lerNomeValido(input);
        }
    }

    public int lerUmOuDoisValido(Scanner input) {
        try {
            System.out.print("Digite um número: ");
            int numValido = input.nextInt();
            if (numValido == 1 || numValido == 2) {
                input.nextLine();
                return numValido;
            } else {
                System.out.println("Entrada inválida! Digite um número valido.");
                return lerUmOuDoisValido(input);
            }

        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida! Digite um número valido.");
            input.nextLine();
            return lerUmOuDoisValido(input);
        }
    }


    public int lerNValido(Scanner input) {
        try {
            System.out.print("Digite um número: ");
            int numValido = input.nextInt();
            input.nextLine();
            return numValido;
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida! Digite um número valido.");
            input.nextLine();
            return lerNValido(input);
        }
    }

    public String lerNumeroCasaValido(Scanner input) {
        System.out.print("Digite o número da casa: ");
        String entrada = input.nextLine().trim();

        if (entrada.isEmpty()) {
            return Pet.NAO_INFORMADO;
        }

        if (entrada.matches("\\d+")) {
            return entrada;
        } else {
            System.out.println("Entrada inválida! Digite apenas números ou pressione Enter para deixar como 'Não Informado'.");
            return lerNumeroCasaValido(input);
        }
    }


    public String lerIdadeValido(Scanner input) {
        while (true) {
            String entrada = input.nextLine();

            if (entrada.trim().isEmpty()) {
                return Pet.NAO_INFORMADO;
            }

            try {
                float idade = Float.parseFloat(entrada);
                if (idade <= 0 || idade > 20) {
                    throw new IllegalArgumentException("Idade inválida. Deve estar entre 1 e 20.");
                }
                return String.valueOf(idade);
            } catch (NumberFormatException e) {
                System.out.println("Erro: Entrada inválida! Digite um número.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    public String lerPesoValido(Scanner input) {
        while (true) {
            String entrada = input.nextLine();

            if (entrada.trim().isEmpty()) {
                return Pet.NAO_INFORMADO;
            }

            try {
                float numValido = Float.parseFloat(entrada);
                if (numValido <= 0 || numValido > 60) {
                    throw new IllegalArgumentException("Peso inválido. Deve ser maior que 0kg e menor ou igual a 60kg.");
                }
                return String.valueOf(numValido);
            } catch (NumberFormatException e) {
                System.out.println("Erro: Entrada inválida! Digite um número.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
