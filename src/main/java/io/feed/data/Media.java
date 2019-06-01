package io.feed.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Media {

    public Media(String url) {
        this.url = url;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    String id;

    @Column
    private String url;
}