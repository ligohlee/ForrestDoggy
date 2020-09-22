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
	@Size(min = 4, max = 12,message = "아이디를 입력하여 주세요.")
	String userId;
	@NotEmpty
	String userPw;
	@NotBlank
	String userPwCon;
	@Email
	String userEmail;
	@NotEmpty
	@Size(min = 15, max = 50)
	String userAddr;
	@NotNull
	@Size(min = 5, max = 13)
	String userPh;
	
	
	public boolean isUserPwEqualToUserPwCon() {
		if(userPw.equals(userPwCon)) {
			return true;
		}
		return false;
	}
}