package e_linked;

class Linked{
	int node;
	Linked next;
}
public class Main {
	public static void main(String[] args) {
		// ����һ�������Ӻ���ǰ����
		Linked linked = null;
		for(int i=0;i<5;i++){
			if(linked==null){
				linked = new Linked();
				linked.node=i;
			}else{
				Linked temp = new Linked();
				temp.node = i;
				temp.next = linked;
				linked = temp;
			}
		}
		// ��������ͷ
		Linked head = new Linked();
		head.next = linked;
		// �������������
		printLinked(head);
		// ����ת
		Linked h = halfReverse2(head);
		// ��ת������
		printLinked(h);
	}
	
	/**
	 * ��ӡһ�������е�����
	 * @param head
	 */
	public static void printLinked(Linked head){
		Linked l = head.next;
		while(l!=null){
			System.out.print(l.node+" ");
			l=l.next;
		}
		System.out.println();
	}
	/**
	 * ��ʽһ
	 * ˼·���½�һ���µ�����,����������һ���ڵ���ǰ�½�
	 * @param head
	 * @return
	 */
	public static Linked reverseLinked1(Linked head){
		Linked l = null;
		Linked linked = head.next;
		/**
		 * ������Ӻ���ǰ����
		 */
		while(linked!=null){
			if(l == null){
				// ����������ĩβ�ڵ�
				l= new Linked();
				l.node = linked.node;
			}else{
				// ������ǰ�ڵ�lǰһ�ڵ�temp
				Linked temp = new Linked();
				temp.next = l;
				temp.node = linked.node;
				// ���µ�ǰ�ڵ�Ϊǰһ�ڵ�
				l = temp;
			}
			// ��������ԭʼ����
			linked = linked.next;
		}
		// �����������ͷ
		Linked h = new Linked();
		// ����ͷָ���һ���ڵ�
		h.next = l;
		return h;
	}
	/**
	 * ��ʽ��
	 * ˼·�����Ƚ��������ݿ����������У�Ȼ�������鷴���½�һ������������ӵ�һ���ڵ�����½�
	 * @param head
	 * @return
	 */
	public static Linked reverseLinked2(Linked head){
		// ���ص�����ͷ
		Linked new_h = new Linked();
		// ��ȡ��������ĵ�һ���ڵ�
		Linked linked = head.next;
		// ���������������飨������ǰ���������С�������ڵ����������100�ͻ����
		int[] a = new int[100];
		// ��¼����ڵ����
		int k=0;
		// �����������ݵ�����
		while(linked!=null){
			a[k] = linked.node;
			k++;
			linked = linked.next;
		}
		
		/*
		 * ��ͷ��ʼ�������
		 */
		Linked l = null;
		for(int i=k-1;i>=0;i--){
			if(l==null){
				// ������һ���ڵ�
				l=new Linked();
				// ��������
				l.node = a[i];
				// ��������ͷָ���һ���ڵ�
				new_h.next=l;
			}else{
				// ������һ���ڵ�
				Linked temp = new Linked();
				// ��������
				temp.node = a[i];
				// ���������ڵ㣬�õ�ǰ�ڵ�ָ����һ�ڵ�
				l.next = temp;
				// ���µ�ǰ�ڵ�
				l=temp;
			}
		}
		return new_h;
	}
	
	/**
	 * ��ʽ��
	 * ʹ�������������ֱ���ǰһ�ڵ㡢��ǰ�ڵ㡢��һ�ڵ�����ת����
	 * @param head
	 * @return
	 */
	public static Linked reverseLinked3(Linked head){
		Linked current_linked = head.next;
		Linked previous_linked = null;
		while(current_linked!=null){
			// �洢��ǰ�����һ�ڵ�
			Linked next_linked = current_linked.next;
			// ����ǰ����һ�ڵ����Ϊǰһ�ڵ㣨��һ��ʵ�ַ�ת��
			current_linked.next = previous_linked;
			// ǰһ�ڵ����Ϊ��ǰ��
			previous_linked = current_linked;
			// ��ǰ�����Ϊ��һ��
			current_linked = next_linked;
		}
		// ������ͷָ��ת��������һ���ڵ�
		head.next = previous_linked;
		return head;
	}
	
	/**
	 * �������һ�뷴ת
	 * @param head
	 * @return
	 */
	public static Linked halfReverse1(Linked head){
		// �ж��������Ƿ����1
		if(head.next!=null){
			// �ж��������Ƿ����2
			if(head.next.next!=null){
				// step_1ÿ�θ���һ����step_1��ʼֵΪ��һ���ڵ�
				Linked step_1 = head.next;
				// ��ʼֵstep_2ָ��step_1�ڵ�ĺ��2���ڵ�
				Linked step_2 = head.next.next.next;
				while(step_2!=null){
					// step_2ÿ�������������ڵ�
					// step_2��������һ���ڵ�
					step_2 = step_2.next;
					// �ж��Ƿ�Ϊ��
					if(step_2!=null){
						// ��Ϊ��step_2��������һ���ڵ�
						step_2 = step_2.next;
					}else{
						// Ϊ��ʱ����ѭ������ʱstep_1ָ�Ľڵ���һ�ڵ�����м�Ҫ��ʼ��ת�Ľڵ�
						break;
					}
					// step_1ÿ�θ���һ��
					step_1 = step_1.next;
				}
				// step_1��߽ڵ�ʵ�ַ�ת
				Linked l = step_1.next;
				Linked previouseNode = null;
				while(l!=null){
					Linked nextNode = l.next;
					l.next = previouseNode;
					previouseNode = l;
					l=nextNode;
				}
				step_1.next=previouseNode;
			}
		}
		return head;
	}
	
	/**
	 * ʵ��������η�ת���������飬ֱ�ӽ������������ݿ����������У�Ȼ���½�һ����������ǰ��ΰ�˳�����������η�ת����
	 */
	public static Linked halfReverse2(Linked head){
		Linked l = head.next;
		int[] a = new int[100];
		int n = 0;
		while(l!=null){
			a[n] = l.node;
			l = l.next;
			n++;
		}
		int middle = n/2;
		Linked h = new Linked();
		Linked linked = null;
		for(int i=0,k=1;i<n;i++){
			if(i==0){
				linked = new Linked();
				linked.node = a[i];
				h.next = linked;
			}else if(i<middle){
				Linked l1 = new Linked();
				l1.node = a[i];
				linked.next = l1;
				linked = l1;
			}else {
				Linked l1 = new Linked();
				l1.node = a[n-k];
				k++;
				linked.next = l1;
				linked = l1;
			}
		}
		return h;
	}
}
