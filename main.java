package DataStruct;

public class main {

	public static int [] sample = {6,9,8,3,4,5};
	public static int [] sample2 = {11,20,18,3,7,15};
	
	public static void main(String[] args) {

		// 버블 정렬 예제
		//sortSample sS = new sortSample();
		//sS.getSample(sample);
		//sS.BubbleSort();
		
		// 선택정렬 예제
		sortSample sS2 = new sortSample();
		sS2.getSample(sample2);
		sS2.SelectSort();
		
	}
	
	

}
