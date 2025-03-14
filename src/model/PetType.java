package src.model;

public enum PetType {
    CACHORRO("Cachorro"),
    GATO("Gato");

    public final String petTypePrint;

    PetType (String petTypePrint) {
        this.petTypePrint = petTypePrint;
    }

    public String getPetTypePrint() {
        return this.petTypePrint;
    }

}
