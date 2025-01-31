package tx.service

import com.gruelbox.transactionoutbox.TransactionOutbox
import org.jooq.DSLContext
import org.springframework.stereotype.Service
import tx.dao.ApplicationDao
import tx.entities.Application

@Service
open class ApplicationServiceImpl(
    private val applicationDao: ApplicationDao,
    private val transactionOutbox: TransactionOutbox,
    private val dsl: DSLContext
) : ApplicationService {

    override fun processApplication(application: Application) {
        val f = {
            applicationDao.save(application)
            transactionOutbox.schedule(javaClass).publishApplication(application)
        }
        dsl.transaction(f)
    }

    override fun publishApplication(application: Application) {
        TODO("Not yet implemented")
    }
}