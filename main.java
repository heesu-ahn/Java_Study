package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main {

	public static void main(String[] args) {
		
		boolean _repeat = false;
		
		Process proc = new Process();
		_repeat = true; 
		
		System.out.println(">>System Message : Please Input Data...");
		
		while(_repeat) {
			
			/* ReadData 
			 * �Է°��� ���������� ���ڿ����� �Ǵ��ϴ� ��� 
			 * �Է� ���� �ƹ��� ���� �Է��� ���� �ʾҴ��� �Ǵ��ϴ� ���
			 * */ 				
			_repeat = proc.ReadData(); 
			
			
			if(_repeat) {
				System.out.println("\n>>System Message : Process Retry");
				System.out.println("\n>>System Message : Please Input Data...");
			} else {
				System.out.println("\n>>System Message : Process Exit");
			}
			
		}
		
		
		

	}

}
