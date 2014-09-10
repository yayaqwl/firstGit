package StringUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	
	public static void main(String[] args) {
		String s = "abc,bcd,eee";
		List<String> l = new ArrayList<String>();
		l.add("abc");
		l.add("eee");
		l.add("bcd");
		System.out.println(judge(s, l));
	}
	
	public static boolean judge(String str, List<String> list) {
		if (str == null || list == null) {
			return false;
		}
		String[] sp = str.split(",");
		if (sp.length != list.size()) {
			return false;
		}
		for (int i = 0; i < sp.length; i++) {
			boolean match = false;
			for (int j = 0; j < list.size(); j++) {
				if (sp[i].equals(list.get(j))) {
					match = true;
					break;
				}
			}
			if (!match) {
				return false;
			}
		}
		return true;
	}

}
