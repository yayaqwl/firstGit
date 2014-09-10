package strategyAndTemplateMethod;

import java.util.Scanner;

public class InsuranceAndHousingFundClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//输入正常工资
		while(true){
		System.out.println("请随便输入工資:");
		Scanner sca=new Scanner(System.in);
		System.out.println("请随便输入每年月份:");
		Scanner monthSca =new Scanner(System.in);
		double salary = Double.parseDouble(sca.next());
		double month = Double.parseDouble(monthSca.next());
		System.out.println("你输入内容是:" + salary);
		//計算正常的到手錢數
		System.out.println("***正常自交五险一金***");
		SelfCaculater normalSelfCaculater = new NormalSelfCaculater();
		double normalSelfGetMoney = normalSelfCaculater.caculaterGetMoney(salary);

		System.out.println();
		System.out.println("***博彥自交五险一金***");
		//博彥公積金基數
		double houstFundBaic = 2359;
		SelfCaculater beyondSelfCaculater = new BeyondsoftSelfCaculater(IConstants.ENDOWMENT_NOEMPLYED_MIN_BASIC, houstFundBaic,IConstants.HOSPITAL_MATERNIYT_INJURY_MIN_BASIC);
		double beyondsoftGetMoney = beyondSelfCaculater.caculaterGetMoney(salary);
		
		
		
		//計算公司交的錢數
		System.out.println();
		System.out.println("***正常公司五险一金***");
		IComputerCaculater computerCaculater = new NormalComputerCaculaterImple();
		
		double computerInsurance = printComputer(computerCaculater, salary);
		
		System.out.println();
		System.out.println("***博彥公司五险一金***");
		IComputerCaculater beyondComputerCaculater = new BeyondsoftComputerCaculaterImple(IConstants.ENDOWMENT_NOEMPLYED_MIN_BASIC, houstFundBaic,IConstants.HOSPITAL_MATERNIYT_INJURY_MIN_BASIC);
		
		double beyondcomputerInsurance =printComputer(beyondComputerCaculater, salary);
		
		System.out.println();
		System.out.println("****總結(所有現在到手)****");
		System.out.println("---------------------博彥到手錢數  = " + beyondsoftGetMoney);
		System.out.println("---------------------正常的到手錢數  = " + normalSelfGetMoney);
		
		System.out.println();
		System.out.println("****總結(含公積金)****");
		double beyondsoftGet = beyondsoftGetMoney + (beyondComputerCaculater.getHouseFund(salary) * 2);
		
		double beyondsoftGetYear = beyondsoftGet * month;
		
		double normalGet = normalSelfGetMoney + (computerCaculater.getHouseFund(salary) * 2);
		
		double normalGetYear = normalGet * month;
		
		
		System.out.println();
		
		System.out.println("---------------------博彥到手總數  = " + beyondsoftGet);
		System.out.println("---------------------正常到手總數  = " + normalGet);
		System.out.println("---------------------博彥一年到手總數  = " + beyondsoftGetYear);
		System.out.println("---------------------正常一年到手總數  = " + normalGetYear);
		System.out.println("----博彥交稅=" + beyondSelfCaculater.getTax(salary) );
		System.out.println("---正常交稅=" + normalSelfCaculater.getTax(salary) );
		System.out.println("多繳稅=" + (beyondSelfCaculater.getTax(salary)- normalSelfCaculater.getTax(salary)));
		
		
		System.out.println();
		System.out.println("****總結(含所有有關的医疗保险)****");
		System.out.println("---------------------博彥到手總數  = " + (beyondsoftGet + beyondSelfCaculater.getSelfEndowmentInsurance(salary) + beyondSelfCaculater.getSelfHispitalInsurance(salary)));
		System.out.println("---------------------正常到手總數  = " + (normalGet +  normalSelfCaculater.getSelfEndowmentInsurance(salary) + normalSelfCaculater.getSelfHispitalInsurance(salary) ));
		}
	
		
		
	}

	
	public static double printComputer(IComputerCaculater computerCaculater,double salary){
		//公積金
		double computerHouseFund = computerCaculater.getHouseFund(salary);
		//養老保險
		double computerEndowment = computerCaculater.getEndowmentInsurance(salary);
		//失業保險
		double computerUnEmployed = computerCaculater.getUnEmployedInsurance(salary);
		//醫療保險
		double computerHispital = computerCaculater.getHispitalInsurance(salary);
		//工傷保險
		double computerInjure = computerCaculater.getInjuryInsurance(salary);
		
		//生育保險
		double computerMaternity = computerCaculater.getmaternityInsurance(salary);
		
		System.out.println("公司公積金 =" + computerHouseFund);
		
		System.out.println("公司養老保險 =" + computerEndowment);
		System.out.println("公司失業保險 =" + computerUnEmployed);
		System.out.println("公司醫療保險=" + computerHispital);
		System.out.println("公司工傷保險 =" + computerInjure);
		System.out.println("公司生育保險 =" + computerMaternity);
		return  computerEndowment;
		
	}
		
}
