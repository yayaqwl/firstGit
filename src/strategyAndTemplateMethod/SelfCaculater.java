package strategyAndTemplateMethod;
/**
 * 設計模式--模板方法
 * @author junezh
 *
 */
public abstract class SelfCaculater {
	
	/**
	 * 模板方式--方法
	 * @param salary
	 * @return
	 */
	public double caculaterGetMoney(double salary){
		//获得自己交的公积金
		double houseFund = getHouseFund(salary);
		System.out.println("自己交的公积金=" + houseFund);
		//获得五险
		//获得自己交的养老保险
		double endowment = getSelfEndowmentInsurance(salary);
		System.out.println("自己交的养老保险=" + endowment);
		//获得自己交的失业保险
		double unemployed = getSelfUnEmployedInsurance(salary);
		System.out.println("自己交的失业保险=" + unemployed);
		//获得自己交的医疗保险
		double hispital = getSelfHispitalInsurance(salary);
		System.out.println("自己交的医疗保险=" + hispital);
		//计算自己交的所有保险总和
		double allSelfInsurance = houseFund + endowment + unemployed + hispital;
		//自己交的保險總和
		System.out.println("自己交的保險總和=" + allSelfInsurance);
		//计算自己要交的税
		double tax = getTax(salary,allSelfInsurance);
		System.out.println("自己要交的税=" + tax);
		//计算自己到手的钱
		double getMoney = salary - allSelfInsurance - tax;
		return getMoney;

	}
	
	/**
	 * 模板方式--方法
	 * @param salary
	 * @return
	 */
	public double getTax(double salary){
		//获得自己交的公积金
		double houseFund = getHouseFund(salary);
		//获得五险
		//获得自己交的养老保险
		double endowment = getSelfEndowmentInsurance(salary);
		//获得自己交的失业保险
		double unemployed = getSelfUnEmployedInsurance(salary);
		//获得自己交的医疗保险
		double hispital = getSelfHispitalInsurance(salary);
		//计算自己交的所有保险总和
		double allSelfInsurance = houseFund + endowment + unemployed + hispital;
		//计算自己要交的税
		double tax = getTax(salary,allSelfInsurance);
		//计算自己到手的钱
		return tax;

	}
	
	 abstract double getHouseFund(double salary);
	//获得自己交的养老保险
	 abstract double getSelfEndowmentInsurance(double salary);
	 
	 
	 abstract double getSelfUnEmployedInsurance(double salary);
	 
	 abstract double getSelfHispitalInsurance(double salary);
	 
	 abstract double getRealSalary1Basic(double salary);
	 
	 abstract double getRealSalary2Basic(double salary);
	 
	  public double getTax(double salary, double allSelfInsurance){
		  return tax(salary - allSelfInsurance - IConstants.TAX_BASIC);
	  }
	 
	 
	  private double tax(double realSalary) {
			// System.out.println("交稅:" +salary );
		  double  tax  = 0;
			if (realSalary >= 9000) {
				tax = tax + (realSalary * 0.25 - 1005);
				// System.out.println("交稅1:" +tax );
			} else if (realSalary >= 4500 && realSalary <= 9000) {
				tax = tax + (realSalary * 0.2 - 555);
				// System.out.println("交稅2:" +tax );
			} else if (realSalary < 4500) {
				tax = tax + (realSalary * 0.1 - 105);
				// System.out.println("交稅3:" +tax );
			}
			return tax;
		}
	  

}
