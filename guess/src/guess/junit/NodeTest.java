package guess.junit;

import guess.Node;
import junit.framework.TestCase;

public class NodeTest extends TestCase {

	public void testMacaco() {

		Node node = new Node();
		// Pense em um animal
		Node nodeViveNaAgua = node.startNode(); // Vive na Agua?
		Node nodeMacaco = node.findNoNode(nodeViveNaAgua); // Macaco?
		Node nodeNull = node.findYesNode(nodeMacaco);
		assertEquals(true, nodeNull == null);
	}

	public void testCorvo() {

		Node node = new Node();
		// Pense em um animal
		Node nodeViveNaAgua = node.startNode(); // Vive na Agua?
		Node nodeMacaco = node.findNoNode(nodeViveNaAgua); // Macaco?
		Node nodeNull = node.findNoNode(nodeMacaco);// Desisto! Qual animal vc
													// pensou?

		assertEquals(true, nodeNull == null); // result null
		// Borboleta
		// Complete a frase, uma Borboleta _______ mas um macaco não
		// Tem Asas
		node.addNode(nodeMacaco, "Tem Asas", "Borboleta");
		node.restartNode();
		// Pense em um animal
		Node nodeTemAsas = nodeViveNaAgua = node.startNode(); // Tem Asas?
		Node nodeBorboleta = node.findYesNode(nodeTemAsas); // Borboleta?
		nodeNull = node.findNoNode(nodeBorboleta); // Desisto! Qual animal vc
													// pensou?
		assertEquals(true, nodeNull == null); // result null
		// Avestruz
		// Complete a frase, uma avestruz_______ mas uma borboleta não
		// é feia
		node.addNode(nodeBorboleta, "É feia", "Avestruz");
		node.restartNode();
		// Pense em um animal
		nodeTemAsas = nodeViveNaAgua = node.startNode(); // Tem Asas?
		Node nodeEhFeia = node.findYesNode(nodeTemAsas); // É feia?
		Node nodeAvestruz = node.findYesNode(nodeEhFeia);// Avestruz?
		nodeNull = node.findNoNode(nodeAvestruz); // Desisto! Qual animal vc
													// pensou?
		assertEquals(true, nodeNull == null); // result null
		// Corvo
		// Complete a frase, uma corvo_______ mas uma avestruz não
		// é preto
		node.addNode(nodeAvestruz, "é preto", "Corvo");
		node.restartNode();
		// Pense em um animal
		nodeTemAsas = nodeViveNaAgua = node.startNode(); // Tem Asas?
		nodeEhFeia = node.findYesNode(nodeTemAsas); // É feia?
		Node nodePreto = node.findYesNode(nodeEhFeia);// é preto?
		Node nodeCorvo = node.findYesNode(nodePreto);// Corvo?
		nodeNull = node.findYesNode(nodeCorvo); // Ganhei de novo!
		assertEquals(true, nodeNull == null); // result null

	}

	public void testVoltarDoNivel2para1() {

		Node node = new Node();
		// Pense em um animal
		Node nodeViveNaAgua = node.startNode(); // Vive na Agua?
		Node nodeMacaco = node.findNoNode(nodeViveNaAgua); // Macaco?
		Node nodeNull = node.findNoNode(nodeMacaco);// Desisto! Qual animal vc
													// pensou?

		assertEquals(true, nodeNull == null); // result null
		// Borboleta
		// Complete a frase, uma Borboleta _______ mas um macaco não
		// Tem Asas
		node.addNode(nodeMacaco, "Tem Asas", "Borboleta");
		node.restartNode();
		// Pense em um animal
		Node nodeTemAsas = nodeViveNaAgua = node.startNode(); // Tem Asas?
		Node nodeBorboleta = node.findYesNode(nodeTemAsas); // Borboleta?
		nodeNull = node.findNoNode(nodeBorboleta); // Desisto! Qual animal vc
													// pensou?
		assertEquals(true, nodeNull == null); // result null
		// Avestruz
		// Complete a frase, uma avestruz_______ mas uma borboleta não
		// é feia
		node.addNode(nodeBorboleta, "É feia", "Avestruz");
		node.restartNode();
		// Pense em um animal
		nodeTemAsas = nodeViveNaAgua = node.startNode(); // Tem Asas?
		Node nodeEhFeia = node.findYesNode(nodeTemAsas); // É feia?
		nodeBorboleta = node.findNoNode(nodeEhFeia);// Borboleta?
		nodeNull = node.findYesNode(nodeBorboleta); // Ganhei de novo!
		assertEquals(true, nodeNull == null); // result null

	}

}
