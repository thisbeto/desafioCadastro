package src.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import src.model.Pet;
import src.model.PetGender;
import src.model.PetType;
import src.model.PetAddress;
import src.utils.ValidatorUtils;

public class BuscarPet {
    static Path pathPetCadastrados = Paths.get("src\\petsCadastrados");
    public ArrayList<Pet> buscarPet() {
        File folder = new File(String.valueOf(pathPetCadastrados.toAbsolutePath()));
        folder = new File(folder.getAbsolutePath());
        File[] files = folder.listFiles();

        ArrayList<Pet> petList = null;


        if (files != null) {
            petList = new ArrayList<>();

            for (int i = 0; i < files.length; i++) {
                if (files[i].getName().endsWith(".txt")) {
                    try (BufferedReader br = new BufferedReader(new FileReader(files[i]))) {
                        String nome = br.readLine().split(" - ")[1];    // 1 - Florzinha da Silva
                        String especie = br.readLine().split(" - ")[1]; // 2 - Gato
                        String genero = br.readLine().split(" - ")[1];  // 3 - Femea
                        String endereco = br.readLine().split(" - ")[1]; // 4 - Rua 2, 456, Seilandia
                        String idade = br.readLine().split(" - ")[1];    // 5 - 6 anos
                        String peso = br.readLine().split(" - ")[1];     // 6 - 5kg
                        String raca = br.readLine().split(" - ")[1];     // 7 - Siames

                        Pet pet = new Pet();
                        PetAddress petAddress = new PetAddress();

                        String[] enderecoParts = endereco.split(",");
                        petAddress.setStreet(enderecoParts[0].trim());
                        petAddress.setHouseNumber(enderecoParts[1].trim());
                        petAddress.setCity(enderecoParts[2].trim());


                        pet.setAddress(petAddress);
                        pet.setPetName(nome);
                        pet.setPetType(PetType.valueOf(especie.toUpperCase()));
                        pet.setPetGender(PetGender.valueOf(genero.toUpperCase()));
                        pet.setPetAge(idade.split(" ")[0]);
                        pet.setPetWeight(peso.split("kg")[0].trim());
                        pet.setPetBreed(raca);

                        petList.add(pet);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

        }

        return petList;
    }

    public void rodarMenuBusca() {
        ArrayList<Pet> listaPetsConvertidos;
        ValidatorUtils validatorUtils = new ValidatorUtils();
        List<Pet> listaFiltrada;

        listaPetsConvertidos = buscarPet();
        Scanner input = new Scanner(System.in);

        System.out.println("Você deseja procurar por: 1 - Cachorro ou 2 - Gato?");
        int escolhaUsuario = validatorUtils.lerNValido(input);

        System.out.println("Escolha um critério para filtrar os pets:");
        opcoesCriterios();
        int escolha1 = validatorUtils.lerNValido(input);

        System.out.println("Escolha um segundo critério para filtrar os pets:");
        opcoesCriterios();
        int escolha2 = validatorUtils.lerNValido(input);

        PetType tipoEscolhido = null;

        if (escolhaUsuario == 1) {
            tipoEscolhido = PetType.CACHORRO;
        } else if (escolhaUsuario == 2) {
            tipoEscolhido = PetType.GATO;
        } else {
            System.out.println("Opção inválida! Digite apenas 1 ou 2.");
            return;
        }

        PetType finalTipoEscolhido = tipoEscolhido;
        listaFiltrada = listaPetsConvertidos.stream()
                .filter(pet -> pet.getPetType() == finalTipoEscolhido)
                .toList();

        if (escolha1 == 1 || escolha2 == 1) {
            System.out.println("Digite o nome ou sobrenome do pet que deseja buscar:");
            String termoBusca = input.next().toLowerCase().trim();

            if (termoBusca.isBlank()) {
                System.out.println("Nenhum nome digitado! Tente novamente.");
            } else {
                listaFiltrada = filtraPorNome(termoBusca, listaFiltrada);
            }
        }

        if (escolha1 == 2 || escolha2 == 2) {
            System.out.println("Você deseja procurar por: 1 - Macho ou 2 - Femea?");
            int escolhaGenero = validatorUtils.lerNValido(input);

            PetGender generoEscolhido = null;
            if (escolhaGenero == 1) {
                generoEscolhido = PetGender.MACHO;
            } else if (escolhaGenero == 2) {
                generoEscolhido = PetGender.FEMEA;
            } else {
                System.out.println("Opção inválida! Digite apenas 1 ou 2.");
                return;
            }

            Enum finalGenEscolha = generoEscolhido;
            listaFiltrada = listaFiltrada.stream()
                    .filter(pet -> pet.getPetGender() == finalGenEscolha)
                    .toList();

        }

        if (escolha1 == 3 || escolha2 == 3) {
            System.out.print("Digite a idade para buscar: ");
            int idadeBusca = validatorUtils.lerNValido(input);
            listaFiltrada = filtraPorIdade(idadeBusca, listaFiltrada);
        }

        if (escolha1 == 4 || escolha2 == 4) {
            System.out.print("Digite o peso para buscar: ");
            float pesoBusca = input.nextFloat();
            listaFiltrada = filtraPorPeso(pesoBusca, listaFiltrada);
        }

        if (escolha1 == 5 || escolha2 == 5) {
            System.out.println("Digite a raça que deseja buscar:");
            String buscarRaca = input.next().trim().toLowerCase();


            if (buscarRaca.isBlank()) {
                System.out.println("Nenhuma raça digitada! Tente novamente.");
            } else {
                listaFiltrada = filtraPorRaca(buscarRaca, listaFiltrada);
            }
        }

        if (escolha1 == 6 || escolha2 == 6) {
            System.out.println("Digite o endereço que deseja buscar:");
            String buscarAddress = input.next().trim().toLowerCase();

            if (buscarAddress.isBlank()) {
                System.out.println("Nenhum endereço digitado! Tente novamente.");
            } else {
                listaFiltrada = filtraPorEndereco(buscarAddress, listaFiltrada);
            }
        }

        formatarListaPets(listaFiltrada);

    }

    private List<Pet> filtraPorNome(String nomeBuscado, List<Pet> petArrayList) {
        List<Pet> newList = petArrayList.stream()
                .filter(pet -> pet.getPetName().toLowerCase().contains(nomeBuscado)).toList();
        return newList;
    }


    private List<Pet> filtraPorIdade(int idadeBuscada, List<Pet> petArrayList) {
        return petArrayList.stream()
                .filter(pet -> {
                    try {
                        return Integer.parseInt(pet.getPetAge()) == idadeBuscada;
                    } catch (NumberFormatException e) {
                        return false;
                    }
                })
                .toList();
    }

    private List<Pet> filtraPorPeso(double pesoBuscado, List<Pet> petArrayList) {
        return petArrayList.stream()
                .filter(pet -> {
                    try {
                        return Double.parseDouble(pet.getPetWeight()) == pesoBuscado;
                    } catch (NumberFormatException e) {
                        return false;
                    }
                })
                .toList();
    }

    private List<Pet> filtraPorRaca(String nomeBuscado, List<Pet> petArrayList) {
        return petArrayList.stream()
                .filter(pet -> pet.getPetBreed().toLowerCase().contains(nomeBuscado.toLowerCase())).toList();
    }

    private List<Pet> filtraPorEndereco(String enderecoBuscado, List<Pet> petArrayList) {
        return petArrayList.stream()
                .filter(pet -> String.valueOf(pet.getAddress().getStreet()).contains(enderecoBuscado) ||
                        String.valueOf(pet.getAddress().getCity()).contains(enderecoBuscado))
                .toList();
    }

    private void opcoesCriterios(){
        System.out.println("1 - Nome ou Sobrenome");
        System.out.println("2 - Sexo");
        System.out.println("3 - Idade");
        System.out.println("4 - Peso");
        System.out.println("5 - Raça");
        System.out.println("6 - Endereço");
        System.out.println("0 - Nenhuma outra");
        System.out.print("Opção: ");
    }

    public void formatarListaPets(List<Pet> listaPets) {
        if (listaPets == null) {
            listaPets = buscarPet();
        }

        if (listaPets.isEmpty()) {
            System.out.println("Nenhum pet encontrado com os critérios selecionados.");
            return;
        }

        int contador = 1;
        for (Pet pet : listaPets) {
            System.out.println(String.format(
                    "%d. %s - %s - %s - %s, %s - %s - %s anos - %s kg - %s",
                    contador++,
                    pet.getPetName(),
                    pet.getPetType(),
                    pet.getPetGender(),
                    pet.getAddress().getStreet(),
                    pet.getAddress().getHouseNumber(),
                    pet.getAddress().getCity(),
                    pet.getPetAge(),
                    pet.getPetWeight(),
                    pet.getPetBreed()
            ));
        }
    }

    public void printarListaPets() {
        formatarListaPets(null);
    }
}

