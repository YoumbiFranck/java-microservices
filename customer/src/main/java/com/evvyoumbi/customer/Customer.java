package com.evvyoumbi.customer;

import lombok.Builder;
import lombok.Data;

/**
 * Cette classe représente un client dans le système.
 * Elle sert de modèle pour les opérations liées aux clients,
 * */

@Data
@Builder
public class Customer {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
}
