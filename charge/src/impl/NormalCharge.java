package impl;

import edu.Charge;
import edu.FormDto;

/**
 * 正常消费
 * @author Administrator
 *
 */
public class NormalCharge implements Charge {

	@Override
	public double charge(FormDto params) {
		return params.getCash();
	}

}
