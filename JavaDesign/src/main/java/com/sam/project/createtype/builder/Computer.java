package com.sam.project.createtype.builder;

public class Computer {
	// CPU
	private Cpu cpu;
	// 主板
	private Board board;

	public Cpu getCpu() {
		return cpu;
	}

	public void setCpu(Cpu cpu) {
		this.cpu = cpu;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}
}
