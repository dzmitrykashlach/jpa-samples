/*
 * This file is generated by jOOQ.
 */
package kafka.tx.jooq.generated.kafka_tx;


import java.util.Arrays;
import java.util.List;

import kafka.tx.jooq.generated.DefaultCatalog;
import kafka.tx.jooq.generated.kafka_tx.tables.Application;
import kafka.tx.jooq.generated.kafka_tx.tables.Person;
import kafka.tx.jooq.generated.kafka_tx.tables.TxnoOutbox;
import kafka.tx.jooq.generated.kafka_tx.tables.TxnoSequence;
import kafka.tx.jooq.generated.kafka_tx.tables.TxnoVersion;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.DSL;
import org.jooq.impl.SchemaImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class KafkaTx extends SchemaImpl {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>kafka-tx</code>
     */
    public static final KafkaTx KAFKA_TX = new KafkaTx();

    /**
     * The table <code>kafka-tx.application</code>.
     */
    public final Application APPLICATION = Application.APPLICATION;

    /**
     * The table <code>kafka-tx.person</code>.
     */
    public final Person PERSON = Person.PERSON;

    /**
     * The table <code>kafka-tx.txno_outbox</code>.
     */
    public final TxnoOutbox TXNO_OUTBOX = TxnoOutbox.TXNO_OUTBOX;

    /**
     * The table <code>kafka-tx.txno_sequence</code>.
     */
    public final TxnoSequence TXNO_SEQUENCE = TxnoSequence.TXNO_SEQUENCE;

    /**
     * The table <code>kafka-tx.txno_version</code>.
     */
    public final TxnoVersion TXNO_VERSION = TxnoVersion.TXNO_VERSION;

    /**
     * No further instances allowed
     */
    private KafkaTx() {
        super(DSL.name("kafka-tx"), null, DSL.comment(""));
    }


    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        return Arrays.asList(
            Application.APPLICATION,
            Person.PERSON,
            TxnoOutbox.TXNO_OUTBOX,
            TxnoSequence.TXNO_SEQUENCE,
            TxnoVersion.TXNO_VERSION
        );
    }
}
