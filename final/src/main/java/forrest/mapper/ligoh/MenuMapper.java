package forrest.mapper.ligoh;

import java.util.List;

import forrest.domain.jm.StartEndPageDTO;
import forrest.domain.ligoh.MenuDTO;

public interface MenuMapper {

	public void menuInsert(MenuDTO dto) throws Exception;

	public List<MenuDTO> getMenu(StartEndPageDTO dto) throws Exception;

	public int getMenuCount() throws Exception;


	public List<MenuDTO> getSoup()throws Exception;

	public List<MenuDTO> getSalad()throws Exception;

	public List<MenuDTO> getMainMenu()throws Exception;

	public List<MenuDTO> getDessert()throws Exception;

	public List<MenuDTO> getDogMenu()throws Exception;

	public List<MenuDTO> getDrink()throws Exception;

}
