/*
 * This file is generated by jOOQ.
 */
package kafka.tx.jooq.generated.kafka_tx.routines;


import kafka.tx.jooq.generated.kafka_tx.KafkaTx;

import org.jooq.Field;
import org.jooq.Parameter;
import org.jooq.impl.AbstractRoutine;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;
import org.jooq.impl.SQLDataType;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class GenRandomString extends AbstractRoutine<String> {

    private static final long serialVersionUID = 1L;

    /**
     * The parameter <code>kafka-tx.gen_random_string.RETURN_VALUE</code>.
     */
    public static final Parameter<String> RETURN_VALUE = Internal.createParameter("RETURN_VALUE", SQLDataType.VARCHAR, false, false);

    /**
     * The parameter <code>kafka-tx.gen_random_string._min_length</code>.
     */
    public static final Parameter<Integer> _MIN_LENGTH = Internal.createParameter("_min_length", SQLDataType.INTEGER.defaultValue(DSL.field(DSL.raw("3"), SQLDataType.INTEGER)), true, false);

    /**
     * Create a new routine call instance
     */
    public GenRandomString() {
        super("gen_random_string", KafkaTx.KAFKA_TX, DSL.comment(""), SQLDataType.VARCHAR);

        setReturnParameter(RETURN_VALUE);
        addInParameter(_MIN_LENGTH);
    }

    /**
     * Set the <code>_min_length</code> parameter IN value to the routine
     */
    public void set_MinLength(Integer value) {
        setValue(_MIN_LENGTH, value);
    }

    /**
     * Set the <code>_min_length</code> parameter to the function to be used
     * with a {@link org.jooq.Select} statement
     */
    public void set_MinLength(Field<Integer> field) {
        setField(_MIN_LENGTH, field);
    }
}
