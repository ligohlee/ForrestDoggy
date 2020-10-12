package forrest.mapper.ligoh;

import java.util.List;

import forrest.domain.jm.StartEndPageDTO;
import forrest.domain.ligoh.MenuDTO;

public interface MenuMapper {

	public void menuInsert(MenuDTO dto) throws Exception;

	public List<MenuDTO> getMenu(StartEndPageDTO dto);

	public int getMenuCount();

}
