package src.model;

import src.Exception.InvalidPetException;

public class Pet {
    String petName;
    PetType petType;
    PetGender petGender;
    PetAddress address;
    float petAge;
    float petWeight;
    String petBreed;

    public static final String NAO_INFORMADO = "NÃO INFORMADO";

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) throws InvalidPetException {
        this.petName = petName;
        if (petName.trim().isEmpty() || !petName.contains(" ") || !petName.matches("[A-Za-z ]+")){
            throw new InvalidPetException("O pet deve ter um nome e um sobrenome.");
        }

    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public PetAddress getAddress() {
        return address;
    }

    public PetAddress getAddress(int i) {
        return address;
    }

    public void setAddress(PetAddress address) {
        this.address = address;
    }

    public float getPetAge() {
        return petAge;
    }

    public void setPetAge(float petAge) {
        if (petAge > 20) {
            throw new IllegalArgumentException("A idade do pet não pode ser maior que 20 anos.");
        }
        this.petAge = petAge;
    }

    public float getPetWeight() {
        return petWeight;
    }

    public void setPetWeight(float petWeight) {
        if (petWeight > 60) {
            throw new IllegalArgumentException("O peso do pet não pode ser maior do que 60kg");
        }
        if (petWeight < 0.5) {
            throw new IllegalArgumentException("O peso do pet não pode ser maior do que 60kg");
        }
        this.petWeight = petWeight;
    }

    public String getPetBreed() {
        return petBreed;
    }

    public void setPetBreed(String petBreed) {
        this.petBreed = petBreed;
    }
}
