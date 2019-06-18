package com.sam.project.frameworktype.combination;

//超市会员卡积分抽象类
public abstract class MarketCommon {
	private String name;
	//积分
	private long cardScore;
	
	public void add(MarketCommon m){}
	public void remove(MarketCommon m){}
	public void pay(){}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getCardScore() {
		return cardScore;
	}
	public void setCardScore(long cardScore) {
		this.cardScore = cardScore;
	}
}
