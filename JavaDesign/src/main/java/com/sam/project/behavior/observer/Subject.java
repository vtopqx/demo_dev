package com.sam.project.behavior.observer;

import java.util.ArrayList;
import java.util.List;

//抽象主题抽象类
public abstract class Subject {
	// 观察者集合
	private List<Observer> list = new ArrayList<Observer>();

	// 添加观察者
	public void register(Observer observer) {
		list.add(observer);
	}
	//删除
	public void remove(Observer observer) {
		if (list.contains(observer)) {
			list.remove(observer);
		}
	}

	public void change(String status) {
		this.notifyObserver(status);
	}
	//通知所有观察者
	private void notifyObserver(String status) {
		for (Observer observer : list) {
			observer.update(status);
		}
	}
}
