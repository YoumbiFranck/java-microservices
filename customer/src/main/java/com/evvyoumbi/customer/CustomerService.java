package com.evvyoumbi.customer;

/**
 * Dans cette classe nous allons faire toutes les opération liées aux clients.
 * L'accès à la base de données, les validations, etc. seront gérés ici.
 */

public record CustomerService() {

    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
        //todo: check if email is valid
        //todo: ckeck if email is not taken
        //todo: store customer in db

    }
}
