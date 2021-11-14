package com.quickPoll.mikailaDeathrun.repos;

import com.quickPoll.mikailaDeathrun.domain.Vote;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface VoteRepo extends CrudRepository<Vote, Long> {

    @Query(value="select v.* from OptionA o, Vote v where o.POLL_ID = ?1 and v.OPTION_ID = o.OPTION_ID", nativeQuery = true)
    Iterable<Vote> findByPoll(Long pollId);

}
