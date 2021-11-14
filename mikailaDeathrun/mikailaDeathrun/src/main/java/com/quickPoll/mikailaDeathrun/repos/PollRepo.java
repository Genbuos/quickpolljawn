package com.quickPoll.mikailaDeathrun.repos;

import com.quickPoll.mikailaDeathrun.domain.Poll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface PollRepo extends CrudRepository<Poll, Long> {




}
