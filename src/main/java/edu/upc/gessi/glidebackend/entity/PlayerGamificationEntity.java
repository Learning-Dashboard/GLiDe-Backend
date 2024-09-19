package edu.upc.gessi.glidebackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "gamification_dashboard")
public class PlayerGamificationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "playername", referencedColumnName = "playername", nullable = false)
    private IndividualPlayerEntity individualPlayerEntity;

    @Column(name = "teamLeaderboardId")
    private Integer teamLeaderboardId;

    @Column(name = "individualLeaderboardId")
    private Integer individualLeaderboardId;


}