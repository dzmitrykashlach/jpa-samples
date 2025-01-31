package tx.service

import com.gruelbox.transactionoutbox.TransactionOutbox
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import tx.dao.ApplicationDao
import tx.entities.Application

@Service
open class ApplicationServiceImpl(
    val applicationDao: ApplicationDao,
    val outbox: TransactionOutbox
    )
    :ApplicationService {

    @Transactional
    override fun processApplication(application: Application) {
        applicationDao.save(application)
        outbox.schedule(javaClass).publishApplication(application)
    }

    override fun publishApplication(application: Application) {
        TODO("Not yet implemented")
    }


}