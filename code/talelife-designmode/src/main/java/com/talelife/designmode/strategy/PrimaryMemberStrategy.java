package com.talelife.designmode.strategy;

public class PrimaryMemberStrategy implements MemberStrategy {

	public double calcPrice(double marketPrice) {
		return marketPrice*0.8;
	}

}
