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
@Table(name = "answer")
public class Answer {
  @Id
  @SequenceGenerator(name = "answer_sequence",
          sequenceName = "answer_sequence",
          allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE,
          generator = "answer_sequence")
  @Column(name = "answerId")
  private Long id;

  @Column(name = "inputAnswer", nullable = false)
  private String inputAnswer;

  @ManyToOne(cascade = CascadeType.ALL,
          fetch = FetchType.LAZY)
  @JoinColumn(
          referencedColumnName = "id")
  private Question question;

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
