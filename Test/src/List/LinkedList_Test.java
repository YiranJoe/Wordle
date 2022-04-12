package List;


public class LinkedList_Test<Q> {

	public static int josephus(int size) {
		LinkedList<Integer> list=new LinkedList<Integer>();
		for(int i=0;i<size;i++) {
			list.add(i+1);
		}
		int targetIndex=1;
		while(list.size()>1) {
//			  System.out.println(list.remove(targetIndex));
				list.remove(targetIndex);
	            if (list.size() > 0)
	                targetIndex = (targetIndex + 1) % list.size();
		}
		return list.get(0);
	}
//	1  3 4 5
//	public static int josephus(int NUM,int firstTimeEliminate) {
		
//		LinkedList<Integer> list=new LinkedList<Integer>();
//		for(int i=0;i<size;i++) {
//			list.add(i+1);
//		}
//		int curr=1;
//		while(list.size()>1) {
//			System.out.println(curr%list.size());
//			list.remove(curr%list.size());
//			System.out.println(list+" "+curr);
//			curr++;
//		}
//		return list.get(0);
		
		
//		if(NUM==1) {
//			return 1;
//		}else {
//			return (josephus(NUM-1,firstTimeEliminate)+firstTimeEliminate-1)%NUM+1;
//		}
//	}
	
	public static void main(String[] args) {
		LinkedList<Integer> list=new LinkedList<Integer>();
		for(int i=0;i<8;i++) {
			list.add(i);
		}//list should be 01234567
//		System.out.println(list.toString());
//		System.out.println(list.size());
//		System.out.println(list.length());
//		list.add(9);//list should be 012345679
//		System.out.println(list.toString());
//		System.out.println(list.get(8));//print 9 since it is the content of index 9
//		list.add(3,5);//list should be 0123435679
//		System.out.println(list.toString());
//		list.add(1,0);//list should be 10123435679
//		System.out.println(list.toString());
//		list.remove(0);//list should be 0123435679
//		System.out.println(list.toString());
//		list.remove(2);//list should be 0131435679
//		System.out.println(list);
		System.out.println(josephus(5));
		
	}
}
