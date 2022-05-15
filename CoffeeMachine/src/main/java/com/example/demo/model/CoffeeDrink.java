package com.example.demo.model;

import lombok.*;

import javax.persistence.*;

/**
 * Класс содержит информацию о напитках, которые может приготовить кофе машина.
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "coffee_drink")
public class CoffeeDrink extends AbstractEntity {
    @Column(nullable = false, name = "name_coffee_drink")
    private String nameCoffeeDrink;

    @Column(nullable = false, name = "weight_grain")
    private String weightGrain;

    @Column(nullable = false, name = "weight_water")
    private String weightWater;
}

