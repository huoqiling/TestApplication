package com.example.testing.myapplication.util;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by baiiu on 15/11/25.
 * 简单的通用util
 */
public class CommonUtil {

  public static boolean isEmpty(List list) {
    return list == null || list.isEmpty();
  }

  public static boolean notEmpty(List list) {
    return !isEmpty(list);
  }

  //全部为空
  public static boolean isAllEmpty(List... lists) {
    boolean allEmpty;

    for (List list : lists) {
      allEmpty = isEmpty(list);

      if (!allEmpty) {
        return false;
      }
    }

    return true;
  }

  //有一个为空
  public static boolean isOneEmpty(List... lists) {
    for (List list : lists) {
      if (isEmpty(list)) {
        return true;
      }
    }

    return false;
  }

  //====================================================================
  //====================================================================

  public static boolean isEmpty(String s) {
    return s == null || TextUtils.isEmpty(s.trim());
  }

  public static boolean notEmpty(String s) {
    return s != null && !TextUtils.isEmpty(s.trim());
  }

  //全部为空
  public static boolean isAllEmpty(String... strings) {

    for (String s : strings) {

      if (!isEmpty(s)) {
        //如果有一个不为空则返回false.
        return false;
      }
    }

    return true;
  }

  //有一个为空
  public static boolean isOneEmpty(String... strings) {
    for (String s : strings) {
      if (isEmpty(s)) {
        return true;
      }
    }

    return false;
  }

  public static String pidReplace(String pid) {
    if (TextUtils.isEmpty(pid)) {
      return "";
    }

    if (pid.contains("/")) {
      pid = pid.replaceFirst("/", "");
    }

    return pid;
  }

  //===========================================================

  /**
   * 只encode中文
   */
  public static String encode(String sourceString) {
    if (TextUtils.isEmpty(sourceString)) return null;
    Pattern pattern = Pattern.compile("[\\u4e00-\\u9fa5]+");
    Matcher matcher = pattern.matcher(sourceString);
    while (matcher.find()) {
      String s1 = matcher.group();
      sourceString = sourceString.replace(s1, urlEncode(s1));
    }

    return sourceString;
  }

  public static String urlEncode(String s) {
    try {
      return URLEncoder.encode(s, "UTF-8");
    } catch (UnsupportedEncodingException e) {
      LogUtil.e(e.toString());
      return URLEncoder.encode(s);
    }
  }








}
