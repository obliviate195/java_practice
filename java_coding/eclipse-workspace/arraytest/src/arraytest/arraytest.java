package arraytest;

public class arraytest {
	static int max,min;
	static double[]avg;
	public static void main(String[] args)
	{
		int[][] grades= {{87,96,70},{68,87,90},{94,100,90},{100,81,82},{83,65,85}};
		
		//GradesArray myGrade=new GradesArray();
		
		takeGrades(grades);
		
		System.out.printf("%d %d\n", max,min);
	}
	public static void takeGrades(int[][] arr)
	{
		max=min=arr[0][0];
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr[i].length;j++)
			{
				avg[i]+=arr[i][j];
				if(max<arr[i][j]) max=arr[i][j];
				if(min>arr[i][j]) min=arr[i][j];
			}
			avg[i]=(double)avg[i]/arr[i].length;
		}
		
	}
}
