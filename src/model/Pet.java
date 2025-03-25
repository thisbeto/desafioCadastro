package src.model;

public class Pet {
    private String petName;
    private PetType petType;
    private PetGender petGender;
    private PetAddress address;
    private float petAge;
    private float petWeight;
    private String petBreed;

    public String getPetName() {
        return petName;
    }

    public String setPetName(String petName) {
        if (petName == null || petName.trim().isEmpty() || !petName.contains(" ") || !petName.matches("[A-Za-z ]+")) {
            throw new IllegalArgumentException("O pet deve ter um nome e um sobrenome.");
        }
        this.petName = petName;
        return petName;
    }

    public void setPetTypeChoose(int escolha) {
        if (escolha == 1) {
            setPetType(PetType.CACHORRO);
        } if (escolha == 2) {
            setPetType(PetType.GATO);
        } else {
            System.out.println("Opção inválida! Digite apenas 1 ou 2.");
        }
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public PetAddress getAddress() {
        return address;
    }

    public void setAddress(PetAddress address) {
        this.address = address;
    }

    public float getPetAge() {
        return petAge;
    }

    public void setPetAge(float petAge) {
        this.petAge = petAge;
    }

    public float getPetWeight() {
        return petWeight;
    }

    public void setPetWeight(float petWeight) {
        this.petWeight = petWeight;
    }

    public void setPetGenderChoose(int escolha) {
        if (escolha == 1) {
            setPetGender(PetGender.MACHO);
        } if (escolha == 2) {
            setPetGender(PetGender.FEMEA);
        } else {
            System.out.println("Opção inválida! Digite apenas 1 ou 2.");
        }
    }

    public void setPetGender(PetGender petGender) {
        this.petGender = petGender;
    }

    public String getPetBreed() {
        return petBreed;
    }

    public void setPetBreed(String petBreed) {
        this.petBreed = petBreed;
    }

    public PetType getPetType() {
        return petType;
    }

    public PetGender getPetGender() {
        return petGender;
    }
}
