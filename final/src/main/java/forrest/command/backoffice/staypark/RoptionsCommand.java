package forrest.command.backoffice.staypark;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoptionsCommand {
	
	int roomNum;
	int optNum;
	int roptionQty;

}
