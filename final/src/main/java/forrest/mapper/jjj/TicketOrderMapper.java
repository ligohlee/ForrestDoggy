package forrest.mapper.jjj;

import java.util.List;

import forrest.domain.jjj.TicketOrderDTO;

public interface TicketOrderMapper {

	void insertOrder(TicketOrderDTO dto);

	void insertOrderList(TicketOrderDTO dto);

	List<TicketOrderDTO> selectNowOrder(TicketOrderDTO dto);

}
