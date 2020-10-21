package forrest.service.ligoh.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import forrest.command.ligoh.CourseCommand;
import forrest.domain.ligoh.ClistDTO;
import forrest.domain.ligoh.CourseDTO;
import forrest.mapper.ligoh.CourseMapper;

@Service
@Component
public class CourseWriteServie {
	@Autowired
	CourseMapper courseMapper;

	public String write(CourseCommand cc) throws Exception {
		CourseDTO dto = new CourseDTO();
		dto.setCourseName(cc.getCourseName());
		dto.setCourseContent(cc.getCourseContent());
		
		courseMapper.makeCourse(dto);
		
		ClistDTO nowNum = courseMapper.nowNum();	
		System.out.println(nowNum+"dfdfdfdfdfdfdfdf");
		
		Integer [] menuL = cc.getMenuNum();
		
		ClistDTO cdto = new ClistDTO();
		
		for (Integer menu : menuL) {
			if (menu > 0 ) {
				cdto.setCourseNum(nowNum.getCourseNum());
				cdto.setMenuNum(menu);
				courseMapper.addMenu(cdto);
			}
			
		}
		
	
		String location="redirect:/espback/course/list";
		
		return location;
	}

}
