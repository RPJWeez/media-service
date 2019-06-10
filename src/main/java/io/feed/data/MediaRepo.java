package io.feed.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MediaRepo extends CrudRepository<Media, Long> {

}