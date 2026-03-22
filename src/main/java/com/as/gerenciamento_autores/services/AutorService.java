package com.as.gerenciamento_autores.services;

import com.as.gerenciamento_autores.modals.AutorModal;
import com.as.gerenciamento_autores.repositories.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    public AutorModal criar(AutorModal autorModal) {
        return autorRepository.save(autorModal);
    }

    public List<AutorModal> listar() {
        return autorRepository.findAll();
    }

    public Optional<AutorModal> buscarId(Long id) {
        return  autorRepository.findById(id);
    }

    public AutorModal atualizar(Long id, AutorModal autorModal) {
        AutorModal model = autorRepository.findById(id).get();
        model.setNome(autorModal.getNome());
        model.setNacionalidade(autorModal.getNacionalidade());
        model.setDataNascimento(autorModal.getDataNascimento());
        return autorRepository.save(model);
    }

    public void deletar(Long id) {
        autorRepository.deleteById(id);
    }
}
