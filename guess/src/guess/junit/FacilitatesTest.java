package guess.junit;

import guess.Game;
import junit.framework.TestCase;

public class FacilitatesTest extends TestCase {

	protected Game game;

	protected void startGame() {
		game = new Game();
	}

	protected void ok() {
		game.ok();
	}

	protected void yes() {
		game.yes();
	}

	protected void no() {
		game.no();
	}

	protected void asking(String asking) {
		assertEquals(asking, game.nextQuestion());
	}

	protected void endGame(String message) {
		assertEquals(message, game.nextQuestion());
	}

	protected void giveUp(String message) {
		assertEquals(message, game.nextQuestion());
	}

	protected void answer(String answer) {
		game.answer(answer);
	}

	protected void complete(String complete) {
		assertEquals(complete, game.nextQuestion());
	}
}
