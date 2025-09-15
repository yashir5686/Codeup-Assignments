import java.util.*;

public class Main{
	public static void main(String args[]){
		int num = 0;
		
		Scanner Sc = new Scanner(System.in);
		
		System.out.println("Enter any number: ");
		num = Sc.nextInt();
		
		for(int i=1; i<=10; i++){
			System.out.println( num + " x " + i + " = " + num*i);
		}
	}
}
