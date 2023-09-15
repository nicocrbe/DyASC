package ar.edu.untref.dyasc.service;

import ar.edu.untref.dyasc.models.Jugador;
import ar.edu.untref.dyasc.models.Partido;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PartidoServiceTest {

    private Jugador jugadorLocal;
    private Jugador jugadorVisitante;

    private PartidoService partidoService;
    private Partido partido;

    @BeforeEach
    public void setUp() {
        jugadorLocal = new Jugador("Juan");
        jugadorVisitante = new Jugador("Pedro");
        partidoService = new PartidoService(jugadorLocal, jugadorVisitante, partido);
    }

    @Test
    public void testJugadorLocalyVisitante() {

        Assertions.assertEquals(jugadorLocal, partidoService.getJugadorLocal());
        Assertions.assertEquals(jugadorVisitante, partidoService.getJugadorVisitante());
    }

    @Test
    public void testPartido() {
        Assertions.assertEquals(partido, partidoService.getPartido());
    }


}
