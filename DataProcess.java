package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

// ������ ��ó�� Ŭ����
public class DataProcess {

	private Object RawData = null; // ���� ������
	private String  strData = ""; // ���ڿ� ������
	private int intData = 0; // ������ ������(���� ���� �� ���ڿ��� �Ź� ���������� ��ȯ�ϴ� ���� ����)
	
	
	public boolean isNumber= false; // ���ڿ� ����
	public boolean retry = false; // ��õ� ����
	
	
	// input �����͸� �Է¹޾Ƽ� ���ڿ����� �������� �Ǵ�
	public void getData(String getData) throws IOException {
		
		RawData = getData;
		if(RawData.getClass() == String.class) {
			try {
				if(!getData.toString().equals("")) {
					
					String pattern = "^[0-9]*$"; // �������� ���θ� �Ǵ��ϴ� ���Խ�
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
			retry = true; // �Է¹��� ���� 0 �̳� ������ ��쿡�� ��õ�
		} else {
			retry = false;
		}
	} 

	// �Է� ���� ���� ������ ��ȯ�ϴ� �޼ҵ�
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
	
	// ���ĺ��� �ѱ��� ȥ��Ǿ����� �Ǻ��ϴ� �޼ҵ�
	public boolean combineAlphabet(String inputData) {
		boolean combine = true;		
		String [] PatternCase = {
			 "^[a-zA-Z0-9]*$" // ���ĺ��� Ư������ ���� ������ ���̵� Ȥ�� �̸��� ó���� ���� ȥ���� �ʿ�
			,"^[��-����-�R]*$" // ���� �ѱ� ����
			,"^[��-����-�R0-9\\W]*$" // �ѱ۰� ���� ������ �̸��� �ּҸ� ���� ȥ���� �ʿ�
			,"^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$" // �̸��� ����
			,"^\\d{3}-\\d{3,4}-\\d{4}$" // �޴���ȭ ����
			,"^\\d{2,3}-\\d{3,4}-\\d{4}$" // �Ϲ� ��ȭ ��ȣ ����			
		};
		
		// ó������ ȥ�Չ�ٴ� �����Ͽ� �ݺ����� ���ؼ� �� ������ ���Խ��� ��ġ�ϰ� �Ǹ� ȥ�յ��� ���� ������ ������
		for(String pattern : PatternCase) {
			if(inputData.toString().matches(pattern)){
				combine = false;
			} 
		}
				
		return combine;
	}
	
	// ���� �Է� ���� ���� ���������� �´��� �Ǵ� �� ���Է� ���θ� ����� �޼ҵ� 
	public boolean ConfirmInputData() {
		
		boolean disagreeData = false; // �Է¹��� ���� ���� ���� �ٽ� �Է�
		System.out.print("\n>>System Message : Are you sure decide Your Data ?\n");
		Scanner sc = new Scanner(System.in);
		String YesNo = sc.next(); // Y or N �� �ܾ ���
		if(!YesNo.equals("Y")) { //Y �� �ƴ� ���� ���� ��õ�
			if(!YesNo.equals("N")) { // N ���� �Է����� ���� �Է¿� ���� ���� ó��
				System.out.print("\n>>Input Error : Decision Must Be ( Y or N )");
			} else {
				System.out.print("\n>>System Message : User denied InputData.");
			}
			disagreeData = true;
		} 
		
		return disagreeData;
	}
	
}
