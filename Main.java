
import java.util.Random;

class Main {
	 
	public static void main(String[] args) 
	{
		final int COUNT = 10;
		final int MAX = 50;
		Random random = new Random(MAX*MAX);
		BinarySearchTree bst = new BinarySearchTree(' ');
 
		for(int i=0; i<COUNT; i++)
		{
			int num = random.nextInt(MAX);
			bst.addNode(num);
			System.out.println("Added : " + num);
		}
 
		//bst.printTree(bst.root, "");
		bst.printNode(bst.root);
		//bst.displaySmallToBig(bst.root, "");
	}
 
}