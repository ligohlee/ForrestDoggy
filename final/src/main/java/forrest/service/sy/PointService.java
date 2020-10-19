package forrest.service.sy;

import forrest.command.sy.PointCommand;
import forrest.domain.sy.PointDTO;

public class PointService {

	public void insertPoint(PointCommand pointCommand) {
		// TODO Auto-generated method stub
		PointDTO dto = new PointDTO();
		dto.setMemId(pointCommand.getMemId());
		dto.setPointIn(pointCommand.getPoint_in());
		
				
	}

}
