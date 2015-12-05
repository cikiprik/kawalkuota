package com.kawalkuota.util;

/**
 *
 * @author Yusrul <yusrul@kemenkeu.go.id>
 */
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringUtil
{
  public static String nullString(String s)
  {
    if (s == null) {
      return "";
    }
    return s;
  }
  
  public static String getDayOfWeek()
  {
    String dow = "";
    
    SimpleDateFormat sdf = new SimpleDateFormat("E");
    String day = sdf.format(new Date()).toLowerCase();
    if (day.equals("sun")) {
      dow = "1";
    } else if (day.equals("mon")) {
      dow = "2";
    } else if (day.equals("tue")) {
      dow = "3";
    } else if (day.equals("wed")) {
      dow = "4";
    } else if (day.equals("thu")) {
      dow = "5";
    } else if (day.equals("fri")) {
      dow = "6";
    } else if (day.equals("sat")) {
      dow = "7";
    }
    return dow;
  }
  
  public static String getDuaDigit(String str)
  {
    String ed = "";
    int sl = str.length();
    if (sl == 1) {
      ed = "0" + str;
    } else if (sl == 2) {
      ed = str;
    }
    return ed;
  }
  
  public static String getTigaDigit(String str)
  {
    String ed = "";
    int sl = str.length();
    if (sl == 1) {
      ed = "00" + str;
    } else if (sl == 2) {
      ed = "0" + str;
    } else if (sl == 3) {
      ed = str;
    }
    return ed;
  }
  
  public static String getEmpatDigit(String str)
  {
    String ed = "";
    int sl = str.length();
    if (sl == 1) {
      ed = "000" + str;
    } else if (sl == 2) {
      ed = "00" + str;
    } else if (sl == 3) {
      ed = "0" + str;
    } else if (sl == 4) {
      ed = str;
    }
    return ed;
  }
  
  public static String getLimaDigit(String str)
  {
    String ed = "";
    int sl = str.length();
    if (sl == 1) {
      ed = "0000" + str;
    } else if (sl == 2) {
      ed = "000" + str;
    } else if (sl == 3) {
      ed = "00" + str;
    } else if (sl == 4) {
      ed = "0" + str;
    } else if (sl == 5) {
      ed = str;
    }
    return ed;
  }
  
  public static String getEnamDigit(String str)
  {
    String ed = "";
    int sl = str.length();
    if (sl == 1) {
      ed = "00000" + str;
    } else if (sl == 2) {
      ed = "0000" + str;
    } else if (sl == 3) {
      ed = "000" + str;
    } else if (sl == 4) {
      ed = "00" + str;
    } else if (sl == 5) {
      ed = "0" + str;
    } else if (sl == 6) {
      ed = str;
    }
    return ed;
  }
  
  public static String getTujuhDigit(String str)
  {
    String ed = "";
    int sl = str.length();
    if (sl == 1) {
      ed = "000000" + str;
    } else if (sl == 2) {
      ed = "00000" + str;
    } else if (sl == 3) {
      ed = "0000" + str;
    } else if (sl == 4) {
      ed = "000" + str;
    } else if (sl == 5) {
      ed = "00" + str;
    } else if (sl == 6) {
      ed = "0" + str;
    } else if (sl == 7) {
      ed = str;
    }
    return ed;
  }
  
  public static String getDelapanDigit(String str)
  {
    String ed = "";
    int sl = str.length();
    if (sl == 1) {
      ed = "0000000" + str;
    } else if (sl == 2) {
      ed = "000000" + str;
    } else if (sl == 3) {
      ed = "00000" + str;
    } else if (sl == 4) {
      ed = "0000" + str;
    } else if (sl == 5) {
      ed = "000" + str;
    } else if (sl == 6) {
      ed = "00" + str;
    } else if (sl == 7) {
      ed = "0" + str;
    } else if (sl == 8) {
      ed = str;
    }
    return ed;
  }
  public static String Capital(String old){
      
      int l = old.length();
          String f = old.substring(0, 1).toUpperCase();
          String s = old.substring(1, l);
          String uf = f + "" + s;
      return uf;
  }
  public static String unCapital(String old){
      
      int l = old.length();
          String f = old.substring(0, 1).toLowerCase();
          String s = old.substring(1, l);
          String uf = f + "" + s;
      return uf;
  }
  public static String ucFirst(String old)
  {
    String uf;
    try
    {
      if (old != null)
      {
        
        if ((old.equals("II/A")) || (old.equals("II/B")) || (old.equals("II/C")) || (old.equals("II/D")) || (old.equals("III/A")) || (old.equals("III/B")) || (old.equals("III/C")) || (old.equals("III/D")) || (old.equals("IV/A")) || (old.equals("IV/B")) || (old.equals("IV/C")) || (old.equals("IV/D")) || (old.equals("DJBC")) || (old.equals("MC")) || (old.equals("IKC")) || (old.equals("PPKC")) || (old.equals("KPU")) || (old.equals("KPPBC")) || (old.equals("KPP")) || (old.equals("I")) || (old.equals("II")) || (old.equals("III")) || (old.equals("IV")) || (old.equals("V")) || (old.equals("VI")) || (old.equals("VII")) || (old.equals("VIII")) || (old.equals("IX")) || (old.equals("X")) || (old.equals("XI")) || (old.equals("XII")) || (old.equals("XIII")) || (old.equals("XIV")) || (old.equals("XV")) || (old.equals("XVI")) || (old.equals("XVII")) || (old.equals("XVIII")) || (old.equals("XIX")) || (old.equals("XX")) || (old.equals("XXI")) || (old.equals("XXII")) || (old.equals("XXIII")) || (old.equals("XXIV")) || (old.equals("XXV")) || (old.equals("XXVI")) || (old.equals("XXVII")) || (old.equals("XXVIII")) || (old.equals("PNS")) || (old.equals("API")) || (old.equals("SIUP")) || (old.equals("IUP")) || (old.equals("TDP")) || (old.equals("IUT")) || (old.equals("NIK")) || (old.equals("KTP")) || (old.equals("NPIK")) || (old.equals("NPWP")) || (old.equals("PKP")) || (old.equals("SIUPJPT")) || (old.equals("SIUPAL")) || (old.equals("SIUPAU")) || (old.equals("SKD")) || (old.equals("TDI")) || (old.equals("TDP")) || (old.equals("TDUP")) || (old.equals("PIB")) || (old.equals("PEB")) || (old.equals("PPJK")) || (old.equals("DIY")) || (old.equals("WIB")) || (old.equals("WITA")) || (old.equals("WIT")))
        {
          String[] olds = old.split("/");
          uf = olds[0] + "/" + olds[1].toLowerCase();
        }
        else
        {
          uf = old.toLowerCase();
          int l = uf.length();
          String f = uf.substring(0, 1).toUpperCase();
          String s = uf.substring(1, l);
          uf = f + "" + s;
        }
      }
      else
      {
        uf = old;
      }
    }
    catch (Exception e)
    {
      uf = old;
    }
    return uf;
  }
  
  public static String ucWords(String old, boolean ucFirst)
  {
    String buw = "";
    if (old != null)
    {
      String uw = old.toUpperCase();
      String[] uws = uw.split(" ");
      
      int imax = uws.length;
      if (ucFirst) {
        for (int i = 0; i < imax; i++) {
          buw = buw + ucFirst(uws[i]) + " ";
        }
      }
      for (int i = 0; i < imax; i++) {
        if (i == 0) {
          buw = buw + uws[i].toLowerCase() + " ";
        } else {
          buw = buw + ucFirst(uws[i]) + " ";
        }
      }
    }
    else
    {
      buw = old;
    }
    return buw;
  }
}

