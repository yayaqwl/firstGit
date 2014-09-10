package strategyAndTemplateMethod;
/**
 * 模板方式--子類
 * @author junezh
 *
 */
public class BeyondsoftSelfCaculater extends SelfCaculater {
	
	
	private double beyondsoftHouseBasic ;
	
	private double beyondsoftEndowmentBasic ;
	
	
	private double beyondsoftHospitalBasic ;
	
	
	BeyondsoftSelfCaculater(double beyondsoftEndowmentBasic,double beyondsoftHouseBasic,double beyondsoftHospitalBasic){
		this.beyondsoftHouseBasic = beyondsoftHouseBasic;
		this.beyondsoftEndowmentBasic = beyondsoftEndowmentBasic;
		this.beyondsoftHospitalBasic = beyondsoftHospitalBasic;
		
	}

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
		return ((getRealSalary2Basic(salary) * 2 / 100) + 3);
	}

	@Override
	double getHouseFund(double salary) {
		return (getHouseFundBasic(salary) * 12 / 100);
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
	

	public double getBeyondsoftEndowmentBasic() {
		return beyondsoftEndowmentBasic;
	}

	public void setBeyondsoftEndowmentBasic(double beyondsoftEndowmentBasic) {
		this.beyondsoftEndowmentBasic = beyondsoftEndowmentBasic;
	}

	@Override
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
		@Override
	  public double getRealSalary1Basic(double salary){
		  if(salary <= IConstants.ENDOWMENT_NOEMPLYED_MIN_BASIC){
			  return IConstants.ENDOWMENT_NOEMPLYED_MIN_BASIC;
		  }else if(salary >= beyondsoftEndowmentBasic){
			  return beyondsoftEndowmentBasic;
		  }else{
			  return salary;
		  }
		  
	  }
		
		
		  /**
		   * 真正的工傷，醫療，生育保險基數
		   * @param salary
		   * @return
		   */
	public double getHouseFundBasic(double salary){
			  if(salary <= IConstants.ENDOWMENT_NOEMPLYED_MIN_BASIC){
				  return IConstants.ENDOWMENT_NOEMPLYED_MIN_BASIC;
			  }else if(salary >= beyondsoftHouseBasic){
				  return beyondsoftHouseBasic;
			  }else{
				  return salary;
			  }
			  
		  }
		
		
		
	 
}
