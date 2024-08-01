package com.example.demo;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Utils {
    public static double roundNDecimals(double nb, int N) {
        return (double)Math.round(nb * Math.pow(10, N)) / Math.pow(10, N);
    }
    public static String formatDoubleToString(double nb, int N) {
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(N);
        df.setMinimumFractionDigits(N);
        df.setGroupingUsed(true);

        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
        symbols.setGroupingSeparator(',');
        df.setDecimalFormatSymbols(symbols);

        return df.format(nb);
    }
}
