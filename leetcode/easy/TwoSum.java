package leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
	
	/*
	A simple implementation involves two iterations. 
	In the first iteration, we populate a hash table where each element's value
	is stored as a key and its index as the corresponding value. 
	In the second iteration, we check if the complement of each 
	element (target - nums[i]) exists as a key in the hash table. 
	If it does, we return the indices of both the current element and its complement. 
	It's crucial that the complement found is not nums[i] itself, as nums[i]
	represents the position of the other number in the pair.
	*/
	public static int[] twoPassHashTable(int nums[], int target) {
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}
		for(int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if(map.containsKey(complement) && map.get(complement) != i) {
				return new int[] {i, map.get(complement)};
			}
		}
		
		return new int[] {};
	}
	
	/*
	For each number it encounters, the function calculates its "complement"
	(the value needed to reach the target). It then checks if this complement already
	exists in the HashMap. If  found, it means we've discovered the two numbers and
	the function immediately returns their respective indices. If the
	complement isn't in the map, the current number and its index are added to the
	HashMap, making it available as a potential complement for numbers processed
	later. This approach ensures that we always look for a pair among previously 
	encountered elements, effectively solving the problem in linear time by
	avoiding nested loops.
	*/
	public static int[] onePassHashTable(int nums[], int target) {
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int i = 0; i < nums.length; i++) {
			int complement = target - nums[i]; // 2 7 11 15 target  = 9
											   // 9 - 2 = 7
			if(map.containsKey(complement))
				return new int[] {map.get(complement), i};
		}
		
		return new int[] {};
	}

}
