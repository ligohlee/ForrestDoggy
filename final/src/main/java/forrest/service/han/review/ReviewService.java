package forrest.service.han.review;


import java.sql.Timestamp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import forrest.command.han.ReviewCommand;
import forrest.domain.han.ReviewDTO;
import forrest.mapper.han.ReviewMapper;

@Component
@Service
public class ReviewService {
	@Autowired
	ReviewMapper reviewMapper;
	public void revInsert(ReviewCommand reviewCommand)throws Exception{
		ReviewDTO dto = new ReviewDTO();
	dto.setAttain(reviewCommand.getAttain());
	dto.setCooper(reviewCommand.getCooper());
	dto.setCreativity(reviewCommand.getCreativity());
	dto.setEffort(reviewCommand.getEffort());
	dto.setKnowle(reviewCommand.getKnowle()) ;
	dto.setQuality(reviewCommand.getQuality());
	dto.setResponsibility(reviewCommand.getResponsibility());
	dto.setRevNum(reviewCommand.getRevNum());
	dto.setRevWriter(reviewCommand.getRevWriter());
	dto.setWorkNum(reviewCommand.getWorkNum());
	
	  Timestamp revdate = new Timestamp(reviewCommand.getRevDate().getTime());
	  System.out.println(reviewCommand.getRevDate());
	  dto.setRevDate(revdate); reviewMapper.reviewInsert(dto);
	 
	
	}
}
