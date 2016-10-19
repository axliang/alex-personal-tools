package com.tools;

import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

/**
 * ������util
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
    public static Object bindDataToDTO(String [] filedName, String [] values,Class clzss) throws Exception { 
    	System.setProperty("file.encoding", "UTF-8");
    	Object o = clzss.newInstance();
    	Method[] methods = clzss.getMethods(); 
    	
    	 for (int i = 0; i < filedName.length; i++) {   
             //ȡ��Set����   
             String setMethodName = "set" + filedName[i];   
             //����Method   
             for (int j = 0; j < methods.length; j++) {   
                 if (methods[j].getName().equalsIgnoreCase(setMethodName)) {   
                     setMethodName = methods[j].getName();   
                     if(values[i] == null)//�����
                     	break;
                     //ʵ��Set����   
                     try {   
                         //JavaBean�ڲ����Ժ�ResultSet��һ��ʱ��   
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
    	return o;
    }  
	
	
	
	
	
	/**  
     * ��ResultSet�󶨵�JavaBean  
     *   
     * @param ResultSet  
     * @param DTO��JavaBean��  
     * @return DTO  
     */   
    public static List bindDataToDTO(ResultSet rs, Class clzss) throws Exception { 
    	System.setProperty("file.encoding", "UTF-8");
    	List obList = new ArrayList();
        //ȡ��Method����   
        Method[] methods = clzss.getMethods();  
  
        //ȡ��ResultSet������   
        ResultSetMetaData rsmd = rs.getMetaData();   
        int columnsCount = rsmd.getColumnCount();   
        String[] columnNames = new String[columnsCount];   
        for (int i = 0; i < columnsCount; i++) {   
            columnNames[i] = rsmd.getColumnLabel(i + 1);   
        }  
        long start_time = System.currentTimeMillis();

        System.out.println("����ʼ��������");
        //����ResultSet   
        int k=1;
        while (rs.next()) {  
        	System.out.println("����"+k);
        	Object o = clzss.newInstance();
            //����, ��ResultSet�󶨵�JavaBean   
            for (int i = 0; i < columnNames.length; i++) {   
                //ȡ��Set����   
                String setMethodName = "set" + columnNames[i];   
                //����Method   
                for (int j = 0; j < methods.length; j++) {   
                    if (methods[j].getName().equalsIgnoreCase(setMethodName)) {   
                        setMethodName = methods[j].getName();   
                       Object value = rs.getObject(columnNames[i]);

                        if(value==null)//�����
                        	break;
                        //ʵ��Set����   
                        try {   
                            //JavaBean�ڲ����Ժ�ResultSet��һ��ʱ��   
                            Method setMethod = clzss.getMethod(   
                                    setMethodName, value.getClass());   
                            setMethod.invoke(o, value); 
                            break;
                        } catch (Exception e) {
                            //JavaBean�ڲ����Ժ�ResultSet�в�һ��ʱ��ʹ��String������ֵ��
                            Method setMethod = clzss.getMethod(   
                                    setMethodName, String.class);   
                            setMethod.invoke(o, value.toString());   
                        }   
                    }   
                }   
            }  
            obList.add(o);
            k++;
        }  
        System.out.println("�����������");
        long end_time = System.currentTimeMillis();
        System.out.println("��ʱ��      "+(end_time-start_time)+" ms");
        rs.close();
        return obList;   
    }  
    
    
}
