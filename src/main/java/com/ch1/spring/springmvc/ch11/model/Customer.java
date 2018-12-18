package com.ch1.spring.springmvc.ch11.model;

import com.ch1.spring.springmvc.ch11.validator.Phone;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.util.Date;

public class Customer {
    @Size(min = 2, max = 20)
    private String name;

    @NotEmpty
    @Email
    private String email;

    @NotNull
    @Min(18)
    @Max(100)
    private Integer age;

    @NotNull
    private Gender gender;

    @DateTimeFormat(pattern = "MM/dd/yyyy")
    @NotNull
    @Past
    private Date birthday;

    @Phone
    private String phone;

    public enum Gender {
        MALE, FEMALE
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
