package com.example.prisoner.controller;

import com.example.prisoner.dtos.Paginate;
import com.example.prisoner.models.Prisoner;
import com.example.prisoner.service.PrisonerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("prisoners")
public class PrisonerController {

    private final PrisonerService prisonerService;

    @Autowired
    public PrisonerController(PrisonerService prisonerService) {
        this.prisonerService = prisonerService;
    }

    @PostMapping("/datatables")
    public List<Prisoner> datatables(@RequestBody Paginate paginate) {
        return this.prisonerService.getDatatables(paginate);
    }

    @GetMapping()
    public List<Prisoner> getAll() {
        return this.prisonerService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Prisoner> getById(@PathVariable Long id) {
        Optional<Prisoner> prisoner = prisonerService.getUserById(id);
        return prisoner.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Prisoner> create(@RequestBody Prisoner prisoner) {
        Prisoner createdUser = prisonerService.create(prisoner);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Optional<Prisoner>> update(@PathVariable Long id, @RequestBody Prisoner newPrisoner) {
        Optional<Prisoner> updatedPrisoner = prisonerService.update(id, newPrisoner);
        return ResponseEntity.ok(updatedPrisoner);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        prisonerService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
