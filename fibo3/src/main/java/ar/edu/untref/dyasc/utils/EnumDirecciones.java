package ar.edu.untref.dyasc.utils;

public enum EnumDirecciones {
    HORIZONTAL_DERECHA("hd"),
    HORIZONTAL_INVERSA("hi"),
    VERTICAL_DERECHA("vd"),
    VERTICAL_INVERSA("vi");

    private final String direccion;

    EnumDirecciones(String direccion) {
        this.direccion = direccion;
    }

    public String getDireccion() {
        return direccion;
    }

    //get by direccion
    public static EnumDirecciones getDireccion(String direccion) {
        for (EnumDirecciones enumDireccion : EnumDirecciones.values()) {
            if (enumDireccion.getDireccion().equals(direccion)) {
                return enumDireccion;
            }
        }
        return null;
    }
}
