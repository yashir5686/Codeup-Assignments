import java.util.*;

public class Assignment2{
	
	public static String append(String input){
		Scanner sc = new Scanner(System.in);
		String str = "";
		String res = input;
		System.out.println("Enter String to append: ");
		str = sc.nextLine();
		res += str;
		return res;
	}
	
	public static String replace(String str){
		Scanner sca = new Scanner(System.in);
		String target = "";
		String replace = "";
		while(true){
			System.out.println("Enter the old char or word: ");
			target = sca.nextLine();
			
			if(target == null){
				System.out.println("Please Enter a non Null value");
			} else {
				break;
			}
		}
		
		while(true){
			System.out.println("Enter the new char or word: ");
			replace = sca.nextLine();
			
			if(target == null){
				System.out.println("Please Enter a non Null value");
			} else {
				break;
			}
		}
		
		String fstring = "";
		
		for(int i=0; i<str.length(); i++){
			
			if(str.charAt(i) == target.charAt(0)){
				int si = i;
				int fi = i;
				for(int j=1; j<target.length(); j++){
					if(str.charAt(i+1) == target.charAt(j)){
						fi++;
						i++;
					} else {
						break;
					}
				}
				if((fi-si) == (target.length() - 1)){
					fstring += replace;
				}
			} else {
				fstring += str.charAt(i);
			}
		}
		return fstring;
	}
	
	public static String Sort(String input){
		char[] str=input.toCharArray();
		for(int i=0;i<str.length;i++){
			for(int j=i+1;j<str.length;j++){
				if(str[i]>str[j]){
					char temp=str[i];
					str[i]=str[j];
					str[j]=temp;
				}
			}
		}
		return new String(str);
	}
	
	public static String Reverse(String input){
		String rev = "";
		
		for(int i=input.length() - 1; i>=0; i--){
			rev += input.charAt(i);
		}
		
		return rev;
	}
	
	public static void main(String[] args){
		String input = "";
		Scanner sc = new Scanner(System.in);
		
		while(true){
			System.out.println("Please Input a String: ");
			input = sc.nextLine();
			
			if(input.trim().isEmpty() || input == null){
				System.out.print("String is Empty or Null");
			} else {
				break;
			}
		}
		
		while(true){
			String print = """ 
			=========Oprations Available=========
			1. Append
			2. Replace
			3. Sort
			4. Reverse
			0. Exit
			
			Enter your choice: 
			""";
			System.out.println(print);
			int choice = sc.nextInt();
			
			switch(choice) {
				case 1:
					System.out.println("Appended Result: " + append(input));
					break;
				case 2:
					System.out.println("String with replaced word: " + replace(input));
					break;
				case 3:
					System.out.println("Sorted String: " + Sort(input));
					break;
				case 4:
					System.out.println("Reversed String: " + Reverse(input));
					break;
				case 0:
					System.out.println("Exiting. Bye!");
                    sc.close();
                    return;
				default:
					System.out.println("Please Make a Choice");
			}
		}
	}
}