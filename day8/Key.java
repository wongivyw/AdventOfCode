package day8;

public class Key {
	private int value;
	private String key;
	
	public Key (String keySequence, int value) {
		key = keySequence;
		this.value = value;
	}
	
	public int getVal() {
		return value;
	}
	
	public String getKey() {
		return key;
	}
}
