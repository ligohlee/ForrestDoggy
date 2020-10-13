package forrest.service.jm.goods;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import forrest.command.jm.GoodsCommand;
import forrest.domain.jm.GoodsDTO;
import forrest.mapper.jm.GoodsMapper;

@Component
@Service
public class GoodsWriteService {
	@Autowired
	GoodsMapper goodsMapper;
	
	public String writePro(GoodsCommand goodsCommand, HttpServletRequest request) throws Exception{

		GoodsDTO dto = new GoodsDTO();
		dto.setGoodsNum(goodsCommand.getGoodsNum());
		dto.setPtNum(goodsCommand.getPtNum());
		dto.setCtNum(goodsCommand.getCtNum());
		dto.setGoodsName(goodsCommand.getGoodsName());
		dto.setGoodsPrice(goodsCommand.getGoodsPrice());
		dto.setGoodsCategory(goodsCommand.getGoodsCategory());
		dto.setGoodsMade(goodsCommand.getGoodsMade());
		dto.setGoodsSize(goodsCommand.getGoodsSize());
		dto.setGoodsManual(goodsCommand.getGoodsManual());
		dto.setGoodsIntro(goodsCommand.getGoodsIntro());
		dto.setGoodsTimeLimit(goodsCommand.getGoodsTimeLimit());
		
		
		String location = "";
		String filePath = "C:/Java/ForrestDoggy-master/final/src/main/resources/static/upload/goods";
		
		MultipartFile mf = goodsCommand.getReport();
		String img = mf.getOriginalFilename();
		File file = new File(filePath + "/" + img);
		try {
		   mf.transferTo(file);
		} catch (Exception e) {
		   // TODO: handle exception
		   location = "thymeleaf/backOfficePage/html/dgm_manager/goods_form";
		   e.printStackTrace();
		}
		dto.setGoodsImg(img);
		goodsMapper.goodsInsert(dto);

		location = "redirect:/goods/goodsList";
		return location;
	} 
}
