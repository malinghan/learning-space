package com.mlh.learning.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Number Util
 *
 * @author 孔令政
 * @date 2017/8/16
 * @since wiki
 */
public class NumberUtil {

    private static String[] numberCN = {"零", "一", "二", "三", "四", "五", "六", "七", "八", "九"};
    private static String[] bitCN = {"", "十", "百", "千"};
    private static String[] unitCN = {"", "万", "亿"};


    /**
     * 从str中提取整数 类似PHP里的intval
     *
     * @param str
     * @return
     */
    public static int parseInt(String str) {
        String regex = "^-?\\d+";
        Pattern regPattern = Pattern.compile(regex);
        Matcher matcher = regPattern.matcher(str);
        if (matcher.find()) {
            return Integer.parseInt(matcher.group());
        } else {
            return 0;
        }
    }

    /**
     * 整数转换 数字转中文
     * 支持范围：(Integer.MIN_VALUE, Integer.MAX_VALUE]
     * <p>
     * examle:
     * 0->零 5->五 14->十四
     * 56781234->五千六百七十八万一千二百三十四
     * 1020304050->十亿零二千零三十万零四千零五十
     *
     * @param digit
     * @return
     */
    public static String getChineseIntStr(int digit) {
        if (digit == Integer.MIN_VALUE) {
            // 最小值  0x80000000   MIN_VALUE 的补码是本身 0-min=min
            throw new RuntimeException("最小整数，暂不支持");
        }
        String digitCN = "";
        boolean negative = false;
        if (0 == digit) {
            return numberCN[0];
        } else if (digit < 0) {
            // 负数处理
            negative = true;
            digit = 0 - digit;
        }


        int wan = NumericUtil.pow(10, 4);

        for (int i = 3; i > 0; i--) {
            // 每 4 位分一段
            int part = digit / NumericUtil.pow(wan, i - 1) % NumericUtil.pow(wan, 1);
            String unitStr = getPartStr(part, unitCN[i - 1]);

            // 相邻段之间是否需要加"零"
            if (!StringUtil.isEmpty(digitCN) && !digitCN.endsWith(numberCN[0]) && 0 != digit % NumericUtil.pow(wan, i) &&
                    (0 == part / 1000 || 0 == digit / NumericUtil.pow(wan, i) % 10)) {
                digitCN += numberCN[0];
            }

            digitCN += unitStr;
        }

        if (negative) {
            digitCN = "负" + digitCN;
        }

        return digitCN;
    }


    /**
     * 获取 4 位数的对应中文
     *
     * @param thousand
     * @param unit
     * @return
     */
    private static String getPartStr(int thousand, String unit) {
        // 数值
        String res = getChineseDigit(thousand);
        if (!StringUtil.isEmpty(res)) {
            // 加单位
            res += unit;
        }

        return res;
    }

    /**
     * (0,9999] 数字转换中文
     *
     * @param thousand
     * @return
     */
    private static String getChineseDigit(int thousand) {
        String res = "";

        if (thousand > 9 && thousand < 20) {
            String bitStr = thousand % 10 == 0 ? "" : numberCN[thousand % 10];
            return bitCN[1] + bitStr;
        }
        for (int i = 4; i > 0; i--) {
            int bit = thousand % NumericUtil.pow(10, i) / NumericUtil.pow(10, i - 1);

            if (0 != bit) {
                res += numberCN[bit] + bitCN[i - 1];
            } else if (!StringUtil.isEmpty(res) &&
                    0 != thousand % NumericUtil.pow(10, i - 1)
                    && !res.endsWith(numberCN[0]) && i > 1) {
                res += numberCN[0];
            }
        }

        return res;
    }
}
