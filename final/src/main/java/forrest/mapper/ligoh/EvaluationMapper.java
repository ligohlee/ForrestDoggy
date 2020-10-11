package forrest.mapper.ligoh;

import java.util.List;

import forrest.domain.jm.StartEndPageDTO;
import forrest.domain.ligoh.EvaluationDTO;

public interface EvaluationMapper {

	public void evaluationInsert(EvaluationDTO dto) throws Exception;

	public List<EvaluationDTO> getEvalList(StartEndPageDTO dto)throws Exception;

	public int getEvalCount()throws Exception;
	
	List<EvaluationDTO> ingredientSearch(StartEndPageDTO dto) throws Exception;

}
