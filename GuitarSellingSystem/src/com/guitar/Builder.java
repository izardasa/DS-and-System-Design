package com.guitar;

public enum Builder {
COLLINGS, MARTIN, FENDER, GIBSON;
	
	public String toString() {
		switch(this)
		{
		case COLLINGS: return "Collings";
		case MARTIN: return "Martin";
		case FENDER: return "Fender";
		case GIBSON: return "Gibson";
		default: return "Unspecified";
		}
		
	};
}
