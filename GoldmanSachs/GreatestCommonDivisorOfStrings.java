class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if(str1.length()<str2.length()){
            String temp = str1;
            str1 = str2;
            str2 = temp;
        }
        int ind = 0;
        for(int i = str2.length();i>0;i--){
            
            if(str2.length()%i != 0){
                continue;
            }if(str1.length()%i != 0){
                continue;
            }
            boolean flag = false;
            for(int j = 0;j<str2.length();j+=i){
                if(!str2.substring(0,i).equals(str2.substring(j,j+i))){
                    flag = true;
                }
            }if(flag == true) continue;
            
            for(int j = 0;j<str1.length();j+=i){
                if(!str2.substring(0,i).equals(str1.substring(j,j+i))){
                    flag = true;
                }
            }if(flag == true) continue;
            
            return str2.substring(0,i);
        }
        return "";
        
    }
}
//For two strings s and t, we say "t divides s" if and only if s = t + ... + t (i.e., t is concatenated with itself one or more times).

//Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.
// Input: str1 = "ABCABC", str2 = "ABC"
// Output: "ABC"
// Input: str1 = "ABCABC", str2 = "ABC"
// Output: "ABC"