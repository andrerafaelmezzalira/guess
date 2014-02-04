package guess.junit;

public class PlayerTest extends FacilitatesTest {

	public void testMacaco() {

		startGame();

		asking("Pense em um animal");
		ok();
		asking("Vive na Água?");
		no();
		asking("Macaco?");
		yes();

		endGame("Ganhei! Sou muito bom!");

	}

	public void testBorboleta() {

		startGame();

		asking("Pense em um animal");
		ok();
		asking("Vive na Água?");
		no();
		asking("Macaco?");
		no();
		giveUp("Desisto, qual foi o animal que você pensou?");
		answer("Borboleta");
		complete("Complete, Borboleta __________ mas Macaco não");
		answer("Tem Asas");

		asking("Pense em um animal");
		ok();
		asking("Tem Asas?");
		yes();
		asking("Borboleta?");
		no();
		giveUp("Desisto, qual foi o animal que você pensou?");
		answer("Avestruz");
		complete("Complete, Avestruz __________ mas Borboleta não");
		answer("É feio");

		asking("Pense em um animal");
		ok();
		asking("Tem Asas?");
		yes();
		asking("É feio?");
		yes();
		asking("Avestruz?");
		no();
		giveUp("Desisto, qual foi o animal que você pensou?");
		answer("Corvo");
		complete("Complete, Corvo __________ mas Avestruz não");
		answer("É preto");

		asking("Pense em um animal");
		ok();
		asking("Tem Asas?");
		yes();
		asking("É feio?");
		no();
		asking("Borboleta?");
		yes();

		endGame("Ganhei! Sou muito bom!");

	}

	public void testCorvo() {
		startGame();

		asking("Pense em um animal");
		ok();
		asking("Vive na Água?");
		no();
		asking("Macaco?");
		no();
		giveUp("Desisto, qual foi o animal que você pensou?");
		answer("Borboleta");
		complete("Complete, Borboleta __________ mas Macaco não");
		answer("Tem Asas");

		asking("Pense em um animal");
		ok();
		asking("Tem Asas?");
		yes();
		asking("Borboleta?");
		no();
		giveUp("Desisto, qual foi o animal que você pensou?");
		answer("Avestruz");
		complete("Complete, Avestruz __________ mas Borboleta não");
		answer("É feio");

		asking("Pense em um animal");
		ok();
		asking("Tem Asas?");
		yes();
		asking("É feio?");
		yes();
		asking("Avestruz?");
		no();
		giveUp("Desisto, qual foi o animal que você pensou?");
		answer("Corvo");
		complete("Complete, Corvo __________ mas Avestruz não");
		answer("É preto");

		asking("Pense em um animal");
		ok();
		asking("Tem Asas?");
		yes();
		asking("É feio?");
		yes();
		asking("É preto?");
		yes();
		asking("Corvo?");
		yes();

		endGame("Ganhei! Sou muito bom!");

	}

}
