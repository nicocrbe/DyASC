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

    @Test
    public void testSumarPuntoGameActualVisitanteDeCeroAGame(){
        partidoService.sumarPuntoGameActualVisitante();
        Assertions.assertEquals("15", partidoService.getPartido().getPuntosGameActualVisitante());
        partidoService.sumarPuntoGameActualVisitante();
        Assertions.assertEquals("30", partidoService.getPartido().getPuntosGameActualVisitante());
        partidoService.sumarPuntoGameActualVisitante();
        Assertions.assertEquals("40", partidoService.getPartido().getPuntosGameActualVisitante());
        partidoService.sumarPuntoGameActualVisitante();
        Assertions.assertEquals("0", partidoService.getPartido().getPuntosGameActualVisitante());
    }

    @Test
    public void testSumarPuntosGameActualLocalYGame(){
        partidoService.sumarPuntoGameActualLocal();
        Assertions.assertEquals("15", partidoService.getPartido().getPuntosGameActualLocal());
        partidoService.sumarPuntoGameActualLocal();
        Assertions.assertEquals("30", partidoService.getPartido().getPuntosGameActualLocal());
        partidoService.sumarPuntoGameActualLocal();
        Assertions.assertEquals("40", partidoService.getPartido().getPuntosGameActualLocal());
        partidoService.sumarPuntoGameActualLocal();
        Assertions.assertEquals("0", partidoService.getPartido().getPuntosGameActualLocal());
        Assertions.assertEquals(1, partidoService.getPartido().getCantidadGamesLocal());
    }

    @Test
    public void testSumarPuntosGameActualVisitanteYGame(){
        partidoService.sumarPuntoGameActualVisitante();
        Assertions.assertEquals("15", partidoService.getPartido().getPuntosGameActualVisitante());
        partidoService.sumarPuntoGameActualVisitante();
        Assertions.assertEquals("30", partidoService.getPartido().getPuntosGameActualVisitante());
        partidoService.sumarPuntoGameActualVisitante();
        Assertions.assertEquals("40", partidoService.getPartido().getPuntosGameActualVisitante());
        partidoService.sumarPuntoGameActualVisitante();
        Assertions.assertEquals("0", partidoService.getPartido().getPuntosGameActualVisitante());
        Assertions.assertEquals(1, partidoService.getPartido().getCantidadGamesVisitante());
    }

    @Test
    public void testGanarSetLocal(){
        partidoService.sumarGameLocal();
        partidoService.sumarGameLocal();
        partidoService.sumarGameLocal();
        partidoService.sumarGameLocal();
        partidoService.sumarGameLocal();
        partidoService.sumarGameLocal();
        Assertions.assertEquals(1, partidoService.getPartido().getSetsLocal());
    }

    @Test
    public void testGanarSetVisitante(){
        partidoService.sumarGameVisitante();
        partidoService.sumarGameVisitante();
        partidoService.sumarGameVisitante();
        partidoService.sumarGameVisitante();
        partidoService.sumarGameVisitante();
        partidoService.sumarGameVisitante();
        Assertions.assertEquals(1, partidoService.getPartido().getSetsVisitante());
    }

    @Test
    public void testGanarPartidoLocal() {
        partidoService.sumarGameLocal();
        partidoService.sumarGameLocal();
        partidoService.sumarGameLocal();
        partidoService.sumarGameLocal();
        partidoService.sumarGameLocal();
        partidoService.sumarGameLocal();

        partidoService.sumarGameLocal();
        partidoService.sumarGameLocal();
        partidoService.sumarGameLocal();
        partidoService.sumarGameLocal();
        partidoService.sumarGameLocal();
        partidoService.sumarGameLocal();

        partidoService.sumarGameLocal();
        partidoService.sumarGameLocal();
        partidoService.sumarGameLocal();
        partidoService.sumarGameLocal();
        partidoService.sumarGameLocal();
        partidoService.sumarGameLocal();

        Assertions.assertTrue(partidoService.getPartido().isGanoLocal());
    }

    @Test
    public void testGanarPartidoVisitante() {
        partidoService.sumarGameVisitante();
        partidoService.sumarGameVisitante();
        partidoService.sumarGameVisitante();
        partidoService.sumarGameVisitante();
        partidoService.sumarGameVisitante();
        partidoService.sumarGameVisitante();

        partidoService.sumarGameVisitante();
        partidoService.sumarGameVisitante();
        partidoService.sumarGameVisitante();
        partidoService.sumarGameVisitante();
        partidoService.sumarGameVisitante();
        partidoService.sumarGameVisitante();

        partidoService.sumarGameVisitante();
        partidoService.sumarGameVisitante();
        partidoService.sumarGameVisitante();
        partidoService.sumarGameVisitante();
        partidoService.sumarGameVisitante();
        partidoService.sumarGameVisitante();

        Assertions.assertTrue(partidoService.getPartido().isGanoVisitante());
    }

    @Test
    public void testDeuceAlSumarPuntoVisitante() {
        partidoService.sumarPuntoGameActualLocal();
        partidoService.sumarPuntoGameActualLocal();
        partidoService.sumarPuntoGameActualLocal();
        partidoService.sumarPuntoGameActualVisitante();
        partidoService.sumarPuntoGameActualVisitante();
        partidoService.sumarPuntoGameActualVisitante();

        Assertions.assertEquals("40", partidoService.getPartido().getPuntosGameActualLocal());
        Assertions.assertEquals("40", partidoService.getPartido().getPuntosGameActualVisitante());
        Assertions.assertTrue(partidoService.getPartido().isDeuce());
    }

    @Test
    public void testDeuceAlSumarPuntoLocal() {
        partidoService.sumarPuntoGameActualVisitante();
        partidoService.sumarPuntoGameActualVisitante();
        partidoService.sumarPuntoGameActualVisitante();
        partidoService.sumarPuntoGameActualLocal();
        partidoService.sumarPuntoGameActualLocal();
        partidoService.sumarPuntoGameActualLocal();

        Assertions.assertEquals("40", partidoService.getPartido().getPuntosGameActualLocal());
        Assertions.assertEquals("40", partidoService.getPartido().getPuntosGameActualVisitante());
        Assertions.assertTrue(partidoService.getPartido().isDeuce());
    }

    @Test
    public void testDeuceVentajaLocal() {
        partidoService.sumarPuntoGameActualVisitante();
        partidoService.sumarPuntoGameActualVisitante();
        partidoService.sumarPuntoGameActualVisitante();
        partidoService.sumarPuntoGameActualLocal();
        partidoService.sumarPuntoGameActualLocal();
        partidoService.sumarPuntoGameActualLocal();
        partidoService.sumarPuntoGameActualLocal();

        Assertions.assertTrue(partidoService.getPartido().isVentajaLocal());
        Assertions.assertFalse(partidoService.getPartido().isDeuce());
        Assertions.assertEquals("40", partidoService.getPartido().getPuntosGameActualLocal());
        Assertions.assertEquals("40", partidoService.getPartido().getPuntosGameActualVisitante());
    }

    @Test
    public void testDeuceVentajaVisitante() {
        partidoService.sumarPuntoGameActualLocal();
        partidoService.sumarPuntoGameActualLocal();
        partidoService.sumarPuntoGameActualLocal();
        partidoService.sumarPuntoGameActualVisitante();
        partidoService.sumarPuntoGameActualVisitante();
        partidoService.sumarPuntoGameActualVisitante();
        partidoService.sumarPuntoGameActualVisitante();

        Assertions.assertTrue(partidoService.getPartido().isVentajaVisitante());
        Assertions.assertFalse(partidoService.getPartido().isDeuce());
        Assertions.assertEquals("40", partidoService.getPartido().getPuntosGameActualLocal());
        Assertions.assertEquals("40", partidoService.getPartido().getPuntosGameActualVisitante());
    }

    @Test
    public void testEstandoEnVentajaLocalQuitarVentaja(){
        partidoService.sumarPuntoGameActualVisitante();
        partidoService.sumarPuntoGameActualVisitante();
        partidoService.sumarPuntoGameActualVisitante();
        partidoService.sumarPuntoGameActualLocal();
        partidoService.sumarPuntoGameActualLocal();
        partidoService.sumarPuntoGameActualLocal();
        partidoService.sumarPuntoGameActualLocal();
        partidoService.sumarPuntoGameActualVisitante();

        Assertions.assertFalse(partidoService.getPartido().isVentajaLocal());
        Assertions.assertTrue(partidoService.getPartido().isDeuce());
        Assertions.assertEquals("40", partidoService.getPartido().getPuntosGameActualLocal());
        Assertions.assertEquals("40", partidoService.getPartido().getPuntosGameActualVisitante());
    }

    @Test
    public void testEstandoEnVentajaVisitanteQuitarVentaja(){
        partidoService.sumarPuntoGameActualLocal();
        partidoService.sumarPuntoGameActualLocal();
        partidoService.sumarPuntoGameActualLocal();
        partidoService.sumarPuntoGameActualVisitante();
        partidoService.sumarPuntoGameActualVisitante();
        partidoService.sumarPuntoGameActualVisitante();
        partidoService.sumarPuntoGameActualVisitante();
        partidoService.sumarPuntoGameActualLocal();

        Assertions.assertFalse(partidoService.getPartido().isVentajaVisitante());
        Assertions.assertTrue(partidoService.getPartido().isDeuce());
        Assertions.assertEquals("40", partidoService.getPartido().getPuntosGameActualLocal());
        Assertions.assertEquals("40", partidoService.getPartido().getPuntosGameActualVisitante());
    }

    @Test
    public void testSetearValoresPorDefectoAlGanarGameLocal(){
        partidoService.sumarPuntoGameActualLocal();
        partidoService.sumarPuntoGameActualLocal();
        partidoService.sumarPuntoGameActualLocal();
        partidoService.sumarPuntoGameActualLocal();

        Assertions.assertEquals("0", partidoService.getPartido().getPuntosGameActualLocal());
        Assertions.assertEquals("0", partidoService.getPartido().getPuntosGameActualVisitante());
        Assertions.assertEquals(1, partidoService.getPartido().getCantidadGamesLocal());
        Assertions.assertEquals(0, partidoService.getPartido().getCantidadGamesVisitante());
        Assertions.assertFalse(partidoService.getPartido().isDeuce());
        Assertions.assertFalse(partidoService.getPartido().isVentajaLocal());
        Assertions.assertFalse(partidoService.getPartido().isVentajaVisitante());
    }

    @Test
    public void testSetearValoresPorDefectoAlGanarGameVisitante(){
        partidoService.sumarPuntoGameActualVisitante();
        partidoService.sumarPuntoGameActualVisitante();
        partidoService.sumarPuntoGameActualVisitante();
        partidoService.sumarPuntoGameActualVisitante();

        Assertions.assertEquals("0", partidoService.getPartido().getPuntosGameActualLocal());
        Assertions.assertEquals("0", partidoService.getPartido().getPuntosGameActualVisitante());
        Assertions.assertEquals(0, partidoService.getPartido().getCantidadGamesLocal());
        Assertions.assertEquals(1, partidoService.getPartido().getCantidadGamesVisitante());
        Assertions.assertFalse(partidoService.getPartido().isDeuce());
        Assertions.assertFalse(partidoService.getPartido().isVentajaLocal());
        Assertions.assertFalse(partidoService.getPartido().isVentajaVisitante());
    }

    @Test
    public void testNoSumarSetEnTieBreakLocal(){
        partidoService.sumarGameLocal();
        partidoService.sumarGameLocal();
        partidoService.sumarGameLocal();
        partidoService.sumarGameLocal();
        partidoService.sumarGameLocal();

        partidoService.sumarGameVisitante();
        partidoService.sumarGameVisitante();
        partidoService.sumarGameVisitante();
        partidoService.sumarGameVisitante();
        partidoService.sumarGameVisitante();

        partidoService.sumarGameLocal();

        Assertions.assertEquals(0, partidoService.getPartido().getSetsLocal());
    }

    @Test
    public void testNoSumarSetEnTieBreakVisitante(){
        partidoService.sumarGameLocal();
        partidoService.sumarGameLocal();
        partidoService.sumarGameLocal();
        partidoService.sumarGameLocal();
        partidoService.sumarGameLocal();

        partidoService.sumarGameVisitante();
        partidoService.sumarGameVisitante();
        partidoService.sumarGameVisitante();
        partidoService.sumarGameVisitante();
        partidoService.sumarGameVisitante();

        partidoService.sumarGameVisitante();

        Assertions.assertEquals(0, partidoService.getPartido().getSetsVisitante());
    }
}
