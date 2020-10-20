package forrest.command.sy.room;

import lombok.Data;

@Data
public class SelectOptionCommand {
	
	String selName[]; // 선택옵션 이름
	Integer selQty[]; // 선택옵션 수량
	Integer selPrice[]; // 선택옵션수량x가격
	String memId;
}
