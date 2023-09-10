package ar.edu.untref.dyasc.models;


import ar.edu.untref.dyasc.utils.EnumDirecciones;
import ar.edu.untref.dyasc.utils.EnumModos;

public class RequerimientoEntrada {

    private boolean orientacionEnabled;
    private EnumDirecciones direccion;

    private boolean modoEnabled;
    private EnumModos modo;

    private boolean salidaTextoEnabled;
    private String nombreArchivo;
    private int numero;

    public RequerimientoEntrada() {
        this.orientacionEnabled = false;
        this.salidaTextoEnabled = false;
        this.modoEnabled = false;
    }

    public boolean isOrientacionEnabled() {
        return orientacionEnabled;
    }

    public void setOrientacionEnabled(boolean orientacionEnabled) {
        this.orientacionEnabled = orientacionEnabled;
    }

    public EnumDirecciones getDireccion() {
        return direccion;
    }

    public void setDireccion(EnumDirecciones direccion) {
        this.direccion = direccion;
    }

    public boolean isModoEnabled() {
        return modoEnabled;
    }

    public void setModoEnabled(boolean modoEnabled) {
        this.modoEnabled = modoEnabled;
    }

    public EnumModos getModo() {
        return modo;
    }

    public void setModo(EnumModos modo) {
        this.modo = modo;
    }

    public boolean isSalidaTextoEnabled() {
        return salidaTextoEnabled;
    }

    public void setSalidaTextoEnabled(boolean salidaTextoEnabled) {
        this.salidaTextoEnabled = salidaTextoEnabled;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}
