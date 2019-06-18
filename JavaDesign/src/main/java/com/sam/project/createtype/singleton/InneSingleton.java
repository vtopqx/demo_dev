package com.sam.project.createtype.singleton;

/**
 * @ClassName: InneSingleton
 * @Description: java单例模式(类级内部类模式)
 * @author mqx
 * @date 2017年9月5日 下午2:44:21
 */
public class InneSingleton {
	// 私有默认构造子
	private InneSingleton() {
	}

	// 类级的内部类，也就是静态的成员式内部类，该内部类的实例与外部类的实例 没有绑定关系，而且只有被调用到时才会装载，从而实现了延迟加载。
	private static class SingletonHolder {
		// 静态初始化器，由JVM来保证线程安全
		private static InneSingleton instance = new InneSingleton();
	}

	// 公有获取实例方法
	public static InneSingleton getInstance() {
		return SingletonHolder.instance;
	}
}
