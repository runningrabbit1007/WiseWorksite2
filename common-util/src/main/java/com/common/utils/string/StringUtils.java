package com.common.utils.string;

import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串工具类，对字符串进行常规的处理
 *
 * @Author:chenssy
 * @date:2014年8月5日
 */
public class StringUtils {
    public static final String RMB = "¥%s";

    /**
     * 将半角的符号转换成全角符号.(即英文字符转中文字符)
     *
     * @param str 要转换的字符
     * @return
     * @autor:chenssy
     * @date:2014年8月7日
     */
    public static String changeToFull(String str){
        String source = "1234567890!@#$%^&*()abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_=+\\|[];:'\",<.>/?";
        String[] decode = {"１", "２", "３", "４", "５", "６", "７", "８", "９", "０",
                "！", "＠", "＃", "＄", "％", "︿", "＆", "＊", "（", "）", "ａ", "ｂ",
                "ｃ", "ｄ", "ｅ", "ｆ", "ｇ", "ｈ", "ｉ", "ｊ", "ｋ", "ｌ", "ｍ", "ｎ",
                "ｏ", "ｐ", "ｑ", "ｒ", "ｓ", "ｔ", "ｕ", "ｖ", "ｗ", "ｘ", "ｙ", "ｚ",
                "Ａ", "Ｂ", "Ｃ", "Ｄ", "Ｅ", "Ｆ", "Ｇ", "Ｈ", "Ｉ", "Ｊ", "Ｋ", "Ｌ",
                "Ｍ", "Ｎ", "Ｏ", "Ｐ", "Ｑ", "Ｒ", "Ｓ", "Ｔ", "Ｕ", "Ｖ", "Ｗ", "Ｘ",
                "Ｙ", "Ｚ", "－", "＿", "＝", "＋", "＼", "｜", "【", "】", "；", "：",
                "'", "\"", "，", "〈", "。", "〉", "／", "？"};
        String result = "";
        for(int i = 0; i < str.length(); i++){
            int pos = source.indexOf(str.charAt(i));
            if(pos != -1){
                result += decode[pos];
            }else{
                result += str.charAt(i);
            }
        }
        return result;
    }

    /**
     * 将字符转换为编码为Unicode，格式 为'\u0020'<br>
     * unicodeEscaped(' ') = "\u0020"<br>
     * unicodeEscaped('A') = "\u0041"
     *
     * @param ch 待转换的char 字符
     * @return
     * @autor:chenssy
     * @date:2014年8月7日
     */
    public static String unicodeEscaped(char ch){
        if(ch < 0x10){
            return "\\u000" + Integer.toHexString(ch);
        }else if(ch < 0x100){
            return "\\u00" + Integer.toHexString(ch);
        }else if(ch < 0x1000){
            return "\\u0" + Integer.toHexString(ch);
        }
        return "\\u" + Integer.toHexString(ch);
    }

    /**
     * 进行toString操作，若为空，返回默认值
     *
     * @param object  要进行toString操作的对象
     * @param nullStr 返回的默认值
     * @return
     * @autor:chenssy
     * @date:2014年8月9日
     */
    public static String toString(Object object, String nullStr){
        return object == null ? nullStr : object.toString();
    }

    /**
     * 将字符串重复N次，null、""不在循环次数里面 <br>
     * 当value == null || value == "" return value;<br>
     * 当count <= 1 返回  value
     *
     * @param value 需要循环的字符串
     * @param count 循环的次数
     * @return
     * @autor:chenssy
     * @date:2014年8月9日
     */
    public static String repeatString(String value, int count){
        if(value == null || "".equals(value) || count <= 1){
            return value;
        }
        int length = value.length();
        if(length == 1){          //长度为1，存在字符
            return repeatChar(value.charAt(0), count);
        }
        int outputLength = length * count;
        switch(length){
            case 1:
                return repeatChar(value.charAt(0), count);
            case 2:
                char ch0 = value.charAt(0);
                char ch1 = value.charAt(1);
                char[] output2 = new char[outputLength];
                for(int i = count * 2 - 2; i >= 0; i--, i--){
                    output2[i] = ch0;
                    output2[i + 1] = ch1;
                }
                return new String(output2);
            default:
                StringBuilder buf = new StringBuilder(outputLength);
                for(int i = 0; i < count; i++){
                    buf.append(value);
                }
                return buf.toString();
        }
    }

    /**
     * 将某个字符重复N次
     *
     * @param ch    需要循环的字符
     * @param count 循环的次数
     * @return
     * @autor:chenssy
     * @date:2014年8月9日
     */
    public static String repeatChar(char ch, int count){
        char[] buf = new char[count];
        for(int i = count - 1; i >= 0; i--){
            buf[i] = ch;
        }
        return new String(buf);
    }

    /**
     * 判断字符串是否全部都为小写
     *
     * @param value 待判断的字符串
     * @return
     * @autor:chenssy
     * @date:2014年8月9日
     */
    public static boolean isAllLowerCase(String value){
        if(value == null || "".equals(value)){
            return false;
        }
        for(int i = 0; i < value.length(); i++){
            if(Character.isLowerCase(value.charAt(i)) == false){
                return false;
            }
        }
        return true;
    }

    /**
     * 判断字符串是否全部大写
     *
     * @param value 待判断的字符串
     * @return
     * @autor:chenssy
     * @date:2014年8月9日
     */
    public static boolean isAllUpperCase(String value){
        if(value == null || "".equals(value)){
            return false;
        }
        for(int i = 0; i < value.length(); i++){
            if(Character.isUpperCase(value.charAt(i)) == false){
                return false;
            }
        }
        return true;
    }

    /**
     * 反转字符串
     *
     * @param value 待反转的字符串
     * @return
     * @autor:chenssy
     * @date:2014年8月9日
     */
    public static String reverse(String value){
        if(value == null){
            return null;
        }
        return new StringBuffer(value).reverse().toString();
    }

    /**
     * @param resourceString
     * @param length
     * @return
     * @desc:截取字符串，支持中英文混乱，其中中文当做两位处理
     * @autor:chenssy
     * @date:2014年8月10日
     */
    public static String subString(String resourceString, int length){
        String resultString = "";
        if(resourceString == null || "".equals(resourceString) || length < 1){
            return resourceString;
        }
        if(resourceString.length() < length){
            return resourceString;
        }
        char[] chr = resourceString.toCharArray();
        int strNum = 0;
        int strGBKNum = 0;
        boolean isHaveDot = false;
        for(int i = 0; i < resourceString.length(); i++){
            if(chr[i] >= 0xa1){// 0xa1汉字最小位开始
                strNum = strNum + 2;
                strGBKNum++;
            }else{
                strNum++;
            }
            if(strNum == length || strNum == length + 1){
                if(i + 1 < resourceString.length()){
                    isHaveDot = true;
                }
                break;
            }
        }
        resultString = resourceString.substring(0, strNum - strGBKNum);
        if(isHaveDot){
            resultString = resultString + "...";
        }
        return resultString;
    }

    /**
     * @param htmlString
     * @param length
     * @return
     * @autor:chenssy
     * @date:2014年8月10日
     */
    public static String subHTMLString(String htmlString, int length){
        return subString(delHTMLTag(htmlString), length);
    }

    /**
     * 过滤html标签，包括script、style、html、空格、回车标签
     *
     * @param htmlStr
     * @return
     * @autor:chenssy
     * @date:2014年8月10日
     */
    public static String delHTMLTag(String htmlStr){
        String regEx_script = "<script[^>]*?>[\\s\\S]*?<\\/script>"; // 定义script的正则表达式
        String regEx_style = "<style[^>]*?>[\\s\\S]*?<\\/style>"; // 定义style的正则表达式
        String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式
        String regEx_space = "\\s*|\t|\r|\n";//定义空格回车换行符
        Pattern p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
        Matcher m_script = p_script.matcher(htmlStr);
        htmlStr = m_script.replaceAll(""); // 过滤script标签  
        Pattern p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
        Matcher m_style = p_style.matcher(htmlStr);
        htmlStr = m_style.replaceAll(""); // 过滤style标签  
        Pattern p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
        Matcher m_html = p_html.matcher(htmlStr);
        htmlStr = m_html.replaceAll(""); // 过滤html标签  
        Pattern p_space = Pattern.compile(regEx_space, Pattern.CASE_INSENSITIVE);
        Matcher m_space = p_space.matcher(htmlStr);
        htmlStr = m_space.replaceAll(""); // 过滤空格回车标签  
        return htmlStr.trim(); // 返回文本字符串
    }

    /**
     * 得到随机文字(中文汉字)
     *
     * @return
     */
    public static char getRandomChar(){
        String str = "";
        int hightPos;
        int lowPos;
        Random random = new Random();
        hightPos = (176 + Math.abs(random.nextInt(39)));
        lowPos = (161 + Math.abs(random.nextInt(93)));
        byte[] b = new byte[2];
        b[0] = Integer.valueOf(hightPos).byteValue();
        b[1] = Integer.valueOf(lowPos).byteValue();
        try{
            str = new String(b, "GBK");
        }catch(Exception e){
            e.printStackTrace();
        }
        return str.charAt(0);
    }

    /**
     * 获取一段字符串中的数字
     *
     * @param originalStr
     * @return
     */
    public static final String getStringNum(String originalStr){
        String numberStr = "";
        originalStr.trim();
        if(originalStr != null && !"".equals(originalStr)){
            for(int i = 0; i < originalStr.length(); i++){
                if(originalStr.charAt(i) >= 48 && originalStr.charAt(i) <= 57){
                    numberStr += originalStr.charAt(i);
                }
            }
        }
        return numberStr;
    }

    /**
     * 从该文件下获取字符串
     */
    public static String readFileData(String fileName){
        String res = "";
        try{
            FileInputStream fin = new FileInputStream(fileName);
            // FileInputStream fin = openFileInput(fileName);
            // 用这个就不行了，必须用FileInputStream
            int length = fin.available();
            byte[] buffer = new byte[length];
            fin.read(buffer);
            res = new String(buffer, "UTF-8");// //依Y.txt的编码类型选择合适的编码，如果不调整会乱码
            fin.close();// 关闭资源
        }catch(Exception e){
            e.printStackTrace();
        }
        return res;
    }

    /**
     * 替换字符串中特殊字符
     *
     * @param target
     * @param signal
     * @param replace
     * @return
     */
    public static String replaceSignal(String target, String signal, String replace){
        return target.replace(signal, replace);
    }

    /**
     * 删除所有的空格
     *
     * @param str
     * @return
     */
    public static String removeAllSpace(String str){
        String tmpstr = str.replace(" ", "");
        return tmpstr;
    }

    public static String getStringByTrim(TextView textView){
        if(textView != null && !TextUtils.isEmpty(textView.getText())){
            return textView.getText().toString().trim();
        }else{
            return "";
        }
    }

    /**
     * 从图片网络地址中拿到图片名称
     *
     * @param photoPath
     * @return
     */
    public static String getSubStringFormPath(String photoPath){
        int i = photoPath.lastIndexOf("/");
        return photoPath.substring(i + 1);
    }

    /**
     * 设置商品价格,并保留俩位小数
     *
     * @param price
     * @return
     */
    public static String setPricekeepDecimal(double price){
        if(price == 0){
            return "¥0.00";
        }else{
            DecimalFormat df = new DecimalFormat("#.00");
            String priceFormat = df.format(price);
            return String.format(RMB, priceFormat);
        }
    }

    /**
     * 设置商品价格,并保留俩位小数
     *
     * @param price
     * @param NoRmb 是否需不返回人民币符号
     * @return
     */
    public static String setPricekeepDecimal(double price, boolean NoRmb){
        if(price == 0){
            return "¥0.00";
        }else{
            DecimalFormat df = new DecimalFormat("0.00");
            String priceFormat = df.format(price);
            if(NoRmb){
                return priceFormat;
            }
            return String.format(RMB, priceFormat);
        }
    }

    /**
     * @param number
     * @return
     */
    public static String setCouponsDecimal(double number){
        if(number == 0){
            return "0.00";
        }
        DecimalFormat decimalFormat = new DecimalFormat("0.##");
        return decimalFormat.format(number);
    }

    /**
     * 高亮部分文字
     *
     * @param targetString 目标内容
     * @param searchName   高亮内容
     * @return
     */
    public static SpannableString getSpannablebyString(String targetString, String searchName){
        SpannableString spanString = new SpannableString(targetString);
        //再构造一个改变字体颜色的Span
        ForegroundColorSpan span = new ForegroundColorSpan(Color.rgb(255, 201, 133));
        //将这个Span应用于指定范围的字体
        int start = targetString.indexOf(searchName);
        spanString.setSpan(span, start, searchName.length() + start, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        return spanString;
    }

    public static String getChartsetString(String origin, String charset){
        if (!TextUtils.isEmpty(origin)) {
            try {
                return new String(origin.getBytes(charset));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                return "";
            }
        }
        return "";
    }
}
