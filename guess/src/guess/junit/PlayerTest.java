package guess.junit;

import guess.Game;
import junit.framework.TestCase;

public class PlayerTest extends TestCase {

	public void testMacaco() {
		Game game = new Game();
		assertEquals("Pense em um animal", game.nextQuestion());
		game.ok();
		assertEquals("Vive na Água?", game.nextQuestion());
		game.no();
		assertEquals("Macaco?", game.nextQuestion());
		game.yes();
		assertEquals("Ganhei! Sou muito bom!", game.nextQuestion());

	}

	public void testBorboleta() {
		Game game = new Game();
		assertEquals("Pense em um animal", game.nextQuestion());
		game.ok();
		assertEquals("Vive na Água?", game.nextQuestion());
		game.no();
		assertEquals("Macaco?", game.nextQuestion());
		game.no();
		assertEquals("Desisto, qual foi o animal que você pensou?",
				game.nextQuestion());
		game.answer("Borboleta");
		assertEquals("Complete, Borboleta __________ mas Macaco não",
				game.nextQuestion());
		game.answer("Tem Asas");

		assertEquals("Pense em um animal", game.nextQuestion());
		game.ok();
		assertEquals("Tem Asas?", game.nextQuestion());
		game.yes();
		assertEquals("Borboleta?", game.nextQuestion());
		game.no();
		assertEquals("Desisto, qual foi o animal que você pensou?",
				game.nextQuestion());
		game.answer("Avestruz");
		assertEquals("Complete, Avestruz __________ mas Borboleta não",
				game.nextQuestion());
		game.answer("É feio");

		assertEquals("Pense em um animal", game.nextQuestion());
		game.ok();
		assertEquals("Tem Asas?", game.nextQuestion());
		game.yes();
		assertEquals("É feio?", game.nextQuestion());
		game.yes();
		assertEquals("Avestruz?", game.nextQuestion());
		game.no();
		assertEquals("Desisto, qual foi o animal que você pensou?",
				game.nextQuestion());
		game.answer("Corvo");
		assertEquals("Complete, Corvo __________ mas Avestruz não",
				game.nextQuestion());
		game.answer("É preto");

		assertEquals("Pense em um animal", game.nextQuestion());
		game.ok();
		assertEquals("Tem Asas?", game.nextQuestion());
		game.yes();
		assertEquals("É feio?", game.nextQuestion());
		game.no();
		assertEquals("Borboleta?", game.nextQuestion());
		game.yes();
		assertEquals("Ganhei! Sou muito bom!", game.nextQuestion());

	}

	public void testCorvo() {
		Game game = new Game();
		assertEquals("Pense em um animal", game.nextQuestion());
		game.ok();
		assertEquals("Vive na Água?", game.nextQuestion());
		game.no();
		assertEquals("Macaco?", game.nextQuestion());
		game.no();
		assertEquals("Desisto, qual foi o animal que você pensou?",
				game.nextQuestion());
		game.answer("Borboleta");
		assertEquals("Complete, Borboleta __________ mas Macaco não",
				game.nextQuestion());
		game.answer("Tem Asas");

		assertEquals("Pense em um animal", game.nextQuestion());
		game.ok();
		assertEquals("Tem Asas?", game.nextQuestion());
		game.yes();
		assertEquals("Borboleta?", game.nextQuestion());
		game.no();
		assertEquals("Desisto, qual foi o animal que você pensou?",
				game.nextQuestion());
		game.answer("Avestruz");
		assertEquals("Complete, Avestruz __________ mas Borboleta não",
				game.nextQuestion());
		game.answer("É feio");

		assertEquals("Pense em um animal", game.nextQuestion());
		game.ok();
		assertEquals("Tem Asas?", game.nextQuestion());
		game.yes();
		assertEquals("É feio?", game.nextQuestion());
		game.yes();
		assertEquals("Avestruz?", game.nextQuestion());
		game.no();
		assertEquals("Desisto, qual foi o animal que você pensou?",
				game.nextQuestion());
		game.answer("Corvo");
		assertEquals("Complete, Corvo __________ mas Avestruz não",
				game.nextQuestion());
		game.answer("É preto");

		assertEquals("Pense em um animal", game.nextQuestion());
		game.ok();
		assertEquals("Tem Asas?", game.nextQuestion());
		game.yes();
		assertEquals("É feio?", game.nextQuestion());
		game.yes();
		assertEquals("É preto?", game.nextQuestion());
		game.yes();
		assertEquals("Corvo?", game.nextQuestion());
		game.yes();
		assertEquals("Ganhei! Sou muito bom!", game.nextQuestion());

	}

}
