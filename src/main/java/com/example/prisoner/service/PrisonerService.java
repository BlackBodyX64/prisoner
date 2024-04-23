package com.example.prisoner.service;

import com.example.prisoner.dtos.Paginate;
import com.example.prisoner.models.Prisoner;
import com.example.prisoner.repository.PrisonerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

@Service
public class PrisonerService {
    private final PrisonerRepository repository;

    @Autowired
    public PrisonerService(PrisonerRepository repository) {
        this.repository = repository;
    }

    public List<Prisoner> getDatatables(Paginate paginate) {

        int size = paginate.getLength();
        int page = (paginate.getStart() + 1) / paginate.getLength();

        Pageable pageable = PageRequest.of(page, size);

        return repository.findAll(pageable).getContent();
    }

    public List<Prisoner> getAll() {
        return repository.findAll();
    }

    public Optional<Prisoner> getUserById(Long id) {
        return repository.findById(id);
    }

    public Prisoner create(Prisoner prisoner) {
        return repository.save(prisoner);
    }

    public Optional<Prisoner> update(Long id, Prisoner newPrisoner) {
        return repository.findById(id);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
