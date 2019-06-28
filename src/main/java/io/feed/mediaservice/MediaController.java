package io.feed.mediaservice;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.feed.data.Media;
import io.feed.data.MediaRepo;
import lombok.AllArgsConstructor;
import lombok.Data;

@RestController
@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:5000" })
public class MediaController {

        @Autowired
        MediaRepo repo;

        @GetMapping("/media")
        public ResponseEntity<List<Media>> getMedia() {
                List<Media> media = new ArrayList<>();
                repo.findAll().forEach(media::add);

                return ResponseEntity.ok(media);
        }

        @PostMapping("/media")
        public ResponseEntity postMedia(@RequestBody Media media) {
                repo.save(media);
                return ResponseEntity.ok().build();
        }

        @DeleteMapping("/media/{id}")
        public ResponseEntity deleteMedia(@PathVariable("id") String id) {
                repo.deleteById(Long.parseLong(id));
                return ResponseEntity.noContent().build();
        }

}
