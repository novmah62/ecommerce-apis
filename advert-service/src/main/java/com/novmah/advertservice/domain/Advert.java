package com.novmah.advertservice.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDateTime;

import static com.fasterxml.jackson.annotation.JsonFormat.Shape.STRING;

@Document("adverts")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Advert implements Serializable {

    @Id
    private String id;

    private String name;

    private String description;

    private String image;

    private String url;

    private Integer count;

    @JsonFormat(shape = STRING,
            pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Ho_Chi_Minh")
    private LocalDateTime creationDateTime;

    @JsonFormat(shape = STRING,
            pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Ho_Chi_Minh")
    private LocalDateTime expirationDateTime;

}
