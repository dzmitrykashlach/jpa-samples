package tx.service

import tx.entities.Application

interface ApplicationService {

    fun processApplication(application: Application)

    fun publishApplication(application: Application)
}