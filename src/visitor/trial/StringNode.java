package visitor.trial;

public class StringNode extends Node {
	private String body;
	
	public StringNode(String body) {
		this.body = body;
	}
	
	public String toString() {
		return body;
	}
}
