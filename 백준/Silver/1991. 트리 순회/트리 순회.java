import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static Tree t = new Tree();
	static Node[] nodes = new Node[26]; // N(1 ≤ N ≤ 26)

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int p = st.nextToken().charAt(0) - 'A'; // A 입력 -> 0 // 배열인덱스매핑
			int l = st.nextToken().charAt(0) - 'A';
			int r = st.nextToken().charAt(0) - 'A';

			if (nodes[p] == null) { // 처음들어오는 데이터면
				nodes[p] = new Node((char) (p + 'A')); // 부모 노드 생성
				if (i == 0)
					t.setRoot(nodes[p]); // 루트 노드 설정
			}

			if (l != '.' - 'A') { // 왼쪽노드가 있으면
				if (nodes[l] == null) { // 처음들어오는 데이터면 {
					nodes[l] = new Node((char) (l + 'A')); // 왼쪽노드 추가
				}
				nodes[p].setLeft(nodes[l]);
			}
			if (r != '.' - 'A') { // 오른쪽노드가 있으면
				if (nodes[r] == null) { // 처음들어오는 데이터면
					nodes[r] = new Node((char) (r + 'A')); // 오른쪽노드 추가
				}
				nodes[p].setRight(nodes[r]);
			}
		}
		t.preorder(t.getRoot());
		System.out.println();
		t.inorder(t.getRoot());
		System.out.println();
		t.postorder(t.getRoot());
	}

}

class Node {
	char data;
	Node left;
	Node right;

	public Node(char data) {
		this.data = data;
	}

	void setLeft(Node left) {
		this.left = left;
	}

	void setRight(Node right) {
		this.right = right;
	}
}

class Tree {
	public Node root;

	public void setRoot(Node node) {
		this.root = node;
	}

	public Node getRoot() {
		return root;
	}

//	public Node makeNode(Node left, char data, Node right) {
//		Node node = new Node(data);
//		node.data = data;
//		node.left = left;
//		node.right = right;
//		return node;
//	}

	public void inorder(Node node) {
		if (node != null) {
			inorder(node.left);
			System.out.print(node.data);
			inorder(node.right);
		}
	}

	public void preorder(Node node) {
		if (node != null) {
			System.out.print(node.data);
			preorder(node.left);
			preorder(node.right);
		}
	}

	public void postorder(Node node) {
		if (node != null) {
			postorder(node.left);
			postorder(node.right);
			System.out.print(node.data);
		}
	}
}