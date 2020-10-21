package forrest.service.ligoh.menu;

import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import forrest.command.AuthInfo;
import forrest.command.ligoh.MorderCommand;
import forrest.domain.ligoh.MenuListDTO;
import forrest.domain.ligoh.MorderDTO;
import forrest.mapper.ligoh.MorderListMapper;
import forrest.mapper.ligoh.MorderMapper;

@Service
@Component
public class MakeABookService {
	@Autowired
	MorderMapper morderMapper;
	@Autowired
	MorderListMapper morderListMapper;
	

	public void firstRegist(MorderCommand mc, HttpServletRequest request) throws Exception {
		
		HttpSession session = request.getSession();
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		
		MorderDTO dto = new MorderDTO();
		
		
		Integer [] peopleCount = mc.getMordPeople();
		Integer sumPeople = 0;
		for (Integer people : peopleCount) {
			sumPeople += people;
		}
		
	
		Timestamp date =  Timestamp.valueOf(mc.getMordDate());
		
		dto.setMemId(authInfo.getId());
		dto.setMordPeople(sumPeople);
		dto.setMordDate(date);
		
		morderMapper.firstRegist(dto);
		
		
		
		
	}


	public void secondRegist(MorderCommand mc, HttpServletRequest request) throws Exception {
         
		HttpSession session = request.getSession();
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		Integer [] peopleCount = mc.getMordPeople();
		
		Integer [] courseMulti = mc.getCourseNum();
		
		MorderDTO getNumber = morderMapper.getOrderNum(authInfo.getId());
		
		for (int i = 0; i < courseMulti.length; i++) {
			List<MenuListDTO> mdto = morderListMapper.getMenu(courseMulti[i]);
			
			for (int j = 0; j < mdto.size(); j++) {
				mdto.get(j).setMordNum(getNumber.getMordNum());
				mdto.get(j).setMordQty(peopleCount[i]);
				if (peopleCount[i]>0) {
					morderListMapper.insertMenu(mdto.get(j));
				  }
				
			  }
			
		  }
	
	}


	public void thirdRegist(MorderCommand mc, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		MorderDTO getNumber = morderMapper.getOrderNum(authInfo.getId());
		
		getNumber.setMenuReq(mc.getMenuReq());
		if (mc.getMenuReq() != null) {
			morderMapper.updateReq(getNumber);
		}
		
		
	}

}
