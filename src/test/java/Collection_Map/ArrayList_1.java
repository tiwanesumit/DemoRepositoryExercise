package Collection_Map;

import java.util.ArrayList;

public class ArrayList_1 {
	
	
	public static void main(String[] args)
    {
  
        ArrayList<Integer> al = new ArrayList<Integer>();
  
        for (int i = 1; i <= 5; i++)
            al.add(i);
  

        System.out.println(al);
  
        
        for (int i = 0; i < al.size(); i++)
            System.out.print(al.get(i) + " ");
    }

}
