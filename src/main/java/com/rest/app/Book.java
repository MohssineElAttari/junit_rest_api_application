package com.rest.app;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "book_record")
public class Book {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
    private Long bookId;

    @NonNull
    private String name;

    @NonNull
    private String summary;

    private int rating;

}

