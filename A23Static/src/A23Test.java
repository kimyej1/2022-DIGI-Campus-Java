import java.util.Scanner;

class Car
{
	public static int count;
	public String name;
	
	public Car()
	{
		//this.name = "no name";
		//count++;
		this("no name");
	}
	
	public Car(String name)
	{
		this.name = name;
		count++;
	}
	
	public static int getCount() { 
		// static에서는 static만 부를 수 있어서 getter/setter에도 static 붙음
		return count;
	}
	public static void setCount(int count) {
		Car.count = count;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Car [name = " + name + ", count = " + count + " ]";
	}
	
}


public class A23Test 
{

	public static void main(String[] args) 
	{	// TODO Auto-generated method stub
		print();
		
		Car none = new Car();
		System.out.println(none);
		
		Car taxi = new Car("taxi");
		System.out.println(taxi);
		
		Car bus = new Car("bus");
		System.out.println(bus);
		
		System.out.println(taxi); // 메모리는 공유하는지 확인
		

		
		/* int index;
		for(index = 0; index < lotto.length; index++)
		{
			lotto[index] = (index + 1) * 2;
		}
		
		for(index = 0; index < lotto.length; index++)
		{
			System.out.println("lotto[" + index + "] = " + lotto[index]);
		} */
		
		
		// 로또 6개를 입력받으시오.
		// 로또를 입력값을 출력하고,
		// 입력 받은 로또의 평균을 구하시오.
		
		Scanner scan = new Scanner(System.in);
		
		int[] lotto = new int[6];
		
		int index;
		int sum = 0;
		
		for(index = 0; index < lotto.length; index++)
		{
		System.out.print((index+1) + "번째 로또 번호 입력 : ");
		lotto[index] = scan.nextInt();
		sum += lotto[index];
		}
				
		for(index = 0; index < lotto.length; index++)
		{
		System.out.print(lotto[index] + ", ");
		}
		
		System.out.println("Average = " + (double)sum/lotto.length);
		
		// Enhanced For
		// for(값 : 배열)
		
		for(int value : lotto)
		{
			System.out.println(value);
		}
		
		printArray(lotto);
		
		scan.close();
		
		
	}
	
	public static void printArray(int[] array)
	{
		System.out.println("printArray()");
		
		for(int i=0; i<array.length; i++) // for문 안에 변수선언하면 선언한 변수가 for 안에서만 사용됨(단발성으로 사용하고 버리는 메모리)
		{
			System.out.println(array[i]);
		}
	}
	
	public static void print()
	{
		System.out.println("print ...");
	} 

}
