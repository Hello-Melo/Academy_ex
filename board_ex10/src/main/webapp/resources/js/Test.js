console.log('뽈롱');

var obj = {
		"bno" : "1",
		"reply" : "나는 모르것다아아아아",
		"replyer" : "니도 모르것다아아아아",
	
}
console.log(obj);

console.log(obj.bno);
console.log(obj.reply);
console.log(obj.replyer);

function myObjFun(bno, reply, replyer){
return {
		"bno" : bno,
		"reply" : reply,
		"replyer" : replyer

		};
	}
	
	let reply1  = myObjFun(10, "다모른다아아아??", "몰몰것다");
console.log(reply1);