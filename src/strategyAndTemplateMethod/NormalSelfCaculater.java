package strategyAndTemplateMethod;
/**
 * 模板方式--子類
 * @author junezh
 *
 */
public class NormalSelfCaculater extends SelfCaculater {

	@Override
	double getSelfEndowmentInsurance(double salary) {

		return (getRealSalary1Basic(salary) * 8 / 100);
	}

	@Override
	double getSelfUnEmployedInsurance(double salary) {
		// TODO Auto-generated method stub
		return (getRealSalary1Basic(salary) * 0.2 / 100);
	}

	@Override
	double getSelfHispitalInsurance(double salary) {
		// TODO Auto-generated method stub
		return (getRealSalary2Basic(salary) * 2 / 100 + 3);
	}

	@Override
	double getHouseFund(double salary) {
		return (getRealSalary1Basic(salary) * 12 / 100);
	}
	
	
	@Override
	double getRealSalary2Basic(double salary) {
		  if(salary <= IConstants.HOSPITAL_MATERNIYT_INJURY_MIN_BASIC){
			  return IConstants.HOSPITAL_MATERNIYT_INJURY_MIN_BASIC;
		  }else if(salary >= IConstants.HOSPITAL_MATERNIYT_INJURY_MAX_BASIC){
			  return IConstants.HOSPITAL_MATERNIYT_INJURY_MAX_BASIC;
		  }else{
			  return salary;
		  }
		  
	}

	
	  /**
	   * 真正的工傷，醫療，生育保險基數
	   * @param salary
	   * @return
	   */
		@Override
	  public double getRealSalary1Basic(double salary){
		  if(salary <= IConstants.ENDOWMENT_NOEMPLYED_MIN_BASIC){
			  return IConstants.ENDOWMENT_NOEMPLYED_MIN_BASIC;
		  }else if(salary >= IConstants.ENDOWMENT_NOEMPLYED_MAX_BASIC){
			  return IConstants.ENDOWMENT_NOEMPLYED_MAX_BASIC;
		  }else{
			  return salary;
		  }
		  
	  }
}
