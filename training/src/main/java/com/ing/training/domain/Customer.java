package com.ing.training.domain;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    private int accountId;

    private String password;

    @NotNull
    @Size(min = 2, max = 50)
    private String firstname;

    @NotNull
    @Size(min = 2, max = 50)
    private String lastname;

    @NotNull
    @Size(min = 2, max = 50)
    private String email;

    @NotNull
    @Size(min = 2, max = 50)
    private String phone;

    @NotNull
    @Size(min = 2, max = 50)
    private String nationalId;

    @NotNull
    @Size(min = 5, max = 200)
    private String address;

    @NotNull
    @Size(min = 5, max = 10)
    private String postalCode;

    @NotNull
    @Size(min = 5, max = 50)
    private String city;

    @NotNull
    @Size(min = 2, max = 50)
    private String country;
    
    @NotNull
    @Size(min = 2, max = 50)
    private String gender;
    
    @NotNull
    @Size(min = 2, max = 50)
    private String accountType;
    
    private double balance;


    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public String getFirstname() {
	return firstname;
    }

    public void setFirstname(String firstname) {
	this.firstname = firstname;
    }

    public String getLastname() {
	return lastname;
    }

    public void setLastname(String lastname) {
	this.lastname = lastname;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public String getPhone() {
	return phone;
    }

    public void setPhone(String phone) {
	this.phone = phone;
    }

    public String getNationalId() {
	return nationalId;
    }

    public void setNationalId(String nationalId) {
	this.nationalId = nationalId;
    }

    public String getAddress() {
	return address;
    }

    public void setAddress(String address) {
	this.address = address;
    }

    public String getPostalCode() {
	return postalCode;
    }

    public void setPostalCode(String postalCode) {
	this.postalCode = postalCode;
    }

    public String getCity() {
	return city;
    }

    public void setCity(String city) {
	this.city = city;
    }

    public String getCountry() {
	return country;
    }

    public void setCountry(String country) {
	this.country = country;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + accountId;
	result = prime * result + ((accountType == null) ? 0 : accountType.hashCode());
	result = prime * result + ((address == null) ? 0 : address.hashCode());
	long temp;
	temp = Double.doubleToLongBits(balance);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	result = prime * result + ((city == null) ? 0 : city.hashCode());
	result = prime * result + ((country == null) ? 0 : country.hashCode());
	result = prime * result + ((email == null) ? 0 : email.hashCode());
	result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
	result = prime * result + ((gender == null) ? 0 : gender.hashCode());
	result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
	result = prime * result + ((nationalId == null) ? 0 : nationalId.hashCode());
	result = prime * result + ((password == null) ? 0 : password.hashCode());
	result = prime * result + ((phone == null) ? 0 : phone.hashCode());
	result = prime * result + ((postalCode == null) ? 0 : postalCode.hashCode());
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
	Customer other = (Customer) obj;
	if (accountId != other.accountId)
	    return false;
	if (accountType == null) {
	    if (other.accountType != null)
		return false;
	} else if (!accountType.equals(other.accountType))
	    return false;
	if (address == null) {
	    if (other.address != null)
		return false;
	} else if (!address.equals(other.address))
	    return false;
	if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
	    return false;
	if (city == null) {
	    if (other.city != null)
		return false;
	} else if (!city.equals(other.city))
	    return false;
	if (country == null) {
	    if (other.country != null)
		return false;
	} else if (!country.equals(other.country))
	    return false;
	if (email == null) {
	    if (other.email != null)
		return false;
	} else if (!email.equals(other.email))
	    return false;
	if (firstname == null) {
	    if (other.firstname != null)
		return false;
	} else if (!firstname.equals(other.firstname))
	    return false;
	if (gender == null) {
	    if (other.gender != null)
		return false;
	} else if (!gender.equals(other.gender))
	    return false;
	if (lastname == null) {
	    if (other.lastname != null)
		return false;
	} else if (!lastname.equals(other.lastname))
	    return false;
	if (nationalId == null) {
	    if (other.nationalId != null)
		return false;
	} else if (!nationalId.equals(other.nationalId))
	    return false;
	if (password == null) {
	    if (other.password != null)
		return false;
	} else if (!password.equals(other.password))
	    return false;
	if (phone == null) {
	    if (other.phone != null)
		return false;
	} else if (!phone.equals(other.phone))
	    return false;
	if (postalCode == null) {
	    if (other.postalCode != null)
		return false;
	} else if (!postalCode.equals(other.postalCode))
	    return false;
	return true;
    }

    @Override
    public String toString() {
	return "Customer [accountId=" + accountId + ", password=" + password + ", firstname=" + firstname
		+ ", lastname=" + lastname + ", email=" + email + ", phone=" + phone + ", nationalId=" + nationalId
		+ ", address=" + address + ", postalCode=" + postalCode + ", city=" + city + ", country=" + country
		+ ", gender=" + gender + ", accountType=" + accountType + ", balance=" + balance + "]";
    }

   
}
