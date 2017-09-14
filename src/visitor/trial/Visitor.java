package visitor.trial;

public class Visitor {
	public void visit(Node node) {
		System.out.print("node - ");
	}

	public void visit(SNode node) {
		System.out.print("s(" + node + ") - ");
	}

	public void visit(INode node) {
		System.out.print("i(" + node + ") - ");
	}
}
