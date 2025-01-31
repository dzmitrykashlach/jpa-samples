package tx.dao

import tx.entities.Application

interface ApplicationDao {

    fun findAll(): List<Application?>?

    fun findById(id: String?): Application?

    fun save(application: Application?)

    fun delete(application: Application?)

}