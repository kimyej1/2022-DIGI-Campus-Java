class Dice
{
	private int diceFace;
	private int userGuess;
	
	public int getDiceFace()
	{
		return this.diceFace;
		// return diceFace를 이렇게 치면 더 빠름(자동완성)
	}
	
	public void setDiceFace(int diceFace) // 'new'는 키워드이기 때문에 사용 불가
	{
		this.diceFace = diceFace;
	}
	
	public int getUserGuess()
	{
		return this.userGuess;
	}
	
	public void setUserGuess(int userGuess)
	{
		this.userGuess = userGuess;
	}

	
}


public class A19Test 
{

	public static void main(String[] args) 
	{		// TODO Auto-generated method stub

	}

}
