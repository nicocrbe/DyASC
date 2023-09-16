package ar.edu.untref.dyasc.models;

public class Partido {
    private int setsLocal;
    private int setsVisitante;
    private String puntosGameActualLocal;
    private String puntosGameActualVisitante;
    private int cantidadGamesLocal;
    private int cantidadGamesVisitante;

    private boolean ganoLocal;
    private boolean ganoVisitante;

    private boolean deuce;
    private boolean ventajaLocal;
    private boolean ventajaVisitante;

    public boolean isGanoLocal() {
        return ganoLocal;
    }

    public void setGanoLocal(boolean ganoLocal) {
        this.ganoLocal = ganoLocal;
    }

    public boolean isGanoVisitante() {
        return ganoVisitante;
    }

    public void setGanoVisitante(boolean ganoVisitante) {
        this.ganoVisitante = ganoVisitante;
    }

    public Partido() {
        this.setsLocal = 0;
        this.setsVisitante = 0;
        this.puntosGameActualLocal = "0";
        this.puntosGameActualVisitante = "0";
        this.cantidadGamesLocal = 0;
        this.cantidadGamesVisitante = 0;
        this.ganoLocal = false;
        this.ganoVisitante = false;
    }

    public boolean isVentajaLocal() {
        return ventajaLocal;
    }

    public void setVentajaLocal(boolean ventajaLocal) {
        this.ventajaLocal = ventajaLocal;
    }

    public boolean isVentajaVisitante() {
        return ventajaVisitante;
    }

    public void setVentajaVisitante(boolean ventajaVisitante) {
        this.ventajaVisitante = ventajaVisitante;
    }

    public boolean isDeuce() {
        return deuce;
    }

    public void setDeuce(boolean deuce) {
        this.deuce = deuce;
    }

    public int getSetsLocal() {
        return setsLocal;
    }

    public void setSetsLocal(int setsLocal) {
        this.setsLocal = setsLocal;
    }

    public int getSetsVisitante() {
        return setsVisitante;
    }

    public void setSetsVisitante(int setsVisitante) {
        this.setsVisitante = setsVisitante;
    }

    public String getPuntosGameActualLocal() {
        return puntosGameActualLocal;
    }

    public void setPuntosGameActualLocal(String puntosGameActualLocal) {
        this.puntosGameActualLocal = puntosGameActualLocal;
    }

    public String getPuntosGameActualVisitante() {
        return puntosGameActualVisitante;
    }

    public void setPuntosGameActualVisitante(String puntosGameActualVisitante) {
        this.puntosGameActualVisitante = puntosGameActualVisitante;
    }

    public int getCantidadGamesLocal() {
        return cantidadGamesLocal;
    }

    public void setCantidadGamesLocal(int cantidadGamesLocal) {
        this.cantidadGamesLocal = cantidadGamesLocal;
    }

    public int getCantidadGamesVisitante() {
        return cantidadGamesVisitante;
    }

    public void setCantidadGamesVisitante(int cantidadGamesVisitante) {
        this.cantidadGamesVisitante = cantidadGamesVisitante;
    }
}
