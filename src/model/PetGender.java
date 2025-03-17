package src.model;

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
