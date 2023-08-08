package org.sid.Ecommerce.Services.auth;


import org.sid.Ecommerce.Dao.UtilisateurRepository;
import org.sid.Ecommerce.Entity.Utilisateur;
import org.sid.Ecommerce.Exception.EntityNotFoundException;
import org.sid.Ecommerce.Exception.ErrorCode;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class ApplicationDetailservice implements UserDetailsService {
    private UtilisateurRepository  utilisateurRepository;

    public ApplicationDetailservice(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Utilisateur utilbyEmail = utilisateurRepository.findByEmail(email).orElseThrow(()->new EntityNotFoundException("Aucun Utilisateur avec lemail four<ni", ErrorCode.UTILISATEUR_NOT_FOUND));
        return new User(utilbyEmail.getEmail(),utilbyEmail.getMotDePasse(),Collections.emptyList());
    }
}
