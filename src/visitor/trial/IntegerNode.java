package visitor.trial;

public class IntegerNode extends Node {
	private Integer body;
	
	public IntegerNode(Integer body) {
		this.body = body;
	}

	public String toString() {
		return String.valueOf(body);
	}
}
