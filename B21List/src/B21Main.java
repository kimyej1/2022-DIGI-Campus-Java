import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeSet;

public class B21Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<String> list = new ArrayList<String>(); // ArrayList : list�ε� arrayó�� ÷�ڸ� ����ϴ� list
		
		list.add("A"); // A
		list.add("B"); // A-B (ArrayList�ϱ� ���� �ڿ� ����) 
		list.add("C"); // A-B-C
		list.add(1, "D"); // 1���ڸ��� D�� �־� : A-D-B-C
		list.set(2, "K"); // 2���ڸ��� K�� �ٲ� : A-D-K-C
		list.remove(2); // 2���ڸ��� ���� : A-D-C
		//list.remove(5); // 5���ڸ��� ��� ���� �߻� -> ������ Ȯ�� �� ��������!
		
		System.out.println("KKK index = " + list.indexOf("KKK")); // �����ϱ� -1 �������� 
		System.out.println("D index = " + list.indexOf("D")); // ������ �� ��ġ �������� 
		
		System.out.println("size = " + list.size());
		System.out.println(list);
		
	
		for(int i=0; i<list.size(); i++)
		{
			// list[2] = K �̷������� ���.. 
			System.out.printf("list[%d] = %s\n", i, list.get(i));
		}
		System.out.println("\nEnhanced For...");
		// for(int value : lotto)
		for(String value : list) // list�� value�� ���ư��鼭 �ϳ��� ��� 
		{
			System.out.println(value);
		}
		
		System.out.println("\nIterator(�ݺ���)");
		
		Iterator e = list.iterator();
		while(e.hasNext())
		{
			String value = (String)e.next(); // �������� � �������� �𸣴ϱ� string���� �ٲ㼭 ������� 
			System.out.println(value);
		}
		
		// ============== Set : �ߺ�������� �ʴ� �ڷᱸ�� (���� ����) 
		// HashSet<String> set = new HashSet<String>();
		TreeSet<String> set = new TreeSet<String>();
		// {A, A, A} = {A}
		set.add("A");
		set.add("C");
		set.add("B");
		set.add("A");
		set.add("C");
		set.add("B");
		set.add("A");
		set.add("C");
		System.out.println("\nSet = " + set); // �ߺ������ϰ� A, B, C
		
		Queue<String> q = new LinkedList<String>();
		q.add("AAA");
		q.add("BBB"); // AAA - BBB
		q.add("CCC"); // AAA - BBB - CCC
		q.add("DDD"); // AAA - BBB - CCC - DDD
		q.remove(); // queue�� Ư�� �� AAA�� ���� ������ : BBB - CCC - DDD
		System.out.println("\nq = " + q);
		
		for(String value : q)
		{
			System.out.println(value);
		}
		
		Stack<Integer> intStack = new Stack<Integer>();
		Stack<String> strStack = new Stack<String>();
		
		intStack.push(11);
		intStack.push(22);
		intStack.push(33);
		intStack.add(44); // add, push �Ѵ� ���������, Stack�ǹ̻� push�� �� ��︲
		intStack.pop(); // stack�� Ư�� �� 44�� ���� ������ : 11 - 22 - 33
		
		System.out.println("\nintStack = " + intStack);
		
		strStack.push("AA");
		strStack.push("BB");
		strStack.add("CC");
		System.out.println("strStack = " + strStack);
		
		ArrayList<String> sList = new ArrayList<String>();
		sList.add("Java");
		sList.add("Python");
		sList.add("HTML");
		sList.add("JS");
		System.out.println("\nsList = " + sList);
		Collections.sort(sList); // ��������! 
		System.out.println("sList = " + sList);
		Collections.shuffle(sList); // ������!
		System.out.println("sList = " + sList);
		Collections.sort(sList, Collections.reverseOrder()); // ���� ��������!
		System.out.println("sList = " + sList);
		
		String[] name = {"�̼���", "ȫ�浿", "������", "������", "�۽ÿ�"};
		List<String> nameList = Arrays.asList(name); // array�� list�ΰ�ó�� �ٲ���! 
		Collections.sort(nameList);
		System.out.println("nameList = " + nameList);
	
	}

}
