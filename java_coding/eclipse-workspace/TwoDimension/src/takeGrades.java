public class takeGrades{
	static int max, min;
	public void takeGrade(int[][] arr)
	{
		double avg=0;
		max=min=arr[0][0];
		for(int i=0;i<arr.length;i++)
		{
			System.out.printf("Student %d ", i+1);
			for(int j=0;j<arr[i].length;j++)
			{
				System.out.printf("%5d ", arr[i][j]);
				avg+=arr[i][j];
				if(max<arr[i][j]) max=arr[i][j];
				if(min>arr[i][j]) min=arr[i][j];
			}
			avg=(double)avg/arr[i].length;
			System.out.printf("%7.2f\n", avg);
			avg=0;
		}
		System.out.printf("max: %d min: %d", max,min);
	}
}
