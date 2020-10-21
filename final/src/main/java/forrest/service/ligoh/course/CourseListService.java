package forrest.service.ligoh.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import forrest.controller.page.PageAction;
import forrest.domain.jm.StartEndPageDTO;
import forrest.domain.ligoh.CourseDTO;
import forrest.mapper.ligoh.CourseMapper;

@Service
@Component
public class CourseListService {
	@Autowired
	CourseMapper courseMapper;

	public void getCourse(Model model) throws Exception {
		
		CourseDTO num = new CourseDTO(0,null,null,0,0,null);

	    List<CourseDTO> lists = courseMapper.getCourse(num);

	    model.addAttribute("lists", lists);
	
	}

}
