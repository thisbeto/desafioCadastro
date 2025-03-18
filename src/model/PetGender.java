package src.model;

public enum PetGender {
    MACHO("Macho"),
    FEMEA("Femea");

    private final String descricao;

    PetGender(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }
}
