package org.sid.Ecommerce.Dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;
import org.sid.Ecommerce.Entity.Roles;
import org.sid.Ecommerce.Entity.Utilisateur;

import javax.management.relation.Role;

@Data
@Builder
public class RolesDto {
    private Integer id;

    private  String rolename;
    @JsonIgnore
    private UtilisateurDto utilisateurDto;



    public static RolesDto fromEntity(Roles roles) {
        if (roles == null) {
            return null;
        }
        return RolesDto.builder()
                .id(roles.getId())
                .rolename(roles.getRoleName())
                .build();
    }

    public static Roles toEntity(RolesDto dto) {
        if (dto == null) {
            return null;
        }
        Roles roles = new Roles();
        roles.setId(dto.getId());
        roles.setRoleName(dto.getRolename());
        roles.setUtilisateur(UtilisateurDto.toEntity(dto.getUtilisateurDto()));
        return roles;
    }
}
