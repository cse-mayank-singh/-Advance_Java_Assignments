public class Validator {
	public boolean isUsernameValid(String username) {
		if(username==null||username.isEmpty()) {
			return false;
		}
		if(username.length()<5||username.length()>15) {
			return false;
		}
		String pattern="[a-zA-Z0-9]+";
		if(username.matches(pattern)) {return true;}
		else {return false;}
	}
	
	public boolean isPasswordValid(String password) {
		if(password==null||password.isEmpty()==true) {
			return false;
		}
		if(password.length()<8) {
			return false;
		}
		String pattern="^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[@$!%*?&]).+$";
		if(password.matches(pattern)) {return true;}
		else{return false;}
	}
	public boolean isLoginValid(String username,String password) {
		return isUsernameValid(username)&&isPasswordValid(password);
	}
}
