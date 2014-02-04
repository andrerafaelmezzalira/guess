package guess;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Representa a arvore de animais e suas caracteristicas.
 * 
 * @author andrerafaelmezzalira
 * 
 */
public class Node {

	/**
	 * nós filhos
	 */
	private Set<Node> nodes;

	/**
	 * nivel de profunidade
	 */
	private Integer level;

	/**
	 * caracteristica ou nome do animal
	 */
	private String description;

	/**
	 * marca se caracteristica/animal ja foi apresentado na tela nesta sessao do
	 * jogo.
	 */
	private boolean mark;

	public Node() {
		// cria alguns valores default para iniciar a brincadeira.
		Node node = new Node("Vive na Água", 1);
		node.addNode(new Node("Tubarão", 2));
		this.addNode(node);
		this.addNode(new Node("Macaco", 1));
	}

	public Node(String description, Integer level) {
		this.level = level;
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public Integer getLevel() {
		return level;
	}

	public Set<Node> getNodes() {
		return nodes;
	}

	public boolean isMark() {
		return mark;
	}

	public void setMark(boolean mark) {
		this.mark = mark;
	}

	/**
	 * Inicia o jogo obtendo a primeira pergunta
	 */
	public Node startNode() {

		Node node = nodes.iterator().next();
		node.setMark(true);

		return node;
	}

	/**
	 * Toda vez que o programa ganha ou desiste é reiniciado com a pergunta
	 * 'Pensa em um animal'. É feito uma reinicialização do objeto Node marcando
	 * como false o atributo mark.
	 */
	public void restartNode() {
		restartNode(nodes);
	}

	private void restartNode(Set<Node> nodes) {

		if (nodes == null)
			return;

		for (Node node : nodes) {
			node.setMark(false);
			restartNode(node.getNodes());
		}
	}

	/**
	 * Monta o objeto Node com base nos parametros typeAnimal e nameAnimal e
	 * depois procura o node pai na arvore para adicionar como filho dele.
	 */
	public void addNode(Node node, String typeAnimal, String nameAnimal) {

		Node typeNode = new Node(typeAnimal, node.getLevel());
		Node animalNode = new Node(nameAnimal, node.getLevel() + 1);
		typeNode.addNode(animalNode);

		addNode(this, node, typeNode);
	}

	private void addNode(Node node, Node comparatorNode, Node newNode) {

		if (node.getNodes() == null)
			return;

		for (Node iteratorNode : node.getNodes()) {
			if (equals(iteratorNode, comparatorNode)) {
				node.addNode(newNode);
				break;
			} else {
				addNode(iteratorNode, comparatorNode, newNode);
			}
		}
	}

	/**
	 * Realiza a busca quando for acionado o botão Sim na tela. O parametro
	 * representa o objeto atual na tela.
	 */
	public Node findYesNode(Node node) {
		return findYesNode(this, node);
	}

	private Node findYesNode(Node node, Node comparatorNode) {

		if (node.getNodes() == null)
			return null;

		for (Node iteratorNode : node.getNodes()) {
			if (equals(iteratorNode, comparatorNode)
					&& iteratorNode.getNodes() != null) {
				for (Node childNode : iteratorNode.getNodes()) {
					if (!childNode.isMark()) {
						childNode.setMark(true);
						return childNode;
					}
				}
			} else {
				Node childNode = findYesNode(iteratorNode, comparatorNode);
				if (childNode != null)
					return childNode;
			}
		}

		return null;
	}

	/**
	 * Realiza a busca quando for acionado o botão Nao na tela. O parametro
	 * representa o objeto atual na tela.
	 */
	public Node findNoNode(Node node) {
		return findNoNode(this, node);
	}

	private Node findNoNode(Node node, Node comparatorNode) {

		if (node.getNodes() == null)
			return null;

		for (Node iteratorNode : node.getNodes()) {
			if (equals(iteratorNode, comparatorNode)) {
				for (Node iteratorChildNode : node.getNodes()) {
					if (!equals(iteratorChildNode, comparatorNode)
							&& !iteratorChildNode.isMark()) {
						iteratorChildNode.setMark(true);
						return iteratorChildNode;
					}
				}
			} else {
				Node childNode = findNoNode(iteratorNode, comparatorNode);
				if (childNode != null)
					return childNode;
			}
		}
		return null;
	}

	private void addNode(Node node) {

		if (nodes == null)

			// ordena colocando por ultimo na lista sempre
			// um animal (no folha ou no externo) em vez da característica (no
			// interno) para que quando o programa desiste das adivinhações,
			// fique um animal para comparação na segunda questão para
			// definirmos a caracteristica que representa o animal que o usuário
			// pensou.

			nodes = new TreeSet<Node>(new Comparator<Node>() {
				@Override
				public int compare(Node o1, Node o2) {
					if (o1.getNodes() == null)
						return 1;
					return -1;
				}
			});

		nodes.add(node);
	}

	private boolean equals(Node iteratorNode, Node comparatorNode) {
		return iteratorNode.getLevel() != null
				&& iteratorNode.getLevel().equals(comparatorNode.getLevel())
				&& iteratorNode.getDescription() != null
				&& iteratorNode.getDescription().equals(
						comparatorNode.getDescription());
	}
}