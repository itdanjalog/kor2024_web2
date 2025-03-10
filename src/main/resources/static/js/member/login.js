
// [2] 로그인 함수 , 시큐리티 사용하시에는 form 형식
const onLogin = () =>{
    // (1) FORM 가져오기
    const loginForm = document.querySelector('#loginForm')
    // (2) FORMDATA 객체
    const formData = new FormData( loginForm );
    // (3) fetch option
    const option = {
        method : 'POST' ,
        body : formData
    }
    // (4) fetch 통신
    fetch( '/member/login.do' , option )
        .then( response => response.json() )
        .then( data => {
            if( data == true ){
                alert('로그인성공');
                location.href="/";
            }
            else{ alert('회원정보가 일치하지 않습니다.'); }
        })
        .catch( error =>{ alert('시스템오류:관리자에게문의'); });
}

// [2] 로그인 함수 , 시큐리티 이후에 사용하지 않는다.
//const onLogin = ( ) => { console.log('함수 실행됨.')
//    // (1) INPUT DOM 가져오기
//    let midInput = document.querySelector('.midInput');
//    let mpwdInput = document.querySelector('.mpwdInput');
//    // (2) 가져온 DOM 의 value(입력값) 가져오기
//    let mid = midInput.value;
//    let mpwd = mpwdInput.value;
//    // (!) 유효성검사 생략
//    // (3) 입력받은 값들을 보낼 객체 만들기
//    let dataObj = { mid : mid , mpwd : mpwd };
//    // (4) fetch 함수 옵션 정의
//    const option = {
//        method:'POST',
//        headers : { 'Content-Type' : 'application/json'} ,
//        body : JSON.stringify( dataObj )
//    }; // o end
//    // (5) fetch 함수 실행
//    fetch( '/member/login.do' , option )
//        .then( response => response.json() )
//        .then( data => {
//            // (6) 결과에 따른 화면 제어
//            if( data == true ){ alert('로그인성공'); location.href="/"; }
//            else{ alert('회원정보가 일치하지 않습니다.'); }
//        })
//        .catch( error =>{ alert('시스템오류:관리자에게문의'); console.log(error ) });
//}