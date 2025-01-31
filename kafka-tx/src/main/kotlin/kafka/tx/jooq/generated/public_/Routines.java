/*
 * This file is generated by jOOQ.
 */
package kafka.tx.jooq.generated.public_;


import kafka.tx.jooq.generated.public_.routines.GenRandomString;

import org.jooq.Configuration;
import org.jooq.Field;


/**
 * Convenience access to all stored procedures and functions in public.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class Routines {

    /**
     * Call <code>public.gen_random_string</code>
     */
    public static String genRandomString(
          Configuration configuration
        , Integer _MinLength
    ) {
        GenRandomString f = new GenRandomString();
        f.set_MinLength(_MinLength);

        f.execute(configuration);
        return f.getReturnValue();
    }

    /**
     * Get <code>public.gen_random_string</code> as a field.
     */
    public static Field<String> genRandomString(
          Integer _MinLength
    ) {
        GenRandomString f = new GenRandomString();
        f.set_MinLength(_MinLength);

        return f.asField();
    }

    /**
     * Get <code>public.gen_random_string</code> as a field.
     */
    public static Field<String> genRandomString(
          Field<Integer> _MinLength
    ) {
        GenRandomString f = new GenRandomString();
        f.set_MinLength(_MinLength);

        return f.asField();
    }
}
