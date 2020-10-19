package forrest.command.jm;

import java.sql.Timestamp;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WareCommand {
	@NotNull
	Integer wareNum;
	Integer goodsNum;
	@NotNull
	Integer wareQty;
	@NotNull
	Timestamp wareRegist;
	String goodsName;
	String ptName;
	String ptType;
	String goodsCategory;
	String goodsMade;
	

}
