package com.sam.project.createtype.singleton;

/**
 * @ClassName: EHSingletion
 * @Description: java单例模式(饿汉模式)
 * @author mqx
 * @date 2017年9月5日 下午1:56:58
 */
public class EHSingletion {
	//当类装载的时候就会创建类的实例，先创建出来，然后每次调用的时候，就不需要再判断，节省了运行时间。
	private static EHSingletion obj = new EHSingletion();

	// 私有化对象实例化方法
	private EHSingletion() {
	}
	public static EHSingletion getInstance() {
		return obj;
	}
}
