package com.sam.project.createtype.singleton;

/**
 * @ClassName: ThreadSecurity 
 * @Description: java单例模式(双重加锁模式)
 * @author mqx 
 * @date 2017年9月5日 下午2:41:48
 */
public class ThreadSecurity {
	//初始化实例为空，并用volatile修饰
	private volatile static ThreadSecurity instance = null;
	//私有化类构造器
	private ThreadSecurity(){}
	//公有获取实例方法
	public static ThreadSecurity getInstance(){
		if (instance==null) {
			synchronized(ThreadSecurity.class){
				//再次判断实例是否需要创建
				if (instance==null) {
					instance = new ThreadSecurity();
				}
			}
		}
		return instance;
	}
}
