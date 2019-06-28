package com.cskaoyan.converter;

import org.springframework.core.convert.converter.Converter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class StringToDateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String s) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = simpleDateFormat.parse(s);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
