package ru.gitpub.rosatom.domain.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Attachment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "task_id")
    private Long taskId;

    @Column(name = "comment_id")
    private Long commentId;

    @Column
    private String name;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] content;

    @Column
    private LocalDateTime tstmpCreate;

    @OneToOne
    private User author;

    @Column
    private String url;

    public Attachment() {
    }

    public Attachment(User author, Long commentId, String url) {
        this.author = author;
        this.commentId = commentId;
        this.url = url;
    }
}
