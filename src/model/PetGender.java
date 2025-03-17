package src.model;

import src.Exception.InvalidPetException;

import java.util.InputMismatchException;

public enum PetGender {
    MACHO("Macho"),
    FEMEA("Fêmea");

    private final String descricao;

    PetGender(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }
}
