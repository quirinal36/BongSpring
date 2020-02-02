package com.bong.patientphoto.util;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StringUtil {
	final static Logger logger = LoggerFactory.getLogger(StringUtil.class.getSimpleName());
	
	public static String replaceBR(String input) {
		String result = input.replaceAll("<br>", "\r\n");
		return result;
	}
	
	public static String dateStr(Timestamp input) {
		StringBuilder result = new StringBuilder();
		LocalDateTime writtenDate = input.toLocalDateTime();
		LocalDateTime now = LocalDateTime.now();
		
		Period period = Period.between(writtenDate.toLocalDate(), now.toLocalDate());
		int days = period.getDays();
		logger.info("days: " + days);
		int months = period.getMonths();
		logger.info("months: " + months);
		int years = period.getYears();
		logger.info("years: " + years);
		
		long seconds = ChronoUnit.SECONDS.between(writtenDate, now);
		long minutes = ChronoUnit.MINUTES.between(writtenDate, now);
		long hours = ChronoUnit.HOURS.between(writtenDate, now);
		
		logger.info("hours: " + hours);
		logger.info("minutes: " + minutes);
		logger.info("seconds: " + seconds);
		
		if(minutes < 1) {
			result.append("방금 전");
		}else if(minutes < 60) {
			result.append(minutes).append("분 전");
		}else if(hours < 24) {
			result.append(hours).append("시간 전");
		}else if(months < 1) {
			result.append(days).append("일 전");
		}else {
			result.append(writtenDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
		}
		
		return result.toString();
	}
}
