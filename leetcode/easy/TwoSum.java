package leetcode.easy;

import java.util.Arrays;
import java.util.Scanner;

public class TwoSum {

	public static void main(String[] args) {
		
	int nums[] = {2, 7, 11, 15};
	
	
	System.out.println(Arrays.toString(bruteForceSolution(nums, 9)));
		
	}
	
	/*
	Loop through each element x and find if there is another value that equals
	to target - x.
	Two "for" loops are used. In the iteration of the first loop (for index i), it's
	checked if the subtraction of the element at position [i] from the target is equal
	to the element at position [j] (where j is the index for the second loop). 
	The elements at position [j] are always one position ahead of the elements at 
	position [i]. 
	This ensures that compared elements will always be different and guarantees a 
	complete scan of the array. 
	If the result of the subtraction matches the value of the element at position [j],
	then an array with the two indices (i and j) is returned.
	*/
	public static int[] bruteForceSolution(int nums[], int target) {
		for(int i = 0; i < nums.length; i++) {
			for(int j = i + 1; j < nums.length; j++) {
				if(nums[j] == target - nums[i]) {
					return new int[] {i, j};
				}
			}
		}
		
		return new int[] {};
	}

}
