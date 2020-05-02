package com.adneom.repository;


import com.adneom.bean.Client;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.util.Optional;

/**
 * @ClassName: UserRepository/ClientRepository
 * @Description: UserRepository/ClientRepository
 * @Author: Yang Naihua
 * @Create: 2019-01-20 10:33
 **/
@Repository
public class UserRepository extends BaseJpaRepository<Client, String> {
    public UserRepository() {
        super(Client.class);
    }

    public Optional<Client> findByUsername(String username) {
        try {
            return Optional.of(getEm().createQuery("from Client where username = :username", Client.class)
                    .setParameter("username", username)
                    .setMaxResults(1)
                    .getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }
}