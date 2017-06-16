package com.wsk.b_eituan;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<Integer> list = new LinkedList<>();
        int k=0;
        while(k<5){
        	k++;
        	String m_str = sc.nextLine();

        	int m = Integer.parseInt(m_str);
        	boolean flag = true;
        	int count = 0;
        	HashSet<Integer> set = new HashSet<>();
        	for(int i=0;i<m;i++){
        		String str = sc.nextLine();
        		if(flag){
	        		String[] split = str.split(" ");
	        		if(split.length==2){
		        		char ch = split[0].charAt(0);
		        		if(ch=='I' || ch=='i'){
		        			if(!set.contains(Integer.parseInt(split[1]))){
		        				set.add(Integer.parseInt(split[1]));
		        			}else{
		        				list.add(i+1);
		        				flag = false;
		        			}
		        		}else if(ch=='O' || ch=='o'){
		        			if(!set.contains(Integer.parseInt(split[1]))){
		        				if(count>0){
		        					count--;
		        				}else{
			        				list.add(i+1);
			        				flag = false;
		        				}
		        			}else {
		        				set.remove(Integer.parseInt(split[1]));
		        			}
		        		}else{
		        			list.add(i+1);
	        				flag = false;
		        		}
	        		}else if(split.length==1){
	        			char ch = split[0].charAt(0);
	        			if(ch=='?'){
	        				count++;
	        			}else{
	        				list.add(i+1);
	        				flag = false;
	        			}
	        		}else{
	        			list.add(i+1);
        				flag = false;
	        		}
        		}
        	}
        	
        	if(flag){
        		list.add(-1);
        	}
        }
        
        for(int i=0;i<list.size();i++){
        	System.out.println(list.get(i));
        }
	}

}