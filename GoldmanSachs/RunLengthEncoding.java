// { Driver Code Starts
import java.util.*;
 
class RLEncoding
{
   public static void main(String[] args) 
   {
 
      Scanner sc = new Scanner(System.in);
    
	  int T = sc.nextInt();
	  sc.nextLine();
	  while(T>0)
	  {
		  
		String str = sc.nextLine();
		
		GfG g = new GfG();
		System.out.println(g.encode(str));
		
      
        T--;
	  }
   }
}

// } Driver Code Ends


class GfG
 {
	String encode(String str)
	{
          //Your code here
          StringBuilder sb = new StringBuilder();
          if(str.length()==1){
              return str+"1";
          }
          
          int j=0;
          while(j<str.length()){
              int n = 1,i=j;
              while(i+1<str.length() && str.charAt(i+1)==str.charAt(i)){
                  n++;
                  i++;
              }
              sb.append(str.charAt(j));
              sb.append(n);
              j=i;
              j++;
          }
    
          return sb.toString();
	}
	
 }