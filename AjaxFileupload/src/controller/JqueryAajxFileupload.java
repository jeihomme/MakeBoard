package controller;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet(value="/jquery")
public class JqueryAajxFileupload extends HttpServlet {

	private static final long serialVersionUID = 1L;

	
	//확인
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/jquery/jquery_ajax_fileupload.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//파일 업로드 처리
		
		//요청 파라미터 한글 인코딩 설정 : UTF-8
		req.setCharacterEncoding("UTF-8");
		
		boolean isMultipart = ServletFileUpload.isMultipartContent(req);
		
		if( !isMultipart ) {
			System.out.println("멀티파트 아님");
			return;
		}
		
		DiskFileItemFactory factory = null;
		factory = new DiskFileItemFactory();

		//메모리 처리 사이즈
		int maxMem = 1 * 1024 * 1024; //1MB
		factory.setSizeThreshold(maxMem);
		
		//디스크 처리 사이즈
		ServletContext context = getServletContext();
		File repository=new File(context.getRealPath("tmp"));
		factory.setRepository(repository);
		
		//업로드 객체 생성
		ServletFileUpload upload = null;
		upload = new ServletFileUpload(factory);
		
		//용량 제한 설정 : 10MB
		int maxFile = 10 * 1024 * 1024; //10MB
		upload.setFileSizeMax(maxFile);
		
		//업로드 데이터 파싱(추출) - 임시파일 업로드 수행
		List<FileItem> items = null;
		try {
			items = upload.parseRequest(req);
			
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		
		//파싱된 데이터 처리
		Iterator<FileItem> iter = items.iterator();
		
		//요청정보 전부 처리하기
		while( iter.hasNext() ) {
			FileItem item = iter.next();//요청정보 하나씩얻기
			
			// 빈 파일 처리
			if( item.getSize() <= 0 )	continue;
			
			// 빈 파일이 아닐 경우
			if( item.isFormField() ) {
				System.out.println("----------------------------------");
				System.out.println("폼 필드 키 : " + item.getFieldName());
				System.out.println("값 : " + item.getString("utf-8"));
				System.out.println("----------------------------------");
				
			} else {
				//파일일 경우

				// --- UUID 생성 ---
				UUID uuid = UUID.randomUUID();
				System.out.println(uuid);
				
				String u = uuid.toString().split("-")[4];
				System.out.println(u);
				// -----------------
				
				//로컬 저장소 파일
				File up = new File( context.getRealPath("upload"), item.getName() + "_" + u);
				System.out.println(up);
								
				try {
					// 실제 업로드
					item.write(up);
					
					// 임시 파일 삭제
					item.delete();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
			
		}
		
	}
}
