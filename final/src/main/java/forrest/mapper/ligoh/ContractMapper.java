package forrest.mapper.ligoh;

import java.util.List;

import forrest.domain.jm.StartEndPageDTO;
import forrest.domain.ligoh.ContractDTO;

public interface ContractMapper {
	public void contractInsert(ContractDTO ContractDTO) throws Exception;

	public List<ContractDTO> getContractList(StartEndPageDTO dto) throws Exception;
	public int getContractCount() throws Exception;
	
}
