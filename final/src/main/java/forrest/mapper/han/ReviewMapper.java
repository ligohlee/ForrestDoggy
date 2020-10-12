package forrest.mapper.han;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import forrest.domain.han.ReviewDTO;

@Component
@Repository
public interface ReviewMapper {
	public void reviewInsert(ReviewDTO reviewDTO)throws Exception;
	public List<ReviewDTO> getrevView();
	public ReviewDTO detailview(Integer workNum)throws Exception;
}
