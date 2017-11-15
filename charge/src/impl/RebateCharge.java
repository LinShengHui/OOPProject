package impl;

import edu.Charge;
import edu.FormDto;

/**
 * ·µÏÖ
 * @author Administrator
 *
 */
public class RebateCharge implements Charge {

	@Override
	public double charge(FormDto params) {
		if(params.getCash()>=params.getFullCash()){
			return params.getCash()-params.getCash()/params.getFullCash()*params.getReturnCash();
		}
		return params.getCash();
	}

}
