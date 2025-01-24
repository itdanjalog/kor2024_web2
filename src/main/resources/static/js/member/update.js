

const getMyInfo = () =>{
    // fetch() 함수로 /member/info.do 요청
    fetch( '/member/myinfo.do' )
       .then( response => response.json() )
       .then( data => {
           document.querySelector('.midInput').value = data.mid
            document.querySelector('.mnameInput').value = data.mname
            document.querySelector('.memailInput').value = data.memail
        })
       .catch( error => {
            console.error(error);
        });
}
getMyInfo();

const onUpdate = () =>{

    const option = {
        method : 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            mname: document.querySelector('.mnameInput').value,
            memail: document.querySelector('.memailInput').value
        })
    }
    fetch( '/member/update.do' ,  option )
    .then( response => response.json() )
    .then( data => {
        if( data == true ){ alert('수정 성공'); location.href="/member/info"; }
        else{ alert('수정 실패'); }
    })
    .catch( error => {
        console.error(error);
    });
}