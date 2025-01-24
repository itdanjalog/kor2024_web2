

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

const onDelete = () =>{

    let result =  confirm('정말 탈퇴 하시겠습니까?');
    if( result == false ){ return; }

    fetch( '/member/delete.do'  , { method : 'DELETE' } )
    .then( response => response.json() )
    .then( data => {
        if( data == true ){ alert('탈퇴 성공'); location.href="/"; }
        else{ alert('탈퇴 실패'); }
    })
    .catch( error => {
        console.error(error);
    });

}