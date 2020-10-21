package forrest.mapper.ligoh;

import java.util.List;

import forrest.domain.ligoh.ClistDTO;
import forrest.domain.ligoh.CourseDTO;
import forrest.domain.ligoh.MenuDTO;

public interface CourseMapper {

	public void makeCourse(CourseDTO dto) throws Exception;

	public List<CourseDTO> getCourse(CourseDTO num)throws Exception;

	public int getCourseCount()throws Exception;

	public void addMenu(ClistDTO cdto)throws Exception;

	public ClistDTO nowNum() throws Exception;

	public CourseDTO getSoup(CourseDTO num) throws Exception;

	public CourseDTO getSalad(CourseDTO num) throws Exception;

	public CourseDTO getMainMenu(CourseDTO num)throws Exception;

	public CourseDTO getDessert(CourseDTO num)throws Exception;

	public CourseDTO getDrink(CourseDTO num)throws Exception;
	

}
