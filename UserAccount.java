package study;

public class UserAccount {
		
	private UserInfo _user;
	
	private class UserInfo {
		String _name;
		int _age;
		String _gender;
		String _phone;
		String _Mail;
	}
	
	public void CreateUser() {
		UserInfo info = new UserInfo();
		_user = info;
	}
	
	public String getName() {
		String name = _user._name;
		return name;
	}	
	public void SetName(String name) {
		if(_user != null) {
			_user._name = name;
		}
	}
	
	public int getAge() {
		int age = _user._age;
		return age;
	}	
	public void SetAge(int age) {
		if(_user != null) {
			_user._age = age;
		}
	}
	
	public String getGender() {
		String gender = _user._gender;
		return gender;
	}	
	public void SetGender(String gender) {
		if(_user != null) {
			_user._gender = gender;
		}
	}
	
	public String getPhone() {
		String phone_number = _user._phone;
		return phone_number;
	}	
	public void SetPhone(String phone_number) {
		if(_user != null) {
			_user._phone = phone_number;
		}
	}	

	public String getMail() {
		String Email = _user._Mail;
		return Email;
	}	
	public void SetMail(String Email) {
		if(_user != null) {
			_user._Mail = Email;
		}
	}	
}
