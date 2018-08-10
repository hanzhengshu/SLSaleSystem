package org.slsale.common;
/**
 * mybatis 防止sql注入工具类
 * @author hanlu
 *
 */
public class SQLTools {
	/**
	 * mybaits 模糊查询防止sql注入（字符替换）
	 * @param keyword
	 * @return
	 * String.contains()方法当且仅当此字符串包含指定的 char 值序列时，返回 true。
	 * String.(String regex, String replacement)  regex - 用来匹配此字符串的正则表达式  replacement - 用来替换每个匹配项的字符串 
	 *  使用给定的 replacement 替换此字符串所有匹配给定的正则表达式的子字符串
	 */
	public static String transfer(String keyword){
		if(keyword.contains("%") || keyword.contains("_")){
			keyword = keyword.replaceAll("\\\\", "\\\\\\\\")
							.replaceAll("\\%", "\\\\%")
							.replaceAll("\\_", "\\\\_");
		}
		return keyword;
	}
}
