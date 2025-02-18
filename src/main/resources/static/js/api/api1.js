console.log( 'api.js open' )

// [1] 부평구 인구 현황 요청 함수
const api1 = ( ) => {
    // 1. 요청할 API URL
    const url = 'https://api.odcloud.kr/api/3044322/v1/uddi:466eee86-a8be-447b-9c8e-802bdbe897d7?page=1&perPage=23&serviceKey='
    // 2. 요청할 API 인증 KEY , 개별 발급
    const serviceKey = 'nwPZ%2F9Z3sVtcxGNXxOZfOXwnivybRXYmyoIDyvU%2BVDssxywHNMU2tA55Xa8zvHWK0bninVkiuZAA4550BDqIbQ%3D%3D'
    // 3. fetch 이용한 API 통신
    fetch( url + serviceKey ) // url 과 serviceKey
        .then( response => response.json() )
        .then( responseData => { console.log( responseData );

            // (1) 출력할 DOM( HTML 를 객체 표현 ) 가져온다.
            const boardTable1 = document.querySelector('#boardTable1')
            // (2) 출력할 내용을 저장할 변수 선언한다.
            let html = '';
            // (3) 출력할 자료를 반복문 이용하여 여러개 자료를 html 문법 표현한다.
            responseData.data.forEach( ( obj ) => {
                // 객체내 속성값을 호출하는 방법 : 객체변수명.속성명 vs 객체변수명['속성명']
                // 객체내 속성값 호출시 주의할점 : 속성명에 특수문자가 있을경우에는 ['속성명'] 없으면 .속성명
                html +=`<tr>
                            <td> ${ obj['동별'] } </td>
                            <td> ${ obj['세대수'] } </td>
                            <td> ${ obj['인구수(계)'] } </td>
                            <td> ${ obj['인구수(남)'] } </td>
                            <td> ${ obj['인구수(여)'] } </td>
                        </tr>`
            }) // for end
            // (4) 출력할 DOM 에 생성한 HTML 대입하기.
            boardTable1.innerHTML = html;
        })
        .catch( error => { console.log( error ); } )
}
api1() // 함수 실행