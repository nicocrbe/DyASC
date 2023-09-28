package ar.edu.untref.dyasc.service;

import ar.edu.untref.dyasc.models.Jugador;
import ar.edu.untref.dyasc.models.Partido;
import ar.edu.untref.dyasc.models.Tiebreak;
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
        partido = new Partido();
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
        sumarNGamesLocal(6);
        Assertions.assertEquals(1, partidoService.getPartido().getSetsLocal());
    }

    @Test
    public void testGanarSetVisitante(){
        sumarNGamesVisitante(6);
        Assertions.assertEquals(1, partidoService.getPartido().getSetsVisitante());
    }

    @Test
    public void testGanarPartidoLocal() {
        sumarNGamesLocal(6);

        sumarNGamesLocal(6);

        sumarNGamesLocal(6);

        Assertions.assertTrue(partidoService.getPartido().isGanoLocal());
    }

    @Test
    public void testGanarPartidoVisitante() {
        sumarNGamesVisitante(6);

        sumarNGamesVisitante(6);

        sumarNGamesVisitante(6);

        Assertions.assertTrue(partidoService.getPartido().isGanoVisitante());
    }

    @Test
    public void testDeuceAlSumarPuntoVisitante() {
        sumarNPuntosGameActualLocal(3);
        sumarNPuntosGameActualVisitante(3);

        Assertions.assertEquals("40", partidoService.getPartido().getPuntosGameActualLocal());
        Assertions.assertEquals("40", partidoService.getPartido().getPuntosGameActualVisitante());
        Assertions.assertTrue(partidoService.getPartido().isDeuce());
    }

    @Test
    public void testDeuceAlSumarPuntoLocal() {
        sumarNPuntosGameActualVisitante(3);
        sumarNPuntosGameActualLocal(3);

        Assertions.assertEquals("40", partidoService.getPartido().getPuntosGameActualLocal());
        Assertions.assertEquals("40", partidoService.getPartido().getPuntosGameActualVisitante());
        Assertions.assertTrue(partidoService.getPartido().isDeuce());
    }

    @Test
    public void testDeuceVentajaLocal() {
        sumarNPuntosGameActualVisitante(3);
        sumarNPuntosGameActualLocal(3);
        partidoService.sumarPuntoGameActualLocal();

        Assertions.assertTrue(partidoService.getPartido().isVentajaLocal());
        Assertions.assertFalse(partidoService.getPartido().isDeuce());
        Assertions.assertEquals("40", partidoService.getPartido().getPuntosGameActualLocal());
        Assertions.assertEquals("40", partidoService.getPartido().getPuntosGameActualVisitante());
    }

    @Test
    public void testDeuceVentajaVisitante() {
        sumarNPuntosGameActualLocal(3);
        sumarNPuntosGameActualVisitante(3);
        partidoService.sumarPuntoGameActualVisitante();

        Assertions.assertTrue(partidoService.getPartido().isVentajaVisitante());
        Assertions.assertFalse(partidoService.getPartido().isDeuce());
        Assertions.assertEquals("40", partidoService.getPartido().getPuntosGameActualLocal());
        Assertions.assertEquals("40", partidoService.getPartido().getPuntosGameActualVisitante());
    }

    @Test
    public void testEstandoEnVentajaLocalQuitarVentaja(){
        sumarNPuntosGameActualVisitante(3);
        sumarNPuntosGameActualLocal(3);
        partidoService.sumarPuntoGameActualLocal();
        partidoService.sumarPuntoGameActualVisitante();

        Assertions.assertFalse(partidoService.getPartido().isVentajaLocal());
        Assertions.assertTrue(partidoService.getPartido().isDeuce());
        Assertions.assertEquals("40", partidoService.getPartido().getPuntosGameActualLocal());
        Assertions.assertEquals("40", partidoService.getPartido().getPuntosGameActualVisitante());
    }

    @Test
    public void testEstandoEnVentajaVisitanteQuitarVentaja(){
        sumarNPuntosGameActualLocal(3);
        sumarNPuntosGameActualVisitante(3);
        partidoService.sumarPuntoGameActualVisitante();
        partidoService.sumarPuntoGameActualLocal();

        Assertions.assertFalse(partidoService.getPartido().isVentajaVisitante());
        Assertions.assertTrue(partidoService.getPartido().isDeuce());
        Assertions.assertEquals("40", partidoService.getPartido().getPuntosGameActualLocal());
        Assertions.assertEquals("40", partidoService.getPartido().getPuntosGameActualVisitante());
    }

    @Test
    public void testSetearValoresPorDefectoAlGanarGameLocal(){
        sumarNPuntosGameActualLocal(3);
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

        sumarNPuntosGameActualVisitante(4);

        Assertions.assertEquals("0", partidoService.getPartido().getPuntosGameActualLocal());
        Assertions.assertEquals("0", partidoService.getPartido().getPuntosGameActualVisitante());
        Assertions.assertEquals(0, partidoService.getPartido().getCantidadGamesLocal());
        Assertions.assertEquals(1, partidoService.getPartido().getCantidadGamesVisitante());
        Assertions.assertFalse(partidoService.getPartido().isDeuce());
        Assertions.assertFalse(partidoService.getPartido().isVentajaLocal());
        Assertions.assertFalse(partidoService.getPartido().isVentajaVisitante());
    }

    @Test
    public void testNoSumarSiDiferenciaEsMenorADosLocal(){
        sumarNGamesLocal(5);

        sumarNGamesVisitante(5);

        partidoService.sumarGameLocal();

        Assertions.assertEquals(0, partidoService.getPartido().getSetsLocal());
    }

    @Test
    public void testNoSumarSetSiDiferenciaEsMenorADosVisitante(){
        sumarNGamesLocal(5);

        sumarNGamesVisitante(5);

        partidoService.sumarGameVisitante();

        Assertions.assertEquals(0, partidoService.getPartido().getSetsVisitante());
    }

    @Test
    public void testSumarSetSiDiferenciaEsIgualADosLocal() {
        sumarNGamesLocal(5);

        sumarNGamesVisitante(5);

        partidoService.sumarGameLocal();
        partidoService.sumarGameLocal();

        Assertions.assertEquals(1, partidoService.getPartido().getSetsLocal());
    }

    @Test
    public void testSumarSetSiDiferenciaEsIgualADosVisitante() {
        sumarNGamesLocal(5);

        sumarNGamesVisitante(5);

        partidoService.sumarGameVisitante();
        partidoService.sumarGameVisitante();

        Assertions.assertEquals(1, partidoService.getPartido().getSetsVisitante());
    }

    @Test
    public void crearTieBreakLocal(){
        sumarNGamesLocal(5);
        sumarNGamesVisitante(5);

        partidoService.sumarGameVisitante();
        partidoService.sumarGameLocal();

        Tiebreak tiebreak = partidoService.getTiebreak();
        int puntosLocalTB = tiebreak.getPuntosLocalTB();
        int puntosVisitanteTB = tiebreak.getPuntosVisitanteTB();

        Assertions.assertEquals(0, puntosLocalTB);
        Assertions.assertEquals(0, puntosVisitanteTB);
    }

    @Test
    public void crearTieBreakVisitante(){
        sumarNGamesLocal(5);
        sumarNGamesVisitante(5);

        partidoService.sumarGameLocal();
        partidoService.sumarGameVisitante();

        Tiebreak tiebreak = partidoService.getTiebreak();
        int puntosLocalTB = tiebreak.getPuntosLocalTB();
        int puntosVisitanteTB = tiebreak.getPuntosVisitanteTB();

        Assertions.assertEquals(0, puntosLocalTB);
        Assertions.assertEquals(0, puntosVisitanteTB);
    }

    @Test
    public void testSumarPuntoLocalTB(){
        sumarNGamesLocal(5);
        sumarNGamesVisitante(5);

        partidoService.sumarGameVisitante();
        partidoService.sumarGameLocal();

        partidoService.getTiebreak().sumarPuntoLocalTB();

        Tiebreak tiebreak = partidoService.getTiebreak();
        int puntosLocalTB = tiebreak.getPuntosLocalTB();

        Assertions.assertEquals(1, puntosLocalTB);
    }

    @Test
    public void testSumarPuntoVisitanteTB(){
        sumarNGamesLocal(5);
        sumarNGamesVisitante(5);

        partidoService.sumarGameVisitante();
        partidoService.sumarGameLocal();

        partidoService.getTiebreak().sumarPuntoVisitanteTB();

        Tiebreak tiebreak = partidoService.getTiebreak();
        int puntosVisitanteTB = tiebreak.getPuntosVisitanteTB();

        Assertions.assertEquals(1, puntosVisitanteTB);
    }

    @Test
    public void ganaLocalTiebreakSiTieneDiferenciaDeDosYLlegaAlMenosASietePuntos(){
        sumarNGamesLocal(5);
        sumarNGamesVisitante(5);

        partidoService.sumarGameVisitante();
        partidoService.sumarGameLocal();

        sumarNPuntosTiebreakLocal(6);
        sumarNPuntosTiebreakVisitante(6);

        sumarNPuntosTiebreakLocal(2);

        Assertions.assertTrue(partidoService.getTiebreak().checkGanadorLocalTB());

    }

    @Test
    public void ganaVisitanteTiebreakSiTieneDiferenciaDeDosYLlegaAlMenosASietePuntos(){
        sumarNGamesLocal(5);
        sumarNGamesVisitante(5);

        partidoService.sumarGameVisitante();
        partidoService.sumarGameLocal();

        sumarNPuntosTiebreakLocal(6);
        sumarNPuntosTiebreakVisitante(6);

        sumarNPuntosTiebreakVisitante(2);

        Assertions.assertTrue(partidoService.getTiebreak().checkGanadorVisitanteTB());

    }

    @Test
    public void testObtenerJugadorLocalSiEsGanador() {
        sumarNGamesLocal(6);

        sumarNGamesLocal(6);

        sumarNGamesLocal(6);

        Assertions.assertEquals("Juan", partidoService.obtenerGanador().getNombre());
    }

    @Test
    public void testObtenerJugadorVisitanteSiEsGanador() {
        sumarNGamesVisitante(6);

        sumarNGamesVisitante(6);

        sumarNGamesVisitante(6);

        Assertions.assertEquals("Pedro", partidoService.obtenerGanador().getNombre());
    }

    private void sumarNGamesLocal(int n) {
        for(int i = 0; i < n; i++){
            partidoService.sumarGameLocal();
        }
    }

    private void sumarNGamesVisitante(int n) {
        for(int i = 0; i < n; i++){
            partidoService.sumarGameVisitante();
        }
    }

    private void sumarNPuntosGameActualVisitante(int n) {
        for(int i = 0; i < n; i++){
            partidoService.sumarPuntoGameActualVisitante();
        }
    }

    private void sumarNPuntosGameActualLocal(int n) {
        for(int i = 0; i < n; i++){
            partidoService.sumarPuntoGameActualLocal();
        }
    }

    private void sumarNPuntosTiebreakLocal(int n){
        for(int i = 0; i < n; i++){
            partidoService.getTiebreak().sumarPuntoLocalTB();
        }
    }

    private void sumarNPuntosTiebreakVisitante(int n){
        for(int i = 0; i < n; i++){
            partidoService.getTiebreak().sumarPuntoVisitanteTB();
        }
    }
}
