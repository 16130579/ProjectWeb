package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Test {
public static void main(String[] args) {
//	Map<String, String> redem = new HashMap<>();
//	ArrayList<String> list = new ArrayList<String>();
//	list.add("1");
//	list.add("2");
//	for (String string : list) {
//		redem.put(string, "");
//	}
//	for(Map.Entry<String,String> entry : redem.entrySet()){
//		System.out.println(entry.getKey());
//	}
	double total = 13333;
	int fee = 22000;
	double finals = total/fee;
	finals=(double) Math.round(finals * 100) / 100;
	System.out.println(finals);
}
}
