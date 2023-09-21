package com.unimaster.unimaster.domain.repository

import com.unimaster.unimaster.domain.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long?>