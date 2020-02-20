package com.guitar;

public enum InstrumentType {
	GUITAR, BANJO, DABRO, FIDDLE, BASS, MANDOLIN;
	public String toString() {
		switch (this) {
		case GUITAR:
			return "Guitar";
		case BANJO:
			return "Banjo";
		case DABRO:
			return "Dabro";
		case FIDDLE:
			return "Fiddle";
		case BASS:
			return "Bass";
		case MANDOLIN:
			return "Madolin";
		default:
			return "Unspecified";
		}
	};
}
