package visitor.trial;

public class SNode extends Node {
	private String body;
	
	public SNode(String body) {
		this.body = body;
	}
	
	public String toString() {
		return body;
	}
	
}
