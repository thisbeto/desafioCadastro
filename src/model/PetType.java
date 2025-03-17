package src.model;

import src.Exception.InvalidPetException;

import java.util.InputMismatchException;

public enum PetType {
    CACHORRO("Cachorro"),
    GATO("Gato");

    private final String descricao;

    PetType(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }
}
