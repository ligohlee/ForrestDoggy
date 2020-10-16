package forrest.service.sy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import forrest.command.sy.PaymentCommand;
import forrest.domain.sy.PaymentDTO;
import forrest.mapper.sy.PaymentMapper;

@Service
@Component
public class PaymentService {
	
	@Autowired
	PaymentMapper mapper;
	public void insertPayment(PaymentCommand paymentCommand) {
		// TODO Auto-generated method stub
		
		PaymentDTO dto = new PaymentDTO();
		dto.setPayPrice(paymentCommand.getPayPrice());
		dto.setPayWay(paymentCommand.getPayWay());
		
		mapper.insertPay(dto);
		
		
		
		
	}

}
