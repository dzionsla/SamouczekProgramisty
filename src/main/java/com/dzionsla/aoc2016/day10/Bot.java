package com.dzionsla.aoc2016.day10;

public class Bot {
	private final Integer id;
    private Integer lower;
    private Integer higher;

    public Bot(Integer id) {
        this.id = id;
    }

    public void consumeData(Integer value) {
        if (isFilled()) {
            throw new IllegalStateException("Adding number to filled pair! " + lower + " " + higher + " " + id);
        }
        if (lower == null) {
            lower = value;
        }
        else if (lower < value) {
            higher = value;
        }
        else {
            higher = lower;
            lower = value;
        }
    }

    public Integer getLower() {
		return lower;
	}

	public void setLower(Integer lower) {
		this.lower = lower;
	}

	public Integer getHigher() {
		return higher;
	}

	public void setHigher(Integer higher) {
		this.higher = higher;
	}

	public Integer getId() {
		return id;
	}

	public boolean isFilled() {
        return lower != null && higher != null;
    }

	@Override
	public String toString() {
		return "Bot [id=" + id + ", lower=" + lower + ", higher=" + higher + "]";
	}
    
    
}
