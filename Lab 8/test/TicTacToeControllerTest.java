import org.junit.Test;

import java.io.StringReader;

import tictactoe.TicTacToe;
import tictactoe.TicTacToeConsoleController;
import tictactoe.TicTacToeController;
import tictactoe.TicTacToeModel;

import static org.junit.Assert.assertTrue;

/**
 * Test cases for the tic tac toe controller, using mocks for readable and
 * appendable.
 */
public class TicTacToeControllerTest {

  // Providing this shell for you to write your
  // own test cases for the TicTacToe controller
  // You DO NOT NEED to implement tests for the provided model

  // TODO: Implement your own tests cases for the controller

  /**
   * Failing appendable test.
   */
  @Test(expected = IllegalStateException.class)
  public void testFailingAppendable() {
    // Testing when something goes wrong with the Appendable
    // Here we are passing it a mock of an Appendable that always fails
    TicTacToe m = new TicTacToeModel();
    StringReader input = new StringReader("2 2 1 1 3 3 1 2 1 3 2 3 2 1 3 1 3 2");
    Appendable gameLog = new FailingAppendable();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(m);
  }

  /**
   * Test to validate that the Controller throws an IllegalArgumentException
   * if the model passed to playGame is invalid.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidGame() {
    Readable input = new StringReader("2 2 1 1 3 3 1 2 1 3 2 3 2 1 3 1 3 2");
    Appendable output = new StringBuilder();
    TicTacToe m = new TicTacToeModel();
    TicTacToeController c = new TicTacToeConsoleController(input, output);
    c.playGame(null);
  }

  /**
   * Test that the Controller works correctly when given invalid input for a row.
   */
  @Test
  public void testInvalidRow() {
    Readable input = new StringReader("2 2 one 1 1 3 3 1 2 1 3 2 3 2 1 3 1 three 3 2");
    Appendable output = new StringBuilder();
    TicTacToe m = new TicTacToeModel();
    TicTacToeController c = new TicTacToeConsoleController(input, output);
    c.playGame(m);
    assertTrue(output.toString().contains("Not a valid number: one"));
    assertTrue(output.toString().contains("Not a valid number: three"));
  }

  /**
   * Test that the Controller works correctly when given invalid input for a column.
   */
  @Test
  public void testInvalidColumn() {
    Readable input = new StringReader("2 2 1 1 3 three 3 1 2 1 3 2 3 2 one 1 3 1 3 2");
    Appendable output = new StringBuilder();
    TicTacToe m = new TicTacToeModel();
    TicTacToeController c = new TicTacToeConsoleController(input, output);
    c.playGame(m);
    assertTrue(output.toString().contains("Not a valid number: three"));
    assertTrue(output.toString().contains("Not a valid number: one"));
  }

  /**
   * Test to validate that the Controller works correctly when given a row that is out of bounds.
   */
  @Test
  public void testRowOutOfBounds() {
    Readable input = new StringReader("2 2 1 1 6 3 3 3 1 2 1 3 2 3 2 1 3 1 5 2 3 2");
    Appendable output = new StringBuilder();
    TicTacToe m = new TicTacToeModel();
    TicTacToeController c = new TicTacToeConsoleController(input, output);
    c.playGame(m);
    assertTrue(output.toString().contains("Not a valid move: 6, 3"));
    assertTrue(output.toString().contains("Not a valid move: 5, 2"));
  }

  /**
   * test to validate that the Controller works correctly when given a column that is out of bounds.
   */
  @Test
  public void testColOutOfBounds() {
    Readable input = new StringReader("2 2 1 1 3 6 3 3 1 2 1 3 2 3 2 1 3 1 1 7 3 2");
    Appendable output = new StringBuilder();
    TicTacToe m = new TicTacToeModel();
    TicTacToeController c = new TicTacToeConsoleController(input, output);
    c.playGame(m);
    assertTrue(output.toString().contains("Not a valid move: 3, 6"));
    assertTrue(output.toString().contains("Not a valid move: 1, 7"));
  }

  /**
   * Test to validate that the Controller works correctly when q is given for the row.
   */
  @Test
  public void testQforRow() {
    Readable input = new StringReader("2 2 1 1 3 6 q");
    Appendable output = new StringBuilder();
    TicTacToe m = new TicTacToeModel();
    TicTacToeController c = new TicTacToeConsoleController(input, output);
    c.playGame(m);
    assertTrue(output.toString().contains("Game quit! Ending game state:\n"));
  }

  /**
   * Test to validate that the Controller works correctly when q is given for the column.
   */
  @Test
  public void testQforCol() {
    Readable input = new StringReader("2 2 1 1 3 6 1 q");
    Appendable output = new StringBuilder();
    TicTacToe m = new TicTacToeModel();
    TicTacToeController c = new TicTacToeConsoleController(input, output);
    c.playGame(m);
    assertTrue(output.toString().contains("Game quit! Ending game state:\n"));
  }

  /**
   * est that controller works correctly when given a valid input.
   */
  @Test
  public void testValidMove() {
    Readable input = new StringReader("1 1 1 2 2 2 1 3 3 3");
    Appendable output = new StringBuilder();
    TicTacToe m = new TicTacToeModel();
    TicTacToeController c = new TicTacToeConsoleController(input, output);
    c.playGame(m);
    assertTrue(output.toString().contains("Game is over! X wins.\n"));
  }

  /**
   * Test that controller works correctly when the space is already taken.
   */
  @Test
  public void testAlreadyOccupied() {
    Readable input = new StringReader("1 1 1 2 2 2 1 3 1 1 3 3");
    Appendable output = new StringBuilder();
    TicTacToe m = new TicTacToeModel();
    TicTacToeController c = new TicTacToeConsoleController(input, output);
    c.playGame(m);
    assertTrue(output.toString().contains("Not a valid move: 1, 1"));
  }

  /**
   * Test when controller continues to run after invalid move is given.
   */
  @Test
  public void gameFinishInvalidMove() {
    Readable input = new StringReader("1 1 1 2 2 2 1 3 5 6 3 3");
    Appendable output = new StringBuilder();
    TicTacToe m = new TicTacToeModel();
    TicTacToeController c = new TicTacToeConsoleController(input, output);
    c.playGame(m);
    assertTrue(output.toString().contains("Not a valid move: 5, 6"));
    assertTrue(output.toString().contains("Game is over! X wins.\n"));
  }

  /**
   * Test that the game is over when X wins.
   */
  @Test
  public void playerXwins() {
    Readable input = new StringReader("1 1 1 2 2 2 1 3 3 3");
    Appendable output = new StringBuilder();
    TicTacToe m = new TicTacToeModel();
    TicTacToeController c = new TicTacToeConsoleController(input, output);
    c.playGame(m);
    assertTrue(output.toString().contains("Game is over! X wins.\n"));
  }

  /**
   * Test that the game is over when O wins.
   */
  @Test
  public void player0wins() {
    Readable input = new StringReader("2 1 1 2 2 2 1 3 3 3 1 1");
    Appendable output = new StringBuilder();
    TicTacToe m = new TicTacToeModel();
    TicTacToeController c = new TicTacToeConsoleController(input, output);
    c.playGame(m);
    assertTrue(output.toString().contains("Game is over! O wins."));
  }

  /**
   * Test that the game is a draw.
   */
  @Test
  public void gameTie() {
    Readable input = new StringReader("1 1 1 2 1 3 2 2 2 1 2 3 3 2 3 1 3 3");
    Appendable output = new StringBuilder();
    TicTacToe m = new TicTacToeModel();
    TicTacToeController c = new TicTacToeConsoleController(input, output);
    c.playGame(m);
    assertTrue(output.toString().contains("Game is over! Tie game."));
  }
}
