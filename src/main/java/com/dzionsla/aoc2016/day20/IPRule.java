package com.dzionsla.aoc2016.day20;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class IPRule {
	private List<String> data;
	private String dir = "C:\\projects\\java\\SamouczekProgramisty\\src\\main\\resources\\day20_input.txt";
	private List<IpRange> ranges = new ArrayList<IpRange>();;
	
	public IPRule() {
		readData();
		
        for (String string : data) {
        	ranges.add(IpRange.parse(string));
		}
        
        Collections.sort(this.ranges);
        
        System.out.println(getFirstAllowedIp());
        System.out.println(getAllowedIpsCount());

	}

	
    public long getFirstAllowedIp() {
        long firstAllowedIp = 0;
        for (IpRange range : ranges) {
            if (firstAllowedIp < range.start) {
                return firstAllowedIp;
            }
            if (range.end > firstAllowedIp) {
                firstAllowedIp = range.end + 1;
            }
        }
        return firstAllowedIp;
    }
    
    public long getAllowedIpsCount() {
        long allowedIP = 0;
        long counts = 0;
        for (IpRange range : ranges) {
            if (allowedIP < range.start) {
            	counts = counts + range.start - allowedIP;
			} 
            if (range.end > allowedIP) {
            	allowedIP = range.end + 1;
            }
        }
        return counts;
    }
	
//	private long getMin(String str) {
//		Pattern p = Pattern.compile("(.+)-(.+)");
//		Matcher m = p.matcher(str);
//		
//		if (!m.matches()) {
//	    	throw new IllegalArgumentException(String.format("Instruction [%s] can't be parsed!", str));
//	    }
//		long end = Long.parseLong(m.group(1));
//		
//		return end;
//	}

	private void readData() {
		try {
			data = Files.readAllLines(Paths.get(dir));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
