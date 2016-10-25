package com.test.reflectiondemo;

import java.lang.reflect.Method;

/**
 * 反射类util
 * @author alex
 *
 */
public class ReflectUtil {
	
	
	/**
	 * 
	 * @param filedName
	 * @param values
	 * @param clzss
	 * @return
	 * @throws Exception
	 */
    public static  <T> T bindDataToDTO(String [] filedName, String [] values,Class<T> clzss) throws Exception { 
    	System.setProperty("file.encoding", "UTF-8");
    	Object o = clzss.newInstance();
    	Method[] methods = clzss.getMethods(); 
    	
    	 for (int i = 0; i < filedName.length; i++) {   
             //取得Set方法   
             String setMethodName = "set" + filedName[i];   
             //遍历Method   
             for (int j = 0; j < methods.length; j++) {   
                 if (methods[j].getName().equalsIgnoreCase(setMethodName)) {   
                     setMethodName = methods[j].getName();   
                     if(values[i] == null)//无数据
                     	break;
                     //实行Set方法   
                     try {   
                         //JavaBean内部属性和ResultSet中一致时候   
                         Method setMethod = clzss.getMethod(setMethodName, values[i].getClass());   
                         setMethod.invoke(o, values[i]); 
                         break;
                     } catch (Exception e) {
                         Method setMethod = clzss.getMethod(setMethodName, String.class);   
                         setMethod.invoke(o, values[i].toString());   
                     }   
                 }   
             }   
         } 
    	
//    	return o;
    	 return  clzss.cast(o);
    }  
    
    
    public static void main (String[] args){
        String [] items ={"name","password"};
        String [] values ={"alexi","123456"};
        String [] values2 ={"alexi2","123456"};
        String [] values3 ={"alexi3","123456"};
        String [] values4 ={"alexi4","123456"};
        
        try {
            Person person = ReflectUtil.bindDataToDTO(items, values, Person.class);
            Person person2 = ReflectUtil.bindDataToDTO(items, values2, Person.class);
            Person person3 = ReflectUtil.bindDataToDTO(items, values3, Person.class);
            Person person4 = ReflectUtil.bindDataToDTO(items, values4, Person.class);
            System.out.println(person.toString());
            System.out.println(person2.toString());
            System.out.println(person3.toString());
            System.out.println(person4.toString());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
    
    
    
    
    
}
