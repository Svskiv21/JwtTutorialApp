package com.example.demo.domain;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "event")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "event_type_id")
    private EventType type;

    @NotNull
    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "pictures")
    private String pictures; // myslalam zeby zrobic z tego liste ale idk

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "duration")
    private Integer duration; // ile dni trwa

    @Column(name = "place_of_event")
    private String placeOfEvent;

    @Column(name = "limited_number_of_seats")
    private Boolean limitatedNumberOfSeats; // nie wiem jak lepiej nazwac ograniczona ilosc miejsc

    @Column(name = "number_of_seats")
    private Integer numerOfSeats;

    @Column(name = "zone_divided")
    private Integer zoneDivided;

    @Column(name = "number_of_zones")
    private Integer numberOfZones;

    @Column(name = "age_range")
    private String ageRange;

    @OneToMany(mappedBy = "event")
    private List<Ticket> tickets;

    public Event(EventType type,
                 String title,
                 String description,
                 String pictures,
                 Date startDate,
                 Date endDate,
                 Integer duration,
                 String placeOfEvent,
                 Boolean limitatedNumberOfSeats,
                 Integer numerOfSeats,
                 Integer zoneDivided,
                 Integer numberOfZones,
                 String ageRange) { // konstruktor dla usera
        this.type = type;
        this.title = title;
        this.description = description;
        this.pictures = pictures;
        this.startDate = startDate;
        this.endDate = endDate;
        this.duration = duration;
        this.placeOfEvent = placeOfEvent;
        this.limitatedNumberOfSeats = limitatedNumberOfSeats;
        this.numerOfSeats = numerOfSeats;
        this.zoneDivided = zoneDivided;
        this.numberOfZones = numberOfZones;
        this.ageRange = ageRange;
    }
}
