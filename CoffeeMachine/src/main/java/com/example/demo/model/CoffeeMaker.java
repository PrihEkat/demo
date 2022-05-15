package com.example.demo.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Класс содержит информацию о приготовленных напитках.
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "coffee_maker")
public class CoffeeMaker extends AbstractEntity {
    @Column(nullable = false)
    private Timestamp date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coffee_drink")
    private CoffeeDrink coffeeDrink;
}

