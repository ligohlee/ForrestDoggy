package forrest.service.ligoh.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import forrest.command.ligoh.MorderCommand;
import forrest.domain.ligoh.CourseDTO;
import forrest.domain.ligoh.MorderDTO;
import forrest.mapper.ligoh.CourseMapper;

@Service
@Component
public class CourseListService2 {
	@Autowired
	CourseMapper courseMapper;

	public void getCourse(Model model, MorderCommand mc) throws Exception {
		
		Integer [] courses = mc.getCourseNum();
		Integer [] qty = mc.getMordPeople();
		MorderDTO mdto = new MorderDTO();
 			
		for (int i = 0; i < qty.length; i++) {
		}
		
		CourseDTO num = new CourseDTO(1,null,null,0,0,null);

	    List<CourseDTO> lists = courseMapper.getCourse(num);

	    model.addAttribute("lists", lists);
	
	}

}
