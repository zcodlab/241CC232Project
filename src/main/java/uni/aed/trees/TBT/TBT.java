package uni.aed.trees.TBT;
public class TBT {
    private TBTNode root;
    public TBT() {
        root=null;
    }    
    public void insert(int value){
        TBTNode newNode= new TBTNode(value);
        TBTNode p=root;
        TBTNode prev=null;
        if(root==null){
            root=newNode; return;}
        while(p!=null){
            prev=p;
            if(value<p.key)
                p=p.left;
            else{
                if(!p.succesor)
                    p=p.right;
                else
                    break;
            }
        }
        if(value<prev.key){
            prev.left=newNode;
            newNode.succesor=true;
            newNode.right=prev;            
        }else{
            if(prev.succesor){                
                prev.succesor=false;
                newNode.succesor=true;
                newNode.right=prev.right;
            }
            prev.right=newNode;
        }
    }    
    
    protected void visit(TBTNode p){
        if(p==null)
            return;
        System.out.println(p.toString());
    }    
    protected void TBTInOrder(){ //LVR
        TBTNode prev;
        TBTNode p=root;
        if(p==null)
            return;
        while(p.left!=null)
            p=p.left;
        while(p!=null){
            visit(p);
            prev=p;
            p=p.right;
            if(p!=null && !prev.succesor){
                while(p.left!=null)
                    p=p.left;
            }
                
        }
    }
    
}
