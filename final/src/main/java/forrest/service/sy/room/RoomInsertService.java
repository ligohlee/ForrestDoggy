package forrest.service.sy.room;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import forrest.command.sy.room.RoomCommand;
import forrest.domain.sy.room.RoomDTO;
import forrest.mapper.sy.room.RoomMapper;




@Service
@Component
public class RoomInsertService {
	
	@Autowired
	RoomMapper roomMapper;

	public String insertRoom(RoomCommand command, HttpServletRequest request) {
		// TODO Auto-generated method stub
		
		String location = "";

		RoomDTO dto = new RoomDTO();
		dto.setRoomNum(command.getRoomNum());
		dto.setRoomName(command.getRoomName());
		dto.setRoomInfo(command.getRoomInfo());
		dto.setRoomPrice(command.getRoomPrice());
		dto.setCapacity(command.getCapacity());
		dto.setDogCap(command.getDogCap());

		// 파일 정보를 입력하기 위한 변수
		String originalTotal = "";
		String storeTotal = "";
		String fileSizeTotal = "";
		String PATH = "/static/staypark/room/upload";
		String filePath = request.getServletContext().getRealPath(PATH);
		for(MultipartFile mf : command.getRoomImg()) {
			String original = mf.getOriginalFilename(); // 전송된 파일명 
			String originalFileExtension = // 전송된 파일명으로 부터 확장자만 자라옴   
					original.substring(original.lastIndexOf("."));
			String store = UUID.randomUUID().toString().replace("-", "")
					+ originalFileExtension; // 임의의 파일명 + 확장자 
			String fileSize = Long.toString(mf.getSize());
			originalTotal += original + "`";
			storeTotal += store + "`";
			fileSizeTotal += fileSize + "`";
			// 파일을저장하기 위해서 파일 객체 생성 
			File file = new File(filePath + "/" + store);
			try {
				mf.transferTo(file);
			}catch(Exception e) {
				location = "thymeleaf/stp_manager/stp_backRoomRegi";
				e.printStackTrace();
			}
		}
		
		dto.setRoomImg(storeTotal);
		roomMapper.insertRoom(dto);
		location="redirect:/stpback/roomList";
		return location;
		

	}

	

}
