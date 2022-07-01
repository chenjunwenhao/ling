package com.faq.utils;

import java.util.*;

public class Abt {
    public static void main(String[] args) {
        int a1 = 1;
        Integer b1 = 200;
        String c1 = "3";
        StringBuilder c2 = new StringBuilder("4");
        StringBuilder c3 = new StringBuilder("444");
        List list = new ArrayList();
        list.add("!");
        Map map = new HashMap();
        map.put("d1","d1");
        map.put("d2",1);

        List list2222 = new List() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public boolean add(Object o) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean addAll(Collection c) {
                return false;
            }

            @Override
            public boolean addAll(int index, Collection c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public boolean equals(Object o) {
                return false;
            }

            @Override
            public int hashCode() {
                return 0;
            }

            @Override
            public Object get(int index) {
                return null;
            }

            @Override
            public Object set(int index, Object element) {
                return null;
            }

            @Override
            public void add(int index, Object element) {

            }

            @Override
            public Object remove(int index) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator listIterator() {
                return null;
            }

            @Override
            public ListIterator listIterator(int index) {
                return null;
            }

            @Override
            public List subList(int fromIndex, int toIndex) {
                return null;
            }

            @Override
            public boolean retainAll(Collection c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection c) {
                return false;
            }

            @Override
            public boolean containsAll(Collection c) {
                return false;
            }

            @Override
            public Object[] toArray(Object[] a) {
                return new Object[0];
            }
        };
        list2222.size();
        c(a1,b1,c1,map,c2,c3,list);
        System.out.printf("111");
    }
    public static void c(int a ,Integer b,String c,Map map,StringBuilder c2,StringBuilder c3
    ,List list
    ){
        a = 4;
        b =200;
        c = "4";
        String[] cc = c.split("");
        c2.append("111111122222");
        map.put("d1","d4");
        map.put("d2",4);
        list = Arrays.asList(c.split(""));
    }
}

