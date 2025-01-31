package tx.dao

import tx.entities.Person

interface PersonDao {

    fun findAll(): List<Person?>?

    fun findById(id: String?): Person?

    fun save(person: Person?)

    fun delete(person: Person?)
}