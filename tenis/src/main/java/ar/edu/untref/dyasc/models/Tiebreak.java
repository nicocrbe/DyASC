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

    public void sumarPuntoLocalTB(Partido partido) {
        puntosLocalTB++;
        checkGanadorLocalTB(partido);
    }

    public void sumarPuntoVisitanteTB(Partido partido) {
        puntosVisitanteTB++;
        checkGanadorVisitanteTB(partido);
    }

    public void checkGanadorLocalTB(Partido partido) {
        if(this.puntosLocalTB > this.puntosVisitanteTB && this.puntosLocalTB >= 7 && this.puntosLocalTB - this.puntosVisitanteTB >= 2){
            partido.setSetsLocal(partido.getSetsLocal() + 1);
            partido.setCantidadGamesLocal(0);
            partido.setCantidadGamesVisitante(0);
        };
    }

    public void checkGanadorVisitanteTB(Partido partido) {
        if(this.puntosVisitanteTB > this.puntosLocalTB && this.puntosVisitanteTB >= 7 && this.puntosVisitanteTB - this.puntosLocalTB >= 2){
            partido.setSetsVisitante(partido.getSetsVisitante() + 1);
            partido.setCantidadGamesLocal(0);
            partido.setCantidadGamesVisitante(0);
        };
    }
}