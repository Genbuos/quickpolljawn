package com.quickPoll.mikailaDeathrun.services;

import com.quickPoll.mikailaDeathrun.domain.Vote;
import com.quickPoll.mikailaDeathrun.repos.VoteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Service
public class VoteService {

    @Autowired
    private VoteRepo voteRepo;

    public ResponseEntity<?> createVote(@PathVariable Long pollId, @RequestBody Vote
            vote) {
        vote = voteRepo.save(vote);

        // Set the headers for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(ServletUriComponentsBuilder.
                fromCurrentRequest().path("/{id}").buildAndExpand(vote.getId()).toUri());

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    public Iterable<Vote> getAllVotes(@PathVariable Long pollId) {
        return voteRepo.findByPoll(pollId);
    }


}
