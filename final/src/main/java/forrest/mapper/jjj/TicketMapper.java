package forrest.mapper.jjj;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import forrest.domain.jjj.TicketDTO;
@Repository
@Component
public interface TicketMapper {

	void insertTicket(TicketDTO dto);

}
