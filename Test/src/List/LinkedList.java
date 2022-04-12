package List;

public class LinkedList<Q> {

	private class Node{
		
		Q info;
		Node next;
		
		public Node(Q i,Node n) {
			info=i;
			next=n;
		}
	}
	
	private Node head=null;
	
	public void add(Q info) {
		Node newNode=new Node(info,null);
		if(head==null) {
			head=newNode; 
		}else {
			Node curr=head;
			while(curr.next!=null) {
				curr=curr.next;
			}
			curr.next=newNode;
		}
	}
	
	public void add(Q info, int index) {
		Node newNode=new Node(info,null);
		Node curr=head;
		if(index==0) {
			Node curr2=head;
			head=newNode;
			newNode.next=curr2;
		}else {
			for(int i=0;i<index-1;i++) {
				curr=curr.next;
			}
			Node curr2=curr.next;
			curr.next=newNode;
			newNode.next=curr2;
		}
	}
	
	public int size() {
		Node curr=head;
		int count=0;
		while(curr!=null) {
			count++;
			curr=curr.next;
		}
		return count;
	}
	
	public int length() {
		return size();
	}
	
	public Q remove(int index) {
		Q storedInfo;
		try {
			Node curr=head;
			if(index==0) {
				storedInfo=head.info;
				head=head.next;
			}else {
				for(int i=0;i<index-1;i++) {
					curr=curr.next;
				}
				storedInfo=curr.next.info;
				Node curr2=curr.next.next;
				curr.next=curr2;
			}
			return storedInfo;
		}catch(NullPointerException e) {
			throw new IndexOutOfBoundsException();
		}
	}
	
	public Q get(int i) {
		try {
			Node curr=head;
			for(int j=0;j<i;j++) {
				curr=curr.next;
			}
			return curr.info;
		}catch(NullPointerException e) {
			throw new IndexOutOfBoundsException();
		}
	}
	
	public String toString() {
		String a="[";
		Node curr=head;
		while(curr!=null) {
			a+=curr.info;
			a+=",";
			curr=curr.next;
		}
		a+="End]";
		return a;
	}
	
	public int josephus(int size) {
		LinkedList<Integer> list=new LinkedList<Integer>();
		for(int i=0;i<size;i++) {
			list.add(i);
		}
		int curr=0;
		while(list.size()>1) {
			list.remove((curr+1)%size);
			curr++;
			System.out.println(list);
		}
		return list.get(0);
	}
	
}
