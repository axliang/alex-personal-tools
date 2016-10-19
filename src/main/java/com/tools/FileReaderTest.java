package com.tools;



import java.io.File;
import java.io.FilenameFilter;

public class FileReaderTest {

	
	
	    public static void main(String[] args) {
	        //C:盘下的所有文件，包括文件夹
	        String[] filenames = new File("E:/Workspaces/MyEclipse 8.5/its5H_task/WebRoot/WEB-INF/lib/").list();
//	        String[] filenames = new File("E:/Workspaces/").list();
//	        String[] filenames = new File("C:/").list();
	        
	        
	        for(int j=0;j<filenames.length;j++){
	        	  System.out.println(filenames[j]);
	        	
	        }
	      
//	        //C:盘下后缀名为txt的文件
//	        String[] filenames2 = new File("C:/").list(new FilenameFilter() {
//	            public boolean accept(File dir, String name) {
//	                return name.endsWith(".txt");
//	            }
//	        });
//	        //C:盘下所有目录
//	        String[] filenames3 = new File("C:/").list(new FilenameFilter() {
//	            public boolean accept(File dir, String name) {
//	                return new File(dir, name).isDirectory();
//	            }
//	        });
	    }
	

}
