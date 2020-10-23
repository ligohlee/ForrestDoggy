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
	Integer goodsNum;
	Integer gorderPrice;
	Integer gorderQty;
	Integer dyPrice;
	String dyMemName;
	String dyMemAddr;
	String addr1;
	String addr2;
	
}
