package forrest.service.sy.roomservice;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import forrest.command.AuthInfo;
import forrest.command.sy.room.ChatNameCommand;
import forrest.domain.sy.room.RorderDTO;
import forrest.mapper.sy.room.RoomOrderMapper;

@Service
@Component
public class RoomServiceOrderService {
	@Autowired

	RoomOrderMapper mapper;

	public String orderRoomService(HttpSession session, Model model, ChatNameCommand command) {

		// TODO Auto-generated method stub

		String path;
		String chatName;
		if(command.getChatName() == null) {
			chatName="";
		}else {
			chatName=command.getChatName();
		}
		
		
		if (session.getAttribute("authInfo") == null) {

			path = "redirect:/login";

		} else {

			AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");

			RorderDTO dto = new RorderDTO();

			dto.setMemId(authInfo.getId());

			List<RorderDTO> list = mapper.selectRoomOrderNow(dto);

			if (list.isEmpty()) {
				if(chatName.equals("")) {
					path = "thymeleaf/frontPage/html/sy/stpNoReservation";
				}else {					
					model.addAttribute("chatName", chatName);
					path = "thymeleaf/frontPage/html/sy/stpRoomService";
				}
				

			} else {
				
				path = "thymeleaf/frontPage/html/sy/stpRoomService";

				model.addAttribute("rsvRoom", list);

				System.out.println("예약정보 "+list);

			}

		}

		return path;

	}

}