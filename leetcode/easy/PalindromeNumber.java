package leetcode.easy;

import java.util.Stack;

public class PalindromeNumber {

	public static void main(String[] args) {
		
		System.out.println(isPalindrome1(122));

	}
	
	/*
	This simples method involves converting the number into a String.
	Then, it uses a stack to push each character of this onto it.
	Next, the characters are popped from the stack one by one into a new
	variable, effectively building a new string in reverse oder.
	Finally, this reversed string is compared with the original string.
	If the two strings are identical, the method returns true; otherwise,
	it returns false.
	*/
	public static boolean isPalindrome1(int number) {
		Stack<Character> pilha = new Stack<>();
		String numberString = Integer.toString(number);
		
		for(int i = 0; i < numberString.length(); i++) 
			pilha.push(numberString.charAt(i));
		
		String inverseNumberString = "";
		for(int i = 0; i < numberString.length(); i++)
			inverseNumberString += pilha.pop();
		
		if(inverseNumberString.equals(numberString))
			return true;
		
		return false;
	}
	
	/*
	It works by first converting the input integer into a string.
	This conversion males it easy to access individual digits (now characters)
	by their position. The function then uses a simple for loop to iterate
	only up to the middle of the string. In each step, it compares a character
	from the beginning of the string with its corresponding character from the
	end. If at any point these two characters don't match, the number can't be
	a palindrome, so the function immediately returns false. If the loop completes
	without finding any mismatches, it means all corresponding characters were 
	identical, and the function correctly returns true, indicating that the
	original number was indeed a palindrome.
	*/
	public static boolean isPalindrome2(int number) {
		String s = String.valueOf(number); // Convert to String
		int n = s.length(); // Store the String length to int n
		
		for(int i = 0; i < n/2; i++) {
			// We check whether the elements at the same distance from
			// beginning and from ending are same, if not we return false
			if(s.charAt(i) != s.charAt(n-i-1)) return false;
		}
		// 12321
		// i[0] = 1 	|	i[5 - 0 - 1] = 4
		// i[0] && i[4] == 1
		
		// if no flaws are found we return true
		return true;
	}

}
