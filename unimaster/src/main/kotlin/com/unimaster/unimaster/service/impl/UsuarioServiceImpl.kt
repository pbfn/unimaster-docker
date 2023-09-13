package com.unimaster.unimaster.service.impl

import com.unimaster.unimaster.domain.model.Usuario
import com.unimaster.unimaster.domain.repository.UsuarioRepository
import com.unimaster.unimaster.service.UsuarioService
import jakarta.transaction.Transactional
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import java.lang.IllegalArgumentException

@Service
class UsuarioServiceImpl(private val usuarioRepository: UsuarioRepository) : UsuarioService {

    override fun findAll(): List<Usuario> {
        return usuarioRepository.findAll(Sort.by(Sort.Direction.DESC, "idusuario"))
    }

    override fun findById(id: String): Usuario {
        TODO("Not yet implemented")
    }

    @Transactional
    override fun create(model: Usuario): Usuario {
        if (usuarioRepository.existsById(model.idusuario)) {
            throw IllegalArgumentException("Ja existe um usuario com id ${model.idusuario}")
        }
        return usuarioRepository.save(model)
    }

    override fun update(id: String, model: Usuario): Usuario {
        TODO("Not yet implemented")
    }

    override fun delete(id: String) {
        TODO("Not yet implemented")
    }
}