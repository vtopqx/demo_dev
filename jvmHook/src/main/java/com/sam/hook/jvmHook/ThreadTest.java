package com.sam.hook.jvmHook;

import java.util.Date;


/**
 * @ClassName: ThreadTest 
 * @Description: jvm 钩子处理程序
 * @author mqx 
 * @date 2017年7月24日 下午4:15:01
 */
public class ThreadTest implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("jvm 停止前钩子处理");
	}

	
	public static void main(String[] args) {
		try {
			ThreadTest thread = new ThreadTest();
			Thread hook = new Thread(thread);
			//注册钩子
			Runtime.getRuntime().addShutdownHook(hook);
			
			int index = 0;
			while (index < 50) {
				System.out.println("线程执行中:"+new Date());
				Thread.sleep(1000);
				index ++;
				
				//当出现异常时处理
				if (index==30) {
					Integer.valueOf("涨");
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
