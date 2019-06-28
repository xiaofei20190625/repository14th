package com.cskaoyan.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter implements Converter<String,Date> {
	@Override
	public Date convert(String s) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date parse = simpleDateFormat.parse(s);
			return parse;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
}
