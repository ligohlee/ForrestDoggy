package forrest.command;

import lombok.Data;

@Data
public class LoginCommand {
	String memId;
	String memPass;
	Boolean idStore;
	Boolean autoLogin;
}
