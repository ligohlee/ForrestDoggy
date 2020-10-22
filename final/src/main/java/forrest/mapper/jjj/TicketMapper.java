package forrest.mapper.jjj;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import forrest.domain.jjj.TicketDTO;
import forrest.domain.jjj.TicketOrderDTO;
@Repository
@Component
public interface TicketMapper {

	void insertTicket(TicketDTO dto);

	List<TicketDTO> selectTicketAll(TicketDTO dto);

	TicketDTO selectTicket(TicketDTO ticketNum1);

	void updateTicket(TicketDTO dto);

	void deleteTicket(int ticketNum);

	void updateQty(TicketOrderDTO dto);

}
