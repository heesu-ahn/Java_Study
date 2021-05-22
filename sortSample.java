package DataStruct;

public class sortSample {
	
	public int [] sortedArray = new int[6]; //6,9,8,3,4,5 예시
	
	// 배열을 받아옴
	public void getSample(int[] arr) {		
		sortedArray = arr;
		System.out.println("[정렬 전 배열]");
		System.out.println("현재 : " + rtnSortArray()); // 정렬 전 배열
		System.out.println("------------------------------------------------------");
		
	}

	// 버블 정렬
	public void BubbleSort() {
		
		System.out.println("[1. 버블 정렬]");
		int a = 0;
		int b = 0;
		int c = 0; //배열 갯수 만큼 비교해서 변경할 대상이 없을 때 빠져나가도록
		
		for(int i = 0; i < sortedArray.length; i++ ) {
						
			c = 0;
			System.out.println( i + 1 + "차");				
			for(int j = 0; j < sortedArray.length-1; j++ ) {

				a = sortedArray[j];
				b = sortedArray[j+1];
								
				if(a > b) {
					System.out.println(">>> (" + (j+ 1) + ") 단계");
					System.out.println("현재 위치 값 : " + a);
					System.out.println("다음 위치 값 : " + b);

					System.out.println(a + " 가 " + b + " 보다 크므로   [" + (j + 1) + "] 열 과 : [" + j + "] 열  서로 이동");					
					System.out.println("위치 : " + "[0],[1],[2],[3],[4],[5]"); // 열 위치 참고용
					System.out.println("이전 : " + rtnSortArray());
					sortedArray[j] = b;
					sortedArray[j+1] = a;

					System.out.println("현재 : " + rtnSortArray());
				} else {
					System.out.println(">>> (" + (j+ 1) + ") 단계");
					System.out.println(a + " 가 " + b + " 보다 작으므로   [" + j + "] 열 과 : [" + (j + 1) + "] 열  이동 하지 않음");
					
					c = c +1;
					// 배열 갯수 만큼 비교해서 더 이상 변경할 대상이 없을 경우에는 더 이상 처리하지 않음 
					if(c == sortedArray.length-1) {
						System.out.println("더 이상 정렬할 대상이 없음. \r실행 종료");
						System.out.println("------------------------------------------------------");
						return;
					} else {
						System.out.println("현재 : " + rtnSortArray());
					}
					
				} 
			}
			System.out.println("------------------------------------------------------");
		}
		
	}
	// 선택 정렬
	public void SelectSort() {
	
		System.out.println("[2. 선택 정렬]");
		int a = 0;
		int b = 0;
		int c = 0;
		int d = 0; //배열 갯수 만큼 비교해서 변경할 대상이 없을 때 빠져나가도록
		
		for(int i = 0; i < sortedArray.length; i ++) {
			
			System.out.println( i + 1 + "차");
			a = sortedArray[i];

			System.out.println("["+ i +"] 열 : " + a);
			
			for(int j = i+1; j < sortedArray.length; j ++) {
				b = sortedArray[j];

				System.out.println("[" + j + "] 열 : 값 = " + b);
				
				if(a > b) {					
					c = j; // 스욉할 대상의 배열 위치 기억
					a = b;
				}
				
			}
			System.out.println("현재 위치 값 = [" + i + "]열 : 값 = " + sortedArray[i]);
			System.out.println("최소 값 = [" + c + "]열 : 값  = " + a);


			
			if(i < sortedArray.length - 1){
				if(sortedArray[i] != a) {
					
					System.out.println("["+ i +"] 열과 ["+ c +"] 열의 자리 변경");
					System.out.println("위치 : " + "[0],[1],[2],[3],[4],[5]"); // 열 위치 참고용
					
					System.out.println("이전 : "+ rtnSortArray());				
					sortedArray[c] = sortedArray[i];
					sortedArray[i] = a;	
					System.out.println("현재 : "+ rtnSortArray());
				}
			} else {
				// 선택 정렬 가장 마지막 단계에서 전체를 한번 더 검색하는 단계
				for(int k = 0; k < sortedArray.length -1; k++) {
					
					if(sortedArray[k] > sortedArray[i]) {
						System.out.println("현재 위치 값 = " + sortedArray[i]);
						System.out.println("최대 값 = " + sortedArray[k]);
						b = sortedArray[k]; // 최대 값 기억
						a = sortedArray[i]; // 스왑 할 값 기억
						
						System.out.println("["+ i +"] 열과 ["+ c +"] 열의 자리 변경");
						System.out.println("위치 : " + "[0],[1],[2],[3],[4],[5]"); // 열 위치 참고용
						
						System.out.println("이전 : "+ rtnSortArray());						
						sortedArray[i] = b;
						sortedArray[k] = a;
						System.out.println("현재 : "+ rtnSortArray());

					}
					
					d = d +1;
					
					// 배열 갯수 만큼 비교해서 더 이상 변경할 대상이 없을 경우에는 더 이상 처리하지 않음 
					if(d == sortedArray.length -1 ) {
						System.out.println("더 이상 정렬할 대상이 없음. \r실행 종료");
					}
				}
				

			}
			
			System.out.println("------------------------------------------------------");
		}
		
	}
	// 이진 정렬
	public void BinarySort() {
		
	}
	
	// 배열의 내용을 표시함
	public String rtnSortArray(){
		String rtn = ""; 
		
		for(int i =0; i < sortedArray.length; i++) {
			
			if(i < sortedArray.length-1) {
				rtn += "["+ sortedArray[i] + "],";
			} else {
				rtn += "["+ sortedArray[i] + "]";
			}
			
		}
		
		return rtn;
		
	}
	
}
