import java.util.Scanner;

public class MyString {

    // ----------------- Task 1 -----------------
    // Expand encoded string like "a1b4c3" -> "abbbbccc"
    public static String expand(String s) {
        if (s == null || s.length() == 0) return "";
		String res = "";
		
		String chr = "";
		for(int i = 0; i < s.length(); i++){
			int r = 0;
			if(Character.isDigit(s.charAt(i))){
				r = s.charAt(i) - '0';
				while(r != 0){
					res += chr;
					r--;
				}
				chr = "";
			} else {
				if('a' <= s.charAt(i) && s.charAt(i) <= 'z'){
					chr += s.charAt(i);
				} else {
					res = "Invalid String Please only Enter characters(a - z in lowercase) followed by digits";
				}
			}
		}
		
        return res;
    }

    // ----------------- Task 2 -----------------
    // Run-length encoding: "aabcccdeee" -> "a2b1c3d1e3"
    public static String compressRuns(String s) {
        if (s == null || s.isEmpty()) return "";
        String res = "";
        int n = s.length();
        int i = 0;
        while (i < n) {
            char c = s.charAt(i);
			int count = 1;
            i++;
			if('a' <= c && c <= 'z'){
            while (i < n && s.charAt(i) == c) {
                count++;
                i++;
            }
            res += c;
			res += count;
			} else {
				res = "Invalid String Please only Enter characters(a - z in lowercase)";
			}
        }
        return res;
    }

    // ----------------- Task 3 -----------------
    // Prime number checker
    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0) return false;
        int limit = (int) Math.sqrt(n);
        for (int i = 3; i <= limit; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // ----------------- Task 4 -----------------
    // Number to words (1..1000)
    private static final String[] below20 = {
        "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
        "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen",
        "seventeen", "eighteen", "nineteen"
    };
    private static final String[] tens = {
        "", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"
    };
    public static String numberToWords(int num) {
        if (num <= 0 || num > 1000) throw new IllegalArgumentException("Number must be 1..1000");
        if (num == 1000) return "one thousand";
        StringBuilder sb = new StringBuilder();
        if (num >= 100) {
            int h = num / 100;
            sb.append(below20[h]).append(" hundred");
            num %= 100;
            if (num != 0) sb.append(" ");
        }
        if (num >= 20) {
            int t = num / 10;
            sb.append(tens[t]);
            int rem = num % 10;
            if (rem != 0) sb.append(" ").append(below20[rem]);
        } else if (num > 0) {
            sb.append(below20[num]);
        }
        return sb.toString().trim();
    }

    // ----------------- Task 5 -----------------
    // Longest substring without repeating characters
    public static int lengthOfLongestSubstring(String s) {
        if (s == null) return 0;
        int n = s.length();
        int[] lastIndex = new int[256];
        for (int i = 0; i < lastIndex.length; i++) lastIndex[i] = -1;
        int maxLen = 0, left = 0;
        for (int right = 0; right < n; right++) {
            char c = s.charAt(right);
            if (lastIndex[c] >= left) {
                left = lastIndex[c] + 1;
            }
            lastIndex[c] = right;
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    // ----------------- Main Menu -----------------
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n===== Assignment Menu =====");
            System.out.println("1. Expand encoded string");
            System.out.println("2. Character frequency (run-length encoding)");
            System.out.println("3. Prime number checker");
            System.out.println("4. Number to words (1-1000)");
            System.out.println("5. Longest substring without repeating chars");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter encoded string: ");
                    String enc = sc.nextLine();
                    System.out.println("Expanded: " + expand(enc));
                    break;
                case 2:
                    System.out.print("Enter string to compress: ");
                    String s = sc.nextLine();
                    System.out.println("Compressed: " + compressRuns(s));
                    break;
                case 3:
                    System.out.print("Enter number: ");
                    int num = sc.nextInt();
                    if (isPrime(num)) System.out.println("The given number is PRIME");
                    else System.out.println("The given number is NOT prime");
                    break;
                case 4:
                    System.out.print("Enter number (1-1000): ");
                    int n = sc.nextInt();
                    try {
                        System.out.println("In words: " + numberToWords(n));
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 5:
                    System.out.print("Enter string: ");
                    String str = sc.nextLine();
                    System.out.println("Length of longest substring: " + lengthOfLongestSubstring(str));
                    break;
                case 0:
                    System.out.println("Exiting. Bye!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
