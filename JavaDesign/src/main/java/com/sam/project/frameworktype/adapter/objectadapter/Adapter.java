package com.sam.project.frameworktype.adapter.objectadapter;

//适配器类
public class Adapter {

	//关联组合对象
	private OtherObject otherObject;

	public Adapter(OtherObject otherObject) {
		this.otherObject = otherObject;
	}

	/**
	 * 源类Adaptee有方法method1 因此适配器类直接委派即可
	 */
	public String method1() {
		return this.otherObject.method1();
	}

	// 适配器类需要补充此方法
	public void method2() {
		// TODO Auto-generated method stub

	}
}
