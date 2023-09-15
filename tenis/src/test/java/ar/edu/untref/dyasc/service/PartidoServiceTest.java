package ar.edu.untref.dyasc.service;

import ar.edu.untref.dyasc.models.Jugador;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

public class PartidoServiceTest {

    @BeforeEach
    public void setUp() {

    }

    @Test
    public void testJugadorLocalyVisitante() {
        Jugador jugadorLocal = new Jugador("Juan");
        Jugador jugadorVisitante = new Jugador("Pedro");
        PartidoService partidoService = new PartidoService(jugadorLocal, jugadorVisitante);
        Assertions.assertEquals(jugadorLocal, partidoService.getJugadorLocal());
        Assertions.assertEquals(jugadorVisitante, partidoService.getJugadorVisitante());
    }



}
