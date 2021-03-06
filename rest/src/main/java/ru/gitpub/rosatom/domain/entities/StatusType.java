package ru.gitpub.rosatom.domain.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class StatusType implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String code;

    public StatusType() {
    }

    public StatusType(String code) {
        this.code = code;
    }

    public StatusType updateCode(String code) {
        this.code = code;
        return this;
    }
}
