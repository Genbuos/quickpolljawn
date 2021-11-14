package com.quickPoll.mikailaDeathrun.repos;

import com.quickPoll.mikailaDeathrun.domain.OptionA;
import org.springframework.data.repository.CrudRepository;

public interface OptionRepo extends CrudRepository<OptionA, Long> {
}
