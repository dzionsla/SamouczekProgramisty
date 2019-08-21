package com.dzionsla.aoc2016.day10;

public class Bot {
	private final Integer id;
    private Integer lowerValue;
    private Integer higherValue;
    
    Boolean lowValueToBot;
    Integer idBotLow;
	Boolean highValueToBot;
	Integer idBotHigh;

    public Bot(Integer id) {
        this.id = id;
    }
    
    public Bot(Integer id, Boolean lowValueToBot, Boolean highValueToBot) {
    	this.id = id;
        this.lowValueToBot = lowValueToBot;
        this.highValueToBot = highValueToBot;
    }

    public void consumeData1(Integer value) {
        if (isFilled()) {
            throw new IllegalStateException("Adding number to filled pair! " + lowerValue + " " + higherValue + " " + id);
        }
        if (lowerValue == null) {
            lowerValue = value;
        }
        else if (lowerValue < value) {
            higherValue = value;
        }
        else {
            higherValue = lowerValue;
            lowerValue = value;
        }
    }
    
    public void consumeData2(Integer idBotLow, Boolean lowValueToBot, Integer idBotHigh, Boolean highValueToBot) {
        this.idBotLow = idBotLow;
        this.lowValueToBot = lowValueToBot;
        this.idBotHigh = idBotHigh;
        this.highValueToBot = highValueToBot;
    }

    public Integer getLower() {
		return lowerValue;
	}

	public void setLower(Integer lower) {
		this.lowerValue = lower;
	}

	public Integer getHigher() {
		return higherValue;
	}

	public void setHigher(Integer higher) {
		this.higherValue = higher;
	}

	public Integer getId() {
		return id;
	}

	public Boolean isLowValueToBot() {
		return lowValueToBot;
	}

	public void setLowValueToBot(Boolean lowValueToBot) {
		this.lowValueToBot = lowValueToBot;
	}

	public Integer getIdBotLow() {
		return idBotLow;
	}

	public void setIdBotLow(int idBotLow) {
		this.idBotLow = idBotLow;
	}

	public Boolean isHighValueToBot() {
		return highValueToBot;
	}

	public void setHighValueToBot(Boolean highValueToBot) {
		this.highValueToBot = highValueToBot;
	}

	public Integer getIdBotHigh() {
		return idBotHigh;
	}

	public void setIdBotHigh(int idBotHigh) {
		this.idBotHigh = idBotHigh;
	}

	public boolean isFilled() {
        return lowerValue != null && higherValue != null;
    }

	@Override
	public String toString() {
		return "Bot [id=" + id + ", lowerValue=" + lowerValue + ", higherValue=" + higherValue + ", lowValueToBot="
				+ lowValueToBot + ", idBotLow=" + idBotLow + ", highValueToBot=" + highValueToBot + ", idBotHigh="
				+ idBotHigh + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bot other = (Bot) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
    
    
}
