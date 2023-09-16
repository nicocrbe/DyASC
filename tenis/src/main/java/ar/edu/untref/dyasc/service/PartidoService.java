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
            partido.setPuntosGameActualLocal("40");
        }else if(partido.getPuntosGameActualLocal().equals("40")){
            partido.setPuntosGameActualLocal("0");
        }
    }
/*
    * Conceptos básicos

        En un partido de tenis, un jugador empieza con una puntuación de 0. Con cada pelota exitosa, el jugador gana más puntos de la siguiente manera: 0 → 15 → 30 → 40
        Si un jugador llega a los 40 puntos y vuelve a obtener una pelota exitosa, ganará un game. (En la medida que el otro jugador no tenga 40 puntos también).

        Si ambos jugadores alcanzan 40 puntos que se conoce como deuce.

        Deuce

        Una pelota exitosa obtenida en estado de deuce, otorga una ventaja al jugador. Si el jugador contrario marcará nuevamente el marcador vuelve a deuce.
        Si un jugador se encuentra en ventaja y marca otra vez, ese jugador gana el game.


        Tie Brake

        La partida gana cuando un jugador gana 3 sets. Cada set se gana si un jugador llega a 6 games, siempre y cuando tenga diferencia de 2 games con su contrincante. En caso de que ambos lleguen a 6 games ese set se definirá por Tie brake. Aquí la secuencia de puntos es de 1 en 1 y gana el primero que llega a 7 puntos con diferencia de 2. En caso de llegar a 6-6 el ganador deberá estirarse hasta 8-6 y así sucesivamente.

        Escriba un programa para manejar cada uno de estos requisitos de puntuación:

        Los jugadores deben ser capaces de sumar puntos.
        El juego debe ser capaz de terminar con un ganador.
        El caso de "deuce" debe ser manejado.
        El caso de “Tie Brake” debe ser manejado también.
        Después de que un juego haya sido ganado, se debe poder determinar al ganador.
        Se debe poder obtener la puntuación actual de cualquier jugador en cualquier momento durante el juego.
        Se debe resolver el ejercicio adoptando las siguientes reglas que nos plantea TDD:

        No se puede escribir código de la solución sin una prueba que falle.
        No se puede tener más de una prueba en estado fallido a la vez.
        No se puede escribir una nueva prueba hasta tanto en código esté debidamente refactorizado.
    * */
    public void sumarPuntoGameActualVisitante() {
        if(partido.getPuntosGameActualVisitante().equals("0")){
            partido.setPuntosGameActualVisitante("15");
        }else if(partido.getPuntosGameActualVisitante().equals("15")){
            partido.setPuntosGameActualVisitante("30");
        }else if(partido.getPuntosGameActualVisitante().equals("30")){
            partido.setPuntosGameActualVisitante("40");
        }else if(partido.getPuntosGameActualVisitante().equals("40")){
            partido.setPuntosGameActualVisitante("0");
    }

    }

    public void sumarGameLocal() {
        partido.setCantidadGamesLocal(partido.getCantidadGamesLocal() + 1);
        if (partido.getCantidadGamesLocal() == 6) {
            partido.setSetsLocal(partido.getSetsLocal() + 1);
            partido.setCantidadGamesLocal(0);
            partido.setCantidadGamesVisitante(0);
        }
    }

    public void sumarGameVisitante() {
        partido.setCantidadGamesVisitante(partido.getCantidadGamesVisitante() + 1);
    }

}
