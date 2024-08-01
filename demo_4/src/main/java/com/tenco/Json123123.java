//package com.tenco;
//
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.URL;
//
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//public class Json123123 extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//	public Json123123() throws ServletException {
//		super();
//		System.out.println("1");
//	}
//
//	@Override
//	public void init() throws ServletException {
//		// 순수 자바코드에서 HTTP 통신
//		// 1. 서버 주소 경로
//		// 2. URL 클래스
//		// 3. url.openConnection() <--- 스트림 I/O
//		
//	
//		 
//	}
//
//	// http://localhost:8080/d4/Json123123
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		System.out.println("4");
//		  try { URL url = new URL("https://jsonplaceholder.typicode.com/todos/1");
//		  HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//		  conn.setRequestMethod("GET"); conn.setRequestProperty("Content-type",
//		  "application/json");
//		  
//		  // 응답 코드 확인 int responseCode = conn.getResponseCode();
//		  System.out.println("response code : " + responseCode);
//		  
//		  // HTTP 응답 메세지에 데이터를 추출 [] -- Stream --- [] BufferedReader in = new
//		  BufferedReader(new InputStreamReader(conn.getInputStream())); String
//		  inputLine; StringBuffer buffer = new StringBuffer(); while ((inputLine =
//		  in.readLine()) != null) { buffer.append(inputLine); } in.close();
//		  
//		  System.out.println(buffer.toString());
//		  System.err.println("-------------------------------"); // gson lib 활용 // Gson
//		  gson = new Gson(); Gson gson = new
//		  GsonBuilder().setPrettyPrinting().create(); IdDTO idDTO =
//		  gson.fromJson(buffer.toString(), IdDTO.class);
//		  
//		  System.out.println(idDTO.id); System.out.println(idDTO.userId);
//		  System.out.println(idDTO.title); System.out.println(idDTO.complted);
//		  System.out.println("2"); System.out.println("2222");
//		  
//		  //response.setContentType("aplication/json"); //PrintWriter pw =
//		  response.getWriter(); // pw.write(idDTO.toString());
//		  System.out.println("get 출력"); } catch (IOException e) { e.printStackTrace();
//		  }
//
//	}
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//
//	}
//
//}
