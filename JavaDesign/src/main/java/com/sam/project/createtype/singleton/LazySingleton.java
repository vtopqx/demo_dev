package com.sam.project.createtype.singleton;

/**
 * @ClassName: LazySingleton
 * @Description: java单例模式(懒汉模式)
 * @author mqx
 * @date 2017年9月5日 下午2:01:06
 */
public class LazySingleton {
	//"懒汉式"则实例对象实现为空，需要时才创建
	private static LazySingleton instance = null;

	// 私有默认构造子
	private LazySingleton() {
	}

	//获取对象方法
	public static synchronized LazySingleton getInstance() {
		if (instance == null) {
			instance = new LazySingleton();
		}
		return instance;
	}
}
