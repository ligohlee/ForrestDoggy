package forrest.command.jm;

import java.sql.Timestamp;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class COrderCommand {
	@NotNull
	Integer cordNum;
	Integer goodsNum;
	@NotNull
	Integer cordQty;
	@NotNull
	Timestamp cordRegist;
}
