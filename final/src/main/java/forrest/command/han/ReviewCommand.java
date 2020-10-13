package forrest.command.han;




import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewCommand {
	Integer revNum;
	Integer workNum;
	Integer quality;
	Integer attain;
	Integer effort;
	Integer creativity;
	Integer responsibility;
	Integer cooper;
	Integer knowle;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date revDate;
	String revWriter;
}
