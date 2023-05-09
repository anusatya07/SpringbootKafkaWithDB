package com.v2.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

//@Data
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@ToString
//@EqualsAndHashCode
@Entity
public class Customer {
	
	@Id
	private Long custId;
	
	private String custName;
	
	public Customer() {
		super();
	}
	public Long getCustId() {
		return custId;
	}
	public void setCustId(Long custId) {
		this.custId = custId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public Customer(Long custId, String custName) {
		super();
		this.custId = custId;
		this.custName = custName;
	}
	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(custId, custName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(custId, other.custId) && Objects.equals(custName, other.custName);
	}
}
