package com.sam.project.frameworktype.combination;

import java.util.ArrayList;
import java.util.List;

public class MarketBranchScore extends MarketCommon {
	public MarketBranchScore(String name) {
		super.setName(name);
	}
	//记录各个分店信息
	private List<MarketCommon> branchList = new ArrayList<MarketCommon>();
	
	public void add(MarketCommon m) {
		branchList.add(m);
	}

	public void remove(MarketCommon m) {
		branchList.remove(m);
	}

	public void pay() {
		for (MarketCommon card : branchList) {
			System.out.println(card.getName()+"消费累计积分："+card.getCardScore());
		}
	}
}
