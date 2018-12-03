

function validate(){

  var check=/^[a-zA-Z0-9]{4,12}$/; // 아이디, 비밀번호, 비밀번호 확인 유효성검사
  var emailCheck = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i; //메일주소 유효성검사

  var id=document.getElementById("id");
  var pass=document.getElementById("pass");
  var passcheck=document.getElementById("passcheck");
  var email = document.getElementById("email");
  var name=document.getElementById("name");
  var citizenNum = document.getElementById("citizenNum1");
  var cnFormulation =0;
  var total = 0;

//아이디 입력 안 했을때
if(id.value==""){
alert("아이디를 입력해주세요.");
id.focus();
return false;

}
//아이디 정규식 체크
 if(check.test(id.value)){

   //return true;
 }else {
   alert("아이디가 잘못된 형식입니다. 다시 입력해주세요.");
   id.value="";
   id.focus();
   return false;
 }

 // 비밀번호 입력 안했을때
       if(pass.value==""){
           alert("비밀번호를 입력해주세요.");
           pass.focus();
           return false;
       }

      //비밀번호 정규식 체크
  if(check.test(pass.value)&&id.value!=pass.value){
    //정규식 체크를 통과하고 아이디와같지 않을때 통과
    //return true;
  }else{

    if(id.value==pass.value)
    {
      alert("아이디와 비밀번호가 일치합니다. 다시 입력해주세요.");
      pass.value="";
      pass.focus();
      return false;
    }else{

      alert("비밀번호가 잘못된 형식입니다. 다시 입력해주세요.");
      pass.value="";
      pass.focus();
      return false;
    }

  }
  // 비밀번호 확인란 입력 안했을 때
 if(passcheck.value==""){
     alert("비밀번호 확인란에 입력해주세요.");
     passcheck.focus();
     return false;
 }

 //비밀번호 확인 정규식 체크
 if(check.test(passcheck.value)&&pass.value==passcheck.value){
   //return true;
 }else {

   alert("비밀번호가 일치하지 않습니다. 다시 확인해주세요.");
   passcheck.value="";
   passcheck.focus();
   return false;
 }

 // 이메일 입력 안했을 때
 if(email.value=="")
 {
    alert("이메일을 입력해 주세요");
    email.focus();
    return false;
}
 // 이메일 정규식 체크
if(!check2(emailCheck, email, "적합하지 않은 이메일 형식입니다."))
{
  return false;
}



 // 이름란 입력안했을때
 if(name.value==""){
   alert("이름을 입력해 주세요");
   name.focus();
   return false;
 }


 //주민번호란 입력안했을 때
 if(citizenNum.value==""){
   alert("주민번호를 입력해 주세요");
   citizenNum.focus();
   return false;

 }



           if(citizenNum.value.length == 13){

              //주민등록번호 계산공식
              total=   (citizenNum.value[0]*2)+(citizenNum.value[1]*3)+(citizenNum.value[2]*4)+
              (citizenNum.value[3]*5)+(citizenNum.value[4]*6)+(citizenNum.value[5]*7)+
              (citizenNum.value[6]*8)+(citizenNum.value[7]*9)+(citizenNum.value[8]*2)+
              (citizenNum.value[9]*3)+(citizenNum.value[10]*4)+(citizenNum.value[11]*5);
              cnFormulation =(11-(total%11))%10;

              //주민등록번호 유효여부
              if(citizenNum.value[12] != cnFormulation){
                 alert("잘못된 주민등록번호입니다.");
                 citizenNum.value="";
                 citizenNum.focus();
                 return false;
              }

           }else{
                  alert("주민등록번호는 13자리 입니다.");
                  citizenNum.value="";
                  citizenNum.focus();
                  return false;
           }

} // validate ()함수끝

function check2(re, what, message) {

      if(re.test(what.value)) {
          return true;
      }else{

        alert(message);
        what.value = "";
        what.focus();
        return false;
      }


  }//check2()

  //주민등록번호란의 입력 주민번호로 생년월일로 자동입력
       function birth(){
          var citizenNum1 = document.getElementById("citizenNum1");
          var year = document.getElementById("year1");
          var month = document.getElementById("month1");
          var day = document.getElementById("date");

          year.value = "19"+citizenNum1.value[0]+citizenNum1.value[1];
          month.value = citizenNum1.value[2]+citizenNum1.value[3];
          day.value =  citizenNum1.value[4]+citizenNum1.value[5];

       }//birth()

