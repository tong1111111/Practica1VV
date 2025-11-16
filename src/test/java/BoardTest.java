import main.Board;
import main.Commons;
import org.junit.jupiter.api.Test;
import space_invaders.sprites.Alien;
import space_invaders.sprites.Shot;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    Board board;
    @org.junit.jupiter.api.BeforeEach
    void setUp(){
        board=new Board();
    }

    @Test
    public void test_GameInit_Case1(){
        assertTrue(board.getAliens().size() == (Commons.ALIEN_ROWS*Commons.ALIEN_COLUMNS));
    }

    @Test
    public void test_Update_Case1() {
        try{
            board.setDeaths(23);
            Method method = Board.class.getDeclaredMethod("update");
            method.setAccessible(true);
            method.invoke(board);
            assertTrue(board.isInGame());
        }catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test_Update_Case2() {
        try{
            board.setDeaths(24);
            Method method = Board.class.getDeclaredMethod("update");
            method.setAccessible(true);
            method.invoke(board);
            assertFalse(board.isInGame());
        } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test_Update_Shots_Caso1() {
        try{
            Shot shot = board.getShot();
            shot.die();
            Method method = Board.class.getDeclaredMethod("update_shots");
            method.setAccessible(true);
            method.invoke(board);
            assertFalse(shot.isVisible());
        } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test_Update_Shots_Caso3() {
        try{
            Iterator<Alien> itAlien = board.getAliens().iterator();
            while (itAlien.hasNext()) {
                itAlien.next().die();
            }
            Shot shot = board.getShot();
            shot.setY(100);
            shot.setX(100);
            int shotPosY = shot.getY();
            Method method = Board.class.getDeclaredMethod("update_shots");
            method.setAccessible(true);
            method.invoke(board);
            assertTrue((shotPosY - Commons.SHOT_SPEED) == shot.getY() && (shotPosY - Commons.SHOT_SPEED) == shot.getX());
        } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test_Update_Shots_Caso4() {
        try{
            Iterator<Alien> itAlien = board.getAliens().iterator();
            Alien alien = itAlien.next();
            while (itAlien.hasNext()) {
                itAlien.next().die();
            }
            Shot shot = board.getShot();
            shot.setY(alien.getY() - 1);
            shot.setX(alien.getX() - 1);
            int shotPosY = shot.getY();
            Method method = Board.class.getDeclaredMethod("update_shots");
            method.setAccessible(true);
            method.invoke(board);
            assertTrue((shotPosY - Commons.SHOT_SPEED) == shot.getY() && (shotPosY - Commons.SHOT_SPEED) == shot.getX());
        } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test_Update_Shots_Caso5() {
        try{
            Iterator<Alien> itAlien = board.getAliens().iterator();
            Alien alien = itAlien.next();
            while (itAlien.hasNext()) {
                itAlien.next().die();
            }
            Shot shot = board.getShot();
            shot.setY(alien.getY());
            shot.setX(alien.getX());
            int deaths = board.getDeaths();
            Method method = Board.class.getDeclaredMethod("update_shots");
            method.setAccessible(true);
            method.invoke(board);
            assertTrue( alien.isDying() && ((deaths + 1) == board.getDeaths()));
        } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test_Update_Shots_Caso6() {
        try{
            Iterator<Alien> itAlien = board.getAliens().iterator();
            while (itAlien.hasNext()) {
                itAlien.next().die();
            }
            Shot shot = board.getShot();
            shot.setX(100);
            shot.setY(-1);
            Method method = Board.class.getDeclaredMethod("update_shots");
            method.setAccessible(true);
            method.invoke(board);
            assertTrue(!shot.isVisible());
        } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
