package src.utils;

import src.exception.InvalidPetException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ValidatorUtils {
    public String lerNomeValido(Scanner input) {
        try {
            String nomeFornecido = input.nextLine();
            return validarNome(nomeFornecido);
        } catch (InvalidPetException e) {
            System.out.println("Erro: " + e.getMessage() + " Tente novamente.");
            return lerNomeValido(input);
        }
    }

    private String validarNome(String nome) throws InvalidPetException {
        if (nome.trim().isEmpty() || !nome.contains(" ") || !nome.matches("[A-Za-z ]+")) {
            throw new InvalidPetException("O pet deve ter um nome e um sobrenome.");
        }
        return nome;
    }

    public int lerNValido(Scanner input) {
        try {
            System.out.print("Digite um número: ");
            int numValido = input.nextInt();
            input.nextLine(); // Limpa o buffer após leitura válida
            return numValido;
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida! Digite um número inteiro.");
            input.nextLine();
            return lerNValido(input);
        }
    }

    public float lerIdadeValido(Scanner input) {
        try {
            if (input.hasNextFloat()) {
                float numValido = input.nextFloat();
                if (numValido <= 0) {
                    System.out.println("Idade inválida. Deve ser maior que 0.");
                    return lerIdadeValido(input);
                } else if (numValido > 20) {
                    System.out.println("Idade inválida. Deve ser menor ou igual a 20.");
                    return lerIdadeValido(input);
                }
                return numValido; // Retorna a idade válida
            } else {
                System.out.println("Erro: Entrada inválida! Digite um número.");
                input.nextLine();
                return lerIdadeValido(input);
            }

        } catch (InputMismatchException e) {
            System.out.println("Erro: Entrada inválida! Digite um número.");
            return lerIdadeValido(input);
        }
    }

    public float lerPesoValido(Scanner input) {
        try {
            if (input.hasNextFloat()) {
                float numValido = input.nextFloat();
                if (numValido <= 0 || numValido > 60) {
                    throw new IllegalArgumentException("Peso inválido. Deve ser maior que 0kg e menor ou igual a 60kg.");
                }
                return numValido;
            } else {
                System.out.println("Erro: Entrada inválida! Digite um número.");
                input.nextLine();
                return lerPesoValido(input);
            }

        } catch (InputMismatchException | IllegalArgumentException e) {
            System.out.println("Erro: Entrada inválida! Digite um número.");
            return lerIdadeValido(input);
        }
    }
}
