package com.guobaoru.java;

import org.omg.PortableInterceptor.INACTIVE;

import javax.validation.constraints.NotNull;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author Created by guobaoru.
 * @create on 2018/8/22.
 */
public class test {

    public static void main(String[] args) throws ParseException {

        double d = 40.1131231;
        d = (double) Math.round(d * 100) / 100;
        System.out.println(d);


    }
}
