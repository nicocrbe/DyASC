package ar.edu.untref.dyasc.models;

public class Tiebreak {
    private int puntosLocalTB;
    private int puntosVisitanteTB;

    public Tiebreak() {
        this.puntosLocalTB = 0;
        this.puntosVisitanteTB = 0;
    }

    public int getPuntosLocalTB() {
        return puntosLocalTB;
    }

    public void setPuntosLocalTB(int puntosLocalTB) {
        this.puntosLocalTB = puntosLocalTB;
    }

    public int getPuntosVisitanteTB() {
        return puntosVisitanteTB;
    }

    public void setPuntosVisitanteTB(int puntosVisitanteTB) {
        this.puntosVisitanteTB = puntosVisitanteTB;
    }

    public void sumarPuntoLocalTB() {
        puntosLocalTB++;
    }

    public void sumarPuntoVisitanteTB() {
        puntosVisitanteTB++;
    }

    public boolean checkGanadorLocalTB() {
        return puntosLocalTB > puntosVisitanteTB && puntosLocalTB >= 7 && puntosLocalTB - puntosVisitanteTB >= 2;
    }

    public boolean checkGanadorVisitanteTB() {
        return puntosVisitanteTB > puntosLocalTB && puntosVisitanteTB >= 7 && puntosVisitanteTB - puntosLocalTB >= 2;
    }
}