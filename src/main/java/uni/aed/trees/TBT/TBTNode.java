package uni.aed.trees.TBT;
public class TBTNode {
    protected int key;
    protected boolean succesor;
    protected TBTNode left;
    protected TBTNode right;

    public TBTNode(int key) {
        this(key,null,null );
    }

    public TBTNode(int key, TBTNode left, TBTNode right) {
        this.key = key;
        this.succesor=false;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        StringBuilder str=new StringBuilder();
        str.append("key=" + key + ", succesor=" + succesor + " ");
        if(this.left!=null)
            str.append("left.key=" + left.key);
        if(this.right!=null)
            str.append("right.key=" + right.key);
        
        return str.toString();
    }
    
    
    
}
