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

		ArrayList<String> list = new ArrayList<String>(); // ArrayList : list인데 array처럼 첨자를 허용하는 list
		
		list.add("A"); // A
		list.add("B"); // A-B (ArrayList니까 제일 뒤에 붙음) 
		list.add("C"); // A-B-C
		list.add(1, "D"); // 1번자리에 D를 넣어 : A-D-B-C
		list.set(2, "K"); // 2번자리를 K로 바꿔 : A-D-K-C
		list.remove(2); // 2번자리를 지워 : A-D-C
		//list.remove(5); // 5번자리가 없어서 오류 발생 -> 사이즈 확인 후 지워야함!
		
		System.out.println("KKK index = " + list.indexOf("KKK")); // 없으니까 -1 리턴해줌 
		System.out.println("D index = " + list.indexOf("D")); // 있으면 그 위치 리턴해줌 
		
		System.out.println("size = " + list.size());
		System.out.println(list);
		
	
		for(int i=0; i<list.size(); i++)
		{
			// list[2] = K 이런식으로 출력.. 
			System.out.printf("list[%d] = %s\n", i, list.get(i));
		}
		System.out.println("\nEnhanced For...");
		// for(int value : lotto)
		for(String value : list) // list의 value를 돌아가면서 하나씩 출력 
		{
			System.out.println(value);
		}
		
		System.out.println("\nIterator(반복자)");
		
		Iterator e = list.iterator();
		while(e.hasNext())
		{
			String value = (String)e.next(); // 다음값이 어떤 형태인지 모르니까 string으로 바꿔서 출력해줘 
			System.out.println(value);
		}
		
		// ============== Set : 중복허용하지 않는 자료구조 (순서 무관) 
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
		System.out.println("\nSet = " + set); // 중복제거하고 A, B, C
		
		Queue<String> q = new LinkedList<String>();
		q.add("AAA");
		q.add("BBB"); // AAA - BBB
		q.add("CCC"); // AAA - BBB - CCC
		q.add("DDD"); // AAA - BBB - CCC - DDD
		q.remove(); // queue의 특성 상 AAA가 먼저 지워짐 : BBB - CCC - DDD
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
		intStack.add(44); // add, push 둘다 허용하지만, Stack의미상 push가 더 어울림
		intStack.pop(); // stack의 특성 상 44가 먼저 지워짐 : 11 - 22 - 33
		
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
		Collections.sort(sList); // 정렬해줘! 
		System.out.println("sList = " + sList);
		Collections.shuffle(sList); // 섞어줘!
		System.out.println("sList = " + sList);
		Collections.sort(sList, Collections.reverseOrder()); // 역순 정렬해줘!
		System.out.println("sList = " + sList);
		
		String[] name = {"이순신", "홍길동", "강감찬", "박지원", "송시열"};
		List<String> nameList = Arrays.asList(name); // array를 list인것처럼 바꿔줘! 
		Collections.sort(nameList);
		System.out.println("nameList = " + nameList);
	
	}

}
