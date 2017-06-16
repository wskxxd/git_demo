package com.wsk.a_scanf;

public class Scanf {
	
	
	public static void main(String[] args) {
		String hosts = "10.171.1.";
		
		for (int i = 1; i < 255; i++) {
			String host = hosts + i;
				int port = 80;
				if(PortScannerByIP.scan(host, port)){
					System.out.println(host+":"+port);
				
			}
		}
		
	}
}
