package forrest.service.jm.order;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import forrest.command.AuthInfo;
import forrest.command.jm.GOrderCommand;
import forrest.domain.jjj.MemberDTO;
import forrest.domain.jm.GoodsDTO;
import forrest.domain.jm.StartEndPageDTO;
import forrest.domain.sy.PointDTO;
import forrest.mapper.jjj.MemberMapper;
import forrest.mapper.jm.GoodsMapper;
import forrest.mapper.sy.PointMapper;

@Service
@Component
public class GoodsOrderService {
	@Autowired
	GoodsMapper goodsMapper;
	@Autowired
	PointMapper pointMapper;
	@Autowired
	MemberMapper memberMapper;
	
	public String goodsOrder(GOrderCommand gOrderCommand, Model model, HttpSession session) throws Exception{
	
		String path;
		if (session.getAttribute("authInfo") == null) {
			path="redirect:/login";
		}else {
			AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
			
			String num = Integer.toString(gOrderCommand.getGoodsNum());
			
			StartEndPageDTO startEndPageDTO = new StartEndPageDTO(1L, 1L, null, num);
			GoodsDTO goodsdto = goodsMapper.getGoodsList(startEndPageDTO).get(0);
			model.addAttribute("goodsdto", goodsdto);
			
			MemberDTO memberdto = memberMapper.selectMember(authInfo.getId());
			model.addAttribute("memberdto", memberdto);
			
			Integer qty = gOrderCommand.getQty();
			model.addAttribute("qty", qty);
			
			Integer price = goodsdto.getGoodsPrice();
			Integer totalPrice = qty * price;
			model.addAttribute("totalPrice", totalPrice);
			
			PointDTO dto = new PointDTO();
			dto = pointMapper.selectPointSum(authInfo.getId());
//			model.addAttribute("point", dto.getPointSum());
			path="thymeleaf/frontPage/html/jm/goods_order";
		}
	
	return path;
	}
	
}