<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계산 결과</title>
</head>
<body>
	<h1>계산 결과</h1>
	
	<!--  HTML 주석 -->
	<%-- JSP 주석 --%>
	<%
		// 폼에서 데이터 추출
		
		// 방어적 코드 작성
		
		// 계산에 결과를 스트링을 통해 내려주기
		String strNum1=request.getParameter("num1");

		String strNum2=request.getParameter("num2");

		if(strNum1 ==null && strNum2==null){
			out.println("<p>제대로 입력 해주세요 </p>");
		} else{
		try{
			int num1=Integer.parseInt(strNum1);
			int num2=Integer.parseInt(strNum2);
			int pNum=num1+num2;
			int mNum=num1-num2;
			int mulNum=num1*num2;
			double dNum=(double)num1/(double)num2;
			out.println("<p>입력 되었습니다 </p>");
			out.println("<p>'+' 값은"+ pNum+"입니다</p>" );
			out.println("<p>'-' 값은"+ mNum+"입니다</p>" );
			out.println("<p>'*' 값은"+ mulNum+"입니다</p>" );
			out.println("<p>'-' 값은"+ String.format("%.2f",dNum)+"입니다</p>" );
		}catch(NumberFormatException e){
			e.printStackTrace();
			out.print("<p> 유효한 숫자를 입력해주세요</p>");
			}
		}
	%>
	
	
	
	<a href="calculator.html">돌아가기</a>
</body>
</html>