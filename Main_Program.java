package study;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import study.SystemCode.AskProcess;

public class Main_Program {

	public static Integer step = 0;
	public static String Target = "";
	public static InputData input;
	//public static Scanner sc;
	
	public static void main(String[] args) throws IOException {
		
		boolean RunProcess = true;		
		//Scanner sc = new Scanner(System.in);	
		String YesOrNo = "";
		String str = "";
				
		System.out.println("사용자 등록을 하시겠습니까? (Y/N)");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine();
		
		
		if(str.equals("Y")) {
			
			UserAccount Account = new UserAccount();
			Account.CreateUser();
			
			input = new InputData();
			
			step = 0;
			ChangeTarget(step);							

			do {
				
				ChangeTarget(step);	
				
				input = new InputData();
				
				if(step == SystemCode.Age) {

					if(input.ConfirmValue(step, "I", Account)) {
						step ++;						
					}
					RunProcess = true;
					
				} else {
					
					if(input.ConfirmValue(step, "S", Account)) {
						step ++;						
					}	
					RunProcess = true;
					
				}
				
				if(step == SystemCode.Exit) {
					RunProcess = false;
					
					System.out.println("Name:" + Account.getName());
					System.out.println("Gender:" + Account.getGender());
					System.out.println("Age:" + Account.getAge());
					System.out.println("Phone:" + Account.getPhone());
					System.out.println("Email:" + Account.getMail());
					
				}
				
				
			} while(RunProcess);
		}
				
	}
	
	
	
	
	private static void ChangeTarget(Integer step) {
		switch (step) {
		case SystemCode.Name:
			Target = "이름";
			break;
		case SystemCode.Gender:
			Target = "성별";
			break;
		case SystemCode.Age:
			Target = "나이";
			break;
		case SystemCode.PhoneNumber:
			Target = "전화번호";
			break;
		case SystemCode.EmailAddress:
			Target = "이메일주소";
			break;			
		}
	}
	
	

}
