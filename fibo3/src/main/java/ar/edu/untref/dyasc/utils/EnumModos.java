package ar.edu.untref.dyasc.utils;

public enum EnumModos {
    SUMATORIA("s"),
    LISTA("l");

    private final String modo;

    EnumModos(String modo) {
        this.modo = modo;
    }

    public String getModo() {
        return modo;
    }

    //get by modo
    public static EnumModos getModo(String modo) {
        for (EnumModos enumModo : EnumModos.values()) {
            if (enumModo.getModo().equals(modo)) {
                return enumModo;
            }
        }
        return null;
    }
}
