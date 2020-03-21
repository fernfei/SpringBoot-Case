/**
 * Copyright (C), 2019-2019, XXX有限公司
 * FileName: Test
 * Author:   Administrator
 * Date:     2019/12/7 8:11
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.example.springbootdemo;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/12/7
 * @since 1.0.0
 */
public class Test {
    public static int solve(int n){
        if(n==1) return 1;
        if(n==2) return 2;
        return solve(n-1)+solve(n-2);
    }

    public static int cheng(int Number) {
        if(Number<=0)return 1;
        return Number*cheng(Number-1);
    }
    public static void move(int n,String start,String temp,String target){
        //如果盘数小于等于1直接移动到目标盘符
        if(n<=1){

            System.out.println(start+"--->移动到--->"+target);

            return;
        }

        //先将n-1盘子的移到temp
        move(n-1,start,target,temp);
        //再将最后一个盘子移到target
        System.out.println(start+"--->移动到--->"+target);
        //将在temp的n-1盘子移动到target
        move(n-1,temp,start,target);


    }
    public static void main(String[] args) {
        /*int num=solve(10);
        System.out.println("一共有"+num+"种走法！！！！");*/
        //System.out.println(cheng(4));
        move(8, "中间","左边","右边");

    }
}