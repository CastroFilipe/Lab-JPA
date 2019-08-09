package com.filipe.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Point {
    // Persistent Fields:
	@Id
	private Long id;
	
    private int x;
    private int y;
    
    public Point() { 	
    }

	public Point(Long id, int x, int y) {
		super();
		this.id = id;
		this.x = x;
		this.y = y;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	// String Representation:
    @Override
    public String toString() {
        return String.format("(%d, %d)", this.x, this.y);
    }
}
