package com.evvyoumbi.customer;

import org.springframework.stereotype.Service;

/**
 * Dans cette classe nous allons faire toutes les opération liées aux clients.
 * L'accès à la base de données, les validations, etc. seront gérés ici.
 */

@Service
public record CustomerService(CustomerRepository customerRepository) {

    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
        //todo: check if email is valid
        //todo: ckeck if email is not taken


        customerRepository.save(customer); // Enregistrer le client dans la base de données

    }
}
