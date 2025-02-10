console.log( 'view.js open' )

// [1] 개별 게시물 조회 요청 함수
const onFind = () =>{

    // 1. 현재 보고자하는 게시물의 번호를 찾기 / 사용자가 클릭한 게시물 번호 찾기
    // board/view?bno = 3 , 즉] url 경로상의 쿼리스트링으로 bno 존재한다.
    // console.log( new URL() ) // new URL() : url 정보를 담는 객체를 생성
    // console.log( new URL( location.href ) ) // 현재 페이지의 url 정보를 담은 객체를 생성
    // console.log( new URL( location.href ).searchParams ) // 현재 페이지의 url 정보중에 매개변수를 반환 속성

    const bno = new URL( location.href ).searchParams.get('bno')

    // 2. fetch
    fetch( `/board/find.do?bno=${ bno }` )
        .then( r => r.json() )
        .then( data => {
            console.log( data );
            document.querySelector('.midbox').innerHTML = data.mid
            document.querySelector('.bviewbox').innerHTML = data.bview
            document.querySelector('.cdatebox').innerHTML = data.cdate

            document.querySelector('.btitle').innerHTML = data.btitle
            document.querySelector('.bcontent').innerHTML = data.bcontent
        })
        .catch( e =>{ console.log(e); })

}
onFind(); // 페이지가 열릴때 개별 게시물 조회 함수 실행
