package forrest.mapper.backoffice.staypark.room;

import java.util.List;

import forrest.domain.backoffice.staypark.OptionsDTO;
import forrest.domain.backoffice.staypark.RoomDTO;

public interface RoomMapper {

	void insertRoom(RoomDTO dto);

	List<OptionsDTO> selectRoom();

}
