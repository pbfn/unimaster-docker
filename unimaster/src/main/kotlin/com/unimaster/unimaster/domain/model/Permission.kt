package com.unimaster.unimaster.domain.model

import jakarta.persistence.*
import org.springframework.security.core.GrantedAuthority

@Entity
@Table(name="permission")
data class Permission(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    @Column(name="description" ,nullable = true, length = 255)
    var description: String? = null,

):GrantedAuthority{


    override fun getAuthority(): String = description!!

}
