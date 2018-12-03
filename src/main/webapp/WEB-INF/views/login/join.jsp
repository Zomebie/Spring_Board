<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta charset="utf-8">
<html>

<head>

  <title>회원가입</title>

</head>

<body>

  <br>

  <form action="join" method="post" onsubmit="return validate()">
    <table border="1" cellspacing="0.5" align="center">
      <tr>
        <td colspan="2" bgcolor="#F5A9D0" align="center"> <b> 회원 기본 정보 </td>
      </tr>
      <tr>
        <td bgcolor="#D8D8D8" align="center"> <b> 아이디: </td>
        <td> <input type="text" name="id" id="id" size="12">
          4~12자리의 영문 대소문자와 숫자로만 입력
        </td>
      </tr>
      <tr>
        <td bgcolor="#BDBDBD" align="center"><b> 비밀번호:</td>
        <td> <input type="password" name="pw" id="pass" size="12">
          4~12자리의 영문 대소문자와 숫자로만 입력
        </td>
      </tr>

      <tr>
        <td bgcolor="#D8D8D8" align="center"> <b> 비밀번호확인: </b></td>
        <td> <input type="password" name="passcheck" id="passcheck" size="12"> </td>
      </tr>

      <tr>
        <td bgcolor="#BDBDBD" align="center"> <b>메일주소:</td>
        <td> <input type="text" name="email" id="email" size="20">
          예) id@domain.com
        </td>
      </tr>

      <tr>
        <td bgcolor="#D8D8D8" align="center"> <b>이름:</td>
        <td> <input type="text" name="name" id="name" size="20"> </td>
      </tr>

      <tr>
        <td colspan="2" bgcolor="#F5A9D0" align="center"><b>개인 신상 정보 </td>
      </tr>
      <tr>
        <td bgcolor="#D8D8D8" align="center"><b>주소:</td>
        <td>

          <input type="text" name="sample4_postcode" id="sample4_postcode" placeholder="우편번호" value="">
          <input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br>
          <input type="text" name="sample4_roadAddress" id="sample4_roadAddress" placeholder="도로명주소" value="">
          <input type="text" name="sample4_jibunAddress" id="sample4_jibunAddress" placeholder="지번주소" value=""><br>
          <input type="text" name="address" id="sample4_detailAddress" placeholder="상세주소" value="">
          <span id="guide" style="color:#999" ></span>

        </td>
      </tr>
      <tr>
        <td bgcolor="#BDBDBD" align="center"> <b>주민등록번호:</td>
        <td> <input type="text" name="citizenNum1" id="citizenNum1" onkeypress="birth()" size="20">
          예)1234561234567
        </td>
      </tr>

      <tr>
        <td bgcolor="#D8D8D8" align="center"><b> 생일:</td>
        <td> <input type="text" name="year1" id="year1" size="4"> 년
          <select name="month1" id="month1">
            <option value="01">01</option>
            <option value="02">02</option>
            <option value="03">03</option>
            <option value="04">04</option>
            <option value="05">05</option>
            <option value="06">06</option>
            <option value="07">07</option>
            <option value="08">08</option>
            <option value="09">09</option>
            <option value="10">10</option>
            <option value="11">11</option>
            <option value="12">12</option>
          </select> 월
          <select name="date" id="date">
            <option value="01">01</option>
            <option value="02">02</option>
            <option value="03">03</option>
            <option value="04">04</option>
            <option value="05">05</option>
            <option value="06">06</option>
            <option value="07">07</option>
            <option value="08">08</option>
            <option value="09">09</option>
            <option value="10">10</option>
            <option value="11">11</option>
            <option value="12">12</option>
            <option value="13">13</option>
            <option value="14">14</option>
            <option value="15">15</option>
            <option value="16">16</option>
            <option value="17">17</option>
            <option value="18">18</option>
            <option value="19">19</option>
            <option value="20">20</option>
            <option value="21">21</option>
            <option value="22">22</option>
            <option value="23">23</option>
            <option value="24">24</option>
            <option value="25">25</option>
            <option value="26">26</option>
            <option value="27">27</option>
            <option value="28">28</option>
            <option value="29">29</option>
            <option value="30">30</option>
            <option value="31">31</option>

          </select> 일

        </td>
      </tr>
      <tr>
        <td bgcolor="#BDBDBD" align="center"><b> 관심분야:</td>
        <td>
          <input type="checkbox" name="checkbox" id="checkbox" value="컴퓨터"> 컴퓨터
          <input type="checkbox" name="checkbox" id="checkbox" value="인터넷"> 인터넷
          <input type="checkbox" name="checkbox" id="checkbox" value="여행"> 여행
          <input type="checkbox" name="checkbox" id="checkbox" value="영화감상">영화감상
          <input type="checkbox" name="checkbox" id="checkbox" value="음악감상"> 음악감상</td>
      </tr>

      <tr>
        <td bgcolor="#D8D8D8" align="center"> <b> 자기소개:</td>
        <td> <textarea rows=5 cols=60 size=100 name="self2"></textarea> </td>
      </tr>


    </table>
    <br><br>

    <div align="center">
      <input type="submit" value="확인">
      <INPUT TYPE="RESET" value="다시 입력">
    </div>

  </form>
  <script src="https://ssl.daumcdn.net/dmaps/map_js_init/postcode.v2.js"></script>
  <script src="/bit/resources/js/signup.js" charset='utf-8'></script> 
<script>

</script>
</body>

</html>
