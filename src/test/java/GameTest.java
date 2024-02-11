import org.example.Game;
import org.example.NotRegisteredException;
import org.example.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    public void shouldTestFirstRound() {

        Player player1 = new Player(245, "Саша", 30);
        Player player2 = new Player(201, "Паша", 45);
        Game game = new Game();

        game.register(player1);
        game.register(player2);

        int actual = game.round("Саша", "Паша");
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldTestSecondRound() {

        Player player1 = new Player(245, "Саша", 51);
        Player player2 = new Player(201, "Паша", 45);
        Game game = new Game();

        game.register(player1);
        game.register(player2);

        int actual = game.round("Саша", "Паша");
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldTestThirdRound() {

        Player player1 = new Player(245, "Саша", 80);
        Player player2 = new Player(201, "Паша", 80);
        Game game = new Game();

        game.register(player1);
        game.register(player2);

        int actual = game.round("Саша", "Паша");
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldTestIfTheFirstPlayerIsRegistered() {

        Player player1 = new Player(245, "Саша", 80);
        Player player2 = new Player(201, "Паша", 80);
        Game game = new Game();

        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Марина", "Паша"));
    }

    @Test
    public void shouldTestIfTheSecondPlayerIsRegistered() {

        Player player1 = new Player(245, "Саша", 80);
        Player player2 = new Player(201, "Паша", 80);
        Game game = new Game();

        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Саша", "Оля"));
    }
}
