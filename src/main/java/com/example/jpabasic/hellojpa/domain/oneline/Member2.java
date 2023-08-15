package com.example.jpabasic.hellojpa.domain.oneline;

import javax.persistence.*;

@Entity
public class Member2 {
    @Id
    @GeneratedValue
    @Column(name = "member2_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    @Column(name = "name")
    private String username;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
