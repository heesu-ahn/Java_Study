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
		
		// ������ �� �ľ�
		if(!_isBlank) {
			
			// ��ȭ��ȣ ���Խ�
			
			// �̸��� ���Խ�
			
			
		}
		
	}
	
	public boolean ConfirmValue(Integer step ,String Parameter, UserAccount account) throws IOException {
	
		_isConfirm = true;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Target = get_Target(step);
		System.out.println(String.format("%s�� �Է��ϼ���", Target));
		
		String str = br.readLine();		
		
		
		if(tryPaseInt(str)) {
			inputData = Integer.parseInt(str);	
		} else {
			inputData =str;
		}
		

		if (_isBlank) {
			System.out.println("�Է°��� �����Դϴ�.");
			System.out.println(String.format("%s�� �Է��ϼ���", Target));
			_isConfirm = false;
		}
		
		if(Parameter == "S") {
			
			if(inputData instanceof String) {
				
				
				System.out.println(String.format("�Է¹��� %s��(��) " + str + " �Դϴ�.", Target));
				System.out.println("�ٽ� �Է� �Ͻðڽ��ϱ�? (Y/N)");
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
				
				System.out.println("�߸��� ������ �Է°� �Դϴ�.  " + str);
				return false;
			}

			
		} else if (Parameter == "I") {
			
			if(!(inputData instanceof String)) {
				
				System.out.println("�Է¹��� ���� " + str + " �Դϴ�.");
				System.out.println("�ٽ� �Է� �Ͻðڽ��ϱ�? (Y/N)");
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
				
				System.out.println("�߸��� ������ �Է°� �Դϴ�.  " + str);
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
		
		if(kind == SystemCode.PhoneNumber) { // ��ȭ��ȣ
			
		}
		
		if(kind == SystemCode.EmailAddress) { // �̸���
			
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
			_Target = "�̸�";
			break;
		case SystemCode.Gender:
			_Target = "����";
			break;
		case SystemCode.Age:
			_Target = "����";
			break;
		case SystemCode.PhoneNumber:
			_Target = "��ȭ��ȣ";
			break;
		case SystemCode.EmailAddress:
			_Target = "�����ּ�";
			break;			
		}
		return _Target;
		
		
	}
	
}
