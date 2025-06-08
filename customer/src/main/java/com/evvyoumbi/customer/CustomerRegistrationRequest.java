package com.evvyoumbi.customer;

/**
 * Cette classe représente une requête d'enregistrement de client et les paramètres nécessaires pour créer un client.
 * @param firstName
 * @param lastName
 * @param email
 */
public record CustomerRegistrationRequest(String firstName, String lastName, String email) {

}
