package com.cdt.tools;

import java.net.*;

public class IPtools {
	public static void main(String[] args) throws Exception {
		String ip = InetAddress.getLocalHost().getHostAddress();
		System.out.println(ip);
	}

}
