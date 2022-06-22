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
	showList();
	
})

