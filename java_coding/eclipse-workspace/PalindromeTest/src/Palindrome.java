
public class Palindrome {
	private int num_input;
	
	public Palindrome(int initial_num)
	{
		num_input=initial_num;
	}
	
	public int Judge_palin()
	{
		int c=0;
		int tens=1;
		int numinp1, numinp2;
		numinp1=numinp2=num_input;
		int i;
		for(i=0;numinp1!=0;i++)
		{
			numinp1/=10;
		}
		numinp1=numinp2=num_input;
		int numlen;
		numlen=i-1;
		for(int j=0;j<numlen;j++)
		{
			tens*=10;
		}
		
		for(int j=0;j<(i/2);j++)
		{
			if((numinp1/tens)!=(numinp2%10))
			{
				c=1;
				break;
			}
			else
			{
				numinp1-=(numinp1/tens)*tens;
				numinp2/=10;
				tens/=10;
			}
		}
		return c;
		
	}
	
}
