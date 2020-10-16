package forrest.command.jm;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GOrderCommand {
	Integer gorderNum;
	String memId;
	Timestamp gorderRegist;
}