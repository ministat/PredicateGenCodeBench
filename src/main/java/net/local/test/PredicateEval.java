package net.local.test;

import org.apache.spark.sql.catalyst.InternalRow;

public class PredicateEval implements IPredicateEval {
    private boolean globalIsNull_0 = false;
    private boolean globalIsNull_1 = false;
    private boolean globalIsNull_2 = false;

    @Override
    public String name() {
        return this.getClass().getName();
    }

    @Override
    public boolean eval(InternalRow i) {

        boolean value_26 = And_2(i);
        boolean isNull_0 = false;
        boolean value_0 = false;

        if (!globalIsNull_2 && !value_26) {
        } else {
            boolean isNull_24 = true;
            boolean value_27 = false;

            // input[11, bigint, true] <= input[5, bigint, true]
            boolean isNull_25 = i.isNullAt(11);
            long value_28 = isNull_25 ? -1L : (i.getLong(11));
            if (!isNull_25) {

                boolean isNull_26 = i.isNullAt(5);
                long value_29 = isNull_26 ? -1L : (i.getLong(5));
                if (!isNull_26) {

                    isNull_24 = false; // resultCode could change nullability.
                    value_27 = value_28 <= value_29;

                }

            }
            if (!isNull_24 && !value_27) {
            } else if (!globalIsNull_2 && !isNull_24) {
                value_0 = true;
            } else {
                isNull_0 = true;
            }
        }
        return !isNull_0 && value_0;
    }

    // input[9, bigint, true] <= input[3, bigint, true]
    // input[10, bigint, true] >= input[1, bigint, true]
    private boolean And_1(InternalRow i) {
        boolean value_12 = And_0(i);
        boolean isNull_4 = false;
        boolean value_4 = false;

        if (!globalIsNull_0 && !value_12) {
        } else {

            boolean isNull_12 = true;
            boolean value_13 = false;
            // input[9, bigint, true] <= input[3, bigint, true]
            boolean isNull_13 = i.isNullAt(9);
            long value_14 = isNull_13 ? -1L : (i.getLong(9));
            if (!isNull_13) {

                boolean isNull_14 = i.isNullAt(3);
                long value_15 = isNull_14 ? -1L : (i.getLong(3));
                if (!isNull_14) {

                    isNull_12 = false; // resultCode could change nullability.
                    value_13 = value_14 <= value_15;

                }

            }
            if (!isNull_12 && !value_13) {
            } else if (!globalIsNull_0 && !isNull_12) {
                value_4 = true;
            } else {
                isNull_4 = true;
            }
        }
        boolean isNull_3 = false;
        boolean value_3 = false;

        if (!isNull_4 && !value_4) {
        } else {

            boolean isNull_15 = true;
            boolean value_16 = false;

            boolean isNull_16 = i.isNullAt(10);
            long value_17 = isNull_16 ? -1L : (i.getLong(10));
            if (!isNull_16) {

                boolean isNull_17 = i.isNullAt(1);
                long value_18 = isNull_17 ? -1L : (i.getLong(1));
                if (!isNull_17) {

                    isNull_15 = false; // resultCode could change nullability.
                    value_16 = value_17 >= value_18;

                }

            }
            if (!isNull_15 && !value_16) {
            } else if (!isNull_4 && !isNull_15) {
                value_3 = true;
            } else {
                isNull_3 = true;
            }
        }
        globalIsNull_1 = isNull_3;
        return value_3;
    }
    // input[12, date, true] < input[7, date, true]
    // input[9, bigint, true] >= input[0, bigint, true]
    private boolean And_0(InternalRow i) {
        boolean isNull_6 = true;
        boolean value_6 = false;
        // input[12, date, true] < input[7, date, true]
        boolean isNull_7 = i.isNullAt(12);
        long value_7 = isNull_7 ? -1 : (i.getLong(12));
        if (!isNull_7) {

            boolean isNull_8 = i.isNullAt(7);
            long value_8 = isNull_8 ? -1 : (i.getLong(7));
            if (!isNull_8) {

                isNull_6 = false; // resultCode could change nullability.
                value_6 = value_7 < value_8;

            }

        }
        boolean isNull_5 = false;
        boolean value_5 = false;

        if (!isNull_6 && !value_6) {
        } else {

            boolean isNull_9 = true;
            boolean value_9 = false;
            // input[9, bigint, true] >= input[0, bigint, true]
            boolean isNull_10 = i.isNullAt(9);
            long value_10 = isNull_10 ? -1L : (i.getLong(9));
            if (!isNull_10) {

                boolean isNull_11 = i.isNullAt(0);
                long value_11 = isNull_11 ? -1L : (i.getLong(0));
                if (!isNull_11) {

                    isNull_9 = false; // resultCode could change nullability.
                    value_9 = value_10 >= value_11;

                }

            }
            if (!isNull_9 && !value_9) {
            } else if (!isNull_6 && !isNull_9) {
                value_5 = true;
            } else {
                isNull_5 = true;
            }
        }
        globalIsNull_0 = isNull_5;
        return value_5;
    }

    // input[10, bigint, true] <= input[4, bigint, true]
    // input[11, bigint, true] >= input[2, bigint, true]
    private boolean And_2(InternalRow i) {
        boolean value_19 = And_1(i);
        boolean isNull_2 = false;
        boolean value_2 = false;

        if (!globalIsNull_1 && !value_19) {
        } else {

            boolean isNull_18 = true;
            boolean value_20 = false;

            boolean isNull_19 = i.isNullAt(10);
            long value_21 = isNull_19 ? -1L : (i.getLong(10));
            if (!isNull_19) {

                boolean isNull_20 = i.isNullAt(4);
                long value_22 = isNull_20 ? -1L : (i.getLong(4));
                if (!isNull_20) {

                    isNull_18 = false; // resultCode could change nullability.
                    value_20 = value_21 <= value_22;

                }

            }
            if (!isNull_18 && !value_20) {
            } else if (!globalIsNull_1 && !isNull_18) {
                value_2 = true;
            } else {
                isNull_2 = true;
            }
        }
        boolean isNull_1 = false;
        boolean value_1 = false;

        if (!isNull_2 && !value_2) {
        } else {

            boolean isNull_21 = true;
            boolean value_23 = false;

            boolean isNull_22 = i.isNullAt(11);
            long value_24 = isNull_22 ? -1L : (i.getLong(11));
            if (!isNull_22) {

                boolean isNull_23 = i.isNullAt(2);
                long value_25 = isNull_23 ? -1L : (i.getLong(2));
                if (!isNull_23) {

                    isNull_21 = false; // resultCode could change nullability.
                    value_23 = value_24 >= value_25;

                }

            }
            if (!isNull_21 && !value_23) {
            } else if (!isNull_2 && !isNull_21) {
                value_1 = true;
            } else {
                isNull_1 = true;
            }
        }
        globalIsNull_2 = isNull_1;
        return value_1;
    }
}
