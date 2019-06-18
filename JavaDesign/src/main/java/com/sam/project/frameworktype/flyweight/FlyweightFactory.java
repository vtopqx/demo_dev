package com.sam.project.frameworktype.flyweight;

import java.util.HashMap;
import java.util.Map;

//享元工厂角色类
public class FlyweightFactory {

	Map<Character, Flyweight> map = new HashMap<Character, Flyweight>();

	public Flyweight create(Character status) {
		// 先从缓存中查找对象
		if (map.containsKey(status)) {
			return map.get(status);
		} else {
			Flyweight obj = new RealFlyweight(status);
			map.put(status, obj);
			return obj;
		}
	}
}
