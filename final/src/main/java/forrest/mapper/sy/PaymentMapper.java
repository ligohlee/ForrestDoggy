package forrest.mapper.sy;

import forrest.domain.ligoh.MenuPayDTO;
import forrest.domain.sy.PaymentDTO;
import forrest.domain.sy.PointDTO;

public interface PaymentMapper {

	public void insertPay(PaymentDTO dto);

	public MenuPayDTO getPayNum() throws Exception;

	public void menuPayInsert(MenuPayDTO dto);

}
