package com;

import java.io.BufferedReader;  
import java.io.IOException;  
import java.io.InputStream;  
import java.io.InputStreamReader;  
  
/**
 * @ClassName: DynamicDownLoad 
 * @Description: java根据url生成图片
 * @author mqx 
 * @date 2017年7月10日 下午5:58:20
 */
public class DynamicDownLoad {  
    
	/**
	 * @Description: 根据传入的url，调用phantomjs进行下载，并返回源码信息 
	 * @param url
	 * @return
	 */
    public static String getSrcContent(String url){  
        //windows下phantomjs位置  
//        String path = "D:/phantomjs-2.1.1-windows/bin/";  
        Runtime rt = Runtime.getRuntime();  
        Process process = null;  
        try {  
        	String cmd = "D:/phantomjs-2.1.1-windows/bin/phantomjs D:/phantomjs-2.1.1-windows/examples/rasterize.js " + url.trim() +" D:/phantomjs-2.1.1-windows/bin/hao1233.png";
            process = rt.exec(cmd);  
            System.out.println("生成成功!");
        } catch (IOException e) {  
            // TODO 这里写异常处理的代码  
            e.printStackTrace();  
        }  
        InputStream is = process.getInputStream();  
        BufferedReader br = new BufferedReader(new InputStreamReader(is));  
        StringBuffer sbf = new StringBuffer();  
        String tmp = "";  
        try {  
            while((tmp = br.readLine())!=null){    
                sbf.append(tmp);    
            }  
        } catch (IOException e) {  
            // TODO 这里写异常处理的代码  
            e.printStackTrace();  
        }  
          
        return sbf.toString();  
    }  
      
      
      
    /**
     * @Description: test
     * @param args
     */
    public static void main(String[] args){  
        // TODO Auto-generated method stub  
    	String src = DynamicDownLoad.getSrcContent("http://blog.csdn.net/xxx9001/article/details/52515719");  
        System.out.println(src);  
    }  
  
}  