package snippets.jdk.text.decimalformat.a1;

import java.text.DecimalFormat;

public class ZipCode {
	
	public static String convert(int zipCode) {
		DecimalFormat formatter = new DecimalFormat("00000");
		return formatter.format(zipCode);
	}
	
	public static void main(String[] args) {
		System.out.println(convert(123));		
	}
}
