package com.nowcoder;

/**
 * Created by dell--pc on 2016/8/17.
 */


class MyThread extends Thread{
    private int tid;
    public MyThread(int tid){
        this.tid=tid;
    }

    @Override
    public void run() {
        try{
            for(int i=0;i<10;i++){
                Thread.sleep(1000);
                System.out.println(String.format("%d:%d",tid,i));;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

public class MultiThreadTests {
    public static void testThread(){
        for(int i=0;i<10;i++){
            //new MyThread(i).start();
        }

        for(int i=0;i<10;i++){

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try{
                        for(int j=0;j<10;j++){
                            Thread.sleep(1000);
                            System.out.println(String.format("T2 %d:",j));;
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

    public static Object obj=new Object();
    public static void testSynchronized1(){
        synchronized (obj){
            try{
                for(int j=0;j<10;j++){
                    Thread.sleep(1000);
                    System.out.println(String.format("T3 %d:",j));;
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    public static void testSynchronized2(){
        synchronized (new Object()){
            try{
                for(int j=0;j<10;j++){
                    Thread.sleep(1000);
                    System.out.println(String.format("T4 %d:",j));;
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void testSynchronized(){
        for(int i=0;i<10;i++){
        new Thread(new Runnable() {
            @Override
            public void run() {
                testSynchronized1();
                testSynchronized2();
            }
        }).start();}
    }

    public static void main(String[] argv){
        testSynchronized();
    }
}
