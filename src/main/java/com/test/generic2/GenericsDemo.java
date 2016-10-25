package com.test.generic2;



interface Info<T> { // �ڽӿ��϶��巺��  
    public T getVar(); // ������󷽷������󷽷��ķ���ֵ���Ƿ�������  
}

class InfoImpl<T> implements Info<T> { // ���巺�ͽӿڵ�����  
    private T var; // ��������  

    public InfoImpl(T var) { // ͨ�����췽��������������  
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
 * @Desc  ���ͽӿ�
 * @author alex
 * @date 2016��10��21�� ����4:45:36
 * @version 
 */
public class GenericsDemo {
    
    public static void main(String arsg[]){  
        Info i = null;      // �����ӿڶ���  
        i = new InfoImpl("���˻�") ;   // ͨ������ʵ��������  
        System.out.println("���ݣ�" + i.getVar()) ;  
    }  
}




/**
 * Revision history
 * -------------------------------------------------------------------------
 * 
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2016��10��21�� alex creat
 */