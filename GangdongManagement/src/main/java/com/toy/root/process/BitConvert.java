package com.toy.root.process;

public class BitConvert {
	public String BitConvert(int times) {
		String bitform = Integer.toBinaryString(times);
		return String.format("%8s", bitform).replace(' ', '0');	
	}
	public int BitConvert(String bit_times) {
		return Integer.parseInt(bit_times,2);
	}
}