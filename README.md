# 誰か助けて
**解決しました**

### 何をしたい？
- ツリー構造にvisitorパターンを適用したい．

### 現状は？
- クラス図はこんな感じ．問題を単純化してあるのでかなりシンプル
```
     [Node]                  [Visitor]
      △ +accept(Visitor)       +visit(Node)
  ----|------                   +visit(SNode)
  |         |                   +visit(INode)
[SNode]  [INode]    
```

- 左の3種類のノードに対して，それぞれに対応するVisitor.visit(...)メソッドが右にある．
- さらにVisitor.visit(...)はNode.accept(Visitor)から呼び出される．Visitorパターンです．

### 問題は？
- どのノードからaccept(Visitor)を呼び出しても，visit(Node)が呼ばれてしまう．
```java
  Visitor visitor = new Visitor();
  SNode snode = new SNode("aaa");
  snode.accept(visitor);  // Visitor.visit(Node)が呼ばれてしまう．Visitor.visit(SNode)が期待．
```
- どうやってもノードに対応するvisit(...)メソッドが呼ばれない．

### 手元で確認するためには？
- VisitorTestクラスをJUnitテスト実行してください
- 俺のexcpectとactualがきちんと書いています．
- 全テストケースが正しく動作すればgod

### 仮説はある？
- accept(Visitor)メソッドをNodeクラスから継承しているのが悪そう．
  - 継承やめてaccept(Visitor)メソッドをSNodeとINodeにばらまけば動く．
  - でもNodeの種類が増えると地獄なので避けたい．

- JDTの実装見るとこのやり方で正しく動いているっぽいけど，何かが足りない？？？
  - https://github.com/eclipse/eclipse.jdt.core/blob/BETA_JAVA8/org.eclipse.jdt.core/dom/org/eclipse/jdt/core/dom/ASTNode.java
  - https://github.com/eclipse/eclipse.jdt.core/blob/BETA_JAVA8/org.eclipse.jdt.core/dom/org/eclipse/jdt/core/dom/ASTVisitor.java

### 解決した
- acceptをぶちまけるのが正解．
  - JDTではaccept0(Visitor)がNodeの抽象メソッドとして定義されていて，全継承クラスで実装されている．
  - Javaでは親クラス内でのthisの型解決が，どうあがいても子と見なされないっぽい．
