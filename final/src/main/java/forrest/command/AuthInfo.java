package forrest.command;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthInfo {
	String id;
	String ph;
	String name;
	String pw;
}