package impl;

import edu.Charge;
import edu.FormDto;

/**
 * ��������
 * @author Administrator
 *
 */
public class NormalCharge implements Charge {

	@Override
	public double charge(FormDto params) {
		return params.getCash();
	}

}
