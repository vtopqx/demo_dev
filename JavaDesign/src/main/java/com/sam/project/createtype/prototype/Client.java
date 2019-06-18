package com.sam.project.createtype.prototype;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: Client 
 * @Description: java设计模式(原型模式)
 * @author mqx 
 * @date 2017年9月25日 下午3:31:03
 */
public class Client {
	
	//设置个实例对象缓存
	private static Map<String, Prototype> cacheMap = new HashMap<String, Prototype>();
	
	//测试
	public static void main(String[] args) {
		//初始化待克隆创建对象
		loadCache();

		//分别进行各对象实例进行创建
		Instance1 clonedInstance1 = (Instance1) getProto("1");
		System.out.println("Prototype : " + clonedInstance1.getType());

		Instance2 clonedInstance2 = (Instance2) getProto("2");
		System.out.println("Prototype : " + clonedInstance2.getType());
	}

	/**
	 * @Description: 根据不同实例ID进行克隆
	 * @param shapeId 实例编号
	 * @return
	 */
	public static Prototype getProto(String shapeId) {
		Prototype cachedProto = cacheMap.get(shapeId);
		return (Prototype) cachedProto.clone();
	}

	 
	// 例如，我们要添加三种形状
	public static void loadCache() {
		Instance1 obj1 = new Instance1();
		obj1.setId("1");
		cacheMap.put(obj1.getId(), obj1);

		Instance2 obj2 = new Instance2();
		obj2.setId("2");
		cacheMap.put(obj2.getId(), obj2);
	}
}
