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
			 * 입력값이 정수형인지 문자열인지 판단하는 기능 
			 * 입력 값에 아무런 값도 입력이 되지 않았는지 판단하는 기능
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
