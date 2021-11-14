package com.quickPoll.mikailaDeathrun.controllers;

import com.quickPoll.mikailaDeathrun.domain.Poll;
import com.quickPoll.mikailaDeathrun.repos.PollRepo;
import com.quickPoll.mikailaDeathrun.services.PollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.inject.Inject;
import java.net.URI;
import java.security.PrivateKey;

@RestController
@RequestMapping("/polls")
public class PollController {


    @Inject
    private PollService pollService;


//    @RequestMapping( method= RequestMethod.GET)
    @GetMapping
    public ResponseEntity<Iterable<Poll>> getAllPolls() {
        return pollService.getAllPolls();
    }


    @PostMapping
    public ResponseEntity<?> createPoll(@RequestBody Poll poll) {

        return pollService.createPoll(poll);

    }

   @GetMapping("/{pollId}")
    public ResponseEntity<?> getPoll(@PathVariable Long pollId) {
        return pollService.getPoll(pollId);
    }

    @PutMapping("/{pollId}")
    public ResponseEntity<?> updatePoll(@RequestBody Poll poll, @PathVariable Long pollId) {
        Poll p = pollRepo.findOne(pollId);
        if(p == null) {
            throw new ResourceNotFoundException("Poll with id " + pollId + " not found");
        }
        return new ResponseEntity<> (p, HttpStatus.OK);

        return pollService.updatePoll(poll,pollId);
    }

    @DeleteMapping("/{pollId}")
    public ResponseEntity<?> deletePoll(@RequestBody Poll poll, @PathVariable Long pollId){
        return pollService.deletePoll(poll,pollId);
    }



}
