package ru.gitpub.rosatom.domain.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Department implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String code;

    @OneToMany
    @JoinTable(name = "DepartmentHousing")
    private List<Housing> housing = new ArrayList<>();

    public Department() {
    }

    public Department(String code) {
        this.code = code;
    }

    public Department updateCode(String code) {
        this.code = code;
        return this;
    }
}
