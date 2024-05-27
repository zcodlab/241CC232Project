package uni.aed.tree;
/** 
 * BST: Binary Search Tree
 */
public class BST {
    private BSTNode root;
    public BST() {
        this.root = null;
    }    
    public void insert(int e){
        BSTNode p=root,prev=null;
        while(p!=null){
            prev=p;
            if(p.getKey()<e)
                p=p.right;
            else    
                p=p.left;
        }
        if(root==null)
            root=new BSTNode(e);
        else if(prev.getKey() < e)
            prev.right=new BSTNode(e);
        else
            prev.left=new BSTNode(e);
    }
    public void visit(BSTNode p){
        if(p!=null)
            System.out.println(p.getKey());
        else
            System.out.println("Nodo No existe");
    }
    //LVR
    public void inorder(){
        inorder(root);
    }
    private void inorder(BSTNode p){
        if(p!=null){
            inorder(p.left);
            visit(p);
            inorder(p.right);
        }        
    }
    
    
}
