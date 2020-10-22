package forrest.service.jjj.ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import forrest.command.jjj.ticket.TicketOrderCommand;
import forrest.command.sy.PaymentCommand;
import forrest.domain.jjj.TicketPayDTO;
import forrest.mapper.jjj.TicketPayMapper;

@Service
@Component
public class TicketPayService {
	@Autowired
	TicketPayMapper ticketPayMapper;
	public void insertTicketPay(TicketOrderCommand command, PaymentCommand paymentCommand) {
		// TODO Auto-generated method stub
		TicketPayDTO dto = new TicketPayDTO();
		dto.setMemId(command.getMemId());
		dto.setPayPrice(paymentCommand.getPayPrice());
		dto.setPayWay(paymentCommand.getPayWay());
		ticketPayMapper.insertTicketPay(dto);
	}

}
