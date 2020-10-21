package forrest.command.ligoh;



import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class MorderCommand {
	
	Integer [] mordPeople;
	Integer [] courseNum;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	LocalDateTime mordDate;
	Integer mordPrice;
	String menuReq;
	String [] menuNum;
	
}
