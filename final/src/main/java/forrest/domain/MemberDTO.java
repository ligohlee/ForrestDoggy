package forrest.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO {

	String memId;
	String memName;
	String memPass;
	String memEmail;
	String memAddr;
	String memPh;
	
}
