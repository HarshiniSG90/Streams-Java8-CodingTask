package org.interview;

import java.util.*;

public class ConcurrentModificationException {

    public static void main(String args[])
    {
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
       // list1.add(4);

        Iterator<Integer> itr = list1.iterator();
        while(itr.hasNext())
        {
            Integer val = itr.next();//exe
            System.out.println(val+"==");
            if(val.equals(2))
            {
                System.out.println("hello");
               //list1.remove(1);
                itr.remove();
            }
        }
        System.out.println(list1);
        Iterator<Integer> result = list1.iterator();
        while(result.hasNext())
        {
            Integer res = result.next();
            System.out.println(res);
        }

        Map<Integer,Integer> map = new HashMap<>();
        map.put(1,1);
        map.put(2,2);
        map.put(3,3);

        Iterator<Integer> it1 = map.keySet().iterator();
        while(it1.hasNext())
        {
            Integer key = it1.next();
            System.out.println("Map val :"+ map.get(key));
            if(key.equals(2))
            {
                map.put(1,4);
            }
        }

        map.entrySet().stream().forEach(x->{System.out.println(x.getKey()+""+x.getValue());});
    }
}
