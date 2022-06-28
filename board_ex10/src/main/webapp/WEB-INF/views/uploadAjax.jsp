<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>파일 업로드</h2>
<div class="uploadDiv">
	<input type="file" name="uploadFile" multiple>
</div>

	<button id="uploadBtn">submit</button>



<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	
	let contextPath = '${pageContext.request.contextPath}';

	$(document).ready(function() {
		let regex = new RegExp("(.*?)\.(exe|sh|js|alz|txt)$"); //정규표현식
		let maxSize = 5242880; //5mb
		
		function checkExtension(fileName, fileSize) {
			if(fileSize >= maxSize){
				alert("파일 사이즈 초과");
				return false;
			}
			if(regex.test(fileName)){
				alert("지원하지 않는 확장자")
				return false;
			}
			return true;
		}
		
		
		
		$('#uploadBtn').on('click', function(e) {
			let formData = new FormData();
			let inputFile = $("input[name='uploadFile']");
			let files = inputFile[0].files;
			console.log(files);
			
			for(let i = 0 ; i < files.length ; i++){
				if(!checkExtension(files[i].name, files[i].size)){
					return false;
				}
				formData.append("uploadFile", files[i]);
				}
				
				$.ajax({
				url : contextPath + '/uploadAjaxAction',
				processData : false,
				contentType : false,
				data : formData,
				type : 'post',
				success : function(result) {
					alert('uploaded');
				}
			})
			
		})
	})
</script>

</body>
</html>