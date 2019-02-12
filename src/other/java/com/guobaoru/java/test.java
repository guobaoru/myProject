package com.guobaoru.java;

import org.omg.PortableInterceptor.INACTIVE;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Created by guobaoru.
 * @create on 2018/8/22.
 */
public class test {

    public static void main(String[] args) throws ParseException {


        String a = "123" + "456";

        System.out.println(a);



    }

    public static Double convertCurrencyUnit(Double original, Double diffMultiplier) {
        BigDecimal ogl = new BigDecimal(original.toString());
        BigDecimal unit = new BigDecimal(diffMultiplier.toString());
        return ogl.divide(unit,10, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}
