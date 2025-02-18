console.log( 'api.js open' )

// [5] 공공데이터의 자료를 요청하여 chart.js API로 정보 시각화 하기
const api4 = () =>{
    // 1. 부평구 인구현황 api url(key포함)
    const url = 'https://api.odcloud.kr/api/3044322/v1/uddi:466eee86-a8be-447b-9c8e-802bdbe897d7?page=1&perPage=22&serviceKey=nwPZ%2F9Z3sVtcxGNXxOZfOXwnivybRXYmyoIDyvU%2BVDssxywHNMU2tA55Xa8zvHWK0bninVkiuZAA4550BDqIbQ%3D%3D'
    // 2. fetch 이용한 api 요청
    fetch( url )
        .then( r =>  r.json())
        .then( responseData => { console.log( responseData);
            // 데이터 준비
            let 동별리스트 = []
            let 남자인구수 = []
            let 여자인구수 = []

            responseData.data.forEach( obj => {
                동별리스트.push( obj['동별'] ) // 동별리스트에 모든 '동별' 를 대입해준다.
                남자인구수.push( obj['인구수(남)'] ) // 남자인구수에 모든 '남자인구수'를 대입한다.
                여자인구수.push( obj['인구수(여)'] ) // 여자인구수에 모든 '여자인구수'를 대입한다.
            })

            // chart.js  활용
                // (1) 차트를 표현할 위치의 DOM 가져온다.
            const myChart2 = document.querySelector('#myChart2');
                // (2) 차트 객체를 생성한다.
            new Chart( myChart2 , {
                type : 'bar' ,
                data : {
                    labels : 동별리스트 ,  // 동별 // 가로축
                    datasets : [
                        { label : '남자인구수' , data : 남자인구수 },
                        { label : '여자인구수' , data : 여자인구수 }
                    ]  // 자료/값
                }, // data end
            }) // chart end
        })
        .catch( e => { console.log( e ); })

}
api4();

// [4] chart.js 샘플 코드
    // (1) 차트가 표현될 DOM 객체
// const ctx = document.getElementById('myChart');
const ctx = document.querySelector('#myChart');

new Chart(ctx, { // 차트 객체 생성 , new Chart( ctx , { 차트 옵션 }
  type: 'bar', // type : 차트모양 , bar(막대차트) , line(선차트) 등등 공식홈페이지 찾아서 사용한다.
  data: { // data : 차트에 들어갈 자료들
    labels: [ '1월', '2월', '3월', '4월', '5월', '6월'], // labels : 가로축 제목 들
    datasets: [  // [] 안에 {} 1개당 항목1개 , [ {} , {} , {} ]
        {
          label: '사이다판매량', // 항목명
          data: [12, 19, 3, 5, 2, 3], // 항목의 (세로축) 값
          borderWidth: 1 // 선 굵기
        },
        {
          label : '콜라판매량',
          data: [10,5,20,18,8,2],
          borderWidth : 2 //
        }
    ]
  },
  options: {
    scales: {
      y: {
        beginAtZero: true
      }
    }
  }
});

// [3] 부평구 맛집 현황 요청 함수
const api3 = ( ) => {
    // 1. 요청 URL 작성 + 서비스키 포함
    const url = 'https://api.odcloud.kr/api/15103411/v1/uddi:0875260e-d807-49b7-85fe-adb00bfa76ce?page=1&perPage=70&serviceKey=nwPZ%2F9Z3sVtcxGNXxOZfOXwnivybRXYmyoIDyvU%2BVDssxywHNMU2tA55Xa8zvHWK0bninVkiuZAA4550BDqIbQ%3D%3D'
    // 2. fetch
    fetch( url )
        .then( r => r.json() )
        .then( responseData => { console.log( responseData );
            // 3. 응답 자료를 table 출력하기.
            const boardTable2 = document.querySelector('#boardTable2')
            let html = '';
            responseData.data.forEach( obj => {
                html += `<tr>
                            <td> ${ obj.소재지 } </td>
                            <td> ${ obj['업 소 명'] } </td>
                            <td> ${ obj.업태 } </td>
                            <td> ${ obj.전화번호 } </td>
                            <td> ${ obj.지정메뉴 } </td>
                         </tr>`
            }) // f end
            boardTable2.innerHTML = html;
        })
        .catch( e => { console.log(e); })
} // f end
api3(); // 함수 호출 !!!

// [2] 사업자 상태 조회 요청 함수
const api2 = ( ) => {
    // 1. 입력받은 데이터(사업자번호) 가져오기
    const 사업자번호입력상자 = document.querySelector('#사업자번호입력상자')
    const 사업자번호 = 사업자번호입력상자.value;
    // 2. 요청 자료 만들기 // 입력받은 사업자번호를 api 요청 형식에 맞게 구성
    const data = { "b_no" : [ 사업자번호.replaceAll('-','') ] } // 사업자번호에 '-' 있을경우 불가능하므로 replace 함수 이용하여 '-' 제거.
    // 3. url
    const url = 'https://api.odcloud.kr/api/nts-businessman/v1/status?serviceKey='
    // 4. 서비스 키 , 일반 인증키(Encoding)
    const serviceKey = 'nwPZ%2F9Z3sVtcxGNXxOZfOXwnivybRXYmyoIDyvU%2BVDssxywHNMU2tA55Xa8zvHWK0bninVkiuZAA4550BDqIbQ%3D%3D'
    // 5. fetch 이용한 API 요청
    const option = {
        method: 'POST' ,
        headers : { 'Content-Type' : 'application/json' },
        body : JSON.stringify( data )
    }
    fetch( url+serviceKey , option )
        .then( r => r.json() )
        .then( responseData => {
            console.log( responseData  )
            // 6. 만약에 요청 성공시 응답 자료 의 결과를 HTML 에 출력하기.
            const 결과구역 = document.querySelector('#결과구역')
            let html = responseData.data[0].tax_type
            결과구역.innerHTML = html
        })
        .catch( e => { console.log(e); } )
} // f end

// [1] 부평구 인구 현황 요청 함수
const api1 = ( ) => {
    // 1. 요청할 API URL
    const url = 'https://api.odcloud.kr/api/3044322/v1/uddi:466eee86-a8be-447b-9c8e-802bdbe897d7?page=1&perPage=22&serviceKey='
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
                            <td> ${ obj['인구수(계)'].toLocaleString()  } </td>
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