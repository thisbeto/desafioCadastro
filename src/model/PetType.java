package src.model;

import src.Exception.InvalidPetException;

import java.util.InputMismatchException;

public enum PetType {
    CACHORRO(1,"Cachorro"),
    GATO(2,"Gato");

    public final String petTypePrint;
    public final int petTypeCode;

    PetType (int petTypeCode, String petTypePrint) {
        this.petTypePrint = petTypePrint;
        this.petTypeCode = petTypeCode;
    }

    public static PetType fromCodigo(int petTypeNumber) throws InvalidPetException, InputMismatchException {
        for (PetType type: PetType.values()) {
            if (type.petTypeCode == petTypeNumber) {
                return type;
            }
        }
        throw new InvalidPetException("Tipo de animal inválido: " +petTypeNumber);
    }


    public String getPetTypePrint() {
        return this.petTypePrint;
    }

}
