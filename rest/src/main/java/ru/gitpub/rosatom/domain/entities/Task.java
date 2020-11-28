package ru.gitpub.rosatom.domain.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Task implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private Long type;

    @OneToOne
    private User assignee;

    @Column
    private LocalDateTime dateTo;

    @Column
    private LocalDateTime dateFact;

    @Column
    private LocalDateTime tstmpCreate;

    @OneToOne
    private User author;

    @Column
    private String header;

    @Column
    private String info;

    @OneToOne
    private StatusType status;

    @OneToOne
    private Priority priority;

    @Column(name = "parent_id")
    private Long parentId;

    @PrePersist
    void onCreate() {
        tstmpCreate = LocalDateTime.now();
    }
}
