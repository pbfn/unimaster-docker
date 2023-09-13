package com.unimaster.unimaster.domain.repository

import com.unimaster.unimaster.domain.model.Usuario
import org.springframework.data.jpa.repository.JpaRepository

interface UsuarioRepository : JpaRepository<Usuario, String>