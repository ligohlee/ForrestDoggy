package forrest.service.sy.room;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.velocity.runtime.directive.Parse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import forrest.command.AuthInfo;
import forrest.command.sy.room.RoomReservationInfoCommand;
import forrest.domain.sy.PointDTO;
import forrest.mapper.sy.PointMapper;

@Service
@Component
public class RoomRsvInfoService {
	
	@Autowired
	PointMapper pointMapper;
	
	public void infoRsv(RoomReservationInfoCommand command, Model model, HttpSession session) {
		// TODO Auto-generated method stub
		
		List<Integer> optNum = new ArrayList<Integer>();
		
		Integer optopt=0;
		Integer qty=0;
		String namename="";
		Integer total=0;
		
		for (Integer opt : command.getOptNum()) {
			optopt= opt;
			optNum.add(optopt);
		}		
		model.addAttribute("optNum", optNum);
		
		
		List<Integer> selQty = new ArrayList<Integer>();
		for (Integer opt : command.getSelQty()) {
			qty = opt;
			selQty.add(qty);		
		}		
		model.addAttribute("selQty", selQty);
		
		
		List<String> optName = new ArrayList<String>();
		for (String opt : command.getOptName()) {
			namename = opt;
			optName.add(namename);		
		}		
		model.addAttribute("optName", optName);
		
		List<Integer> optTotal = new ArrayList<Integer>();
		for (Integer opt : command.getOptTotalPrice()) {
			total = opt;
			optTotal.add(total);		
		}		
		model.addAttribute("optTotal", optTotal);
		
		String checkIn = command.getCheckIn();
		String checkOut = command.getCheckOut();
		
		try {
			
			
			SimpleDateFormat formmatter = new SimpleDateFormat("yyyy-MM-dd");
			Date beginDate = formmatter.parse(checkIn);
			Date endDate = formmatter.parse(checkOut);
			
			long diff = endDate.getTime() - beginDate.getTime();
			long diffDays = diff/(24*60*60*1000);
			
			System.out.println("체크아웃-체크인="+diffDays);
			model.addAttribute("days", diffDays);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		PointDTO dto = new PointDTO();
		dto = pointMapper.selectPointSum(authInfo.getId());
		
		model.addAttribute("point", dto.getPointSum());
		
		
		
		
		
	}

}
