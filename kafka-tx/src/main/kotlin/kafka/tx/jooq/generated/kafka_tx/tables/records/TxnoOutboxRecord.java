/*
 * This file is generated by jOOQ.
 */
package kafka.tx.jooq.generated.kafka_tx.tables.records;


import java.time.LocalDateTime;

import kafka.tx.jooq.generated.kafka_tx.tables.TxnoOutbox;

import org.jooq.Record1;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class TxnoOutboxRecord extends UpdatableRecordImpl<TxnoOutboxRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>kafka-tx.txno_outbox.id</code>.
     */
    public void setId(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>kafka-tx.txno_outbox.id</code>.
     */
    public String getId() {
        return (String) get(0);
    }

    /**
     * Setter for <code>kafka-tx.txno_outbox.invocation</code>.
     */
    public void setInvocation(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>kafka-tx.txno_outbox.invocation</code>.
     */
    public String getInvocation() {
        return (String) get(1);
    }

    /**
     * Setter for <code>kafka-tx.txno_outbox.nextattempttime</code>.
     */
    public void setNextattempttime(LocalDateTime value) {
        set(2, value);
    }

    /**
     * Getter for <code>kafka-tx.txno_outbox.nextattempttime</code>.
     */
    public LocalDateTime getNextattempttime() {
        return (LocalDateTime) get(2);
    }

    /**
     * Setter for <code>kafka-tx.txno_outbox.attempts</code>.
     */
    public void setAttempts(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>kafka-tx.txno_outbox.attempts</code>.
     */
    public Integer getAttempts() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>kafka-tx.txno_outbox.blocked</code>.
     */
    public void setBlocked(Boolean value) {
        set(4, value);
    }

    /**
     * Getter for <code>kafka-tx.txno_outbox.blocked</code>.
     */
    public Boolean getBlocked() {
        return (Boolean) get(4);
    }

    /**
     * Setter for <code>kafka-tx.txno_outbox.version</code>.
     */
    public void setVersion(Integer value) {
        set(5, value);
    }

    /**
     * Getter for <code>kafka-tx.txno_outbox.version</code>.
     */
    public Integer getVersion() {
        return (Integer) get(5);
    }

    /**
     * Setter for <code>kafka-tx.txno_outbox.uniquerequestid</code>.
     */
    public void setUniquerequestid(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>kafka-tx.txno_outbox.uniquerequestid</code>.
     */
    public String getUniquerequestid() {
        return (String) get(6);
    }

    /**
     * Setter for <code>kafka-tx.txno_outbox.processed</code>.
     */
    public void setProcessed(Boolean value) {
        set(7, value);
    }

    /**
     * Getter for <code>kafka-tx.txno_outbox.processed</code>.
     */
    public Boolean getProcessed() {
        return (Boolean) get(7);
    }

    /**
     * Setter for <code>kafka-tx.txno_outbox.lastattempttime</code>.
     */
    public void setLastattempttime(LocalDateTime value) {
        set(8, value);
    }

    /**
     * Getter for <code>kafka-tx.txno_outbox.lastattempttime</code>.
     */
    public LocalDateTime getLastattempttime() {
        return (LocalDateTime) get(8);
    }

    /**
     * Setter for <code>kafka-tx.txno_outbox.topic</code>.
     */
    public void setTopic(String value) {
        set(9, value);
    }

    /**
     * Getter for <code>kafka-tx.txno_outbox.topic</code>.
     */
    public String getTopic() {
        return (String) get(9);
    }

    /**
     * Setter for <code>kafka-tx.txno_outbox.seq</code>.
     */
    public void setSeq(Long value) {
        set(10, value);
    }

    /**
     * Getter for <code>kafka-tx.txno_outbox.seq</code>.
     */
    public Long getSeq() {
        return (Long) get(10);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<String> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached TxnoOutboxRecord
     */
    public TxnoOutboxRecord() {
        super(TxnoOutbox.TXNO_OUTBOX);
    }

    /**
     * Create a detached, initialised TxnoOutboxRecord
     */
    public TxnoOutboxRecord(String id, String invocation, LocalDateTime nextattempttime, Integer attempts, Boolean blocked, Integer version, String uniquerequestid, Boolean processed, LocalDateTime lastattempttime, String topic, Long seq) {
        super(TxnoOutbox.TXNO_OUTBOX);

        setId(id);
        setInvocation(invocation);
        setNextattempttime(nextattempttime);
        setAttempts(attempts);
        setBlocked(blocked);
        setVersion(version);
        setUniquerequestid(uniquerequestid);
        setProcessed(processed);
        setLastattempttime(lastattempttime);
        setTopic(topic);
        setSeq(seq);
        resetTouchedOnNotNull();
    }
}
