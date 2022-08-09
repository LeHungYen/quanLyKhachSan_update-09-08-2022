package utils;

import java.awt.Color;
import java.security.MessageDigest;
import java.util.regex.Pattern;

import javax.swing.JTextField;

public class Utilities {
	public static String hashingPassword(String password) {
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			
			messageDigest.update(password.getBytes());
			
			byte[] resultByteArray = messageDigest.digest();
			
			StringBuilder stringBuilder = new StringBuilder();
			
			for (byte b : resultByteArray) {
				stringBuilder.append(String.format("%02x", b));
			}
		return stringBuilder.toString();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public static String regexCheckGmail (String gmail) {
//		Pattern pattern = Pattern.compile("^[a-zA-Z][a-zA-Z0-9]+@[a-zA-Z]+(\\.[a-zA-Z]+){1,3}$");
//		if(pattern.matcher(gmail).find()) {
//			return "true";
//		}
//		return "false";
		
		return  gmail.matches(
				"(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-"
						+ "\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:"
						+ "[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)"
						+ "\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f"
						+ "\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")+"";
	}
	
	
	public static String regexCheckFullName(String fullName) {
		Pattern pattern = Pattern.compile("[A-Z][a-z]{1,4}+ [A-Z][a-z]{1,4}+ [A-Z][a-z]{1,4}");
		if(pattern.matcher(fullName).find()) {
			return "true";
		}
		return "false";
	}
	
	public static String regexCheckPhoneNumber(String phoneNumber) {

		return String.valueOf(phoneNumber.matches("0\\d{9,10}"));
	}
	
	
	
	public static String regexCheckIdentityCardNumber(String identityCardNumber) {
//		Pattern pattern = Pattern.compile("\\d{9}|\\d{12}");
//		if(pattern.matcher(identityCardNumber).find()) {
//			return "true";
//		}
//		return "false";
		return String.valueOf(identityCardNumber.matches("\\d{9}|\\d{12}"));
	}
	
	public static String regexCheckDouble(String text) {
		Pattern pattern = Pattern.compile("^(\\-)?[0-9]+(.[0-9]+)?$");
		if(pattern.matcher(text).find()) {
			return "true";
		}
		return "false";
	}
	public static String regexCheckSoNguyenDuong(String text) {
		Pattern pattern = Pattern.compile("^\\d+$");
		if(pattern.matcher(text).find()) {
			return "true";
		}
		return "false";
	}
	
	public static int splitDate(String yyyyMMdd) {
		int date =  Integer.parseInt(yyyyMMdd.substring(8, 10));
		return date;
	}
	public static int splitMonth(String yyyyMMdd) {
		int month = Integer.parseInt(yyyyMMdd.substring(5, 7));
		return month;
	}
	public static int splitYear(String yyyyMMdd) {
		int year =  Integer.parseInt(yyyyMMdd.substring(0, 4));
		return year;
	}
	
	public static String getIdByNameAndID(int id , String name) {
		int lastSpace = name.lastIndexOf(" ");
		String lastName = name.substring(lastSpace+1, name.length());
		name = name.substring(0, lastSpace);
		String idByNameAndID = lastName;
		while(true) {
			if(name.indexOf(" ")<0) {
				idByNameAndID = idByNameAndID + name.substring(0,1);
				break;
			}else {
				int firstSpace = name.indexOf(" ");
				idByNameAndID = idByNameAndID + name.substring(0,1);
				name = name.substring(firstSpace+1, name.length());
			}
		}
		idByNameAndID = idByNameAndID+"NV"+id;
		return idByNameAndID;
	}
	
	public static int splitIdFromIdByNameAndId(String idByNameAndID) {
		String id = idByNameAndID.substring(idByNameAndID.indexOf("NV")+2,idByNameAndID.length());
		return Integer.parseInt(id);
	}
	
	public static void setTextFocusGained (JTextField jTextField , String text) {
		if (jTextField.getText().equals(text)) {
			jTextField.setForeground(Color.black);
			jTextField.setText(null);
		}
	}

	public static void setTextFocusLost (JTextField jTextField , String text) {
	if (jTextField.getText().equals("")) {
		jTextField.setText(text);
		jTextField.setForeground(new Color(153, 153, 153));
		}
	}
	
	public static void main(String[] args) {
		System.out.println(regexCheckDouble("7.66666666666666666666666666666d"));
	}
	
}
