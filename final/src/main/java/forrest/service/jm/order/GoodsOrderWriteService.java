package forrest.service.jm.order;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import forrest.command.AuthInfo;
import forrest.command.jm.GOrderCommand;
import forrest.domain.jm.DeliveryDTO;
import forrest.domain.jm.GOrderDTO;

@Component
@Service
public class GoodsOrderWriteService {
	
	public String writePro(GOrderCommand gOrderCommand, HttpSession session, Model model ) throws Exception {
		
		String path;
		if (session.getAttribute("authInfo") == null) {
			path="redirect:/login";
		}else {
			GOrderDTO gorderDTO = new GOrderDTO();
			AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
			gorderDTO.setMemId(authInfo.getId());
			gorderDTO.setGoodsNum(gOrderCommand.getGoodsNum());
			gorderDTO.setGorderPrice(gOrderCommand.getGorderPrice());
			gorderDTO.setGorderQty(gOrderCommand.getGorderQty());
			
			DeliveryDTO deliveryDTO = new DeliveryDTO();
			deliveryDTO.setOrderNum(null);
			deliveryDTO.setPtNum(null);
			deliveryDTO.setCtNum(null);
			deliveryDTO.setDyPrice(3000);
			deliveryDTO.setDyMemName(gOrderCommand.getDyMemName());
			deliveryDTO.setDyMemAddr(gOrderCommand.getDyMemAddr());
			
			String addr = gOrderCommand.getAddr1().concat(" ").concat(gOrderCommand.getAddr2());
			System.out.println(addr);
		
	
			path="thymeleaf/frontPage/html/jm/goods_order_complete";
			
		}
		return path;
	}
}

	