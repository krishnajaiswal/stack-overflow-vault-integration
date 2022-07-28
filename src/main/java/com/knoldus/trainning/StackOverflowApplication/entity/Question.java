package com.knoldus.trainning.StackOverflowApplication.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "question")
public class Question {
  @Id
  @SequenceGenerator(name = "question_sequence",
          sequenceName = "question_sequence",
          allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE,
          generator = "question_sequence")
  private long id;

  @Column(name = "questionTitle", nullable = false, unique = true)
  private String questionTitle;

  @Column(name = "questionDescription")
  private String questionDescription;

  @ManyToOne(cascade = CascadeType.ALL,
          fetch = FetchType.LAZY)
  @JoinColumn(
          referencedColumnName = "id")
  private Tag tag;

  @Temporal(TemporalType.TIMESTAMP)
  private Date createdAt;

  @Temporal(TemporalType.TIMESTAMP)
  private Date updatedAt;

  @PrePersist
  public void prePersist() {
    createdAt = new Date();
    updatedAt = new Date();
  }

  @PreUpdate
  public void preUpdate() {
    updatedAt = new Date();
  }

}
