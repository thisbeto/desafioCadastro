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

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) throws InvalidPetException {
        this.petName = petName;
        if (petName == null || petName.trim().isEmpty() || !petName.contains(" ") || !petName.matches("[A-Za-z ]+")){
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
