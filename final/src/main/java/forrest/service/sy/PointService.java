package forrest.service.sy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

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
		if (dto.getPointIn() == null) {
			dto.setPointIn("0");
			System.out.println("dto포인트인(스트링): "+dto.getPointIn());
		}
		dto.setPointOut(pointCommand.getPointOut());
		System.out.println("pointCommand.getPointOut: "+pointCommand.getPointOut());
		if (dto.getPointOut() == null) {
			dto.setPointOut("0");
			System.out.println("dto포인트아웃(스트링): "+dto.getPointOut());
		}
		
		Integer pointIn = Integer.parseInt(dto.getPointIn());
		System.out.println("포인트인(인티저): "+pointIn);
		Integer pointOut = Integer.parseInt(dto.getPointOut());
		System.out.println("포인트아웃(인티저): "+pointOut);
		
		String pointSum0 = pointCommand.getPointSum();
		System.out.println("코맨드 포인트썸(스트링): "+pointSum0);
		
		Integer nowSum;
		Integer pointSum;
		
		if (pointSum0 == null) {			
			pointSum=0;
			System.out.println("코맨드 포인트썸이 null일 떄 pointSum: "+pointSum);
		}else {
			pointSum = Integer.parseInt(pointCommand.getPointSum());
			System.out.println("코맨드 포인트썸이 null이 아닐 때 pointSum: "+pointSum);
		}
		
		nowSum = pointSum-pointOut+pointIn;
		System.out.println("nowSum: "+nowSum);
		
		dto.setPointSum(Integer.toString(nowSum));
		System.out.println("dto포인트썸: "+dto.getPointSum());
		
		mapper.insertPoint(dto);
		System.out.println(dto);
				
	}

}
