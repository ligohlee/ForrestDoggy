package forrest.service.ligoh.menu;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import forrest.command.AuthInfo;
import forrest.command.ligoh.MorderCommand;
import forrest.domain.ligoh.MenuListDTO;
import forrest.domain.ligoh.MorderDTO;
import forrest.mapper.ligoh.MorderMapper;

@Service
@Component
public class MakeABookService {
	@Autowired
	MorderMapper morderMapper;
	

	public void makeBook(MorderCommand mc, HttpServletRequest request) throws Exception {
		
		

		HttpSession session = request.getSession();
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		
		MorderDTO dto = new MorderDTO();
		
		dto.setMemId(authInfo.getId());
		Integer [] peopleCount = mc.getMordPeople();
		Integer sumPeople = 0;
		for (Integer people : peopleCount) {
			sumPeople += people;
		}
		
		dto.setMordPeople(sumPeople);
		
		morderMapper.firstRegist(dto);
		
		
		MorderDTO getNumber = morderMapper.getOrderNum(authInfo.getId());
		
		System.out.println(getNumber.getMordNum()+"dfdffdfdfdfdfdfdf");
	
		MenuListDTO mdto = new MenuListDTO();
		System.out.println(mc.getMordDate()+ "sddfddfdfdfdfdfd");
		Timestamp date =  Timestamp.valueOf(mc.getMordDate());
		mdto.setMordDate(date);
		mdto.setMordNum(getNumber.getMordNum());
		
		morderMapper.secondRegist(mdto);
		
		
	}

}
