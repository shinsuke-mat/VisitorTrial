package visitor.trial;

public class RNode extends Node {

	@Override
	public void accept0(Visitor visitor) {
		visitor.visit(this);
	}

}
