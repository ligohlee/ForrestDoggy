package forrest.mapper.sy.room;

import java.util.List;


import forrest.domain.sy.room.RoomDTO;





public interface RoomMapper {

	void insertRoom(RoomDTO dto);

	List<RoomDTO> selectRoom(Integer roomNum);

}
