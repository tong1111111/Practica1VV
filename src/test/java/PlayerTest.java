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
    void TestActC1(){
        int x = 38;
        int dx = 0;
        int salidaEsperada = 38;
        player.setX(x);
        player.setDx(dx);
        player.act();
        boolean resultado = (player.getX() == salidaEsperada);
        assertTrue(resultado);
    }

    @Test
    void TestActC2(){
        int x = 0;
        int dx = -2;
        int salidaEsperada = 2;
        player.setX(x);
        player.setDx(dx);
        player.act();
        boolean resultado = (player.getX() == salidaEsperada);
        assertTrue(resultado);
    }

    @Test
    void TestActC3(){
        int x = 358;
        int dx = 2;
        int salidaEsperada = 356;
        player.setX(x);
        player.setDx(dx);
        player.act();
        System.out.println(player.getX());
        boolean resultado = (player.getX() == salidaEsperada);
        assertTrue(resultado); //Esta mal, sale resultado 388
    }

    @Test
    void TestInitPlayerC1(){
        int salidaEsperadoPlayerEnMedio = 179;
        int salidaEsperadoPlayerInitGround = 280;
        boolean xyCorrecto = (salidaEsperadoPlayerEnMedio == player.getX()) && (salidaEsperadoPlayerInitGround == player.getY());
        assertTrue(xyCorrecto);
    }

    @Test
    void TestKeyPressedC1(){
        KeyEvent e = new KeyEvent(new JButton(), KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_W, KeyEvent.CHAR_UNDEFINED);
        int salidaEsperadaIzquierda = 37;
        int salidaEsperadaDerecha = 39;
        player.keyPressed(e);
        boolean resultado = (e.getKeyCode() == salidaEsperadaIzquierda) && (e.getKeyCode() == salidaEsperadaDerecha);
        assertFalse(resultado);
    }

    @Test
    void TestKeyPressedC2(){
        KeyEvent e = new KeyEvent(new JButton(), KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_LEFT, KeyEvent.CHAR_UNDEFINED);
        int salidaEsperadaIzquierda = 37;
        player.keyPressed(e);
        boolean resultado = (e.getKeyCode() == salidaEsperadaIzquierda);
        assertTrue(resultado);
    }

    @Test
    void TestKeyPressedC3(){
        KeyEvent e = new KeyEvent(new JButton(), KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_RIGHT, KeyEvent.CHAR_UNDEFINED);
        int salidaEsperadaDerecha = 39;
        player.keyPressed(e);
        boolean resultado = (e.getKeyCode() == salidaEsperadaDerecha);
        assertTrue(resultado);
    }

    @Test
    void TestKeyReleasedC1(){
        KeyEvent e = new KeyEvent(new JButton(), KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_W, KeyEvent.CHAR_UNDEFINED);
        int salidaEsperadaIzquierda = 37;
        int salidaEsperadaDerecha = 39;
        player.keyReleased(e);
        boolean resultado = (e.getKeyCode() == salidaEsperadaIzquierda) && (e.getKeyCode() == salidaEsperadaDerecha);
        assertFalse(resultado);
    }

    @Test
    void TestKeyReleasedC2(){
        KeyEvent e = new KeyEvent(new JButton(), KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_LEFT, KeyEvent.CHAR_UNDEFINED);
        int salidaEsperadaIzquierda = 37;
        player.keyReleased(e);
        boolean resultado = (e.getKeyCode() == salidaEsperadaIzquierda);
        assertTrue(resultado);
    }

    @Test
    void TestKeyReleasedC3(){
        KeyEvent e = new KeyEvent(new JButton(), KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_RIGHT, KeyEvent.CHAR_UNDEFINED);
        int salidaEsperadaDerecha = 39;
        player.keyReleased(e);
        boolean resultado = (e.getKeyCode() == salidaEsperadaDerecha);
        assertTrue(resultado);
    }
}
