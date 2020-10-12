package forrest.command.han;


import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalCommand {
	Integer salNum;
	Integer workNum;
	Integer salNow;
	Integer salIncre;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date salYear;
	String salCont;
	MultipartFile salImage;
}
