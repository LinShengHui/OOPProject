package edu;

import impl.DiscountCharge;
import impl.NormalCharge;

public class Main {

	public static void main(String[] args) {
		FormDto f = new FormDto();
		//������������
		f.setChargeType("rebate");
		//���ý��
		f.setCash(400);
		//���ô���
		f.setDiscount(0.9);
		//���������
		f.setFullCash(300);
		//���÷���
		f.setReturnCash(100);
		
		ChargeService service = new ChargeService(f);
		double money = service.account();
		System.out.println("ʵ�գ�"+money);
	}
}
