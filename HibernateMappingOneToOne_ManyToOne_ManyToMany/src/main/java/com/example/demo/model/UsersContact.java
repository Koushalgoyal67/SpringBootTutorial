package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "users_contact", catalog = "hibernate")//hibernate i s database
public class UsersContact {

    @Override
	public String toString() {
		return "UsersContact [id=" + id + ", phoneNo=" + phoneNo + ", users=" + users + "]";
	}

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    private Integer phoneNo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id") 
    private Users users;

    public UsersContact() {
    }

    public Users getUsers() {
        return users;
    }

    public UsersContact setUsers(Users users) {
        this.users = users;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public UsersContact setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getPhoneNo() {
        return phoneNo;
    }

    public UsersContact setPhoneNo(Integer phoneNo) {
        this.phoneNo = phoneNo;
        return this;
    }
}
