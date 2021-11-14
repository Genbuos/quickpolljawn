package com.quickPoll.mikailaDeathrun.controllers;

import com.quickPoll.mikailaDeathrun.domain.Vote;
import com.quickPoll.mikailaDeathrun.repos.VoteRepo;
import com.quickPoll.mikailaDeathrun.services.VoteService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.inject.Inject;

@RestController
@RequestMapping("/polls/{pollId}/votes")
public class VoteController {


    @Inject
    private VoteRepo voteRepo;

    @Inject
    private VoteService voteService;

    @PostMapping
    public ResponseEntity<?> createVote(@PathVariable Long pollId, @RequestBody Vote
            vote) {

        return voteService.createVote(pollId,vote);
    }
    @GetMapping
    public Iterable<Vote> getAllVotes(@PathVariable Long pollId) {
        return voteService.getAllVotes(pollId);
    }


}

