package com.sam.project.createtype.builder;

//具体建造者（ComputerBuilder）角色
public class ComputerBuilder implements Builder {
	private Computer computer;
	
	public ComputerBuilder() {
		computer = new Computer();
	}

	@Override
	public void createCpu() {
		// TODO Auto-generated method stub
		Cpu cpu = new Cpu(1,"intel 6700");
		computer.setCpu(cpu);
	}

	@Override
	public void createBoard() {
		Board board = new Board(1,"联想");
		computer.setBoard(board);
	}

	@Override
	public Computer buildComputer() {
		return computer;
	}
}
