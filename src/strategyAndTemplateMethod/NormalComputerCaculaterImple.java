package strategyAndTemplateMethod;
/**
 * 策略方式-接口實現類
 * @author junezh
 *
 */
public class NormalComputerCaculaterImple implements IComputerCaculater {

	@Override
	public double getHouseFund(double salary) {
		// TODO Auto-generated method stub
		return (getRealSalary2Basic(salary) * 12 /100);
	}

	@Override
	public double getEndowmentInsurance(double salary) {
		// TODO Auto-generated method stub
		return (getRealSalary2Basic(salary) * 20 /100);
	}

	@Override
	public double getUnEmployedInsurance(double salary) {
		// TODO Auto-generated method stub
		return (getRealSalary2Basic(salary) * 1 /100);
	}

	@Override
	public double getHispitalInsurance(double salary) {
		// TODO Auto-generated method stub
		return (getRealSalary2Basic(salary) * 10 /100);
	}

	@Override
	public double getInjuryInsurance(double salary) {
		// TODO Auto-generated method stub
		return (getRealSalary2Basic(salary) * 0.8 /100);
	}

	@Override
	public double getmaternityInsurance(double salary) {
		// TODO Auto-generated method stub
		return (getRealSalary2Basic(salary) * 0.8 /100);
	}


	
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
