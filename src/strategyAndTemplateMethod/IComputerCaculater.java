package strategyAndTemplateMethod;
/**
 * 公司五險一金計算 策略方式-接口
 * @author junezh
 *
 */
public interface IComputerCaculater {
	
	//获得公司公積金
	 double getHouseFund(double salary);
	//获得养老保险
	 double getEndowmentInsurance(double salary);
	 
	//获得失業保险
	 double getUnEmployedInsurance(double salary);
	 
		//获得醫療保险
	 double getHispitalInsurance(double salary);
	 
	//获得工傷保险
	 double getInjuryInsurance(double salary);
	 
	//获得生育保险
	 double getmaternityInsurance(double salary);
	 

}
