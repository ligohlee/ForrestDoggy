package forrest.service.sy.roomservice;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import forrest.command.AuthInfo;
import forrest.domain.sy.room.RorderDTO;
import forrest.mapper.sy.room.RoomOrderMapper;

@Service
@Component
public class RoomServiceOrderService {
	@Autowired
	RoomOrderMapper mapper;
	
	public String orderRoomService(HttpSession session, Model model) {
		// TODO Auto-generated method stub
		String path;
		if (session.getAttribute("authInfo") == null) {
			path="redirect:/login";
		}else {
			
			AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
			
			RorderDTO dto = new RorderDTO();
			dto.setMemId(authInfo.getId());
			
			List<RorderDTO> list = mapper.selectRoomOrderNow(dto);
			
			if(list==null) {
				path="thymeleaf/frontPage/html/sy/stpNoReservation";
			}else {
				path="thymeleaf/frontPage/html/sy/stpRoomService";
				model.addAttribute("rsvRoom", list);
				System.out.println(list);
			}
		}
		
		return path;
		
		
	}

}
