package forrest.service.han.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import forrest.domain.han.ReviewDTO;
import forrest.mapper.han.ReviewMapper;

@Component
@Service
public class RevdetailService {
	@Autowired
	ReviewMapper reviewMapper;
	public void detailview(Integer workNum, Model model)throws Exception{
		ReviewDTO dto = reviewMapper.detailview(workNum);
		model.addAttribute("dto", dto);
	}
}
