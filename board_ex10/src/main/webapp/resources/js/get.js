$(function () {
	let bnoValue = $('input[name="bno"]').val();
	let replyUL = $('.chat');
		
	function showList(page) {
		replyService.getList({bno : bnoValue, page : page}, function (list) {
			let str = '';
			
			for(let r of list){
					str += `
				            <li class="left clearfix" data-rno='${r.rno}'>
				                <div>
				                    <div class="header">
				                        <strong class="primary-font">${r.replyer}</strong>
				                        <small class="pull-right text-muted">${replyService.displayTime(r.regDate)}</small>
				                        
				                    </div>
				                    <p>${r.reply}</p>
				                </div>
				            </li>
				            `
			}
		      replyUL.html(str);
		});
	}
	showList(1);
	
	
	let bno = $('input[name="bno"]').val();
	
	
	// 모달
	let modal = $('.modal');
	let modalInputReply = modal.find('input[name="reply"]');
	let modalInputReplyer = modal.find('input[name="replyer"]');
	let modalInputReplyDate = modal.find('input[name="regDate"]');
	
	let modalMoBtn = $('#modalMoBtn');
	let modalRemoveBtn = $('#modalRemoveBtn');
	let modalRegisterBtn = $('#modalRegisterBtn');
	let modalCloseBtn = $('modalCloseBtn');
	
	// 댓글등록 모달창
	$('#addReplyBtn').on('click', function(e) {
		modal.find('input').val('');
		modalInputReplyDate.closest('div').hide();
		modalRemoveBtn.hide();
		modalMoBtn.hide();
		modalRegisterBtn.show();
		});
	
	
	// 댓글 등록 이벤트 처리
		modalRegisterBtn.on('click', function(e) {
			let reply = {
					reply : modalInputReply.val(),
					replyer : modalInputReplyer.val(),
					bno : bno
			}
			replyService.add(reply, function(result) {
				alert(result);
				modal.find('input').val('');
				modal.modal('hide');
				showList(1);
			})
		})
	
	// 모델 이벤트 처리
	$('#modalRegisterBtn').on('click', function () {
		let test = modalInputReply.val();
		alert(test);
		})
		
		$('#modalRegisterBtn').on('click', function () {
		let test2 = modalInputReplyer.val();
		alert(test2);
		})		
		
		//
	$('.chat').on('click','li', function(e) {
			// alert('쿨리구' + $(this).data('rno'));
			let rno = $(this).data('rno');
		
			replyService.get(rno, function(reply) {
				console.log(reply);
				modalInputReply.val(reply.reply);
				modalInputReplyer.val(reply.replyer).attr("readonly", "readonly");
				modalInputReplyDate.val(replyService.displayTime(reply.regDate)).attr("readonly", "readonly");
				modal.data("rno", reply.rno)
				
				modal.find("button[id!='modalCloseBtn']").hide();
				modalInputReplyDate.closest('div').show();
				modalMoBtn.show();
				modalRemoveBtn.show();
				
				modal.modal("show");
			})

	})
		
	
	// 댓글 수정
	modalMoBtn.on("click", function(e) {
		let reply = {rno : modal.data("rno"), reply:modalInputReply.val() };
		console.log(reply);
		replyService.update(reply, function(result) {
			alert(result);
			modal.modal("hide");
			showList(1);
		})
	})
	
	//댓글 삭제
	
	modalRemoveBtn.on("click", function(e) {
		let rno = modal.data("rno");
		replyService.remove(rno, function(result) {
			alert(result);
			modal.modal("hide");
			showList(1);
		})
	})
	
	//파일 리스트 블러오기
	$.getJSON(contextPath+"/board/getAttachList", {bno : bnoValue}, function(attachList) {
		let str ="";
		$(attachList).each(function(i, obj){
			if(!obj.fileType){ // 이미지가 아닌경우
				// 파일 경로
				let fileCellPath = encodeURIComponent(obj.uploadPath + "/" + obj.uuid + "_" + obj.fileName);
				let fileLink = fileCellPath.replace(new RegExp(/\\/g),"/");
			
				// 파일이름에 다운로드 링크걸기!
			
				str += "<li class='list-group-item' data-path='"+obj.uploadPath+"'";
				str += "data-uuid='"+obj.uuid+"' data-filename='"+obj.fileName+"' data-type='"+obj.fileType+"'>";
				str += "<img src = '"+contextPath+"/resources/images/attach.png' style='width:30px'>"
				str += "<a href='"+contextPath+"/download?fileName=" + fileCellPath +" '>" + obj.fileName  +"</a>"
				str += "</li>"
				
			} else{//이미지 인 경우
				//파일경로
				
				let fileCellPath = encodeURIComponent(obj.uploadPath + "/s_" + obj.uuid + "_" + obj.fileName);
				console.log(fileCellPath);
				let fileLink = fileCellPath.replace(new RegExp(/\\/g),"/");
				let originPath = obj.uploadPath + "\\" + obj.uuid + "_" + obj.fileName;
				originPath = originPath.replace(new RegExp(/\\/g),"/");
				
			str += "<li class='list-group-item' data-path='"+obj.uploadPath+"'";
			str += "data-uuid='"+obj.uuid+"' data-filename='"+obj.fileName+"' data-type='"+obj.fileType+"'>";	
			str += " <img src = '"+contextPath+"/display?fileName="+fileCellPath+"'>"
			str += "<a href='"+contextPath+"/download?fileName=" + fileCellPath +" '>" + obj.fileName  +"</a>"
			str += "</li>"
			}
		}) //each 종료
		$('.uploadResult ul').append(str);
	})
	
	
	
	
})


