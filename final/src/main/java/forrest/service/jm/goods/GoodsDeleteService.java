package forrest.service.jm.goods;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import forrest.domain.jm.GoodsDTO;
import forrest.domain.jm.StartEndPageDTO;
import forrest.mapper.jm.GoodsMapper;

@Component
@Service
public class GoodsDeleteService {
	@Autowired
	GoodsMapper goodsMapper;
	public String goodsDelete(String goodsNum, HttpServletRequest request) throws Exception {
		
		StartEndPageDTO startEndPageDTO = new StartEndPageDTO(1L, 1L, null, goodsNum);
		GoodsDTO dto = goodsMapper.getGoodsList(startEndPageDTO).get(0);
		goodsMapper.goodsDelete(goodsNum);
		
		String path = "/static/upload/goods";
		String filePath = request.getServletContext().getRealPath(path);
		String img = dto.getGoodsImg();
		File file = new File(filePath + "/" + img);
		if(file.exists()) file.delete();
		
		String location = "redirect:/dgmback/goodsList";
		return location;
	}
	
	
	
	
	
	
	
	
	
	
}
