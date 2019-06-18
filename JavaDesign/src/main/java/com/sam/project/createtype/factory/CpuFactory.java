package com.sam.project.createtype.factory;

public class CpuFactory {

	public static Cpu createCpu(String type, int param) {
		Cpu cpu = null;
		if ("intel".equals(type)) {
			cpu = new IntelCpu(param);
		} else if ("amd".equals(type)) {
			cpu = new AmdCpu(param);
		}
		return cpu;
	}
}
