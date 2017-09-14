package visitor.trial;

import java.util.ArrayList;
import java.util.List;

public class Node {
	List<Node> children = new ArrayList<>();

	// 子の追加
	public void addChild(Node child) {
		children.add(child);
	}

	// 再帰的なvisit & accept
	public void accept(Visitor visitor) {
		visitor.visit(this);
		for (Node child : children) {
			child.accept(visitor);
		}
	}
}
