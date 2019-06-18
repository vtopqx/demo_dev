package com.sam.project.frameworktype.adapter.classadapter;

//适配器类
public class Adapter extends OtherObject implements TargetInterface {
	// 适配器实现OtherObject未实现的方法
	@Override
	public String method2() {
		return "";
	}
	
	public static void main(String[] args) {
		Adapter a = new Adapter();
		a.method1();
		a.method2();
	}
}
