package com.quickPoll.mikailaDeathrun.domain;

import javax.persistence.*;


@Entity
public class Vote {
    @Id
    @GeneratedValue
    @Column(name = "VOTE_ID")
    private Long id;


    @ManyToOne
    @JoinColumn(name = "OPTION_ID")
    private OptionA optionA;

    public Vote(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OptionA getOptionA() {
        return optionA;
    }

    public void setOptionA(OptionA optionA) {
        this.optionA = optionA;
    }
}
