package br.com.lordsabino.api.resources;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.lordsabino.api.Entities.User;
import br.com.lordsabino.api.services.UserService;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    private UserService service;

    public UserResource(UserService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        User obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User obj) {
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .buildAndExpand(obj.getId())
                .toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj) {
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }
}
