package com.test.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * config Class
 * @author alex
 * 
 * 
 * 这种方式 为 spring 读入配置文件
 * 在  spring-mybatis-config.xml   加入 配置文件
 * 
 * <!-- 引入配置文件 -->
    <bean id="propertyConfigurer"
        class="org.springframework.beans.factory.config.PropertyPlaceholderConfigurer">
        <!--<property name="location" value="classpath:mysql.properties" />  -->
          <property name="locations">
            <list>
               <value>classpath:mysql.properties</value>
               <value>classpath:conf/configInfo.properties</value>
                <!--要是有多个配置文件，只需在这里继续添加即可 -->
            </list>
            </property>
            <property name="fileEncoding"  value="utf-8"  />
    </bean>
 * 
 * 
 *
 */
@Component("configInfo")
public class ConfigInfo {

	@Value("${sysConf_flowModel}")
	private String sysConf_flowModel;
	
	@Value("${expense_filedmapname}")
	private String expense_filedmapname;
	
	/**
	 * Excel's titile name map to itmename in db
	 */
	private Map<String,String> expenseHashMap;
	

	public String getExpense_filedmapname() {
		return expense_filedmapname;
	}


	public String getSysConf_flowModel() {
		return sysConf_flowModel;
	}

	
	

	@Override
	public String toString() {
		return "ConfigInfo [sysConf_flowModel=" + sysConf_flowModel
				+ ", expense_filedmapname=" + expense_filedmapname + "]";
	}
	
	
	/**
	 * get the map of ExpenseFiled,key:chinese, value:fileditem
	 * @return
	 */
	public Map<String,String> getExpenseFiled(){
		if(expenseHashMap == null){
			synchronized(this){
				if(expenseHashMap == null){
					expenseHashMap = new HashMap<String, String>(); 
					String[] mapbeans = expense_filedmapname.split(",");
					for(String mapbean:mapbeans){
						String[] chinese_filed = mapbean.split(":");
						expenseHashMap.put(chinese_filed[0], chinese_filed[1]);
					}
				}
			}
		}
		
		return  expenseHashMap;
	}
	
	
	
	
}
