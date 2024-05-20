
public class Frame {
private boolean referred = false;
private char name;
private int page = 0;
private int frozen = 4;

public Frame(char name) {
	this.name = name; 
}

public boolean isUsed() {
	return referred;
}

public char getName() {
	return name;
}

public int getPage() {
	return page;
}

public void setPage(int i) {
	page = i;
}

public void setUsed(boolean b) {
	referred = b;
}


public boolean isFrozen() {
	if(frozen == 0)
		return false;
	return true;
}

public void resetFrozen() {
	frozen = 4;
}

public void decreaseFrozen() {
	frozen--;
}

public void zeroFrozen() {
	frozen = 0;
}
}
