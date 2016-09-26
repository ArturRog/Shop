package com.rog.webshop.model.user;


import com.rog.webshop.validator.UserSsoId;
import com.rog.webshop.validator.ValidateOnCreationOnly;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "APP_USER")
public class User implements Serializable
{

    private static final long serialVersionUID = 4256810895227136750L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @UserSsoId(groups = ValidateOnCreationOnly.class)
    @Size(min = 3, max = 15, message = "{Size.User.ssoId.validation}")
    @Column(name = "SSO_ID", unique = true, nullable = false)
    private String ssoId;
    @Email
    @Column(name = "EMAIL", nullable = false)
    private String email;

    @Size(min = 6, max = 15, message = "{Size.User.password.validation}")
    @Column(name = "PASSWORD", nullable = false)
    private String password;
    @Column(name = "PHONE_NUMBER", nullable = false, length = 15)
    private String phoneNumber;
    @Size(min = 3, max = 15, message = "{Size.User.firstName.validation}")
    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;
    @Size(min = 3, max = 15, message = "{Size.User.lastName.validation}")
    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;


    @NotEmpty
    @Column(name = "STATE", nullable = false)
    private String state = State.ACTIVE.getState();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "APP_USER_USER_PROFILE",
            joinColumns = {@JoinColumn(name = "USER_ID")},
            inverseJoinColumns = {@JoinColumn(name = "USER_PROFILE_ID")})
    private Set<UserProfile> userProfiles = new HashSet<UserProfile>();


    @Size(min = 3, max = 50, message = "{Size.User.streetName.validation}")
    @Column(name = "STREET_NAME", length = 50)
    private String streetName;
    @Min(value = 1, message = "{Min.User.doorNo.validation}")
    @Column(name = "DOOR_NO")
    private String doorNo;
    @Size(min = 3, max = 20, message = "{Size.User.areaName.validation}")
    @Column(name = "AREA_NAME", length = 20)
    private String areaName;
    @Size(min = 3, max = 50, message = "{Size.User.state.validation}")
    @Column(name = "STATE_NAME", length = 50)
    private String stateName;
    @Size(min = 3, max = 25, message = "{Size.User.country.validation}")
    @Column(name = "COUNTRY", length = 25)
    private String country;
    @Size(min = 2, max = 10, message = "{Size.User.zipCode.validation}")
    @Column(name = "ZIP_CODE", length = 10)
    private String zipCode;

    public String getDoorNo() {

        return doorNo;
    }

    public void setDoorNo(String doorNo) {
        this.doorNo = doorNo;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (ssoId != null ? !ssoId.equals(user.ssoId) : user.ssoId != null) return false;
        return password != null ? password.equals(user.password) : user.password == null;

    }

    @Override
    public int hashCode() {
        int result = ssoId != null ? ssoId.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    public String getSsoId() {
        return ssoId;
    }

    public void setSsoId(String ssoId) {
        this.ssoId = ssoId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Set<UserProfile> getUserProfiles() {
        return userProfiles;
    }

    public void setUserProfiles(Set<UserProfile> userProfiles) {
        this.userProfiles = userProfiles;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", ssoId='" + ssoId + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", streetName='" + streetName + '\'' +
                ", doorNo='" + doorNo + '\'' +
                ", areaName='" + areaName + '\'' +
                ", stateName='" + stateName + '\'' +
                ", country='" + country + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", state='" + state + '\'' +
                ", userProfiles=" + userProfiles +
                '}';
    }
}
