package tx.entities

enum class ApplicationStatus(val id: Int, val isFinal: Boolean = false) {
    DRAFT(1, false),
    NEW(2, false),
    COMPLETED(3, true),
    EXPIRED(100, true),
    FAILED(102, true)
    ;

    companion object {
        val NON_FINAL_STATUSES = entries.filter { !it.isFinal }.toSet()
        val FINAL_STATUSES = entries.filter { it.isFinal }.toSet()

        private val TYPES = entries.associateBy { it.id }

        fun get(id: Int): ApplicationStatus =
            TYPES[id] ?: throw RuntimeException("Application status not found, [id = $id].")
    }
}
