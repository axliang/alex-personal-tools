package com.test.generic2;



interface Info<T> { // 在接口上定义泛型  
    public T getVar(); // 定义抽象方法，抽象方法的返回值就是泛型类型  
}

class InfoImpl<T> implements Info<T> { // 定义泛型接口的子类  
    private T var; // 定义属性  

    public InfoImpl(T var) { // 通过构造方法设置属性内容  
        this.setVar(var);
    }

    public void setVar(T var) {
        this.var = var;
    }

    public T getVar() {
        return this.var;
    }
};


/**
 * @Type GenericsDemo.java
 * @Desc  泛型接口
 * @author alex
 * @date 2016年10月21日 下午4:45:36
 * @version 
 */
public class GenericsDemo {
    
    public static void main(String arsg[]){  
        Info i = null;      // 声明接口对象  
        i = new InfoImpl("李兴华") ;   // 通过子类实例化对象  
        System.out.println("内容：" + i.getVar()) ;  
    }  
}




/**
 * Revision history
 * -------------------------------------------------------------------------
 * 
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2016年10月21日 alex creat
 */