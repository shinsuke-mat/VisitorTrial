package visitor.trial;

public class SNode extends Node {
	private String body;
	
	public SNode(String body) {
		this.body = body;
	}
	
	public void accept0(Visitor visitor) {
		visitor.visit(this);
	}
	
	public String toString() {
		return body;
	}
	
}
