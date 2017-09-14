package visitor.trial;

public class Visitor {
	public void visit(Node node) {
		System.out.print("node - ");
	}

	public void visit(StringNode node) {
		System.out.print("s(" + node + ") - ");
	}

	public void visit(IntegerNode node) {
		System.out.print("i(" + node + ") - ");
	}
}
