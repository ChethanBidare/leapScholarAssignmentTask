package utils;

import java.util.Random;

/**
 * StringUtils: Implements String Related methods
 *
 * @author Chethan Bidare
 */
public class StringUtils {

    /**
     * Generate Random String
     * @param length - length
     * @return String
     */
    public static String generateRandomString(int length){
        String charsRange = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();
        Random rnd = new Random();
        while (sb.length() <= length) {
            int index = (int) (rnd.nextFloat() * charsRange.length());
            sb.append(charsRange.charAt(index));
        }
        return Constants.RANDOM_NAME_STRING + sb;
    }

    /**
     * Get Random Numbers
     * @param length - length
     * @return - String
     */
    public static String getRandomNumbers(int length){
        Random random = new Random();
        int num = random.nextInt(90000000) + 10000000;
        return "99" + num;
    }
}
