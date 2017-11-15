package edu;

import util.ChargeUtil;
import impl.DiscountCharge;
import impl.NormalCharge;
import impl.RebateCharge;


public class ChargeService {
	/**
	 * 定义以个抽象接口
	 */
	private Charge 	charge;
	
	/**
	 * 收费实现类换算时所需要的参数
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
	 * 计算，并返回结果
	 * @return 返回的是父类引用了相对于的子类对象
	 */
	public double account(){
		return charge.charge(params);
	}
	 
}
