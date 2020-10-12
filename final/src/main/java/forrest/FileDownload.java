package forrest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

@Component
@Service
public class FileDownload {
	public void fileDownLoad(String path, String fileName, HttpServletRequest request, HttpServletResponse response) {
		String RealPath = request.getServletContext().getRealPath(path);
		String originalFileName = fileName.split("`")[1];
		try {
			originalFileName = URLEncoder.encode(originalFileName,"UTF-8");
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		String storeFileName = fileName.split("`")[0];
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/octet-stream; charset=utf-8");
		response.setHeader("Content-Disposition", "attachment; filename=\"" + originalFileName + "\";");
        response.setHeader("Content-Transfer-Encoding", "binary");
        File file = new File(RealPath + "/" + storeFileName);
        //웹브라우저로 아웃풋, 전송을 위한 객체
        ServletOutputStream out1 = null; 
        //시스템에 있는 파일을 가져오기 위한 객체
        FileInputStream fis = null;
		try {
			//웹브라우저로 전송할 수 있게 정보를 가져옴 연결
			out1 = response.getOutputStream();
			//시스템에 있는 파일을 가져옴
			fis = new FileInputStream(file);
			//웹브라우저로 전송
	        FileCopyUtils.copy(fis, out1);
	        response.flushBuffer(); //리스폰스에 버퍼를 지운다
	        out1.flush();
	        out1.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}finally {
			 if(fis != null){                 
	                try{ fis.close();}catch(Exception e){}
	            }
		}
	}

	
}
