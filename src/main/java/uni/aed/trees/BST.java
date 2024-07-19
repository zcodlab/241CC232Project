package uni.aed.trees;

import uni.aed.queueTDA.LinkedQueueTDA;
import uni.aed.queueTDA.QueueTDA;

/** 
 * BST: Binary Search Tree
 */
public class BST {
    protected BSTNode root;
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
    
    public void deleteByMerging(int e ){
        BSTNode tmp,node,p=root,prev=null;        
        while(p!=null && p.getKey()!=e){
            prev=p;
            if(p.getKey()<e)
                p=p.right;
            else
                p=p.left; }
        node=p;
        if(p!=null && p.getKey()==e){
            if(node.right==null)
                node=node.left;
            else if (node.left==null)
                node=node.right;
            else{
                tmp=node.left;
                while(tmp.right!=null){
                    tmp=tmp.right;
                }
                tmp.right=node.right;
                node=node.left;
            }
            if(p==root)
                root=node;
            else if(prev.left==p)
                prev.left=node;
            else
                prev.right=node;}
        else if(root!=null)
            System.out.println("El valor no se encuentra en el arbol");
        else
            System.out.println("El arbol esta vacio");
    }
    
    //Eliminacion por copiado
    public void deleteByCopying(int e){
        BSTNode tmp,node,p=root,prev=null, previous;
        //buscamos el nodo a eliminar
        while(p!=null && p.getKey()!=e){
            prev=p;
            if(p.getKey()<e)
                p=p.right;
            else
                p=p.left;            
        }
        node=p;
        if(p!=null && p.getKey()==e){//encontro el elemento a eliminar
            if(node.right==null)//no tiene hijo derecho
                node=node.left;
            else if (node.left==null)//no tiene hijo izq
                node=node.right;
            else{//el nodo tiene dos hijos
                tmp=node.left;
                previous=node;
                while(tmp.right!=null){//rama derecha de la rama izq del nodo a elimar
                    previous=tmp;
                    tmp=tmp.right;
                }
                node.setKey(tmp.getKey());//copiamos el nodo derecho mas extremo de la rama izq del nodo con dos hijos a eliminar
                if(previous==node)
                    previous.left=tmp.left;
                else
                    previous.right=tmp.left;                
            }
            if(p==root)
                root=node;
            else if(prev.left==p)
                prev.left=node;
            else
                prev.right=node;            
        }
        else if(root!=null)//no encontro el elemento a elimnar en el arbol
            System.out.println("El valor bno se encuentra en el arbol");
        else
            System.out.println("El arbol esta vacio");
    }
                           
    public BSTNode search(int e){
        return search(root,e);
    }
    public BSTNode search(BSTNode p, int e){
        while(p!=null){
            if(e==p.getKey())
                return p;
            else if(e<p.getKey())
                p=p.left;
            else
                p=p.right;
        }
        return null;
    }
    
    public void visit(BSTNode p){
        if(p!=null)
            System.out.print(p.getKey()+" ");
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
    
    //VLR preorder
    public void preorder(){
        preorder(root);
    }
    public void preorder(BSTNode p){//VLR
        if(p!=null){
            visit(p);
            preorder(p.left);
            preorder(p.right);}
    }
    
    //LRV postorder
    public void postorder(){//LRV
        postorder(root);
    }
    public void postorder(BSTNode p){//LRV
        if(p!=null){            
            postorder(p.left);
            postorder(p.right);
            visit(p);   
        }         
    }
     //recorrido primero en amplitud
    public void breadthFirst(){
        BSTNode p=root;
        QueueTDA queue= new LinkedQueueTDA();
        if(p!=null){
            queue.add(p);
            while(!queue.isEmpty()){
                p=(BSTNode)queue.remove();
                visit(p);
                if(p.left!=null)
                    queue.add(p.left);
                if(p.right!=null)
                    queue.add(p.right);                    
            }
        }
    }
    
}
