package com.tenco.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@WebServlet("/upload")
@MultipartConfig // 반드시 선언
public class FileUploadController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public FileUploadController() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("1111111");

		// "mFile" 이라는 key 값으로 punt 태그로 부터 파일 데이터를 가져 올 수 있다.
	Part filePart=	request.getPart("mFile");
		System.out.println(filePart.getContentType());
		System.out.println(filePart.getSize());
		
		// 파일을 서버측에 업로드 하는 처리 프로세스
		
		// 유효성 검사
		if(filePart == null || filePart.getSize()==0) {
			response.setContentType("text/html");
			response.getWriter().println("첨부파일 추가해주세요");
			return;
		}
		// 사용자가 올린 파일 원본 이름을 가져 온다.
		String originFileName=filePart.getSubmittedFileName();
		
		// 1.원폽ㄴ 파일명ㅇ을 가져온다.
		// 2. 가능한 절대 중복되지 않을 이름을 ㅁ나들어준다.
		// UUID를 통해서 고유한 파일멸을 만들어보자
		// 3. 확장자를 분리해서 원본파일멸 + _ + 고유한 UUID를 생성해서
		// 새로운 파일명을 만들어 준다.
		String uniqueFileName=UUID.randomUUID().toString();
		
		// a.png, b.jpeg ==> a_xhdf.png
		// 파일 확장자를 추출하여 고유한 파일명 뒤에 추가합니다.
		 String extension = "";
		 int i = originFileName.lastIndexOf(".");
		 System.out.println("UNIQUE :  " + uniqueFileName);
		 System.out.println("인덱스 번호:  " + i);
		 
		 if( i > 0) {
			 // . 포함한 확장자를 추출
			 extension = originFileName.substring(i);
			 System.out.println("extension : " + extension);
			 
		 }
		 
		 uniqueFileName += extension;
		   System.out.println(uniqueFileName);
		   // 4. 어디에 저장할지 경로를 설정해야 한다.
		   // C:\work_web\jsp_file_upload_ex1\src\main\webapp\images
		   File uploadDirFile= new File("C:\\work_web\\jsp_file_upload_ex1\\src\\main\\webapp\\images");
		   
		   // 5. 해당경로에 폴더가 존재하는지 확인 -> 업다면 폴더를 코드로 생성하기
		   if(!uploadDirFile.exists()) {
			   // 없으면 생성
			   if(uploadDirFile.mkdirs()) {
				   System.out.println("디렉토리가 생성 되었습니다." + uploadDirFile);
				   
			   } else {
				   throw new ServletException("디렉토리 생성에 실패");
			   }
			  
		   }
		   	// 파일 생성
		   File fileToSave =new File(uploadDirFile,uniqueFileName);
		   
		   
		   // 파일을 서버에 저장
		   filePart.write(fileToSave.getAbsolutePath());
		   
		   
		   // 응답 페이지 구성
		   response.setContentType("text/html");
		   response.getWriter().println("파일 업로드 성공");
		   response.getWriter().println("<br>");
		   response.getWriter().println("사용자가 올린성공" + originFileName);
		   response.getWriter().println("파일 업로드 성공");
		   response.getWriter().println("<br");
		   response.getWriter().println("서버에 저장된 파일명" + uniqueFileName);
	;;	   
		   
	}
}
