package com.common.utils.verification;

import android.text.TextUtils;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式工具类，验证数据是否符合规范
 * 
 * @Author:chenssy
 * @date:2014年8月7日
 */
public class RegexUtils {
	
	/**
	 * 判断字符串是否符合正则表达式
	 * 
	 * @author : chenssy
	 * @date : 2016年6月1日 下午12:43:05
	 *
	 * @param str
	 * @param regex
	 * @return
	 */
	public static boolean find(String str, String regex) {
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(str);
		boolean b = m.find();
		return b;
	}
	
	/**
	 * 判断输入的字符串是否符合Email格式.
	 * @autor:chenssy
	 * @date:2014年8月7日
	 *
	 * @param email
	 * 				传入的字符串
	 * @return 符合Email格式返回true，否则返回false
	 */
	public static boolean isEmail(String email) {
		if (email == null || email.length() < 1 || email.length() > 256) {
			return false;
		}
		Pattern pattern = Pattern.compile("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$");
		return pattern.matcher(email).matches();
	}


	
	/**
	 * 判断输入的字符串是否为纯汉字
	 * @autor:chenssy
	 * @date:2014年8月7日
	 *
	 * @param value
	 * 				传入的字符串
	 * @return
	 */
	public static boolean isChinese(String value) {
		Pattern pattern = Pattern.compile("[\u0391-\uFFE5]+$");
		return pattern.matcher(value).matches();
	}
	
	/**
	 * 判断是否为浮点数，包括double和float
	 * @autor:chenssy
	 * @date:2014年8月7日
	 *
	 * @param value
	 * 			传入的字符串
	 * @return
	 */
	public static boolean isDouble(String value) {
		Pattern pattern = Pattern.compile("^[-\\+]?\\d+\\.\\d+$");
		return pattern.matcher(value).matches();
	}
	
	/**
	 * 判断是否为整数
	 * @autor:chenssy
	 * @date:2014年8月7日
	 *
	 * @param value
	 * 			传入的字符串
	 * @return
	 */
	public static boolean isInteger(String value) {
		Pattern pattern = Pattern.compile("^[-\\+]?[\\d]+$");
		return pattern.matcher(value).matches();
	}

	/**
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(String str) {
		if (TextUtils.isEmpty(str))
			return false;

		Pattern pattern = Pattern.compile("[0-9]*");
		return pattern.matcher(str).matches();
	}


	/**
	 * Whether gender legal
	 */
	public static boolean JudgeSexQual(String sex) {
		return "男".equals(sex) || "女".equals(sex);
	}

	//判断是否是个合格的区号-座机号
	public static boolean judgeTelephone(String number) {
		return number.matches("^0[0-9]{3}-?[0-9]{7,8}$");
	}

	/**
	 * 判断是否是合格的手机号码
	 */
	public static boolean judgePhoneQual(String number) {
		return number
				.matches("^(\\+86-|\\+86|86-|86){0,1}1[3|4|5|7|8]{1}\\d{9}$");
	}

	/**
	 * 判断是否是合格的手机号码
	 */
	public static boolean judgePhoneQual(EditText numberEt) {
		return numberEt.getText().toString().trim()
				.matches("^(\\+86-|\\+86|86-|86){0,1}1[3|4|5|7|8]{1}\\d{9}$");
//		return numberEt.getText().toString().trim().matches("^1[34568]\\d{9}$");
	}


	/**
	 * 功能：判断字符串是否为日期格式
	 *
	 * @param strDate
	 * @return
	 */
	public static boolean isDate(String strDate) {
		Pattern pattern = Pattern
				.compile("^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))(\\s(((0?[0-9])|([1-2][0-3]))\\:([0-5]?[0-9])((\\s)|(\\:([0-5]?[0-9])))))?$");
		Matcher m = pattern.matcher(strDate);
		return m.matches();
	}


	/**
	 * 判断是不是一个合法的url
	 */
	public static boolean checkUrl(String url) {
		if(TextUtils.isEmpty(url)) return true;

		return url.matches("^((https|http|ftp|rtsp|mms)?://)"
				+ "+(([0-9a-z_!~*'().&=+$%-]+: )?[0-9a-z_!~*'().&=+$%-]+@)?"
				+ "(([0-9]{1,3}\\.){3}[0-9]{1,3}" + "|"
				+ "([0-9a-z_!~*'()-]+\\.)*"
				+ "([0-9a-z][0-9a-z-]{0,61})?[0-9a-z]\\." + "[a-z]{2,6})"
				+ "(:[0-9]{1,4})?" + "((/?)|"
				+ "(/[0-9a-z_!~*'().;?:@&=+$,%#-]+)+/?)$");
	}

}
