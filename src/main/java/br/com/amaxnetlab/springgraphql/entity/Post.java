package br.com.amaxnetlab.springgraphql.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "tb-post")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @NonNull
    private String title;
    @NonNull
    private String content;
    @CreationTimestamp
    private Date publishedAt;
    @ManyToOne(fetch = FetchType.LAZY)
    private User author;
}
