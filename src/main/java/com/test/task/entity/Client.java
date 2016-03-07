package com.test.task.entity;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "client")
@DynamicUpdate(value = true)
@AttributeOverride(name = "id", column = @Column(name = "id"))
public class Client extends Identifier {

    private static final long serialVersionUID = 1L;

    @Column(name = "login")
    private String login;

    @Column(name = "email")
    private String email;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "registration_date")
    private Date registrationDate = new Date();

    @Column(name = "admin")
    private boolean admin = false;

    @Column(name = "moderator")
    private boolean moderator = false;

    @Column(name = "active")
    private boolean active = true;

    @Transient
    private String secondaryPassword;

    public Client() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getRegistrationDate() {
        return new Date(registrationDate.getTime());
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = new Date(registrationDate.getTime());
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public boolean isModerator() {
        return moderator;
    }

    public void setModerator(boolean moderator) {
        this.moderator = moderator;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getSecondaryPassword() {
        return secondaryPassword;
    }

    public void setSecondaryPassword(String secondaryPassword) {
        this.secondaryPassword = secondaryPassword;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id='" + getId() + '\'' +
                "login='" + login + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", registrationDate=" + registrationDate +
                ", admin=" + admin +
                ", moderator=" + moderator +
                ", active=" + active +
                ", secondaryPassword='" + secondaryPassword + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        if (admin != client.admin) return false;
        if (moderator != client.moderator) return false;
        if (active != client.active) return false;
        if (!login.equals(client.login)) return false;
        if (!email.equals(client.email)) return false;
        if (name != null ? !name.equals(client.name) : client.name != null) return false;
        if (!password.equals(client.password)) return false;
        if (!registrationDate.equals(client.registrationDate)) return false;
        return !(secondaryPassword != null ? !secondaryPassword.equals(client.secondaryPassword) : client.secondaryPassword != null);
    }

    @Override
    public int hashCode() {
        int result = login.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + password.hashCode();
        result = 31 * result + registrationDate.hashCode();
        result = 31 * result + (admin ? 1 : 0);
        result = 31 * result + (moderator ? 1 : 0);
        result = 31 * result + (active ? 1 : 0);
        result = 31 * result + (secondaryPassword != null ? secondaryPassword.hashCode() : 0);
        return result;
    }
}
