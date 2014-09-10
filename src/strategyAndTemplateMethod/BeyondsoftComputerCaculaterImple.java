package strategyAndTemplateMethod;
/**
 * 策略方式-接口實現類
 * @author junezh
 *
 */
public class BeyondsoftComputerCaculaterImple implements IComputerCaculater {

	
	
	private double beyondsoftHouseBasic ;
	
	private double beyondsoftEndowmentBasic ;
	
	
	private double beyondsoftHospitalBasic ;
	
	
	BeyondsoftComputerCaculaterImple(double beyondsoftEndowmentBasic,double beyondsoftHouseBasic,double beyondsoftHospitalBasic){
		this.beyondsoftHouseBasic = beyondsoftHouseBasic;
		this.beyondsoftEndowmentBasic = beyondsoftEndowmentBasic;
		this.beyondsoftHospitalBasic = beyondsoftHospitalBasic;
		
	}
	
	@Override
	public double getHouseFund(double salary) {
		// TODO Auto-generated method stub
		return (getHouseFundBasic(salary) * 12 /100);
	}

	@Override
	public double getEndowmentInsurance(double salary) {
		// TODO Auto-generated method stub
		return (getRealSalary1Basic(salary) * 20 /100);
	}

	@Override
	public double getUnEmployedInsurance(double salary) {
		// TODO Auto-generated method stub
		return (getRealSalary1Basic(salary) * 1 /100);
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
		  }else if(salary >= beyondsoftHospitalBasic){
			  return beyondsoftHospitalBasic;
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
		  }else if(salary >= beyondsoftEndowmentBasic){
			  return beyondsoftEndowmentBasic;
		  }else{
			  return salary;
		  }
		  
	  }
	  
	  
	  public double getHouseFundBasic(double salary){
		  if(salary <= IConstants.ENDOWMENT_NOEMPLYED_MIN_BASIC){
			  return IConstants.ENDOWMENT_NOEMPLYED_MIN_BASIC;
		  }else if(salary >= beyondsoftHouseBasic){
			  return beyondsoftHouseBasic;
		  }else{
			  return salary;
		  }
		  
	  }

	public double getBeyondsoftHouseBasic() {
		return beyondsoftHouseBasic;
	}

	public void setBeyondsoftHouseBasic(double beyondsoftHouseBasic) {
		this.beyondsoftHouseBasic = beyondsoftHouseBasic;
	}

	public double getBeyondsoftHospitalBasic() {
		return beyondsoftHospitalBasic;
	}

	public void setBeyondsoftHospitalBasic(double beyondsoftHospitalBasic) {
		this.beyondsoftHospitalBasic = beyondsoftHospitalBasic;
	}
	  
	  
}
