import java.util.ArrayList;

public class Node {
	public String name;
	public double weight;
	public int x, y;
	
	boolean isTested = false;
	boolean isExpanded = false;
	
	public ArrayList<Link> links = new ArrayList<Link>();
	
	public Node(String name) {
		this.name = name;
	}
	public Node(String name, double w) {
		this(name);
		this.weight = w;
	}
	public Node(String name, int x, int y) {
		this(name);
		this.x = x;
		this.y = y;
	}
	
	public void reset() {
		this.isExpanded = false;
		this.isTested = false;
	}
}
