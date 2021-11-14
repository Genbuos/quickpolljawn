package com.quickPoll.mikailaDeathrun.services;

import com.quickPoll.mikailaDeathrun.domain.Poll;
import com.quickPoll.mikailaDeathrun.repos.PollRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Service
public class PollService {


    @Autowired
    private PollRepo pollRepo;


    public ResponseEntity<?> getPoll(@PathVariable Long pollId) {
        Poll p = pollRepo.findById(pollId).orElse(null);
        return new ResponseEntity<> (p, HttpStatus.OK);
    }


    public ResponseEntity<?> createPoll(@RequestBody Poll poll) {
        poll = pollRepo.save(poll);

        // Set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newPollUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(poll.getId())
                .toUri();
        responseHeaders.setLocation(newPollUri);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    public ResponseEntity<Iterable<Poll>> getAllPolls() {
        Iterable<Poll> allPolls = pollRepo.findAll();
        return new ResponseEntity<>(pollRepo.findAll(), HttpStatus.OK);
    }


    public ResponseEntity<?> updatePoll(@RequestBody Poll poll, @PathVariable Long pollId) {
        // Save the entity
        Poll p = pollRepo.save(poll);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    public ResponseEntity<?> deletePoll(@RequestBody Poll poll, @PathVariable Long pollId) {

        pollRepo.delete(poll);
        return new ResponseEntity<>(HttpStatus.OK);
    }




}
