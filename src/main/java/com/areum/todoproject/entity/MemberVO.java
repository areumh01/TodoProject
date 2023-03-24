package com.areum.todoproject.entity;

import lombok.*;

import java.time.LocalDate;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MemberVO {
    String id;
    String pw;
    String name;
    String uuid;
}
