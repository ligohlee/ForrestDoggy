package forrest.service.sy;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import forrest.command.AuthInfo;
import forrest.command.sy.PointCommand;
import forrest.domain.sy.PointDTO;
import forrest.mapper.sy.PointMapper;

@Service
@Component
public class PointService {
	
	@Autowired
	PointMapper mapper;
	public void insertPoint(PointCommand pointCommand) {
		// TODO Auto-generated method stub
		PointDTO dto = new PointDTO();
		
		dto.setMemId(pointCommand.getMemId());
		dto.setPointIn(pointCommand.getPointIn());
		dto.setPointOut(pointCommand.getPointOut());
		
		int pointIn = Integer.parseInt(pointCommand.getPointIn());
		int pointOut = Integer.parseInt(pointCommand.getPointOut());
		int pointSum = Integer.parseInt(pointCommand.getPointSum());
		
		int nowSum = pointSum-pointOut+pointIn;
		
		dto.setPointSum(Integer.toString(nowSum));
		
		mapper.insertPoint(dto);
				
	}
	public void selectPointSum(HttpSession session, Model model) {
		// TODO Auto-generated method stub
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		PointDTO dto = new PointDTO();
		dto = mapper.selectPointSum(authInfo.getId());
		System.out.println(dto);
		model.addAttribute("pointSum", dto.getPointSum());
	}

}
