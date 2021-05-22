package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


// 데이터 전처리 과정에서 읽어온 데이터를  가지고 행위를 하는 클래스
public class Process {
	
	public boolean ReadData() {
		
		boolean retry = false; // 잘못된 데이터 입력에 대한 재시도
		boolean confirm = false; // 현재 입력한 데이터가 맞는지 확인하고 재입력 할 것인지 판단
		boolean next = false; // 다음 입력 단계가 있을 경우 지속하여 다른 기능을 실행함		
		
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
		
		String readData = process.ReturnValue(); // 반환값을 알기 위해 일는 행위를 반복적으로 하는 것을 방지
		
		if(!readData.equals("")) {
			
			System.out.print("\n>>System Message : Value : " + readData);
			retry = false; // 입력받은 값이 있을 경우에는 읽기 재시도를 하지 않음
			
			if(!process.isNumber) { // 정수형 데이터가 아닌 경우
				// strData 가 알파벳과 한글을 혼용해서 사용하였는지 판별하는 메소드
				if(process.combineAlphabet(readData)) {
					System.out.print("\n>>Input Error : You use English mixed with Hangul.\n>>Please Check Input Data Again.\n");
					System.out.print(">>System Message : Value : " + readData);
					retry = true;
				} else {
					// 현재 입력 받은 값이 최종적으로 맞는지 판단 후 재입력 여부를 물어보는 메소드
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
