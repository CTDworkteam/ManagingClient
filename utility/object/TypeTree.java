package object;
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
	public boolean addNewElement(String id,String name,T element){
		int depth=Integer.parseInt(id.substring(0,1));
		int[] position={0,0,0,0,0};
		for(int i=0;i<=4;i++){
			position[i]=Integer.parseInt(id.substring(2*i+1,2*i+3));
		}
		if(depth==1){
			return false;
		}
		else{
			Node<T> pointer=this.root;
			for(int j=1;j<=depth-2;j++){
				pointer=pointer.child;
				for(int k=2;k<=position[j];k++){
					pointer=pointer.right;
				}
			}
			if(position[depth-1]==1){
				if(pointer.hasCommodity()){
					return false;
				}
				else{
					pointer.child=new Node<T>(id,name,element,0,pointer,null,null,null);
					return true;
				}
			}
			else{
				pointer=pointer.child;
				while(pointer.right!=null){
					if(pointer.name.equals(name)){
						return false;
					}
					else{
						pointer=pointer.right;
					}
				}
				if(pointer.name.equals(name)){
					return false;
				}
				else{
					pointer.right=new Node<T>(id,name,element,0,pointer.father,null,null,pointer);
					return true;
				}
			}
		}
	}
	public boolean deleteElement(String id){
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
		if(pointer.hasCommodity()){
			return false;
		}
		if(pointer.child!=null){
			return false;
		}
		if(pointer.left==null){
			pointer.father.child=pointer.right;
			pointer.right.left=null;
		}
		else if(pointer.right==null){
			pointer.left.right=null;
		}
		else{
			pointer.left.right=pointer.right;
			pointer.right.left=pointer.left;
		}
		return true;
	}
	public boolean changePosition(String beforeID,String afterID,String name,T element){
		if(!deleteElement(beforeID)){
			return false;
		}
		else{
			if(!addNewElement(afterID,name,element)){
				return false;
			}
			else{
				return true;
			}
		}
	}
	public boolean updateElement(String id,String afterName,T element){
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
		Node<T> pointer1=pointer.left;
		Node<T> pointer2=pointer.right;
		while(pointer1!=null){
			if(pointer1.name.equals(afterName)){
				return false;
			}
			pointer1=pointer1.left;
		}
		while(pointer2!=null){
			if(pointer.name.equals(afterName)){
				return false;
			}
			pointer2=pointer2.right;
		}
		pointer.data=element;
		return true;
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
	public String name;
	public T data;
	public int numOfCommodity;
	public Node<T> father;
	public Node<T> child;
	public Node<T> right;
	public Node<T> left;
	public Node(){
	}
	public boolean isLeaf(){
		if(father!=null&&child==null){
			return true;
		}
		else{
			return false;
		}
	}
	public Node(String id, String name, T data, int numOfCommodity,
			Node<T> father, Node<T> child, Node<T> right, Node<T> left) {
		super();
		this.id = id;
		this.name = name;
		this.data = data;
		this.numOfCommodity = numOfCommodity;
		this.father = father;
		this.child = child;
		this.right = right;
		this.left = left;
	}
	public boolean isRoot(){
		if(father==null){
			return true;
		}
		else{
			return false;
		}
	}
	public boolean hasCommodity(){
		return this.numOfCommodity==0?false:true;
	}
}