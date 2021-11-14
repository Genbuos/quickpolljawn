package com.quickPoll.mikailaDeathrun.domain;

import javax.persistence.*;
import java.util.Set;
@Entity
public class Poll {
    @Id
    @GeneratedValue
    @Column(name = "POLL_ID")
    private Long id;

    @Column(name = "QUESTIONS")
    private String questions;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "POLL_ID")
    @OrderBy
    private Set<OptionA> optionAS;

    public Poll(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestions() {
        return questions;
    }

    public void setQuestions(String questions) {
        this.questions = questions;
    }

    public Set<OptionA> getOptionAS() {
        return optionAS;
    }

    public void setOptionAS(Set<OptionA> optionAS) {
        this.optionAS = optionAS;
    }
}
