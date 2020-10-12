package forrest.service.han.review;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import forrest.domain.han.ReviewDTO;
import forrest.mapper.han.ReviewMapper;

@Component
@Service
public class ReviewlistService {
	@Autowired
	ReviewMapper reviewMapper;
	public void revview(Model model)throws Exception{
		List<ReviewDTO> lists = reviewMapper.getrevView();
		model.addAttribute("lists", lists);
	}
}
