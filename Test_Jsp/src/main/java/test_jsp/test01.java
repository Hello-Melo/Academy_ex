package test_jsp;

public class test01 {
	

	private static String ans;

	public static void main(String[] args) {
		
		ans = null;
		
		
		if("y".equals(ans)){
			System.out.println("ok");
		}else if ("n".equals(ans)) {
			System.out.println("good");
		}else {
			System.out.println("다시입력");
		}
		
	}
	}

	//String객체 ans에 "y"가 들어있는 경우 "ok"를 출력, "n"일경우 "good"을 출력
	//그외의 경우 (null인 경우 포함)은 "다시 입력하세요" 출력하고
	//(ans는 값을 초기화하여 사용합니다) sysin입력값 없이



