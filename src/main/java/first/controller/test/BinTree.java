package first.controller.test;

import java.util.ArrayList;
import java.util.List;

public class BinTree {

	private BinTree root;

	private BinTree lchild;

	private BinTree rchild;

	private Object data;

	private List<BinTree> datas;

	public BinTree() {

	}

	public BinTree(Object obj) {
		this.rchild = null;
		this.lchild = null;
		this.data = obj;
	}

	public BinTree(BinTree lchild, BinTree rchild, Object obj) {
		this.rchild = rchild;
		this.lchild = lchild;
		this.data = obj;
	}

	public void CreateTree(Object[] arrObj) {
		if (null != arrObj && arrObj.length > 0) {
			datas = new ArrayList<BinTree>();
			for (Object o : arrObj) {
				datas.add(new BinTree(o));
			}
			root = datas.get(0);
			for (int i = 0; i < arrObj.length / 2; i++) {
				datas.get(i).lchild = datas.get(2 * i + 1);
				if (2 * 2 + 2 < arrObj.length) {
					datas.get(i).rchild = datas.get(2 * i + 2);
				}
			}
		}
	}

	public BinTree getRoot() {
		return this.root;
	}

	public void preOrder(BinTree tree) {
		if (null != tree) {
			System.out.print(tree.data+" ");
			preOrder(tree.lchild);
			preOrder(tree.rchild);
		}
	}

}
