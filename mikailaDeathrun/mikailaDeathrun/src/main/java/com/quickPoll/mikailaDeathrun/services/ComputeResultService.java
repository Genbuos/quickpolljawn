package com.quickPoll.mikailaDeathrun.services;

import com.quickPoll.mikailaDeathrun.domain.Vote;
import com.quickPoll.mikailaDeathrun.dto.OptionCount;
import com.quickPoll.mikailaDeathrun.dto.VoteResult;
import com.quickPoll.mikailaDeathrun.repos.VoteRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

@Service
public class ComputeResultService {


    @Inject
    private VoteRepo voteRepository;

    public ResponseEntity<?> computeResult(@RequestParam Long pollId) {
        VoteResult voteResult = new VoteResult();
        Iterable<Vote> allVotes = voteRepository.findByPoll(pollId);
        // Algorithm to count votes
        int totalVotes = 0;
        Map<Long, OptionCount> tempMap = new HashMap<Long, OptionCount>();
        for(Vote v : allVotes) {
            totalVotes ++;
            // Get the OptionCount corresponding to this Option
            OptionCount optionCount = tempMap.get(v.getOptionA().getId());
            if(optionCount == null) {
                optionCount = new OptionCount();
                optionCount.setOptionId(v.getOptionA().getId());
                tempMap.put(v.getOptionA().getId(), optionCount);
            }
            optionCount.setCount(optionCount.getCount()+1);
        }
        voteResult.setTotalVotes(totalVotes);
        voteResult.setResults(tempMap.values());
        return new ResponseEntity<VoteResult>(voteResult, HttpStatus.OK);
    }
}
