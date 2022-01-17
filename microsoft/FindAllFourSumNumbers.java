class Solution {
    public List<List<Integer>> fourSum(int[] arr, int tar) {
        HashSet<ArrayList<Integer>> hm = new HashSet<>();
        List<List<Integer>>list = new ArrayList<List<Integer>>();
        Arrays.sort(arr);
        int n = arr.length;
        int ind = 0;
        for(int i = 0;i<=n-4;i++){
            for(int j = i+1;j<=n-3;j++){
                int k = j+1,l = n-1;
                while(k<l){
                    int sum = arr[i]+arr[j]+arr[k]+arr[l];
                    if(sum<tar){
                        k++;
                    }else if(sum>tar){
                        l--;
                    }else{
                        ArrayList<Integer>ans = new ArrayList<Integer>();
                        ans.add(arr[i]);
                        ans.add(arr[j]);
                        ans.add(arr[k]);
                        ans.add(arr[l]);
                        hm.add(ans);
                        ind++;
                        k++;
                        l--;
                    }
                }
                while(j+1<n && arr[j+1]==arr[j]) ++j;
            }
            while(i+1<n && arr[i+1]==arr[i]) ++i;
        }
        for(ArrayList<Integer> temp:hm){
            list.add(temp);
        }
        // for(int i = 0;i<list.size();i++){
        //     for(int j = i+1;j<list.size();j++){
        //         if(list.get(i).get(0)==list.get(j).get(0) && list.get(i).get(1)==list.get(j).get(1)
        //         && list.get(i).get(2)==list.get(j).get(2) && list.get(i).get(3)==list.get(j).get()){
        //             list.remove(j);
        //         }
        //     }
        // }
        return list;
    }
}
/*Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

0 <= a, b, c, d < n
a, b, c, and d are distinct.
nums[a] + nums[b] + nums[c] + nums[d] == target
You may return the answer in any order.

 

Example 1:

Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
Example 2:

Input: nums = [2,2,2,2,2], target = 8
Output: [[2,2,2,2]]*/
