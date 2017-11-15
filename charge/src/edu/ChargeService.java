package edu;

import util.ChargeUtil;
import impl.DiscountCharge;
import impl.NormalCharge;
import impl.RebateCharge;


public class ChargeService {
	/**
	 * �����Ը�����ӿ�
	 */
	private Charge 	charge;
	
	/**
	 * �շ�ʵ���໻��ʱ����Ҫ�Ĳ���
	 */
	private FormDto params;
	
	public ChargeService(FormDto params) {
		this.params = params;
		ChargeUtil cutil = new ChargeUtil();
		
		try {
			charge = (Charge)Class.forName(cutil.getProper(params.getChargeType())).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Class not found",e);
		}
	}
	/**
	 * ���㣬�����ؽ��
	 * @return ���ص��Ǹ�������������ڵ��������
	 */
	public double account(){
		return charge.charge(params);
	}
	 
}
