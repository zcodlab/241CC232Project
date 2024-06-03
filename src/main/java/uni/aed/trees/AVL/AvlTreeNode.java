package uni.aed.trees.AVL;

import java.util.Iterator;
import java.util.LinkedList;

public class AvlTreeNode {
    protected int key;
    protected int height;
    protected AvlTreeNode left;
    protected AvlTreeNode rigth;

    public AvlTreeNode(int key) {
        this.key = key;
        this.height=1;
        this.left=null;
        this.rigth=null;        
    }
    
    private void print(StringBuilder buffer, 
            String prefix, String childrenPrefix){
        LinkedList<AvlTreeNode> children =new LinkedList<>();
        children.add(left);
        children.add(rigth); 
        
        buffer.append(prefix);
        buffer.append(key);
        buffer.append('\n');
        
        for (Iterator<AvlTreeNode> it=children.iterator();it.hasNext();){
            AvlTreeNode next=it.next();
            if(next==null)
                continue;
            if(it.hasNext())
                next.print(buffer, childrenPrefix+ "---", 
                        childrenPrefix+ "|   ");
            else
                next.print(buffer, childrenPrefix+ "+++", 
                        childrenPrefix+"   ");
        }
    }
    @Override
    public String toString(){
        StringBuilder buffer=new StringBuilder(50);
        print(buffer,"","");
        return buffer.toString();
    }   
    
    
}
