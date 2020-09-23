package forrest.command.member;

import java.time.LocalDateTime;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class MemberCommand {

	   String memId;
	   
	   String memName;

	   String memPass;

	   String memPassCon;

	   String memEmail;

	   String memAddr;
	   
	   String memPh;
	
	public boolean isUserPwEqualToUserPwCon() {
		if(memPass.equals(memPassCon)) {
			return true;
		}
		return false;
	}
}