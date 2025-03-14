package src.model;

import src.Exception.InvalidPetException;

import java.util.InputMismatchException;

public enum PetGender {
    MACHO(1,"Macho"),
    FEMEA(2,"Fêmea");

    public final String petTypePrint;
    public final int petTypeCode;

    PetGender(int petTypeCode, String petTypePrint) {
        this.petTypePrint = petTypePrint;
        this.petTypeCode = petTypeCode;
    }

    public static PetGender fromCodigo(int petTypeNumber) throws InvalidPetException, InputMismatchException {
        for (PetGender type: PetGender.values()) {
            if (type.petTypeCode == petTypeNumber) {
                return type;
            }
        }
        throw new InvalidPetException("Tipo de gênero inválido: " +petTypeNumber);
    }


    public String getPetTypePrint() {
        return this.petTypePrint;
    }

}
