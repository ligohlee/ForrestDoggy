package forrest.mapper.jm;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import forrest.domain.jm.GoodsDTO;
import forrest.domain.jm.StartEndPageDTO;

@Component
@Repository
public interface GoodsMapper {
	public List<GoodsDTO> getGoodsList(StartEndPageDTO startEndPageDTO) throws Exception;
	public Integer getGoodsCount() throws Exception;
	public void goodsUpdate(GoodsDTO dto) throws Exception;
	public void goodsInsert(GoodsDTO dto) throws Exception;
	public void goodsDelete(String goodsNum) throws Exception;
	public List<GoodsDTO> getPtGoodsList(String ptNum) throws Exception;
	public List<GoodsDTO> getGoodsCategoryList(StartEndPageDTO startEndPageDTO) throws Exception;
	
}
