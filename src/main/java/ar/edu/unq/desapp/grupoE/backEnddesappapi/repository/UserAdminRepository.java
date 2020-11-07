package ar.edu.unq.desapp.grupoE.backEnddesappapi.repository;

import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.UserAdmin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAdminRepository extends JpaRepository<UserAdmin, Long> {
    UserAdmin findByuserName(String userName);
}
