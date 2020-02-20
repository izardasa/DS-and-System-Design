package com.guitar;

public enum Wood {
	INDIAN_ROSEWOOD, SITKA, MAHOGANY, ADIRONDACK, ALDER, MAPLE;

	public String toString() {
		switch (this) {
		case INDIAN_ROSEWOOD:
			return "Indian Rosewood";
		case SITKA:
			return "Sitka";
		case MAHOGANY:
			return "Mahogany";
		case ADIRONDACK:
			return "Adirondack";
		case ALDER:
			return "Alder";
		case MAPLE:
			return "Maple";
			default: return "Unspecified";

		}

	};
}
