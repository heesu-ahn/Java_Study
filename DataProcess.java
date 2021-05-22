package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

// µ¥ÀÌÅÍ ÀüÃ³¸® Å¬·¡½º
public class DataProcess {

	private Object RawData = null; // ¿ø½Ã µ¥ÀÌÅÍ
	private String  strData = ""; // ¹®ÀÚ¿­ µ¥ÀÌÅÍ
	private int intData = 0; // Á¤¼öÇü µ¥ÀÌÅÍ(°ªÀ» ºñ±³ÇÒ ¶§ ¹®ÀÚ¿­À» ¸Å¹ø Á¤¼öÇüÀ¸·Î º¯È¯ÇÏ´Â °ÍÀ» ¹æÁö)
	
	
	public boolean isNumber= false; // ¹®ÀÚ¿­ ¿©ºÎ
	public boolean retry = false; // Àç½Ãµµ ¿©ºÎ
	
	
	// input µ¥ÀÌÅÍ¸¦ ÀÔ·Â¹Ş¾Æ¼­ ¹®ÀÚ¿­ÀÎÁö Á¤¼öÀÎÁö ÆÇ´Ü
	public void getData(String getData) throws IOException {
		
		RawData = getData;
		if(RawData.getClass() == String.class) {
			try {
				if(!getData.toString().equals("")) {
					
					String pattern = "^[0-9]*$"; // Á¤¼öÀÎÁö ¿©ºÎ¸¸ ÆÇ´ÜÇÏ´Â Á¤±Ô½Ä
					if(getData.toString().matches(pattern)) {
						intData = Integer.parseInt(getData.toString());
						strData = String.valueOf(intData);
						isNumber = true;
						retry = false;
					} else {
						strData = getData.toString();
						isNumber = false;
						retry = false;	
					} 
					
				} else {
					strData = getData.toString();
					isNumber = false;
					retry = false;	
				}
				
				
			}catch (NumberFormatException e) {
				intData = 0;
				strData = getData.toString();
				isNumber = false;
				retry = true;
				e.printStackTrace();
			}
			
		}
		
		if(strData.isEmpty()) {
			System.out.print(">>Input Error : Input Data is Blank.\n>>Please Check Your Input Data Again.");
			retry = true; // ÀÔ·Â¹ŞÀº °ªÀÌ 0 ÀÌ³ª °ø¹éÀÏ °æ¿ì¿¡¸¸ Àç½Ãµµ
		} else {
			retry = false;
		}
	} 

	// ÀÔ·Â ¹ŞÀº °ªÀÇ ³»¿ëÀ» ¹İÈ¯ÇÏ´Â ¸Ş¼Òµå
	public String ReturnValue() {
		String Value = "";
		
		if(isNumber) {
			System.out.print(String.format("\n>>System Info : From Intiger Object Returned [ %d ] Data.", intData));
			Value = String.valueOf(intData);
		} else {
			System.out.print(String.format( "\n>>System Info : From String Object Returned [ %s ] Data.", strData));
			Value = strData;
		}

		return Value;
	}
	
	// ¾ËÆÄºª°ú ÇÑ±ÛÀÌ È¥¿ëµÇ¾ú´ÂÁö ÆÇº°ÇÏ´Â ¸Ş¼Òµå
	public boolean combineAlphabet(String inputData) {
		boolean combine = true;		
		String [] PatternCase = {
			 "^[a-zA-Z0-9]*$" // ¾ËÆÄºª°ú Æ¯¼ö¹®ÀÚ ¼ıÀÚ Á¶ÇÕÀº ¾ÆÀÌµğ È¤Àº ÀÌ¸ŞÀÏ Ã³¸®¸¦ À§ÇØ È¥¿ëÀÌ ÇÊ¿ä
			,"^[¤¡-¤¾°¡-ÆR]*$" // ¼ø¼ö ÇÑ±Û ÆĞÅÏ
			,"^[¤¡-¤¾°¡-ÆR0-9\\W]*$" // ÇÑ±Û°ú ¼ıÀÚ Á¶ÇÕÀº ÀÌ¸§°ú ÁÖ¼Ò¸¦ À§ÇØ È¥¿ëÀÌ ÇÊ¿ä
			,"^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$" // ÀÌ¸ŞÀÏ ÆĞÅÏ
			,"^\\d{3}-\\d{3,4}-\\d{4}$" // ÈŞ´ëÀüÈ­ ÆĞÅÏ
			,"^\\d{2,3}-\\d{3,4}-\\d{4}$" // ÀÏ¹İ ÀüÈ­ ¹øÈ£ ÆĞÅÏ			
		};
		
		// Ã³À½¿¡´Â È¥ÇÕ‰ç´Ù´Â °¡Á¤ÇÏ¿¡ ¹İº¹¹®À» ÅëÇØ¼­ ÇÑ °¡Áö¶óµµ Á¤±Ô½ÄÀÏ ÀÏÄ¡ÇÏ°Ô µÇ¸é È¥ÇÕµÇÁö ¾ÊÀº °ÍÀ¸·Î °£ÁÖÇÔ
		for(String pattern : PatternCase) {
			if(inputData.toString().matches(pattern)){
				combine = false;
			} 
		}
				
		return combine;
	}
	
	// ÇöÀç ÀÔ·Â ¹ŞÀº °ªÀÌ ÃÖÁ¾ÀûÀ¸·Î ¸Â´ÂÁö ÆÇ´Ü ÈÄ ÀçÀÔ·Â ¿©ºÎ¸¦ ¹°¾îº¸´Â ¸Ş¼Òµå 
	public boolean ConfirmInputData() {
		
		boolean disagreeData = false; // ÀÔ·Â¹ŞÀº °©À» ÀÎÁ¤ ¸øÇÔ ´Ù½Ã ÀÔ·Â
		System.out.print("\n>>System Message : Are you sure decide Your Data ?\n");
		Scanner sc = new Scanner(System.in);
		String YesNo = sc.next(); // Y or N ÇÑ ´Ü¾î¸¸ »ç¿ë
		if(!YesNo.equals("Y")) { //Y °¡ ¾Æ´Ñ °ÍÀº ÀüºÎ Àç½Ãµµ
			if(!YesNo.equals("N")) { // N À¸·Î ÀÔ·ÂÇÏÁö ¾ÊÀº ÀÔ·Â¿¡ ´ëÇÑ ¿À·ù Ã³¸®
				System.out.print("\n>>Input Error : Decision Must Be ( Y or N )");
			} else {
				System.out.print("\n>>System Message : User denied InputData.");
			}
			disagreeData = true;
		} 
		
		return disagreeData;
	}
	
}
