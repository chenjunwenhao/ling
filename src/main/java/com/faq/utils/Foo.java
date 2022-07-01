package com.faq.utils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Foo {

    public static void main(String ards[]){
//        for(int i=0;i<10;i++){
//            new ExtendsThread().start();
//        }
        new Foo().bibao(1);
        System.out.println(ards);
        for (String s : ards){
            System.out.println(s);
        }
        int ste = Test.stame;
 //       System.out.println(Thread.currentThread().getName()+"sjsjsjsjssjsjsjsjsjsjsj");
        LinkedList linkedList = new LinkedList();
        linkedList.clear();
                List<?> list = new ArrayList<>();
    }
    public void bibao(int i){
        if (i< 10) {
            System.out.println(i);
            i++;
            bibao(i);
        }
        return ;
    }

    public static class ExtendsThread extends Thread{
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }
    }
}
