package com.faq.utils;

public class CreateThread implements Runnable {
    @Override
    public void run (){
        for (int i = 0; i < 10; i++) {
            System.out.printf("i:"+i );
            System.out.printf("\n" );
        }
    }
    CreateThread(){
        super();
    }
}

class TextThread {
    public static void main(String[] args) {
        System.out.printf("线程开始-----------\n" );
        CreateThread createThread = new CreateThread();
        Thread demo = new Thread(createThread);
        System.out.printf("线程启动-----------\n" );
        demo.start();
        System.out.println(demo.getName());
        System.out.println(demo.getId());
        System.out.printf("线程结束-----------\n" );
    }
}
