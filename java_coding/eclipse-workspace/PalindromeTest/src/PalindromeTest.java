import java.util.Scanner;

public class PalindromeTest {
	//static�� �ƴ� �޼ҵ峪 �ʵ带 ������ �� ����.
	//��� �޼ҵ峪 �ʵ带 static����� �ٲٰų�, Ŭ������ ��ü�� �����Ͽ� �ذ�
	//field�� static���� �ٲ� ���
/*	static int judgePalin(int num)
	{
		int c=0;
		int tens=1;
		int numinp1, numinp2;
		numinp1=numinp2=num;
		int i;
		for(i=0;numinp1!=0;i++)
		{
			numinp1/=10;
		}
		numinp1=numinp2=num;
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
	*/
	public static void main(String[] args)
	{
		//class�� ��ü�� �����Ͽ� �ذ�
		Scanner input=new Scanner(System.in);
		
		int num=0;
		int c=0;
		
		System.out.printf("Welcome to Palindrome Tester\n");
		System.out.printf("Enter a number: ");
		num=input.nextInt();
		
		
		while(num!=-1) {
			Palindrome palindrome=new Palindrome(num);
			c=palindrome.Judge_palin();
			
			if(c==1)
			{
				System.out.printf("Not a palindrome\n");
			}
			else {
				System.out.printf("Yes, it is a palindrome.\n");
			}
			
			System.out.printf("Welcome to Palindrome Tester\n");
			System.out.printf("Enter a number: ");
			num=input.nextInt();
			c=0;
			
		}
		
		System.out.printf("Bye!");
	}
	
	
}

