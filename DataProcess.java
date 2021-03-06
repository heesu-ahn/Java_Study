package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

// 데이터 전처리 클래스
public class DataProcess {

	private Object RawData = null; // 원시 데이터
	private String  strData = ""; // 문자열 데이터
	private int intData = 0; // 정수형 데이터(값을 비교할 때 문자열을 매번 정수형으로 변환하는 것을 방지)
	
	
	public boolean isNumber= false; // 문자열 여부
	public boolean retry = false; // 재시도 여부
	
	
	// input 데이터를 입력받아서 문자열인지 정수인지 판단
	public void getData(String getData) throws IOException {
		
		RawData = getData;
		if(RawData.getClass() == String.class) {
			try {
				if(!getData.toString().equals("")) {
					
					String pattern = "^[0-9]*$"; // 정수인지 여부만 판단하는 정규식
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
			retry = true; // 입력받은 값이 0 이나 공백일 경우에만 재시도
		} else {
			retry = false;
		}
	} 

	// 입력 받은 값의 내용을 반환하는 메소드
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
	
	// 알파벳과 한글이 혼용되었는지 판별하는 메소드
	public boolean combineAlphabet(String inputData) {
		boolean combine = true;		
		String [] PatternCase = {
			 "^[a-zA-Z0-9]*$" // 알파벳과 특수문자 숫자 조합은 아이디 혹은 이메일 처리를 위해 혼용이 필요
			,"^[ㄱ-ㅎ가-힣]*$" // 순수 한글 패턴
			,"^[ㄱ-ㅎ가-힣0-9\\W]*$" // 한글과 숫자 조합은 이름과 주소를 위해 혼용이 필요
			,"^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$" // 이메일 패턴
			,"^\\d{3}-\\d{3,4}-\\d{4}$" // 휴대전화 패턴
			,"^\\d{2,3}-\\d{3,4}-\\d{4}$" // 일반 전화 번호 패턴			
		};
		
		// 처음에는 혼합됬다는 가정하에 반복문을 통해서 한 가지라도 정규식일 일치하게 되면 혼합되지 않은 것으로 간주함
		for(String pattern : PatternCase) {
			if(inputData.toString().matches(pattern)){
				combine = false;
			} 
		}
				
		return combine;
	}
	
	// 현재 입력 받은 값이 최종적으로 맞는지 판단 후 재입력 여부를 물어보는 메소드 
	public boolean ConfirmInputData() {
		
		boolean disagreeData = false; // 입력받은 갑을 인정 못함 다시 입력
		System.out.print("\n>>System Message : Are you sure decide Your Data ?\n");
		Scanner sc = new Scanner(System.in);
		String YesNo = sc.next(); // Y or N 한 단어만 사용
		if(!YesNo.equals("Y")) { //Y 가 아닌 것은 전부 재시도
			if(!YesNo.equals("N")) { // N 으로 입력하지 않은 입력에 대한 오류 처리
				System.out.print("\n>>Input Error : Decision Must Be ( Y or N )");
			} else {
				System.out.print("\n>>System Message : User denied InputData.");
			}
			disagreeData = true;
		} 
		
		return disagreeData;
	}
	
}
