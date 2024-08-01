<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<div class="body">
	<div class="top">
		
		<div class="list">
		<h3> 전체보기</h3>
		<a href="">Python</a>
		<a href="">Java</a>
		<a href="">Ios</a>
		<a href="">소프트웨어 자료</a>
		<a href="">자료구조</a>
		</div>
		<img src="img/img2.png" alt="로고 이미지" title="홈으로 이동"
					style="width: 50px;height: 50px;">
		
	</div>
	<div class="main">
		<div class="center">
			<h3>경영전략</h3>
			<img src="img/img2.png" alt="로고 이미지" title="홈으로 이동" 
			style="width: 50px;height: 50px;">
		</div>		
		<div class="story-container">
                <div class="story">
                    <form action="">
                        <img src="img/img3.png" alt="로고 이미지" title="홈으로 이동" style="width: 200px;height: 50%">
                        <p>팬덤 확보에 성공한 4세대 걸그룹의 차별화 전략</p>
                        <br>
                        <p>
                            <% 
                            Date now= new Date();
                            SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                            String nowtime=sdf.format(now);
                            out.print(nowtime);
                            %>
                        </p>
                    </form>		
                </div>
                <div class="story">
                    <form action="">
                        <img src="img/img3.png" alt="로고 이미지" title="홈으로 이동" style="width: 200px;height: 50%">
                        <p>팬덤 확보에 성공한 4세대 걸그룹의 차별화 전략</p>
                        <br>
                        <p>
                            <%
                            out.print(nowtime);
                            %>
                        </p>
                    </form>		
                </div>
                <div class="story">
                    <form action="">
                        <img src="img/img3.png" alt="로고 이미지" title="홈으로 이동" style="width: 200px;height: 50%">
                        <p>팬덤 확보에 성공한 4세대 걸그룹의 차별화 전략</p>
                        <br>
                        <p>
                            <%
                            out.print(nowtime);
                            %>
                        </p>
                    </form>	 
                </div>
                <div class="story">
                    <form action="">
                        <img src="img/img3.png" alt="로고 이미지" title="홈으로 이동" style="width: 200px;height: 50%">
                        <p>팬덤 확보에 성공한 4세대 걸그룹의 차별화 전략</p>
                        <br>
                        <p>
                            <%
                            out.print(nowtime);
                            %>
                        </p>
                    </form>	 
                </div>
                <div class="story">
                    <form action="">
                        <img src="img/img3.png" alt="로고 이미지" title="홈으로 이동" style="width: 200px;height: 50%">
                        <p>팬덤 확보에 성공한 4세대 걸그룹의 차별화 전략</p>
                        <br>
                        <p>
                            <%
                            out.print(nowtime);
                            %>
                        </p>
                    </form>	 
                </div>
                <div class="story">
                    <form action="">
                        <img src="img/img3.png" alt="로고 이미지" title="홈으로 이동" style="width: 200px;height: 50%">
                        <p>팬덤 확보에 성공한 4세대 걸그룹의 차별화 전략</p>
                        <br>
                        <p>
                            <%
                            out.print(nowtime);
                            %>
                        </p>
                    </form>	 
                </div>
                <div class="story">
                    <form action="">
                        <img src="img/img3.png" alt="로고 이미지" title="홈으로 이동" style="width: 200px;height: 50%">
                        <p>팬덤 확보에 성공한 4세대 걸그룹의 차별화 전략</p>
                        <br>
                        <p>
                            <%
                            out.print(nowtime);
                            %>
                        </p>
                    </form>	 
                </div>
                <div class="story">
                    <form action="">
                        <img src="img/img3.png" alt="로고 이미지" title="홈으로 이동" style="width: 200px;height: 50%">
                        <p>팬덤 확보에 성공한 4세대 걸그룹의 차별화 전략</p>
                        <br>
                        <p>
                            <%
                            out.print(nowtime);
                            %>
                        </p>
                    </form>	 
                </div>
                <div class="story">
                    <form action="">
                        <img src="img/img3.png" alt="로고 이미지" title="홈으로 이동" style="width: 200px;height: 50%">
                        <p>팬덤 확보에 성공한 4세대 걸그룹의 차별화 전략</p>
                        <br>
                        <p>
                            <%
                            out.print(nowtime);
                            %>
                        </p>
                    </form>	 
                </div>
            </div>
		
	</div>
	
</div>
<%@ include file="footer.jsp" %>