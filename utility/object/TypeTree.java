package object;
import comparator.*;
import po.*;
public class TypeTree<T> {
	public Node<T> root;
	public TypeTree(){
	}
	public TypeTree(Node<T> root){
		this.root=root;
	}
	public T getNode(String id){
		int depth=Integer.parseInt(id.substring(0,1));
		if(depth==1){
			return this.root.data;
		}
		int position=0;
		Node<T> pointer=this.root.child;
		for(int i=2;i<=depth;i++){
			position=Integer.parseInt(id.substring(2*i-1,2*i+1));
			for(int j=2;j<=position;j++){
				pointer=pointer.right;
			}
			if(i==depth){
				break;
			}
			else{
				pointer=pointer.child;
			}
		}
		return pointer.data;
	}
	public boolean addNewElement(T element){
		
	}
	public boolean deleteElement(String id){
		
	}
	public boolean changePosition(String beforeID,T element){
		
	}
	public boolean updateElement(T element){
		
	}
	public String calculateNewElementID(String fatherID){
		int depth=Integer.parseInt(fatherID.substring(0,1));
		int[] position={0,0,0,0,0};
		Node<T> pointer=root;
		for(int i=0;i<=depth-1;i++){
			position[i]=Integer.parseInt(fatherID.substring(2*i+1,2*i+3));
		}
		for(int j=1;j<=depth-1;j++){
			pointer=pointer.child;
			for(int k=2;k<=position[j];k++){
				pointer=pointer.right;
			}
		}
		int count=0;
		pointer=pointer.child;
		while(pointer!=null){
			count++;
			pointer=pointer.right;
		}
		position[depth+1]=count;
		String output=new Integer(depth+1).toString();
		for(int l=0;l<=4;l++){
			output+=String.format("%2d",position[l]);
		}
		return output;
	}
	public boolean isLeaf(String id){
		int depth=Integer.parseInt(id.substring(0,1));
		int[] position={0,0,0,0,0};
		Node<T> pointer=root;
		for(int i=0;i<=depth-1;i++){
			position[i]=Integer.parseInt(id.substring(2*i+1,2*i+3));
		}
		for(int j=1;j<=depth-1;j++){
			pointer=pointer.child;
			for(int k=2;k<=position[j];k++){
				pointer=pointer.right;
			}
		}
		if(pointer.child==null){
			return true;
		}
		else{
			return false;
		}
	}
}
class Node<T>{
	public String id;
	public T data;
	public Node<T> father;
	public Node<T> child;
	public Node<T> right;
	public Node(){
	}
	public Node(String id,T data,Node<T> child,Node<T> right){
		this.id=id;
		this.data=data;
		this.child=child;
		this.right=right;
	}
	public boolean isLeaf(){
		if(father!=null&&child==null){
			return true;
		}
		else{
			return false;
		}
	}
	public boolean isRoot(){
		if(father==null){
			return true;
		}
		else{
			return false;
		}
	}
}