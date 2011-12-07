package model.reader;

public class IdPair {
	long stireId;
	int autorId;
	
	public IdPair() {}
	public IdPair(long stireId2, int autorId2) {
		this.stireId = stireId2;
		this.autorId = autorId2;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + autorId;
		result = prime * result + (int) (stireId ^ (stireId >>> 32));
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
		IdPair other = (IdPair) obj;
		if (autorId != other.autorId)
			return false;
		if (stireId != other.stireId)
			return false;
		return true;
	}
	
	
	
	
}
