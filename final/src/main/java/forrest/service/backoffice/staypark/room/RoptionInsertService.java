package forrest.service.backoffice.staypark.room;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import forrest.command.backoffice.staypark.RoptionsCommand;

@Service
@Component
public class RoptionInsertService {

	public void insertRopt(RoptionsCommand rcommand) {
		// TODO Auto-generated method stub
		System.out.println(rcommand.getRoomNum());
		System.out.println(rcommand.getOptNum());
		System.out.println(rcommand.getRoptionQty());
	}

}
