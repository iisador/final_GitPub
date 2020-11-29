package ru.gitpub.rosatom.domain.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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

    @OneToOne
    private TaskType type;

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

    @OneToMany
    private List<Comment> comments;

    @OneToOne
    private Group group;

    @OneToOne
    private Reaction reaction;

    @PrePersist
    void onCreate() {
        tstmpCreate = LocalDateTime.now();
    }

    public Optional<Group> getGroup() {
        return Optional.ofNullable(group);
    }

    public Optional<Reaction> getReaction() {
        return Optional.ofNullable(reaction);
    }
}
