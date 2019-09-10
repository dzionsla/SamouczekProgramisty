package com.dzionsla.aoc2016.day17;

public class App {

	public static void main(String[] args) {
		//Steps s = new Steps();
		//VaultExplorer ve = new VaultExplorer("ihgpwlah");
		//System.out.println(ve.findShortestPath());
		
		VaultMR vmr = new VaultMR();
		System.out.println(vmr.findShortestPath().length());
		System.out.println(vmr.findLongestPath().length());
	}

}
