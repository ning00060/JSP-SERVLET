<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ include file="main_head.jsp" %>

    <main class="myInfoMainDiv">
    <h2>내 정보 조회</h2>
    <div class="table-container">
        <table>
            <tr>
                <th>학번</th>
                <td>2023000001</td>
                <th>소속</th>
                <td>공과대학 컴퓨터공학과</td>
            </tr>
            <tr>
                <th>학년</th>
                <td>1</td>
                <th>학기</th>
                <td>1</td>
            </tr>
            <tr>
                <th>입학일</th>
                <td>2021-03-02</td>
                <th>졸업일(졸업예정일)</th>
                <td></td>
            </tr>
            <tr>
                <th>성명</th>
                <td>박시우</td>
                <th>생년월일</th>
                <td>2002-06-19</td>
            </tr>
            <tr>
                <th>성별</th>
                <td>남성</td>
                <th>주소</th>
                <td>부산시 남구</td>
            </tr>
            <tr>
                <th>연락처</th>
                <td>010-5267-1815</td>
                <th>email</th>
                <td>psw@green.com</td>
            </tr>
        </table>
        <button>수정하기</button>
    </div>
    <h2>학적 변동 내역</h2>
    <div class="table-container">
        <table>
            <tr>
                <th>변동 일자</th>
                <th>변동 구분</th>
                <th>세부</th>
                <th>승인 여부</th>
                <th>복학 예정 연도/학기</th>
            </tr>
            <tr>
                <td>2023-03-02</td>
                <td>재학</td>
                <td></td>
                <td>승인</td>
                <td></td>
            </tr>
        </table>
    </div>
</main>

<%@ include file="main_footer.jsp" %>