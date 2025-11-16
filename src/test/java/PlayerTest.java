import main.Commons;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import space_invaders.sprites.Player;

import javax.swing.*;
import java.awt.event.KeyEvent;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class PlayerTest {

    private Player player;

    @BeforeEach
    void SetUp(){
        player = new Player();
    }

    @Test
    void TestAct_Caso1(){
        int x = 38;
        int dx = 0;
        int salidaEsperada = 38;
        boolean resultado;
        player.setX(x);
        player.setDx(dx);
        player.act();
        resultado = (player.getX() == salidaEsperada);
        assertTrue(resultado);
    }

    @Test
    void TestAct_Caso2(){
        int x = 0;
        int dx = -2;
        int salidaEsperada = 2;
        boolean resultado;
        player.setX(x);
        player.setDx(dx);
        player.act();
        resultado = (player.getX() == salidaEsperada);
        assertTrue(resultado);
    }

    @Test
    void TestAct_Caso3(){
        int x = 358;
        int dx = 2;
        int salidaEsperada = Commons.BOARD_WIDTH + 2 * Commons.PLAYER_WIDTH;
        boolean resultado;
        player.setX(x);
        player.setDx(dx);
        player.act();
        resultado = (player.getX() == salidaEsperada);
        assertTrue(resultado);
    }

    @Test
    void TestInitPlayer_Caso1(){
        int salidaEsperadoPlayerEnMedio = 179;
        int salidaEsperadoPlayerInitGround = 280;
        boolean xyCorrecto;
        xyCorrecto = (salidaEsperadoPlayerEnMedio == player.getX()) && (salidaEsperadoPlayerInitGround == player.getY());
        assertTrue(xyCorrecto);
    }

    @Test
    void TestKeyPressed_Caso1(){
        KeyEvent e = new KeyEvent(new JButton(), KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_W, KeyEvent.CHAR_UNDEFINED);
        int salidaEsperadaIzquierda = 37;
        int salidaEsperadaDerecha = 39;
        boolean resultado;
        player.keyPressed(e);
        resultado = (e.getKeyCode() == salidaEsperadaIzquierda) && (e.getKeyCode() == salidaEsperadaDerecha);
        assertFalse(resultado);
    }

    @Test
    void TestKeyPressed_Caso2(){
        KeyEvent e = new KeyEvent(new JButton(), KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_LEFT, KeyEvent.CHAR_UNDEFINED);
        int salidaEsperadaIzquierda = 37;
        boolean resultado;
        player.keyPressed(e);
        resultado = (e.getKeyCode() == salidaEsperadaIzquierda);
        assertTrue(resultado);
    }

    @Test
    void TestKeyPressed_Caso3(){
        KeyEvent e = new KeyEvent(new JButton(), KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_RIGHT, KeyEvent.CHAR_UNDEFINED);
        int salidaEsperadaDerecha = 39;
        boolean resultado;
        player.keyPressed(e);
        resultado = (e.getKeyCode() == salidaEsperadaDerecha);
        assertTrue(resultado);
    }

    @Test
    void TestKeyReleased_Caso1(){
        KeyEvent e = new KeyEvent(new JButton(), KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_W, KeyEvent.CHAR_UNDEFINED);
        int salidaEsperadaIzquierda = 37;
        int salidaEsperadaDerecha = 39;
        boolean resultado;
        player.keyReleased(e);
        resultado = (e.getKeyCode() == salidaEsperadaIzquierda) && (e.getKeyCode() == salidaEsperadaDerecha);
        assertFalse(resultado);
    }

    @Test
    void TestKeyReleased_Caso2(){
        KeyEvent e = new KeyEvent(new JButton(), KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_LEFT, KeyEvent.CHAR_UNDEFINED);
        int salidaEsperadaIzquierda = 37;
        boolean resultado;
        player.keyReleased(e);
        resultado = (e.getKeyCode() == salidaEsperadaIzquierda);
        assertTrue(resultado);
    }

    @Test
    void TestKeyReleased_Caso3(){
        KeyEvent e = new KeyEvent(new JButton(), KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_RIGHT, KeyEvent.CHAR_UNDEFINED);
        int salidaEsperadaDerecha = 39;
        boolean resultado;
        player.keyReleased(e);
        resultado = (e.getKeyCode() == salidaEsperadaDerecha);
        assertTrue(resultado);
    }
}
