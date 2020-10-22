package forrest.service.ligoh.morder;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import forrest.command.AuthInfo;
import forrest.domain.ligoh.MenuListDTO;
import forrest.domain.ligoh.MorderDTO;
import forrest.mapper.ligoh.MorderListMapper;
import forrest.mapper.ligoh.MorderMapper;

@Service
@Component
public class BookShowService {
	@Autowired
	MorderMapper morderMapper;
	@Autowired
	MorderListMapper morderListMapper;

	public void sendInfo(Model model, HttpServletRequest request) throws Exception {
		  
	      HttpSession session = request.getSession();
	      AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
	      MorderDTO getNumber = morderMapper.getOrderNum(authInfo.getId());
	      
		  List<MenuListDTO> courses = morderListMapper.getCourse(getNumber.getMordNum());
		    model.addAttribute("courseInfo", courses);
		  List<MenuListDTO> dogMenues = morderListMapper.getDogMenu(getNumber.getMordNum());
		    model.addAttribute("menuInfo", dogMenues);
		 
		    Integer totalSum=0;
		   
		 for (MenuListDTO mdto: courses) {
			 totalSum += mdto.getEachTotal();
		}   
		 for (MenuListDTO mmdto: dogMenues) {
			 totalSum += mmdto.getEachTotal();
		}   
		    model.addAttribute("sump", totalSum);
		    
		  MorderDTO orderDate = morderMapper.getDateReq(getNumber.getMordNum());
		   model.addAttribute("date", orderDate);
	}

}
