package com.test.generic2;


/**
 * <T>  泛型标识
 *  T  返回类型
 *  T  传入参数类型
 * @author alex
 *
 */
class Demo{  
    public <T> T fun(T t){            // 可以接收任意类型的数据  
        return t ;                  // 直接把参数返回  
    }  
};  

/**
 * @Type GenericsDemo26.java
 * @Desc 2.1定义泛型方法
 * @author alex
 * @date 2016年10月21日 下午5:02:41
 * @version 
 */
public class GenericsDemo26{  
    public static void main(String args[]){  
        Demo d = new Demo() ;   // 实例化Demo对象  
        String str = d.fun("李兴华") ; //  传递字符串  
        int i = d.fun(30) ;     // 传递数字，自动装箱  
        System.out.println(str) ;   // 输出内容  
        System.out.println(i) ;     // 输出内容  
    }  
};  

/**
 * Revision history
 * -------------------------------------------------------------------------
 * 
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2016年10月21日 alex creat
 */