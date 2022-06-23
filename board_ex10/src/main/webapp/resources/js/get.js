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
				                        <small class="pull-right text-muted">${replyService.displayTime(r.updateDate)}</small>
				                        
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
	
	//모델 이벤트 처리
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
				modalInputReplyer.val(reply.replyer);
				modalInputReplyDate.val(replyService.displayTime(reply.updateDate)).attr("readonly", "readonly");
				modal.data("rno", reply,rno)
				
				modal.find("button[id!='modalCloseBtn']").hide();
				modalInputReplyDate.closest('div').show();
				modalMoBtn.show();
				modalRemoveBtn.show();
				
				modal.modal("show");
			})
	})
		
		
})


