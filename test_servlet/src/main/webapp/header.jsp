<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body{
display: flex;
flex-direction: column;
justify-content: center;
margin-left: 200px;
margin-right: 200px;
background-color: white;
}


.header{
display: flex;
background-image: url('img/images.png');
background-image: no-repeat;
background-size: 50% 100%;
height: 14vh;
justify-content: space-between;
}
ul{
list-style-type: none;
display: flex;
}
li{
}
.top{
background-color: white;
display: flex;
justify-content: space-between;
width: 250px;
border: 2px solid #ccc;
border-radius: 20px;
height: 200px;

}
.body{
display: flex;
}

.center{
display: flex;
justify-content: space-between;
width: 100%;
}

.main{
display: flex;
flex-wrap: wrap;
width: 100%;
justify-content: flex-start;
}

.list{
display: flex;
flex-wrap: wrap;
flex-direction: column;
}
.story-container {
    display: flex;
    flex-wrap: wrap;
    justify-content: flex-start;
}

.story {
    width: 200px;
    margin: 10px;
    border: 2px solid #ccc;
    display: flex;
    flex-direction: column;
    align-items: center;
}

 a:visited{
 text-decoration: underline;
 color: black;
 font-size: 15px;
 }
</style>
</head>
<body>
	<div class="header">
		<h2>Green's Blog</h2>
			
		<nav>
			<ul>
				<li>홈</li>
				<li>취소</li>
			</ul>
		</nav>
	
	
	</div>
	
