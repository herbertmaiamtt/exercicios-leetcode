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
	
	

}
