import java.util.Scanner;

public class AccountTest {
	public static void main(String[] args)
	{
		Scanner input=new Scanner(System.in);
		
		Account account1=new Account(0.0);
		Account account2=new Account(0.0);
		
		int choice=0;
		double deposit_amount=0.0;
		double withdraw_amount=0.0;
		
		System.out.printf("account1 balance: %.2f\n", 
				account1.getBalance());
		System.out.printf("account2 balance: %.2f\n", 
				account2.getBalance());
		
		while(true) {
			System.out.printf("account1 deposit: 1, withdraw: 2 ");
			choice=input.nextInt();
			if(choice==-1) break;
			if(choice==1) {
				System.out.printf("Enter deposit amount for account1: ");
				deposit_amount=input.nextDouble();
				System.out.printf("\nadding %.2f to account1 balance\n\n",
						deposit_amount);
				account1.credit(deposit_amount);
				
				System.out.printf("account1 balance: %.2f\n",
						account1.getBalance());
				System.out.printf("account2 balance: %.2f\n",
						account2.getBalance());
			}
			else if(choice==2) {
				System.out.printf("Enter withdrawal amount for account1: ");
				withdraw_amount=input.nextDouble();
				System.out.printf("\nsubtracting %.2f to account1 balance\n\n",
						withdraw_amount);
				account1.withdraw(withdraw_amount);
				
				System.out.printf("account1 balance: %.2f\n",
						account1.getBalance());
				System.out.printf("account2 balance: %.2f\n",
						account2.getBalance());
			}
			System.out.printf("account2 deposit: 1, withdraw: 2 ");
			choice=input.nextInt();
			if(choice==-1) break;
		
			if(choice==1) {
				System.out.printf("Enter deposit amount for account2: ");
				deposit_amount=input.nextDouble();
				System.out.printf("\nadding %.2f to account2 balance\n\n",
						deposit_amount);
				account2.credit(deposit_amount);
				
				System.out.printf("account1 balance: %.2f\n",
						account1.getBalance());
				System.out.printf("account2 balance: %.2f\n",
						account2.getBalance());
			}
			else if(choice==2) {
				System.out.printf("Enter withdrawal amount for account2: ");
				withdraw_amount=input.nextDouble();
				System.out.printf("\nsubtracting %.2f to account2 balance\n\n",
						withdraw_amount);
				account2.withdraw(withdraw_amount);
				
				System.out.printf("account1 balance: %.2f\n",
						account1.getBalance());
				System.out.printf("account2 balance: %.2f\n",
						account2.getBalance());
			}
		}
	}
}
