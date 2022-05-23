import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class B22Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 1, 2, 3, ...., 45
		// 이렇게 해서 shuffle 한다음에 아무위치에서나 6개 자르면
		// 중복 없는 로또배열이 됨!
		
		List<Integer> list = new ArrayList<Integer>();
		List<Integer> lotto = new ArrayList<Integer>();
		
		for(int i=1; i<=45; i++)
		{
			list.add(i);
		}
		Collections.shuffle(list);
		
		for(int i=1; i<=6; i++)
		{
			lotto.add(list.get(i));
		}
		Collections.sort(lotto);
		System.out.println(lotto);
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Insert Age : ");
		int age = scan.nextInt();
		System.out.println("Age = " + age);
		scan.close();
	}

}
