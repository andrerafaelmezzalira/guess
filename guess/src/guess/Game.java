package guess;

public class Game {

	private Node node = new Node();

	private boolean ok;
	private boolean starNode;
	private boolean question1;
	private boolean yes;
	private Node thisNode;
	private Node oldNode;
	private String nameAnimal;
	private String typeAnimal;

	public String nextQuestion() {

		if (!ok) {
			return "Pense em um animal";
		}

		if (ok && !starNode) {
			starNode = true;
			thisNode = node.startNode();
			return thisNode.getDescription() + "?";
		} else if (ok && starNode) {
			if (thisNode != null) {
				return thisNode.getDescription() + "?";
			} else {
				if (!question1) {
					question1 = true;
					if (yes) {
						yes = false;
						return "Ganhei! Sou muito bom!";
					} else
						return "Desisto, qual foi o animal que você pensou?";
				} else {
					return "Complete, " + nameAnimal + " __________ mas "
							+ oldNode.getDescription() + " não";
				}
			}
		}
		return null;
	}

	public void yes() {
		oldNode = thisNode;
		thisNode = node.findYesNode(thisNode);
		yes = true;
	}

	public void no() {
		oldNode = thisNode;
		thisNode = node.findNoNode(thisNode);
		yes = false;
	}

	public void answer(String answer) {
		if (nameAnimal != null) {
			typeAnimal = answer;
			node.addNode(oldNode, typeAnimal, nameAnimal);
			node.restartNode();
			restart();
			return;
		}
		nameAnimal = answer;
	}

	private void restart() {
		ok = false;
		starNode = false;
		yes = false;
		thisNode = null;
		oldNode = null;
		nameAnimal = null;
		typeAnimal = null;
		question1 = false;
	}

	public void ok() {
		ok = true;
	}
}
