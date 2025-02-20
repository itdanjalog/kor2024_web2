console.log( 'chat.js open' )

// [1] 클라이언트 웹소켓 생성
const clientSocket = new WebSocket( 'ws://localhost:8080/chat' )
console.log( clientSocket );

// [2] 클라이언트 웹소켓 속성
// 1. 만약에 클라이언트 웹소켓이 서버소켓과 연결을 성공 했을때 실행되는 함수 구현
clientSocket.onopen = ( event ) => {
    console.log( '서버소켓에 연동 성공했다.!!!')
}

// 2. 만약에 클라이언트 웹소켓이 서버소켓과 연결이 닫았을때 실행되는 함수 구현
clientSocket.onclose = ( event ) => {
    console.log( '서버소켓과 연동이 닫혔다. ')
}

// 3. 만액에 클라이언트 웹소켓이 서버소켓과 에러가 발생 했을때 실행되는 함수 구현
clientSocket.onerror = ( event ) => {
    console.log( '서버소켓과 에러가 발생했다.')
}

// 4. 만약에 클라이언트 웹소켓으로 서버소켓이 메시지를 보내왔을때(메시지를 받았을때)
clientSocket.onmessage =( event ) => {
    console.log( '서버소켓으로 부터 메시지를 받았다.' )
}
