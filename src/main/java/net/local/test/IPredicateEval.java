package net.local.test;

import org.apache.spark.sql.catalyst.InternalRow;

public interface IPredicateEval {
    public boolean eval(InternalRow i);
    public String name();
}
