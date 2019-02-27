<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jQuery Ajax Fileupload</title>

<!-- jQuery 2.2.4 -->
<script type="text/javascript" src="http://code.jquery.com/jquery-2.2.4.min.js"></script>

<!-- jQuery Form Plugin -->
<script src="http://malsup.github.com/min/jquery.form.min.js"></script> 
 
<script type="text/javascript">
$(document).ready(function() {
	
	//jquery.form.js 플러그인 사용
	//	http://malsup.com/jquery/form/
	
	$("#fileForm").ajaxForm({
// 		type: "post" //form에 설정한 값이 기본값
// 		, url: "/jquery" //form에 설정한 값이 기본값
		data: {
			
		}
		, dataType: "json"
		, success: function( res ) {
			console.log("성공");
		}
		, error: function() {
			console.log("실패");
		}
		
		
	});
});
</script>

</head>
<body>

<h1>jQuery 라이브러리를 이용한 Ajax 파일 업로드</h1>
<hr>

<form id="fileForm" action="/jquery" method="post" enctype="multipart/form-data">

<label>제목 : <input type="text" name="title" /></label><br>
<label>본문 : <input type="text" name="content" /></label><br>
<label>첨부1 : <input type="file" name="file1" /></label><br>
<label>첨부2 : <input type="file" name="file2" /></label><br>
<label>첨부3 : <input type="file" name="file3" /></label><br><br>

<button id="btnSend">보냅니다!</button>
</form>

</body>
</html>