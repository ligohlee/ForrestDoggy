package forrest.mapper.ligoh;

import java.util.List;

import forrest.domain.ligoh.MenuListDTO;

public interface MorderListMapper {

	public List<MenuListDTO> getMenu(Integer integer) throws Exception;

	public void insertMenu(MenuListDTO menuListDTO) throws Exception;

}
