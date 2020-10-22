package forrest.service.ligoh.point;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import forrest.command.AuthInfo;
import forrest.domain.sy.PointDTO;
import forrest.mapper.sy.PointMapper;


@Service
@Component
public class LpointService {
   
	@Autowired
	 PointMapper pointMapper;

	public void pointShow(Model model, HttpServletRequest request) throws Exception {
		 HttpSession session = request.getSession();
	      AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
	      String memId = authInfo.getId();
	      PointDTO pdto = pointMapper.getSomePoint(memId);
	     model.addAttribute("sumPoint", pdto.getSumPoint());
		
	}

}
