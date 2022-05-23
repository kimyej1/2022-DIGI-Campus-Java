
public interface Days {
	public static final int SUN=1, MON=2, TUE=3, WED=4, THU=5, FRI=6, SAT=7; // comma로 나열 가능 
	public static final int NotFound=404, OK=200, Trying=100, Ringing=180;
	
	/*
	 * Trying=100, A, B, C // A, B, C automatically mapped with 101, 102, 103
	 * OK=200, D, E, F // D, E, F automatically mapped with 201, 202, 203
	 */
}
