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
public class Comment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "task_id")
    private Long taskId;

    @OneToOne
    private User author;

    @Column
    private String content;

    @Column
    private LocalDateTime tstmpCreate;

    @PrePersist
    void onCreate() {
        tstmpCreate = LocalDateTime.now();
    }
}
