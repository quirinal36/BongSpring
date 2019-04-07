package com.bong.patientphoto.util;

public class StringUtil {

	public static String replaceBR(String input) {
		String result = input.replaceAll("<br>", "\r\n");
		return result;
	}
}
