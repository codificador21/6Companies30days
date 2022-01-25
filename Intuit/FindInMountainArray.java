/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int[] peak = getPeak(mountainArr);
        if (peak[1] == target) {
            return peak[0];
        }
        int left = getValLeft(mountainArr, peak[0], target);

        if (left != -1) {
            return left;
        }

        return getValRight(mountainArr, peak[0], target);
    }

    private int[] getPeak(MountainArray mountainArray) {
        int len = mountainArray.length();

        int left = 0;
        int right = len - 1;
        while (left <= right) {
            int mid = left + ((right - left) / 2);
            int val = mountainArray.get(mid);
            boolean skipLeft = false;
            int valLeft = -1;
            if (mid - 1 < 0) {
                skipLeft = true;
            } else {
                valLeft = mountainArray.get(mid - 1);
            }

            int valRight = -1;
            boolean skipRight = false;
            if (mid + 1 > len - 1) {
                skipRight = true;
            } else {
                valRight = mountainArray.get(mid + 1);
            }

            if ((skipLeft || valLeft < val) && (skipRight || val > valRight)) {
                return new int[] {mid, val};
            } else if ((skipLeft || valLeft < val) && ( skipRight || val < valRight))  {//left side
                left = mid + 1;
            } else if ((skipLeft || valLeft > val) && ( skipRight || val > valRight)) {
                right = mid - 1;
            }
        }
        return null;
    }

    private int getValLeft(MountainArray mountainArray, int peakId, int target) {
        int left = 0;
        int right = peakId - 1;
        while (left <= right) {
            int mid = left + ((right - left) / 2);
            int val = mountainArray.get(mid);
            if (val == target) {
                return mid;
            } else if (val < target)  {//left side
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    private int getValRight(MountainArray mountainArray, int peakId, int target) {
        int len = mountainArray.length();

        int left = peakId + 1;
        int right = len - 1;
        while (left <= right) {
            int mid = left + ((right - left) / 2);
            int val = mountainArray.get(mid);
            if (val == target) {
                return mid;
            } else if (val > target)  {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}  
/*(This problem is an interactive problem.)

You may recall that an array arr is a mountain array if and only if:

arr.length >= 3
There exists some i with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
Given a mountain array mountainArr, return the minimum index such that mountainArr.get(index) == target. If such an index does not exist, return -1.

You cannot access the mountain array directly. You may only access the array using a MountainArray interface:

MountainArray.get(k) returns the element of the array at index k (0-indexed).
MountainArray.length() returns the length of the array.
Submissions making more than 100 calls to MountainArray.get will be judged Wrong Answer. Also, any solutions that attempt to circumvent the judge will result in disqualification.

 

Example 1:

Input: array = [1,2,3,4,5,3,1], target = 3
Output: 2
Explanation: 3 exists in the array, at index=2 and index=5. Return the minimum index, which is 2.
Example 2:

Input: array = [0,1,2,4,2,1], target = 3
Output: -1
Explanation: 3 does not exist in the array, so we return -1.*/