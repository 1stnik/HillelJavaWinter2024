package com.hillel.lesson_09.task;

//        Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
//        You may assume that each input would have exactly one solution, and you may not use the same element twice.
//
//        Example 1:
//        Input: nums = [2,7,11,15], target = 9
//        Output: [0,1]
//        Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
//        ===================================
//        Example 2:
//        Input: nums = [3,2,4], target = 6
//        Output: [1,2]
//        ===================================
//        Example 3:
//        Input: nums = [3,3], target = 6
//        Output: [0,1]

public class SummTwo {

    public static void main(String[] args) {
        int target = 9;
        Integer[] result = {1, 8, 2, 5, 4, 4, 5, 4};
        for (int i = 0; i < result.length - 1; i++) {
            for (int j = 1; j < result.length; j++) {
                if (result[i] + result[j] == target) {
                    System.out.println("[" + i + ", " + j + "]");
                    return;
                }

            }
        }


    }
}
