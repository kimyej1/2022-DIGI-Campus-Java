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
		// static������ static�� �θ� �� �־ getter/setter���� static ����
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
		
		System.out.println(taxi); // �޸𸮴� �����ϴ��� Ȯ��
		

		
		/* int index;
		for(index = 0; index < lotto.length; index++)
		{
			lotto[index] = (index + 1) * 2;
		}
		
		for(index = 0; index < lotto.length; index++)
		{
			System.out.println("lotto[" + index + "] = " + lotto[index]);
		} */
		
		
		// �ζ� 6���� �Է¹����ÿ�.
		// �ζǸ� �Է°��� ����ϰ�,
		// �Է� ���� �ζ��� ����� ���Ͻÿ�.
		
		Scanner scan = new Scanner(System.in);
		
		int[] lotto = new int[6];
		
		int index;
		int sum = 0;
		
		for(index = 0; index < lotto.length; index++)
		{
		System.out.print((index+1) + "��° �ζ� ��ȣ �Է� : ");
		lotto[index] = scan.nextInt();
		sum += lotto[index];
		}
				
		for(index = 0; index < lotto.length; index++)
		{
		System.out.print(lotto[index] + ", ");
		}
		
		System.out.println("Average = " + (double)sum/lotto.length);
		
		// Enhanced For
		// for(�� : �迭)
		
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
		
		for(int i=0; i<array.length; i++) // for�� �ȿ� ���������ϸ� ������ ������ for �ȿ����� ����(�ܹ߼����� ����ϰ� ������ �޸�)
		{
			System.out.println(array[i]);
		}
	}
	
	public static void print()
	{
		System.out.println("print ...");
	} 

}
