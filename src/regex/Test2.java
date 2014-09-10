package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test2 {

	public static void main(String[] args) {
		
		//第一個參數是要測試的整個值 後面的參數就是你傳入放入的prefixs
		test("Device.DHCPv5.Server.Pool.3.Option2.6.Test.10.diable");
		
		test("Device.DHCPv5.Server.Pool.3.Option2.6.Test.10.diable","Device.DHCPv5.Server.Pool.");
		test("Device.DHCPv5.Server.Pool.3.Option2.6.Test.10.diable","Device.DHCPv5.Server.Pool.","Option2.");
		
		test(",Device.DHCPv5.Server.Pool.3.Option2.6.Test.10.diable","Device.DHCPv5.Server.Pool.","Option2.", "Test.");
	}
	
	//第一個參數是要測試的整個值 後面的參數就是你傳入放入的prefixs 
	public static void test(String testString, String...prefixs){
		StringBuffer regex = new StringBuffer();
		for(int i = 0; i < prefixs.length;i++){
			if(i < prefixs.length -1){
				regex.append(prefixs[i] + "[0-9]+."); 
			}else{
				regex.append(prefixs[i] + "([0-9]+)"); 
			}
			
		}
		System.out.println(regex);
		if(regex.toString().equals("")){
//			regex.append("[\\W.]*\\.([0-9]+)\\.[\\W.]*");
			regex.append("\\.([0-9]+)\\.");
		}
		
		Pattern pattern = Pattern.compile(regex.toString());
		Matcher matcher = pattern.matcher(testString);
		while (matcher.find()) {
			String key = matcher.group(1);
			System.out.println("key=" + key);
		}

		
	}


}
