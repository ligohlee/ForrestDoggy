package forrest.service.ligoh.morder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import forrest.command.AuthInfo;
import forrest.domain.ligoh.MenuPayDTO;
import forrest.domain.ligoh.MorderDTO;
import forrest.mapper.ligoh.MorderMapper;
import forrest.mapper.sy.PaymentMapper;

@Service
@Component
public class MenuPayService {
	@Autowired
	MorderMapper morderMapper;
	@Autowired
	PaymentMapper paymentMapper;
	
	public void insertMenuPay(HttpServletRequest request) throws Exception {
		  HttpSession session = request.getSession();
	      AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
	      MorderDTO getNumber = morderMapper.getOrderNum(authInfo.getId());
		  MenuPayDTO mdto = new MenuPayDTO();
		  mdto.setMordNum(getNumber.getMordNum());
		  MenuPayDTO dto = paymentMapper.getPayNum();
		  mdto.setPayNum(dto.getPayNum());
		  paymentMapper.menuPayInsert(dto);
		   
	}

}
