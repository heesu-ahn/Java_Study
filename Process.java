package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


// ������ ��ó�� �������� �о�� �����͸�  ������ ������ �ϴ� Ŭ����
public class Process {
	
	public boolean ReadData() {
		
		boolean retry = false; // �߸��� ������ �Է¿� ���� ��õ�
		boolean confirm = false; // ���� �Է��� �����Ͱ� �´��� Ȯ���ϰ� ���Է� �� ������ �Ǵ�
		boolean next = false; // ���� �Է� �ܰ谡 ���� ��� �����Ͽ� �ٸ� ����� ������		
		
		DataProcess process = new DataProcess();

		try {

			InputStreamReader Ir = new InputStreamReader(System.in);			
			BufferedReader Br = new BufferedReader(Ir);
						
			process.getData(Br.readLine());	
			retry = process.retry;

		} catch (IOException e) {

			e.printStackTrace();
			retry = true;
		}
		
		String readData = process.ReturnValue(); // ��ȯ���� �˱� ���� �ϴ� ������ �ݺ������� �ϴ� ���� ����
		
		if(!readData.equals("")) {
			
			System.out.print("\n>>System Message : Value : " + readData);
			retry = false; // �Է¹��� ���� ���� ��쿡�� �б� ��õ��� ���� ����
			
			if(!process.isNumber) { // ������ �����Ͱ� �ƴ� ���
				// strData �� ���ĺ��� �ѱ��� ȥ���ؼ� ����Ͽ����� �Ǻ��ϴ� �޼ҵ�
				if(process.combineAlphabet(readData)) {
					System.out.print("\n>>Input Error : You use English mixed with Hangul.\n>>Please Check Input Data Again.\n");
					System.out.print(">>System Message : Value : " + readData);
					retry = true;
				} else {
					// ���� �Է� ���� ���� ���������� �´��� �Ǵ� �� ���Է� ���θ� ����� �޼ҵ�
					if(process.ConfirmInputData()) {
						retry = true;
					} else {
						System.out.print("\n>>System Message : User decided InputData.");
						System.out.print("\n>>System Message : Value : " + readData);
					}
					
				}
			} else {
				if(process.ConfirmInputData()) {
					retry = true;
				} else {
					System.out.print("\n>>System Message : User decided InputData.");
					System.out.print("\n>>System Message : Value : " + readData);
				}
			}
			
			
		}
		
		return retry;
		
	}
	

	
	
	

}
