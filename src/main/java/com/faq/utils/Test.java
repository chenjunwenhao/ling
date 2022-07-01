package com.faq.utils;

import com.faq.entity.User;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class Test {
     final  public static int stame = 1;
     ThreadLocal threadLocal1 = new ThreadLocal();
     ThreadLocal threadLocal2 = new ThreadLocal();

    public ThreadLocal getThreadLocal1() {
        return threadLocal1;
    }

    public void setThreadLocal1(ThreadLocal threadLocal1) {
        this.threadLocal1 = threadLocal1;
    }

    private int id;
      public  static void  main(String[] args) throws Throwable {

//          JdbcTemplate
          Linklist linklist2 = new Linklist();
          LinkedList linkedList = new LinkedList();
          linklist2.addAtIndex(0,1);
          linklist2.addAtIndex(1,2);
          linklist2.addAtIndex(2,3);

          linklist2.rever();
          ThreadLocal threadLocal1 = new ThreadLocal();
          threadLocal1.get();
          ThreadLocal threadLocal2 = new ThreadLocal();
          FutureTask futureTask = new FutureTask(new Callable() {
              @Override
              public Integer call() throws Exception {
                  return 1;
              }
          });
          new Thread(futureTask).start();
          futureTask.isDone();
          int a1 = 1;
          int a2 = a1;
          Integer b1 = 200;
          User user = new User();
          User user2 =(User) user.clone();
          User user3 = user;
          user.setPwd("1111");
          user2.setId(1);
          Integer b2 = b1;
          Integer integer1 = new Integer(100);
          Integer integer2 = new Integer(100);
          System.out.printf(String.valueOf(integer1==integer2));
          b1++;
        System.out.println("jdjkj233r".charAt(2));
        List<String> list = new ArrayList();
          Iterator<String> iterator = list.iterator();
          while (iterator.hasNext()){
              String s = iterator.next();
              iterator.remove();
          }
        Test test =new Test();
          System.out.printf(String.valueOf(10<<1));
          System.out.printf(String.valueOf(9>>1));
          System.out.printf(String.valueOf(3/2));
          System.out.printf(String.valueOf(1/2));
          System.out.printf(String.valueOf(-3/2));
        int jiecheng = test.foo(4);
        list.add("a");
        list.add("b");
        list.add("b");
        list.add("c");
        list.remove("b");
        System.out.printf(list.toString() );
        for (int i = list.size()-1; i >=0; i--) {
            if("b".equals(list.get(i))){
                list.remove(i);
            }
        }
        System.out.printf(list.toString() );
        int arr[] ={3,2,4,6};
        int targ =9;
        int searcharr[] = {5,8,9,13,15};
        int searchtarget = 13;
        for (int i = 0; i <arr.length ; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("===============================");
        int insertarrArr[] = {1,2,4,5};
        int insertarrNum = 3;
        int inserarrNewarr[] = test.insertarr(insertarrArr,insertarrNum);
        System.out.printf("插入后的数组");
        for (int i = 0; i < inserarrNewarr.length; i++) {
            System.out.printf(","+inserarrNewarr[i] );
        }
        System.out.println("\n===============================");
        test.mappao(arr);
        for (int i = 0; i <arr.length ; i++) {
            System.out.println(arr[i]);
        }

        System.out.println(test.search(searcharr,searchtarget));
        test.selectionSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println(test.twoSum(arr,targ)[0]+","+test.twoSum(arr,targ)[1]);

        Linklist linklist = new Linklist();
        //throw new Throwable();
    }
    /**
     *输入{3,2,4,6}，9
     * 输出 {0，3}
     *
     * 两数字之和
     */
    public int[] twoSum(int[] nums, int target) {
        int res[]=new int[2];
        for(int i=0;nums.length>i;i++){
            for(int j=i+1;nums.length>j;j++){
                if(nums[i]+nums[j]==target){
                    res[0] =i;
                    res[1] =j;
                }
            }
        }
        return res;
    }
     static int i = 1;
    public static int foo(int n){
        if(n==1){
            return 1;
        } else {
            return foo(n-1)*n;
        }
    }
     /**
      * 输入{3,2,4,6}
      * 输出 {6,4.3,2}
      *
      * 冒泡排序
      */
     public int[] mappao(int[] nums) {
         int temp;
         for ( int i = 1; i <nums.length ; i++) {// 次数 ：长度-1  3
             for ( int j = 0; j < nums.length-i; j++) {// 比到几：3
                 if(nums[j]<nums[j+1]) {
                     temp = nums[j];
                     nums[j] = nums[j+1];
                     nums[j+1] = temp;
                 }
             }
         }
         return nums;
     }
     /**
      * @param arr
      * @return 选择排序, 输出升序结果
      */
     public  void selectionSort(int[] arr) {
         int length = arr.length;
         int min, tmp;
         // 总共要经过 N-1 轮比较
         for (int i = 0; i < length - 1; i++) {
             min = i;
             // 每轮需要比较的次数 N-i
             for (int j = i + 1; j < length; j++) {
                 //若是需要输出降序结果，则把下面的 < 改为 > 即可
                 if (arr[j] > arr[min]) {
                     // 记录目前能找到的最小值元素的下标
                     min = j;
                 }
             }
             // 将找到的最小值和i位置所在的值进行交换
             if (min != i) {
                 tmp = arr[min];
                 arr[min] = arr[i];
                 arr[i] = tmp;
             }
         }
         return ;
     }

    /**
     * 二分查找
     *
     * 输入 {5,8,9,13,15},13
     *
     * 输出 3 (数组的下标)
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int low =0;
        int high =nums.length-1;
        int middle=0;
        if(target<nums[0]||target>nums[high]){
            return -1;
        }
        while (low<=high) {
            middle = (low+high)/2;
            if(nums[middle]<target){
                low = middle+1;
            }else if (nums[middle]>target) {
                high = middle-1;
            }else {
                return middle;
            }
        }
        return -1;

    }

     /**
      * 输入一个数组，和一个数，插入指定索引，
      * @param arr
      * @param num
      * @return
      */
     public int[] insertarr(int[] arr,int num) {
         int[] fristarr = new int[arr.length+1];
         int[] lastarr = new int[arr.length+1-num];
         boolean flag = false;
         for (int i = 0; i < arr.length; i++) {
             if(!flag){
                 fristarr[i] = arr[i];
             }else{
                 lastarr[i-num+1] = arr[i];
             }
             if(i+1==num){
                 fristarr[i] = num;
                 flag = true;
                 lastarr[0] = arr[i];
             }
         }
         for (int i = 0; i < fristarr.length; i++) {
             if(num<=i){
                 fristarr[i] = lastarr[i-num];
             }
         }
         return fristarr;
     }
 }
