package e_linked;

class Linked{
	int node;
	Linked next;
}
public class Main {
	public static void main(String[] args) {
		// 构建一个链表，从后向前构建
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
		// 建立链表头
		Linked head = new Linked();
		head.next = linked;
		// 输出构建的链表
		printLinked(head);
		// 链表反转
		Linked h = halfReverse2(head);
		// 反转结果输出
		printLinked(h);
	}
	
	/**
	 * 打印一个链表中的数据
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
	 * 方式一
	 * 思路：新建一个新的链表,新链表从最后一个节点向前新建
	 * @param head
	 * @return
	 */
	public static Linked reverseLinked1(Linked head){
		Linked l = null;
		Linked linked = head.next;
		/**
		 * 新链表从后向前构建
		 */
		while(linked!=null){
			if(l == null){
				// 构建新链表末尾节点
				l= new Linked();
				l.node = linked.node;
			}else{
				// 构建当前节点l前一节点temp
				Linked temp = new Linked();
				temp.next = l;
				temp.node = linked.node;
				// 更新当前节点为前一节点
				l = temp;
			}
			// 迭代遍历原始链表
			linked = linked.next;
		}
		// 新链表的链表头
		Linked h = new Linked();
		// 链表头指向第一个节点
		h.next = l;
		return h;
	}
	/**
	 * 方式二
	 * 思路：首先将链表内容拷贝到数组中，然后以数组反序新建一个链表，新链表从第一个节点向后新建
	 * @param head
	 * @return
	 */
	public static Linked reverseLinked2(Linked head){
		// 返回的链表头
		Linked new_h = new Linked();
		// 获取输入链表的第一个节点
		Linked linked = head.next;
		// 新链表拷贝到的数组（这里提前定义数组大小如果链表节点数超过这个100就会出错）
		int[] a = new int[100];
		// 记录链表节点个数
		int k=0;
		// 拷贝链表数据到数组
		while(linked!=null){
			a[k] = linked.node;
			k++;
			linked = linked.next;
		}
		
		/*
		 * 从头开始向后建链表
		 */
		Linked l = null;
		for(int i=k-1;i>=0;i--){
			if(l==null){
				// 构建第一个节点
				l=new Linked();
				// 拷贝数据
				l.node = a[i];
				// 让新链表头指向第一个节点
				new_h.next=l;
			}else{
				// 构建下一个节点
				Linked temp = new Linked();
				// 拷贝数据
				temp.node = a[i];
				// 关联两个节点，让当前节点指向下一节点
				l.next = temp;
				// 更新当前节点
				l=temp;
			}
		}
		return new_h;
	}
	
	/**
	 * 方式三
	 * 使用三个变量，分别是前一节点、当前节点、后一节点来反转链表
	 * @param head
	 * @return
	 */
	public static Linked reverseLinked3(Linked head){
		Linked current_linked = head.next;
		Linked previous_linked = null;
		while(current_linked!=null){
			// 存储当前点的下一节点
			Linked next_linked = current_linked.next;
			// 将当前点下一节点更新为前一节点（这一步实现反转）
			current_linked.next = previous_linked;
			// 前一节点更新为当前点
			previous_linked = current_linked;
			// 当前点更新为下一点
			current_linked = next_linked;
		}
		// 将链表头指向反转后的链表第一个节点
		head.next = previous_linked;
		return head;
	}
	
	/**
	 * 将链表后一半反转
	 * @param head
	 * @return
	 */
	public static Linked halfReverse1(Linked head){
		// 判断链表长度是否大于1
		if(head.next!=null){
			// 判断链表长度是否大于2
			if(head.next.next!=null){
				// step_1每次更新一步，step_1初始值为第一个节点
				Linked step_1 = head.next;
				// 初始值step_2指向step_1节点的后第2个节点
				Linked step_2 = head.next.next.next;
				while(step_2!=null){
					// step_2每次向后更新两个节点
					// step_2先向后跟新一个节点
					step_2 = step_2.next;
					// 判断是否为空
					if(step_2!=null){
						// 不为空step_2再向后更新一个节点
						step_2 = step_2.next;
					}else{
						// 为空时跳出循环，此时step_1指的节点下一节点就是中间要开始反转的节点
						break;
					}
					// step_1每次更新一步
					step_1 = step_1.next;
				}
				// step_1后边节点实现反转
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
	 * 实现链表后半段反转，借助数组，直接将链表所有内容拷贝到数组中，然后新建一个链表将数组前半段按顺序拷入链表，后半段反转拷入
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
