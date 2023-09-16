package ar.edu.untref.dyasc.service;

import ar.edu.untref.dyasc.models.Jugador;
import ar.edu.untref.dyasc.models.Partido;

public class PartidoService {

    private Jugador jugadorLocal;
    private Jugador jugadorVisitante;
    private Partido partido;

    public PartidoService(Jugador jugadorLocal, Jugador jugadorVisitante, Partido partido) {
        this.jugadorLocal = jugadorLocal;
        this.jugadorVisitante = jugadorVisitante;
        this.partido = partido;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    public Jugador getJugadorLocal() {
        return jugadorLocal;
    }

    public void setJugadorLocal(Jugador jugadorLocal) {
        this.jugadorLocal = jugadorLocal;
    }

    public Jugador getJugadorVisitante() {
        return jugadorVisitante;
    }

    public void setJugadorVisitante(Jugador jugadorVisitante) {
        this.jugadorVisitante = jugadorVisitante;
    }

    public void sumarPuntoGameActualLocal() {
        if(partido.getPuntosGameActualLocal().equals("0")){
            partido.setPuntosGameActualLocal("15");
        }else if(partido.getPuntosGameActualLocal().equals("15")){
            partido.setPuntosGameActualLocal("30");
        }else if(partido.getPuntosGameActualLocal().equals("30")){
            if(partido.getPuntosGameActualVisitante().equals("40")){
                partido.setDeuce(true);
            }
            partido.setPuntosGameActualLocal("40");
        }else if(partido.getPuntosGameActualLocal().equals("40")){
            if(partido.isDeuce()){
                partido.setVentajaLocal(true);
                partido.setDeuce(false);
            }else if(partido.isVentajaVisitante()){
                partido.setDeuce(true);
                partido.setVentajaVisitante(false);
            }else{
                sumarGameLocal();
                partido.setPuntosGameActualLocal("0");
            }
        }
    }
    public void sumarPuntoGameActualVisitante() {
        if(partido.getPuntosGameActualVisitante().equals("0")){
            partido.setPuntosGameActualVisitante("15");
        }else if(partido.getPuntosGameActualVisitante().equals("15")){
            partido.setPuntosGameActualVisitante("30");
        }else if(partido.getPuntosGameActualVisitante().equals("30")){
            if(partido.getPuntosGameActualLocal().equals("40")){
                partido.setDeuce(true);
            }
            partido.setPuntosGameActualVisitante("40");
        }else if(partido.getPuntosGameActualVisitante().equals("40")){
            if (partido.isDeuce()) {
                partido.setVentajaVisitante(true);
                partido.setDeuce(false);
            } else if(partido.isVentajaLocal()){
                partido.setDeuce(true);
                partido.setVentajaLocal(false);
            } else {
                sumarGameVisitante();
                partido.setPuntosGameActualVisitante("0");
            }
        }

    }

    public void sumarGameLocal() {
        partido.setVentajaLocal(false);
        partido.setPuntosGameActualLocal("0");
        partido.setPuntosGameActualVisitante("0");
        partido.setDeuce(false);

        partido.setCantidadGamesLocal(partido.getCantidadGamesLocal() + 1);
        if (partido.getCantidadGamesLocal() >= 6 && (partido.getCantidadGamesLocal() - partido.getCantidadGamesVisitante()) >= 2) {
            partido.setSetsLocal(partido.getSetsLocal() + 1);
            partido.setCantidadGamesLocal(0);
            partido.setCantidadGamesVisitante(0);
        }
        if(partido.getSetsLocal()==3){
            partido.setGanoLocal(true);
        }
    }

    public void sumarGameVisitante() {
        partido.setVentajaLocal(false);
        partido.setPuntosGameActualLocal("0");
        partido.setPuntosGameActualVisitante("0");
        partido.setDeuce(false);

        partido.setCantidadGamesVisitante(partido.getCantidadGamesVisitante() + 1);
        if (partido.getCantidadGamesVisitante() >= 6 && (partido.getCantidadGamesVisitante() - partido.getCantidadGamesLocal()) >= 2) {
            partido.setSetsVisitante(partido.getSetsVisitante() + 1);
            partido.setCantidadGamesLocal(0);
            partido.setCantidadGamesVisitante(0);
        }
        if(partido.getSetsVisitante()==3){
            partido.setGanoVisitante(true);
        }
    }

}
