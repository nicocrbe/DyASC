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
        partido = new Partido(jugadorLocal, jugadorVisitante);
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

    @Test
    public void testSumarPuntoGameActualLocal(){
        partidoService.sumarPuntoGameActualLocal();
        Assertions.assertEquals("15", partidoService.getPartido().getPuntosGameActualLocal());
    }

    @Test
    public void testSumarPuntoGameActualVisitante(){
        partidoService.sumarPuntoGameActualVisitante();
        Assertions.assertEquals("15", partidoService.getPartido().getPuntosGameActualVisitante());
    }

    @Test
    public void testSumarPuntoGameActualLocalDeCeroAGame(){
        partidoService.sumarPuntoGameActualLocal();
        Assertions.assertEquals("15", partidoService.getPartido().getPuntosGameActualLocal());
        partidoService.sumarPuntoGameActualLocal();
        Assertions.assertEquals("30", partidoService.getPartido().getPuntosGameActualLocal());
        partidoService.sumarPuntoGameActualLocal();
        Assertions.assertEquals("40", partidoService.getPartido().getPuntosGameActualLocal());
        partidoService.sumarPuntoGameActualLocal();
        Assertions.assertEquals("0", partidoService.getPartido().getPuntosGameActualLocal());
    }


}
