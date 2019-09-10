package com.robertleehoehle;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Robert Hoehle
 */
public class TDDKataStringCalculator {

    public static int add(String number) {

        int total = 0;
        List<String> negatives = new ArrayList<>();

        if (number == null || number.isEmpty()) {
            return 0;
        }

        char dynamicDelimiter = getDelimiter(number.split("\n")[0]);

        String[] parts = (dynamicDelimiter == ',') ? number.split(",|\n") : number.split("\n|" + dynamicDelimiter);

        int skipLine = (dynamicDelimiter == ',') ? 0 : 2;

        for (String part : parts) {
            if (skipLine > 0) {
                --skipLine;
            } else {
                int numbers = Integer.parseInt(part);
                if (numbers < 0) {
                    negatives.add(part);
                } else if (numbers < 1000) {
                    total += numbers;
                }
            }
        }
        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException(
                    "negatives not allowed " + String.join(";", negatives));
        }
        return total;
    }

    private static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    private static char getDelimiter(String line) {
        if (line == null || line.isEmpty()) {
            return ',';
        }
        if (isNumeric(line)) {
            return ',';
        }
        if (line.length() == 1) {
            return line.charAt(0);
        }
        return ',';
    }

}
