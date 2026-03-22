package com.as.gerenciamento_autores.repositories;

import com.as.gerenciamento_autores.modals.AutorModal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<AutorModal, Long> {
}
