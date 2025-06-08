package com.evvyoumbi.customer;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Dans cette classe nous allons faire toutes les opération liées aux clients.
 * L'accès à la base de données, les validations, etc. seront gérés ici.
 */
@AllArgsConstructor
@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;


    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
        //todo: check if email is valid
        //todo: ckeck if email is not taken
        //todo: check if fraudster
        customerRepository.saveAndFlush(customer); // Enregistrer le client dans la base de données

        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject(
                "http://localhost:8081/api/v1/fraud-check/{customerId}",
                FraudCheckResponse.class,
                customer.getId()
        ); // Appel à un service externe pour vérifier l'email ou d'autres informations

        if(fraudCheckResponse.isFraudster()){
            throw new IllegalStateException("Fraudster detected!"); // Lancer une exception si le client est un fraudeur
        }

        //todo: call fraud check service and send notification if fraudster

    }
}
