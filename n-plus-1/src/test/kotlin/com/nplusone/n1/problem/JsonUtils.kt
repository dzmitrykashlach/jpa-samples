package com.nplusone.n1.problem

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.io.File
import java.io.IOException




@Component
class JsonUtils {
    @Value("users.json")
    private val userFile: File? = null

    @Value("groups.json")
    private val groupFile: File? = null

    @Value("groups_with_members.json")
    private val groupsWithMembersFile: File? = null

    fun <T> getUsers(userType: Class<T>): List<T> {
        return getObjects(userType, userFile)
    }

    fun <T> getGroups(userType: Class<T>): List<T> {
        return getObjects(userType, groupFile)
    }

    fun <T> getGroupsWithMembers(groupType: Class<T>): List<T> {
        return getObjects(groupType, groupsWithMembersFile)
    }

    private fun <T> getObjects(userType: Class<T>, userFile1: File?): List<T> {
        try {
            return JsonUtils.Companion.MAPPER.readValue(
                userFile1, JsonUtils.Companion.MAPPER.getTypeFactory()
                    .constructCollectionType(MutableList::class.java, userType)
            )
        } catch (e: IOException) {
            throw RuntimeException(e)
        }
    }


    companion object {
        private val MAPPER: ObjectMapper = ObjectMapper()

        init {
            JsonUtils.Companion.MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        }
    }
}