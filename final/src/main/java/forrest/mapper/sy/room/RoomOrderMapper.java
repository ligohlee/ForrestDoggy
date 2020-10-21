package forrest.mapper.sy.room;

import java.util.List;

import forrest.domain.sy.room.RorderDTO;

public interface RoomOrderMapper {

	void insertRoomOrder(RorderDTO dto);
	List<RorderDTO> selectRoomOrderNow(RorderDTO dto);
	List<RorderDTO> selectList(RorderDTO dto);

}
