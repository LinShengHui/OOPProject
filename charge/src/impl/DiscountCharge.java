package impl;

import edu.Charge;
import edu.FormDto;

/**
 * ����
 * @author Administrator
 *
 */
public class DiscountCharge implements Charge {

	@Override
	public double charge(FormDto params) {
		return params.getCash()*params.getDiscount();
	}

}
