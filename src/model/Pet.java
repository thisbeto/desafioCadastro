package src.model;

import src.Exception.InvalidPetException;

public class Pet {
    String petName;
    int petType;
    String petGender;
    PetAddress address;
    float petAge;
    float petWeight;
    String petBreed;

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) throws InvalidPetException {
        this.petName = petName;
        if (petName == null || petName.trim().isEmpty() || !petName.contains(" ") || !petName.matches("[A-Za-z ]+")){
            throw new InvalidPetException("O pet deve ter um nome e um sobrenome.");
        }

    }

    public int getPetType() {
        return petType;
    }

    public void setPetType(int petType) throws InvalidPetException {
        this.petType = petType;
        PetType cachorro = PetType.CACHORRO;
        PetType gato = PetType.GATO;
        if (petType == 1) {
            System.out.println(cachorro.getPetTypePrint());
        } else if (petType == 2) {
            System.out.println(gato.getPetTypePrint());
        }

    }

    public String getPetGender() {
        return petGender;
    }

    public void setPetGender(String petGender) {
        this.petGender = petGender;
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

    public String getPetBreed() {
        return petBreed;
    }

    public void setPetBreed(String petBreed) {
        this.petBreed = petBreed;
    }
}
