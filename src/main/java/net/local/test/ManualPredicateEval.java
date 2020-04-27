package net.local.test;

import org.apache.spark.sql.catalyst.InternalRow;

public class ManualPredicateEval implements IPredicateEval {
    @Override
    public boolean eval(InternalRow i) {
        if (!i.isNullAt(12) && !i.isNullAt(7) && i.getLong(12) < i.getLong(7)) {
            if (!i.isNullAt(9) && !i.isNullAt(0) && i.getLong(9) >= i.getLong(0)) {
                if (!i.isNullAt(3) && i.getLong(9) <= i.getLong(3)) {
                    if (!i.isNullAt(10) && !i.isNullAt(1) && i.getLong(10) >= i.getLong(1)) {
                        if (!i.isNullAt(4) && i.getLong(10) <= i.getLong(4)) {
                            if (!i.isNullAt(11) && !i.isNullAt(2) && i.getLong(11) >= i.getLong(2)) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override
    public String name() {
        return this.getClass().getName();
    }

}
