package forrest.mapper.ligoh;

import java.util.List;

import forrest.domain.ligoh.MenuListDTO;

public interface MorderListMapper {

	public List<MenuListDTO> getMenu(Integer integer) throws Exception;

	public void insertMenu(MenuListDTO menuListDTO) throws Exception;
	public void insertCourse(MenuListDTO menuListDTO) throws Exception;

	public List<MenuListDTO> getCourse(Integer mordNum) throws Exception;

	public List<MenuListDTO> getDogMenu(Integer mordNum) throws Exception;

	

}
