package edu;

import impl.DiscountCharge;
import impl.NormalCharge;

public class Main {

	public static void main(String[] args) {
		FormDto f = new FormDto();
		//设置消费类型
		f.setChargeType("rebate");
		//设置金额
		f.setCash(400);
		//设置打折
		f.setDiscount(0.9);
		//设置满额度
		f.setFullCash(300);
		//设置反额
		f.setReturnCash(100);
		
		ChargeService service = new ChargeService(f);
		double money = service.account();
		System.out.println("实收："+money);
	}
}
