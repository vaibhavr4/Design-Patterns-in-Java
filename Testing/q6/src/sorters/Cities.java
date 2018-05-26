package sorters;
/**
 * 
 * @author VAIBHAV
 *
 */
public class Cities implements Comparable<Cities> {
	
	private String city;
	
	/**
	 * Constructor for Cities
	 * @param city
	 */
	public Cities(String city) {
		setName(city);
	}

	/**
	 * getter method to get the city name
	 * @return String
	 */
	public String getName() {
		return this.city;
		
	}
	
	/**
	 * setter method to set the city name
	 * @param city
	 */
	void setName(String city) {
		this.city=city;
	}
	
	
	/**
	 * return 0 if two Cities are equal
	 */
	@Override
	public int compareTo(Cities p) {
		return this.getName().compareTo(p.getName());
	}
	

	/** (non-Javadoc)
	 * override hash code
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		return result;
	}

	/** (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 * override equals method to check if two Cities are equals
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Cities))
			return false;
		Cities other = (Cities) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		return true;
	}

}
