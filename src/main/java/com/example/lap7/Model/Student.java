package com.example.lap7.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Student {

    @NotNull(message = "id should be not null")
    private int id;

    @NotEmpty(message = "name should be not empty")
    private String studentName;

    @NotEmpty(message = "phoneNumber should be not empty")
    @Pattern(regexp = "(\05|0)[0-9]{9}",message = "Phone Number must start with '05' and have exactly 10 digits")
    private String phoneNumber;

    @NotEmpty(message = "email should be not empty")
    @Email
    private String email;

    @NotNull(message = "age should be not null")
    private int age;

   @NotEmpty(message = "section should be not empty")
    private String section;

  @NotNull(message = "score should be not null")
   private int score;

  @AssertFalse
  private Boolean isGraduated ;


}
