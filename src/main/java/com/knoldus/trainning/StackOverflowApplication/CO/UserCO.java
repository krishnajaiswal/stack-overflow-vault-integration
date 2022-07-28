package com.knoldus.trainning.StackOverflowApplication.CO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCO {
  private Long id;
  private String username;
  private String email;
  private String password;
  private String address;
}
