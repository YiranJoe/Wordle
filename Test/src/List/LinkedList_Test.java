package List;


public class LinkedList_Test<Q> {

	
	public static void main(String[] args) {
		LinkedList<Integer> list=new LinkedList<Integer>();
		for(int i=0;i<8;i++) {
			list.add(i);
		}//list should be 01234567
		System.out.println(list.toString());
		System.out.println(list.size());
		System.out.println(list.length());
		list.add(9);//list should be 012345679
		System.out.println(list.toString());
		System.out.println(list.get(8));//print 9 since it is the content of index 9
		list.add(3,5);//list should be 0123435679
		System.out.println(list.toString());
		list.add(1,0);//list should be 10123435679
		System.out.println(list.toString());
		list.remove(0);//list should be 0123435679
		System.out.println(list.toString());
		list.remove(2);//list should be 0131435679
		System.out.println(list);
		
	}
}
