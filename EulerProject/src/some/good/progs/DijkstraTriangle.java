package some.good.progs;
import java.io.File;
import java.util.Scanner;
import java.lang.Exception;

public class DijkstraTriangle
{
    public static void main(String[] args)
    {
		//open file DTnumsSmall.data which contains triangle's values
		File file = null;
	
		try{
	    	file = new File("./p067_triangle.txt");
		} catch(Exception e) {
		    System.out.println("File not Found");
	    	return;
		}
	

	
		//generate array from file
		Scanner s;
	
		try{
	    	s = new Scanner(file);
		} catch (Exception e) {
		    System.out.println("Scanner messed up");
	    	return;
		}
	
		int[] numbers = new int[5050]; //big enough for 15 row triangle, easily extendable

		int count = 0;
		while(s.hasNextInt()){
	    	numbers[count] = s.nextInt();
	    	count++;
		}

	
		//generate triangle from array
		Triangle tri = generateTriangle(numbers);

		System.out.println(tri.sumOfLargestPath());
		//System.out.println(tri);
    }

    
    static Triangle generateTriangle(int[] numbers)
    {
		//returns the root node of a triangle structure

	
	
		TriangleNode root = new TriangleNode(numbers[0]); //initialize this here, start with a root node

		generateChildren(numbers, root); //generates all child nodes on root
		
		Triangle tri = new Triangle(root);
	
		return tri;
    }


    
    private static void generateChildren(int[] numbers, TriangleNode root)
    {
	//This function generates the nodes for the Triangle structure.
	
	int count = 0;
	int rowsize = 1;
	
	int tmpcount = 0;
	int tmprowsize = 1;

	TriangleNode lastNode = root;
	TriangleNode tmpLastNode = root;

	while((count + rowsize) < numbers.length){
	    
	    
	    while((tmpcount + tmprowsize) < numbers.length){

		//generate all children to the left of a node, to bottom of triangle
		
		tmpcount += tmprowsize;
		tmprowsize++;

		//System.out.println("tmpcount: " + tmpcount + "tmprowsize: " + tmprowsize );
		
		tmpLastNode.setChildLeft(new TriangleNode(numbers[tmpcount]));
		tmpLastNode = tmpLastNode.getChildLeft();
	    }

	    
	    //move to rightmost value of next row
	    
	    rowsize++;
	    count += rowsize;

	    tmpcount = count;
	    tmprowsize = rowsize;

	    //System.out.println("count: " + count + "rowsize: " + rowsize );
	    
	    lastNode.setChildRight(new TriangleNode(numbers[count]));
	    lastNode = lastNode.getChildRight();

	    tmpLastNode = lastNode;
	}

	linkRight(numbers, root);
	
	return;
    }


    
    private static void linkRight(int[] numbers, TriangleNode root)
    {
	//this function completes linking the nodes for the triangle structure
	//it is called by generateChildren
	
	int count = 0;
	int rowsize = 1;
	
	int tmpcount = 0;
	int tmprowsize = 1;

	TriangleNode lastNode = root;
	TriangleNode tmpLastNode = root;
	
	while((count) <= (numbers.length - 1)){
	    
	    //System.out.println("count: " + count);
	    
	    if (lastNode.hasChildLeft() && lastNode.hasChildRight() &&
		lastNode.getChildRight().hasChildLeft()) {
		
		lastNode.getChildLeft().setChildRight(tmpLastNode.getChildRight().getChildLeft());
	    }

	    
	    while((tmpcount + tmprowsize) < numbers.length){

		//traverse triangle left from node to bottom

		//System.out.println(tmpcount);
		
		tmpcount += tmprowsize;
		tmprowsize++;

 		if (tmpLastNode.hasChildLeft() && tmpLastNode.hasChildRight() &&
		    tmpLastNode.getChildRight().hasChildLeft()) {
		    
		    tmpLastNode.getChildLeft().setChildRight(tmpLastNode.getChildRight().getChildLeft());
		}
		
		tmpLastNode = tmpLastNode.getChildLeft();
	    }

	    //move to rightmost value of next row
	    
	    rowsize++;
	    count += rowsize;

	    tmpcount = count;
	    tmprowsize = rowsize;
	    
	    lastNode = lastNode.getChildRight();

	    tmpLastNode = lastNode;
	}

	return;
    }
    
}




class TriangleNode
{
    private int value;


    private int pathValue;

    private TriangleNode parentLeft = null;
    private TriangleNode parentRight = null;
    private TriangleNode childLeft = null;
    private TriangleNode childRight = null;

    TriangleNode(int value)
    {
		this.value = value;
		this.pathValue = value;
    }

    int getValue()
    {
		return value;
    }

    int getPathValue()
    {
    	return pathValue;
    }

    void setPathValue(int pathValue)
    {
    	this.pathValue = pathValue;
    }

    TriangleNode getParentLeft()
    {
		return parentLeft;
    }

    TriangleNode getParentRight()
    {
		return parentRight;
    }

    TriangleNode getChildLeft()
    {
		return childLeft;
    }

    TriangleNode getChildRight()
    {
		return childRight;
    }

    void setParentLeft(TriangleNode parentLeft)
    {
		this.parentLeft = parentLeft;
		this.parentLeft.childRight = this;
    }

    void setParentRight(TriangleNode parentRight)
    {
		this.parentRight = parentRight;
		this.parentRight.childLeft = this;
    }

    void setChildLeft(TriangleNode childLeft)
    {
		this.childLeft = childLeft;
		this.childLeft.parentRight = this;
    }

    void setChildRight(TriangleNode childRight)
    {
		this.childRight = childRight;
		this.childRight.parentLeft = this;
    }

    boolean hasParentLeft()
    {
		if(parentLeft == null)
	    	return false;
		return true;
    }

    boolean hasParentRight()
    {
		if(parentRight == null)
	    	return false;
		return true;
    }

    boolean hasChildLeft()
    {
		if(childLeft == null)
		    return false;
		return true;
    }

    boolean hasChildRight()
    {
		if(childRight == null)
		    return false;
		return true;
    }
}


class TriangleRow
{
    
    TriangleNode[] nodes;
    int count = 0;

    TriangleRow next = null;
    TriangleRow prev = null;

    TriangleRow(int rowsize)
    {
    	nodes = new TriangleNode[rowsize];
    }

    void addNode(TriangleNode arg)
    {
    	nodes[count] = arg;
    	count++;
    }

    TriangleNode getNodeAt(int index)
    {
    	return nodes[index];
    }

    void setNext(TriangleRow next)
    {
		this.next = next;
		this.next.prev = this;
    }

    TriangleRow getNext()
    {
		return this.next;
    }

    TriangleRow getPrev()
    {
    	return this.prev;
    }

    int getLength()
    {
		return nodes.length;
    }

    public String toString()
    {
		String result = "";
	
		for (TriangleNode node : nodes) {
	    	if (node == null) {
				System.out.println("node is null");
	    	} else {
				result += (Integer.toString(node.getValue()) + " ");
	    	}
		}
		return result;
    }
}

class Triangle
{
    TriangleRow firstRow;
    TriangleRow lastRow;
    int rowindex = 0;

    Triangle(TriangleNode root)
    {
		firstRow = new TriangleRow(1);
		lastRow = firstRow;

		addNode(root);
		while (lastRow.getNodeAt(0).hasChildLeft()) {
	    	addChildren(lastRow);
		}
    }

    void addChildren(TriangleRow currRow)
    {
		if (currRow.getNodeAt(0).hasChildLeft()) {
	    	for (int i = 0; i < currRow.getLength(); i++) {
			addNode(currRow.getNodeAt(i).getChildLeft());
	    }
	    addNode(currRow.getNodeAt(currRow.getLength()-1).getChildRight());
		} else {
	    	System.out.println("No Children");
		}
    }
    
    void addNode(TriangleNode node)
    {
	
		if (rowindex < lastRow.getLength()) {
	    	lastRow.addNode(node);
	    	rowindex++;
		} else {
	   		lastRow.setNext(new TriangleRow(rowindex + 1));
	    	rowindex = 0;
	    	lastRow = lastRow.next;
	    	addNode(node);
		}
	
    }

    int sumOfLargestPath()
    {
    	TriangleRow currRow = lastRow.getPrev();

    	//TODO: logic to ascend rows from bottom up
    	while (currRow != null){
    		if (currRow.getNodeAt(0).hasChildLeft()) {
	    		for (int i = 0; i < currRow.getLength(); i++) {
					//for each node in row
					TriangleNode currNode = currRow.getNodeAt(i);
					//compare children's pathvalue
					if (currNode.getChildLeft().getPathValue() > currNode.getChildRight().getPathValue()) {
						currNode.setPathValue(currNode.getPathValue() + currNode.getChildLeft().getPathValue());
						System.out.println("Choosing Left");
					} else {
						currNode.setPathValue(currNode.getPathValue() + currNode.getChildRight().getPathValue());
						System.out.println("Choosing Right");
					}
					System.out.println("Left: " + currNode.getChildLeft().getPathValue() + "\tRight: " + currNode.getChildRight().getPathValue());

				//add larger to self.pathvalue
	    		}
			} else {
		    	System.out.println("No Children");
			}
			currRow = currRow.getPrev();
		}


		return firstRow.getNodeAt(0).getPathValue();
    }


    
    public String toString()
    {
		TriangleRow currRow = firstRow;
		String result = "";
	
		while (currRow != lastRow){
	    	result += (currRow.toString() + "\n");
	    	currRow = currRow.getNext();
		}
		result += lastRow.toString();
		return result;
    }
}