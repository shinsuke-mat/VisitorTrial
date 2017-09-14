package visitor.trial;

public class INode extends Node {
	private Integer body;
	
	public INode(Integer body) {
		this.body = body;
	}

	public String toString() {
		return String.valueOf(body);
	}
}
