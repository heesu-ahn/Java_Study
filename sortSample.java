package DataStruct;

public class sortSample {
	
	public int [] sortedArray = new int[6]; //6,9,8,3,4,5 ����
	
	// �迭�� �޾ƿ�
	public void getSample(int[] arr) {		
		sortedArray = arr;
		System.out.println("[���� �� �迭]");
		System.out.println("���� : " + rtnSortArray()); // ���� �� �迭
		System.out.println("------------------------------------------------------");
		
	}

	// ���� ����
	public void BubbleSort() {
		
		System.out.println("[1. ���� ����]");
		int a = 0;
		int b = 0;
		int c = 0; //�迭 ���� ��ŭ ���ؼ� ������ ����� ���� �� ������������
		
		for(int i = 0; i < sortedArray.length; i++ ) {
						
			c = 0;
			System.out.println( i + 1 + "��");				
			for(int j = 0; j < sortedArray.length-1; j++ ) {

				a = sortedArray[j];
				b = sortedArray[j+1];
								
				if(a > b) {
					System.out.println(">>> (" + (j+ 1) + ") �ܰ�");
					System.out.println("���� ��ġ �� : " + a);
					System.out.println("���� ��ġ �� : " + b);

					System.out.println(a + " �� " + b + " ���� ũ�Ƿ�   [" + (j + 1) + "] �� �� : [" + j + "] ��  ���� �̵�");					
					System.out.println("��ġ : " + "[0],[1],[2],[3],[4],[5]"); // �� ��ġ �����
					System.out.println("���� : " + rtnSortArray());
					sortedArray[j] = b;
					sortedArray[j+1] = a;

					System.out.println("���� : " + rtnSortArray());
				} else {
					System.out.println(">>> (" + (j+ 1) + ") �ܰ�");
					System.out.println(a + " �� " + b + " ���� �����Ƿ�   [" + j + "] �� �� : [" + (j + 1) + "] ��  �̵� ���� ����");
					
					c = c +1;
					// �迭 ���� ��ŭ ���ؼ� �� �̻� ������ ����� ���� ��쿡�� �� �̻� ó������ ���� 
					if(c == sortedArray.length-1) {
						System.out.println("�� �̻� ������ ����� ����. \r���� ����");
						System.out.println("------------------------------------------------------");
						return;
					} else {
						System.out.println("���� : " + rtnSortArray());
					}
					
				} 
			}
			System.out.println("------------------------------------------------------");
		}
		
	}
	// ���� ����
	public void SelectSort() {
	
		System.out.println("[2. ���� ����]");
		int a = 0;
		int b = 0;
		int c = 0;
		int d = 0; //�迭 ���� ��ŭ ���ؼ� ������ ����� ���� �� ������������
		
		for(int i = 0; i < sortedArray.length; i ++) {
			
			System.out.println( i + 1 + "��");
			a = sortedArray[i];

			System.out.println("["+ i +"] �� : " + a);
			
			for(int j = i+1; j < sortedArray.length; j ++) {
				b = sortedArray[j];

				System.out.println("[" + j + "] �� : �� = " + b);
				
				if(a > b) {					
					c = j; // ������ ����� �迭 ��ġ ���
					a = b;
				}
				
			}
			System.out.println("���� ��ġ �� = [" + i + "]�� : �� = " + sortedArray[i]);
			System.out.println("�ּ� �� = [" + c + "]�� : ��  = " + a);


			
			if(i < sortedArray.length - 1){
				if(sortedArray[i] != a) {
					
					System.out.println("["+ i +"] ���� ["+ c +"] ���� �ڸ� ����");
					System.out.println("��ġ : " + "[0],[1],[2],[3],[4],[5]"); // �� ��ġ �����
					
					System.out.println("���� : "+ rtnSortArray());				
					sortedArray[c] = sortedArray[i];
					sortedArray[i] = a;	
					System.out.println("���� : "+ rtnSortArray());
				}
			} else {
				// ���� ���� ���� ������ �ܰ迡�� ��ü�� �ѹ� �� �˻��ϴ� �ܰ�
				for(int k = 0; k < sortedArray.length -1; k++) {
					
					if(sortedArray[k] > sortedArray[i]) {
						System.out.println("���� ��ġ �� = " + sortedArray[i]);
						System.out.println("�ִ� �� = " + sortedArray[k]);
						b = sortedArray[k]; // �ִ� �� ���
						a = sortedArray[i]; // ���� �� �� ���
						
						System.out.println("["+ i +"] ���� ["+ c +"] ���� �ڸ� ����");
						System.out.println("��ġ : " + "[0],[1],[2],[3],[4],[5]"); // �� ��ġ �����
						
						System.out.println("���� : "+ rtnSortArray());						
						sortedArray[i] = b;
						sortedArray[k] = a;
						System.out.println("���� : "+ rtnSortArray());

					}
					
					d = d +1;
					
					// �迭 ���� ��ŭ ���ؼ� �� �̻� ������ ����� ���� ��쿡�� �� �̻� ó������ ���� 
					if(d == sortedArray.length -1 ) {
						System.out.println("�� �̻� ������ ����� ����. \r���� ����");
					}
				}
				

			}
			
			System.out.println("------------------------------------------------------");
		}
		
	}
	// ���� ����
	public void BinarySort() {
		
	}
	
	// �迭�� ������ ǥ����
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
