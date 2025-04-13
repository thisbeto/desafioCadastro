package src.model;

import src.services.BuscarPet;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Pet {
    private String petName;
    private PetType petType;
    private PetGender petGender;
    private PetAddress address;
    private String petAge;
    private String petWeight;
    private String petBreed;

    public static final String NAO_INFORMADO = "Nao Informado";

    public String getPetName() {
        return petName;
    }

    public String setPetName(String petName) {
        if (petName == null || petName.trim().isEmpty()) {
            this.petName = NAO_INFORMADO;
            return this.petName;
        }

        if (!petName.contains(" ") || !petName.matches("[A-Za-zÀ-ÿ ]+")) {
            throw new IllegalArgumentException("O pet deve ter um nome e um sobrenome.");
        }

        this.petName = petName.trim();
        return this.petName;
    }

    public void setPetTypeChoose(int escolha) {
        if (escolha == 1) {
            setPetType(PetType.CACHORRO);
        } if (escolha == 2) {
            setPetType(PetType.GATO);
        }
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public PetType getPetType() {
        return petType;
    }

    public PetAddress getAddress() {
        return address;
    }

    public void setAddress(PetAddress address) {
        this.address = address;
    }

    public String getPetAge() {
        return petAge;
    }

    public void setPetAge(String petAge) {
        if (petAge == null || petAge.trim().isEmpty() || petAge.equalsIgnoreCase(NAO_INFORMADO)) {
            this.petAge = NAO_INFORMADO;
            return;
        }

        try {
            float idade = Float.parseFloat(petAge.trim());
            if (idade <= 0 || idade > 20) {
                throw new IllegalArgumentException("Idade inválida. Deve estar entre 1 e 20.");
            }
            this.petAge = String.valueOf((int) idade); // salvar como string inteira
        } catch (NumberFormatException e) {
            // Aqui está o problema que você relatou.
            // Então em vez de lançar, podemos assumir que é "Não Informado":
            this.petAge = NAO_INFORMADO;
        }
    }


    public String getPetWeight() {
        return petWeight;
    }


    public void setPetWeight(String petWeight) {
        if (petWeight == null || petWeight.trim().isEmpty() || petWeight.equalsIgnoreCase(NAO_INFORMADO)) {
            this.petWeight = NAO_INFORMADO;
            return;
        }

        try {
            float peso = Float.parseFloat(petWeight);
            if (peso <= 0 || peso > 60) {
                throw new IllegalArgumentException("Peso inválido. Deve estar entre 0kg e 60kg.");
            }
            this.petWeight = String.valueOf(peso);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Peso inválido. Digite um número válido.");
        }
    }

    public void setPetGenderChoose(int escolha) {
        if (escolha == 1) {
            setPetGender(PetGender.MACHO);
        } if (escolha == 2) {
            setPetGender(PetGender.FEMEA);
        }
    }

    public void setPetGender(PetGender petGender) {
        this.petGender = petGender;
    }

    public String getPetBreed() {
        return petBreed;
    }

    public String setPetBreed(String petBreed) {
        if (petBreed == null || petBreed.trim().isEmpty()) {
            this.petBreed = NAO_INFORMADO;
            return this.petBreed;
        }

        this.petBreed = petBreed;
        return petBreed;
    }

    public PetGender getPetGender() {
        return petGender;
    }

    static Path pathCadastrar = Paths.get("src\\petsCadastrados");

    public void savePetFile() {
        String nomeFormatado = getPetName().replace(" ", "").toUpperCase();
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
            bw.write("1 - " + getPetName());
            bw.newLine();
            bw.write("2 - " + getPetType());
            bw.newLine();
            bw.write("3 - " + getPetGender());
            bw.newLine();
            bw.write("4 - " + getAddress().getStreet() + ", " + getAddress().getHouseNumber() + ", " + getAddress().getCity());
            bw.newLine();
            bw.write("5 - " + getPetAge() + " anos");
            bw.newLine();
            bw.write("6 - " + getPetWeight() + "kg");
            bw.newLine();
            bw.write("7 - " + getPetBreed());
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Erro ao criar ou escrever no arquivo: " + e.getMessage());
        }

        System.out.println("Pet salvo! Atualizando lista de pets...");
        buscarPet.buscarPet();
    }


}
