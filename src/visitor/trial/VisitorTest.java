package visitor.trial;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

public class VisitorTest {
	private ByteArrayOutputStream out;

	@Before
	public void before() {
		out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
	}

	/**
	 * まずは単一のルートNodeを生成 & visitして確認．
	 * 期待通り．
	 */
	@Test
	public void test01() {
		Visitor visitor = new Visitor();
		RNode root = new RNode();
		root.accept(visitor);
		assertEquals("node - ", out.toString());
	}

	/**
	 * ルートNodeにSNodeを追加して，ルートNodeにvisit．
	 * Visitor.visit(SNode)が動作せず，Visitor.visit(Node)が呼ばれてしまう．
	 */
	@Test
	public void test02() {
		Visitor visitor = new Visitor();
		RNode root = new RNode();
		root.addChild(new SNode("aaa"));
		root.accept(visitor);
		assertEquals("node - s(aaa) - ", out.toString());
	}

	/**
	 * test02の続き．じゃあINodeは？
	 * 当然test02と同じくだめ
	 */
	@Test
	public void test03() {
		Visitor visitor = new Visitor();
		RNode root = new RNode();
		root.addChild(new INode(100));
		root.accept(visitor);
		assertEquals("node - i(100) - ", out.toString());
	}

	/**
	 * Node.accept(Visitor)内での子ノードの再帰呼び出しが悪い？
	 * じゃあ，ルートNodeを生成せず，直接リーフのSNodeを作ってvisit．
	 * やっぱりだめ，Visitor.visit(Node)が呼ばれてしまう．
	 * 
	 * これはそもそも無理．acceptは直接呼び出さない．ルートからたどるべき．
	 */
	//@Test
	public void test04() {
		Visitor visitor = new Visitor();
		SNode snode = new SNode("aaa");
		snode.accept(visitor);
		assertEquals("s(aaa) - ", out.toString());
	}

}
