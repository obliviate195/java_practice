
public class TwoDimensionTest {
	static int max,min;
	//static double[]avg;
	public static void main(String[] args)
	{
		int[][] grades= {{87,96,70},{68,87,90},{94,100,90},{100,81,82},{83,65,85}};
		
		takeGrades myGrade=new takeGrades();
		
		myGrade.takeGrade(grades);
		
	}
	
}

