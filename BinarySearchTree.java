
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class BinarySearchTree {
	Node root;
	char prefixChar;

	public BinarySearchTree(char preChar) 
	{
		prefixChar = preChar;
	}

	public void addNode(int val)
	{
		Node nNode = new Node(val);

		if(root == null) root = nNode;
		else
		{
			Node tNode = root;
			while(tNode != null)
			{
				if(tNode.data > val)
				{
					if(tNode.left == null) 
					{
						tNode.left = nNode;
						break;
					}
					tNode = tNode.left;
				}
				else
				{
					if(tNode.right == null) 
					{
						tNode.right = nNode;
						break;
					}
					tNode = tNode.right;
				}
			}
		}
	}

	public Node search(int val)
	{
		Node tNode = root;
		while(tNode != null)
		{
			if(val == tNode.data) return tNode;
			else
			{
				tNode = (val < tNode.data) ? tNode.left: tNode.right;
			}
		}
		return null;
	}

	void printTree(Node node, String prefix)
	{
		if(node == null) return;

		System.out.println(prefix + "+ " + node.data);
		printTree(node.left, prefix + prefixChar);
		printTree(node.right, prefix + prefixChar);
	}
	
	void displaySmallToBig(Node node, String prefix)
	{
		if(node == null) return;
		
		printTree(node.right, prefix + prefixChar);
		System.out.println(prefix + "+ " + node.data);
		printTree(node.left, prefix + prefixChar);
	}
	
	
	void printNode(Node root) {
        int maxLevel = maxLevel(root);
        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private void printNodeInternal(List<Node> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int edgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        printWhitespaces(firstSpaces);

        List<Node> newNodes = new ArrayList<>();
        for (Node node : nodes) {
            if (node != null) {
                System.out.print(node.data);
                newNodes.add(node.left);
                newNodes.add(node.right);
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= edgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    printWhitespaces(edgeLines + edgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).left != null) {
                    System.out.print("/");
                } else {
                    printWhitespaces(1);
                }
                printWhitespaces(i + i - 1);

                if (nodes.get(j).right != null) {
                    System.out.print("\\");
                } else {
                    printWhitespaces(1);
                }
                printWhitespaces(edgeLines + edgeLines - i);
            }

            System.out.println("");
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private int maxLevel(Node node) {
        if (node == null)
            return 0;

        return Math.max(maxLevel(node.left), maxLevel(node.right)) + 1;
    }

    private boolean isAllElementsNull(List<Node> list) {
        for (Node object : list) {
            if (object != null)
                return false;
        }
        return true;
    }
	
}