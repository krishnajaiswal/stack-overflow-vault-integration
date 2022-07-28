package com.knoldus.trainning.StackOverflowApplication.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tag")
public class Tag {
  @Id
  @SequenceGenerator(name = "tag_sequence",
          sequenceName = "tag_sequence",
          allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE,
          generator = "tag_sequence")
  private Long id;

  @Column(name = "tagName", unique = true, nullable = false)
  private String name;
}
