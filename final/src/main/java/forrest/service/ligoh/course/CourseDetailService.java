package forrest.service.ligoh.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import forrest.domain.ligoh.CourseDTO;
import forrest.mapper.ligoh.CourseMapper;

@Service
@Component
public class CourseDetailService {
  @Autowired
  CourseMapper courseMapper;
  
	public void getCourse(Integer courseNum, Model model) throws Exception {
		    
		   CourseDTO num = new CourseDTO(courseNum,null,null,0,0,null);
		  
		   CourseDTO soup = courseMapper.getSoup(num);
		   CourseDTO salad = courseMapper.getSalad(num);
		   CourseDTO main = courseMapper.getMainMenu(num);
		   CourseDTO dessert = courseMapper.getDessert(num);
		   CourseDTO drink = courseMapper.getDrink(num);
		   
		   CourseDTO course = courseMapper.getCourse(num).get(0);
		
		    model.addAttribute("list", course);
		    model.addAttribute("soup", soup);
		    model.addAttribute("salad", salad);
		    model.addAttribute("main", main);
		    model.addAttribute("dessert", dessert);
		    model.addAttribute("drink", drink);
		
	}

}
