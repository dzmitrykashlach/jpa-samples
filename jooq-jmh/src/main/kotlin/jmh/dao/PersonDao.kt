package jmh.dao

import jmh.entities.Person
import java.time.LocalDateTime

interface PersonDao {

    //select
    fun findAll(): List<Person?>?
    fun findById(id: Int?): Person?

    //insert
    fun save(person: Person?)

    //delete
    fun delete(person: Person?)

    //join with sub queries
    fun findAllByAge(category: String?): List<Person?>?

    //join
    fun findAllByCreatedAt(createdAt: LocalDateTime?): List<Person?>?
}