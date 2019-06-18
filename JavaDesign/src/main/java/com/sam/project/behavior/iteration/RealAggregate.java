package com.sam.project.behavior.iteration;

//具体聚集角色类
public class RealAggregate extends Aggregate {

	private Object[] objArray = null;

	/**
	 * 构造方法，传入聚合对象的具体内容
	 */
	public RealAggregate(Object[] objArray) {
		this.objArray = objArray;
	}

	@Override
	public Iterator createIterator() {
		return new RealIterator(this);
	}

	/**
	 * 取值方法：向外界提供聚集元素
	 */
	public Object getElement(int index) {

		if (index < objArray.length) {
			return objArray[index];
		} else {
			return null;
		}
	}

	/**
	 * 取值方法：向外界提供聚集的大小
	 */
	public int size() {
		return objArray.length;
	}
}
