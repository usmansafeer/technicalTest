package technicalTest.beans;

import java.math.BigDecimal;

public class Saving {

	private String description;
	private String savingType;
	private BigDecimal totalSaving;

	public Saving() {

	}

	public Saving(String description) {
	this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSavingType() {
		return savingType;
	}

	public void setSavingType(String savingType) {
		this.savingType = savingType;
	}

	public BigDecimal getTotalSaving() {
		return totalSaving;
	}

	public void setTotalSaving(BigDecimal totalSaving) {
		this.totalSaving = totalSaving;
	}

	@Override
	public String toString() {
		return "Saving [description=" + description + ", savingType=" + savingType + ", totalSaving=" + totalSaving
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
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
		Saving other = (Saving) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		return true;
	}

}
