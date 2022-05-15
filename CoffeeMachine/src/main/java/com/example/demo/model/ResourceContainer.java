package com.example.demo.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Класс содержит информацию о ресурсах, с которыми будет работать кофе машина.
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "resource_container")
public class ResourceContainer extends AbstractEntity {
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String weight;
}

