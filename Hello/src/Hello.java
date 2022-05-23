public class Hello 
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
		/*
		 
		create table user_table(
				idx		int(1) auto_increment,
				id		char(20) unique,
				name	char(20),
				age		int(3) default '10',	-- 혹시 사용자가 입력 안하면 10살로 지정해줘~
				time	datetime,				-- 2022-02-18 12:34:56 (* date는 2022-02-18)

				primary key(idx)
			);

		insert into user_table (id, name, age, time)
		values ('test', '테스트', '11', now());

		insert into user_table (id, name, age, time)
		values ('kim', '김유신', '33', now());

		insert into user_table (id, name, age, time)
		values ('kim1', '김모모', '31', now());

		insert into user_table (id, name, age, time)
		values ('park', '박찬호', '13', now());

		insert into user_table (id, name, age, time)
		values ('lee', '이순신', '27', now());
		
		*/
//		int i=0;
//		int lotto[] = new int[6];
//		
//		while(true)
//		{
//			for(i = 0; i< lotto.length; i++)
//			{
//				lotto[i] = (int)(Math.random() * 45
//						+ 1);
//				System.out.println("lotto[" + i + "] = " + lotto[i]);
//			}
//			
//			break;
//		}
		
		// a
	    int myAge = 31;
	    double myWeight = 52.3;
	    System.out.println(myAge);
	    System.out.println(myWeight);
	    
	    
	    // b
	    double multiply = myAge * myWeight;
	    System.out.println(multiply);
	    
	    // c
	    double castMyAge = (double)myAge;
	    System.out.println(castMyAge);
	    
	    // d 
	    int castMyWeight = (int)myWeight;
	    System.out.println(castMyWeight);
	    
	    // e
	    char initial = 'Y';    // ASCII : 89
	    System.out.println(initial);
	    
	    // f
	    System.out.println((char)((int)initial + 32)); // ASCII : 121
	    
	 // a
	    String myName = "YejiKim";
	    System.out.println(myName);
	    
	    // b
	    String replacedName = myName.replace("Y", "A");
	    replacedName = replacedName.replace("m", "Z");
	    System.out.println(replacedName);
	    
	    // c
	    String kb = "www.kbstar.com";
	    System.out.println(kb);
	    
	    // d
	    System.out.println(kb.substring(4,10) + 1331);
	    
	    int a = 1331;
        int b = 1;
        System.out.println("Welcome to \nCS 1331!");
        int c = a / b;
        System.out.println("c is equal to: " + c);
        
        char letter = 'a';
        System.out.println("letter is " + letter);
    }
		
		
	}

