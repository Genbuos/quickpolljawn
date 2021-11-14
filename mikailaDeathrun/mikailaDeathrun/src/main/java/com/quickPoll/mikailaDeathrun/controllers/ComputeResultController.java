package com.quickPoll.mikailaDeathrun.controllers;

import com.quickPoll.mikailaDeathrun.domain.Vote;
import com.quickPoll.mikailaDeathrun.dto.OptionCount;
import com.quickPoll.mikailaDeathrun.dto.VoteResult;
import com.quickPoll.mikailaDeathrun.repos.VoteRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/computeresult")
public class ComputeResultController {

    @Inject
    private VoteRepo voteRepository;
    @Inject
    private ComputeResultController computeResultController;

    @GetMapping
    public ResponseEntity<?> computeResult(@RequestParam Long pollId) {
        return computeResultController.computeResult(pollId);
    }




}
