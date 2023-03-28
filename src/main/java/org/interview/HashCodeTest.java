package org.interview;

import java.util.SortedMap;

public class HashCodeTest {

    public static void main(String args[])
    {
        HashCodeTest hs = new HashCodeTest();
        HashCodeTest hs1 = new HashCodeTest();
        HashCodeTest hs2 = new HashCodeTest();

        System.out.println(hs.hashCode());
        System.out.println(hs1.hashCode());
        System.out.println(hs2.hashCode());

        System.out.println(System.identityHashCode(hs));
        System.out.println(System.identityHashCode(hs1));
        System.out.println(System.identityHashCode(hs2));

    }

    @Override
    public int hashCode() {
        return 1;
    }
}
