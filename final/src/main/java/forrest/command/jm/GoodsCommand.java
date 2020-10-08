package forrest.command.jm;


import java.sql.Timestamp;

import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsCommand {
	@NotNull
	Integer goodsNum;
	Integer ptNum;
	Integer ctNum;
	@NotNull
	String goodsName;
	@NotNull
	Integer goodsPrice;
	@NotNull
	String goodsCategory;
	@NotNull
	String goodsMade;
	@NotNull
	String goodsSize;
	String goodsManual;
	String goodsIntro;
	Timestamp goodsTimeLimit;
	
	MultipartFile report;
	
	
	
	
	
	
	
	
	
}
