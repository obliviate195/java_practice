import java.util.Scanner;

public class PalindromeTest {
	//static이 아닌 메소드나 필드를 참조할 수 없다.
	//모든 메소드나 필드를 static멤버로 바꾸거나, 클래스의 객체를 생성하여 해결
	//field를 static으로 바꾼 경우
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
		//class의 객체를 생성하여 해결
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

