package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputData {
	
	public Object inputData;
	
	public boolean _isBlank = false;
	public boolean _isConfirm = false;
	public static String Target = "";
	
	public void getType(String str) {
		
		// 데이터 형 파악
		if(!_isBlank) {
			
			// 전화번호 정규식
			
			// 이메일 정규식
			
			
		}
		
	}
	
	public boolean ConfirmValue(Integer step ,String Parameter, UserAccount account) throws IOException {
	
		_isConfirm = true;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Target = get_Target(step);
		System.out.println(String.format("%s를 입력하세요", Target));
		
		String str = br.readLine();		
		
		
		if(tryPaseInt(str)) {
			inputData = Integer.parseInt(str);	
		} else {
			inputData =str;
		}
		

		if (_isBlank) {
			System.out.println("입력값이 공백입니다.");
			System.out.println(String.format("%s를 입력하세요", Target));
			_isConfirm = false;
		}
		
		if(Parameter == "S") {
			
			if(inputData instanceof String) {
				
				
				System.out.println(String.format("입력받은 %s은(는) " + str + " 입니다.", Target));
				System.out.println("다시 입력 하시겠습니까? (Y/N)");
				String YesOrNo = br.readLine();
				
				if(YesOrNo.equals("Y")) {
					return false;
				}
				
				
				if(step ==SystemCode.Name ){
					Target = get_Target(step);
					account.SetName(str);
				}
				else if(step ==SystemCode.Gender ){
					Target = get_Target(step);
					account.SetGender(str);
				}
				else if(step ==SystemCode.Age ){
					Target = get_Target(step);
					account.SetAge(Integer.parseInt(str));
				}
				else if(step ==SystemCode.PhoneNumber ){
					Target = get_Target(step);
					account.SetPhone(str);
				}
				else if(step ==SystemCode.EmailAddress ){
					Target = get_Target(step);
					account.SetMail(str);
				}
				
			} else {
				
				System.out.println("잘못된 형식의 입력값 입니다.  " + str);
				return false;
			}

			
		} else if (Parameter == "I") {
			
			if(!(inputData instanceof String)) {
				
				System.out.println("입력받은 값은 " + str + " 입니다.");
				System.out.println("다시 입력 하시겠습니까? (Y/N)");
				String YesOrNo = br.readLine();
				
				if(YesOrNo.equals("Y")) {
					return false;
				}
				
				if(step ==SystemCode.Name ){
					Target = get_Target(step);
					account.SetName(str);
				}
				else if(step ==SystemCode.Gender ){
					Target = get_Target(step);
					account.SetGender(str);
				}
				else if(step ==SystemCode.Age ){
					Target = get_Target(step);
					account.SetAge(Integer.parseInt(str));
				}
				else if(step ==SystemCode.PhoneNumber ){
					Target = get_Target(step);
					account.SetPhone(str);
				}
				else if(step ==SystemCode.EmailAddress ){
					Target = get_Target(step);
					account.SetMail(str);
				}
				
			} else {
				
				System.out.println("잘못된 형식의 입력값 입니다.  " + str);
				return false;
			}
		}
		
		return _isConfirm;
	}
	
	boolean tryPaseInt(String in) {
		
		boolean result;
		try {
			
			Integer.parseInt(in);			
			result = true;
			
		}catch (NumberFormatException e) {
			result = false;
		}
		
		return result;
	}
	
	boolean Regular_Expression(String matches, Integer kind) {
		boolean result = false;
		
		if(kind == SystemCode.PhoneNumber) { // 전화번호
			
		}
		
		if(kind == SystemCode.EmailAddress) { // 이메일
			
		}
		
		
		return result;
	}
	
	boolean IsEmpty(String input) {
		
		boolean _isEmpty;
		
		if(input.isBlank() || input.isEmpty()) {
			_isEmpty = true;
		} else {
			_isEmpty = false;
		}
		
		return _isEmpty;
		
	}
	
	private String get_Target(Integer step) {
		
		String _Target = null; 
		
		switch (step) {
		case SystemCode.Name:
			_Target = "이름";
			break;
		case SystemCode.Gender:
			_Target = "성별";
			break;
		case SystemCode.Age:
			_Target = "나이";
			break;
		case SystemCode.PhoneNumber:
			_Target = "전화번호";
			break;
		case SystemCode.EmailAddress:
			_Target = "메일주소";
			break;			
		}
		return _Target;
		
		
	}
	
}
