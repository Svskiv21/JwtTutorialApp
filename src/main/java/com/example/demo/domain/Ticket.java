package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    @Column(name = "price")
    private Double price;

    @Column(name = "seatNumber") // to moze byc nullem bo moze byc koncert ze wszystcy stoją
    private Integer seatNumber;

    @Column(name = "zoneNumber")
    private Integer zoneNumber;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    public Ticket(Event event,
                  Double price,
                  Integer seatNumber,
                  Integer zoneNumber) {
        this.event = event;
        this.price = price;
        this.seatNumber = seatNumber;
        this.zoneNumber = zoneNumber;
    }
}
