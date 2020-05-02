package com.adneom.utils;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * @ClassName: BigDecimalUtilsTest
 * @Description: BigDecimalUtilsTest, https://github.com/mortezaadi/bigdecimal-utils
 * @Author: Yang Naihua
 * @Create: 2019-01-14 10:33
 **/

public final class BigDecimalUtils {

    private BigDecimalUtils() {
    }

    /**
     * Entry points of {@link BigDecimalUtils} <br/>
     * <br/>
     * Example usage:
     *
     * <pre>
     * <code>
     *      is(three).eq(four); //Equal  等于
     * 		is(two).gt(two);    //Greater than 大于
     * 		is(two).gte(one);   //Greater than equal  大于等于
     * 		is(three).lt(two);  //Less than   小于
     * 		is(three).lte(two); //Less than equal   小于等于
     *
     *      is(three).notEq(four); //Not Equal    不等于
     * 		is(two).notGt(two);    //Not Greater than
     * 		is(two).notGte(one);   //Not Greater than equal
     * 		is(three).notLt(two);  //Not Less than
     * 		is(three).notLte(two); //Not Less than equal
     *
     *      is(three).isZero();                 为零
     *      is(three).notZero();                不为零
     *      is(three).isPositive(); // greater than zero  大于零
     *      is(three).isNegative(); // less than zero     小于零
     *      is(three).isNonPositive(); //less than or equal zero   小于等于零
     *      is(three).isNonNegative(); //greater than or equal zero 大于等于零
     * </code>
     * </pre>
     *
     * @param decimal your {@link BigDecimal}
     * @return {@link BigDecimalWrapper}
     * @see
     */
    public static BigDecimalWrapper is(BigDecimal decimal) {
        return new BigDecimalWrapper(decimal);
    }

    /**
     * nullable add
     *
     * @param v1
     * @param v2
     * @return
     */
    public static BigDecimal add(BigDecimal v1, BigDecimal v2) {
        v1 = v1 == null ? BigDecimal.ZERO : v1;
        v2 = v2 == null ? BigDecimal.ZERO : v2;
        return v1.add(v2);
    }

    /**
     * Sum big decimal array
     *
     * @param values double array
     * @return sum value
     */
    public static BigDecimal sum(BigDecimal... values) {
        return Arrays.stream(values).reduce(BigDecimalUtils::add).get();
    }

    // TODO default is 3 and used by price
    public static BigDecimal convert(Double v) {
        if (v == null) {
            return BigDecimal.ZERO;
        }
        return new BigDecimal(String.format("%.3f", v));
    }

    public static BigDecimal convert(Double v, int scale) {
        if (v == null) {
            return BigDecimal.ZERO;
        }
        return new BigDecimal(String.format("%." + scale + "f", v));
    }

    /**
     * Sum big decimal array
     *
     * @param v Integer Value
     * @return BigDecimal type value
     */
    public static BigDecimal convert(Integer v) {
        if (v == null) {
            return BigDecimal.ZERO;
        }
        return new BigDecimal(Integer.toString(v));
    }

    public static BigDecimalWrapper is(double dbl) {
        return is(BigDecimal.valueOf(dbl));
    }

    public static class BigDecimalWrapper {
        private static final int ZERO = 0;
        private final BigDecimal bigDecimal;

        BigDecimalWrapper(BigDecimal bigDecimal) {
            this.bigDecimal = bigDecimal == null ? BigDecimal.ZERO : bigDecimal;
        }

        /**
         * 取余
         *
         * @param divisor
         * @return BigDecimal divideAndRemainder
         */
        public BigDecimal divideAndRemainder(BigDecimal divisor) {
            return bigDecimal.divideAndRemainder(divisor)[1];
        }

        /**
         * nullable add
         * 相加
         *
         * @param v2
         * @return
         */
        public BigDecimal add(BigDecimal v2) {
            v2 = v2 == null ? BigDecimal.ZERO : v2;
            return bigDecimal.add(v2);
        }

        /**
         * Checks whether input argument is <i><b> equal </b></i> to the provided
         * {@link BigDecimal} or not;
         *
         * @param decimal value to compare
         * @return {@link Boolean} true if two are equal.
         */
        public boolean eq(BigDecimal decimal) {
            return bigDecimal.compareTo(decimal) == ZERO;
        }

        /**
         * Checks whether input argument is <i><b> equal </b></i> to the provided
         * {@link Double} or not;
         *
         * @param decimal value to compare
         * @return {@link Boolean} true if two are equal.
         */
        public boolean eq(double decimal) {
            return eq(BigDecimal.valueOf(decimal));
        }

        /**
         * Checks whether input argument is <i><b> greater than </b></i> to the provided
         * {@link BigDecimal} or not;
         *
         * @param decimal value to compare
         * @return {@link Boolean} value
         */
        public boolean gt(BigDecimal decimal) {
            return bigDecimal.compareTo(decimal) > ZERO;
        }

        /**
         * Checks whether input argument is <i><b> greater than </b></i> to the provided
         * {@link Double} or not;
         *
         * @param decimal value to compare
         * @return {@link Boolean} value
         */
        public boolean gt(double decimal) {
            return gt(BigDecimal.valueOf(decimal));
        }

        /**
         * Checks whether input argument is <i><b> greater than equal </b></i> to the provided
         * {@link BigDecimal} or not;
         *
         * @param decimal value to compare
         * @return {@link Boolean} value
         */
        public boolean gte(BigDecimal decimal) {
            return bigDecimal.compareTo(decimal) >= ZERO;
        }

        /**
         * Checks whether input argument is <i><b> greater than equal </b></i> to the provided
         * {@link BigDecimal} or not;
         *
         * @param decimal value to compare
         * @return {@link Boolean} value
         */
        public boolean gte(double decimal) {
            return gte(BigDecimal.valueOf(decimal));
        }

        /**
         * Checks whether input argument is <i><b> less than </b></i> to the provided
         * {@link BigDecimal} or not;
         *
         * @param decimal value to compare
         * @return {@link Boolean} value
         */
        public boolean lt(BigDecimal decimal) {
            if (decimal == null) {
                decimal = BigDecimal.ZERO;
            }
            return bigDecimal.compareTo(decimal) < ZERO;
        }

        /**
         * Checks whether input argument is <i><b> less than </b></i> to the provided
         * {@link BigDecimal} or not;
         *
         * @param decimal value to compare
         * @return {@link Boolean} value
         */
        public boolean lt(double decimal) {
            return lt(BigDecimal.valueOf(decimal));
        }

        /**
         * Checks whether input argument is <i><b> less than equal </b></i> to the provided
         * {@link BigDecimal} or not;
         *
         * @param decimal value to compare
         * @return {@link Boolean} value
         */
        public boolean lte(BigDecimal decimal) {
            return bigDecimal.compareTo(decimal) <= ZERO;
        }

        /**
         * Checks whether input argument is <i><b> less than equal </b></i> to the provided
         * {@link BigDecimal} or not;
         *
         * @param decimal value to compare
         * @return {@link Boolean} value
         */
        public boolean lte(double decimal) {
            return lte(BigDecimal.valueOf(decimal));
        }

        /**
         * Checks whether input argument is <i><b> not equal </b></i> to the provided
         * {@link BigDecimal} or not;
         *
         * @param decimal value to compare
         * @return {@link Boolean} true if two are not equal.
         */
        public boolean notEq(BigDecimal decimal) {
            return !eq(decimal);
        }

        /**
         * Checks whether input argument is <i><b> not equal </b></i> to the provided
         * {@link Double} or not;
         *
         * @param decimal value to compare
         * @return {@link Boolean} true if two are not equal.
         */
        public boolean notEq(double decimal) {
            return !eq(decimal);
        }

        /**
         * Checks whether input argument is <i><b> not greater than </b></i> to the provided
         * {@link BigDecimal} or not;
         *
         * @param decimal value to compare
         * @return {@link Boolean} value
         */
        public boolean notGt(BigDecimal decimal) {
            return !gt(decimal);
        }

        /**
         * Checks whether input argument is <i><b> not greater than </b></i> to the provided
         * {@link Double} or not;
         *
         * @param decimal value to compare
         * @return {@link Boolean} value
         */
        public boolean notGt(double decimal) {
            return !gt(decimal);
        }

        /**
         * Checks whether input argument is <i><b> not greater than or equal </b></i> to the provided
         * {@link BigDecimal} or not;
         *
         * @param decimal value to compare
         * @return {@link Boolean} value
         */
        public boolean notGte(BigDecimal decimal) {
            return !gte(decimal);
        }

        /**
         * Checks whether input argument is <i><b> not greater than or equal </b></i> to the provided
         * {@link Double} or not;
         *
         * @param decimal value to compare
         * @return {@link Boolean} value
         */
        public boolean notGte(double decimal) {
            return !gte(decimal);
        }

        /**
         * Checks whether input argument is <i><b> not less than </b></i> to the provided
         * {@link BigDecimal} or not;
         *
         * @param decimal value to compare
         * @return {@link Boolean} value
         */
        public boolean notLt(BigDecimal decimal) {
            return !lt(decimal);
        }

        /**
         * Checks whether input argument is <i><b> not less than </b></i> to the provided
         * {@link Double} or not;
         *
         * @param decimal value to compare
         * @return {@link Boolean} value
         */
        public boolean notLt(double decimal) {
            return !lt(decimal);
        }

        /**
         * Checks whether input argument is <i><b> not less than equal </b></i> to the provided
         * {@link BigDecimal} or not;
         *
         * @param decimal value to compare
         * @return {@link Boolean} value
         */
        public boolean notLte(BigDecimal decimal) {
            return !lte(decimal);
        }

        /**
         * Checks whether input argument is <i><b> not less than equal </b></i> to the provided
         * {@link Double} or not;
         *
         * @param decimal value to compare
         * @return {@link Boolean} value
         */
        public boolean notLte(double decimal) {
            return !lte(decimal);
        }

        /**
         * @return true if the value is greater than zero
         */
        public boolean isPositive() {
            return gt(ZERO);
        }

        /**
         * @return true if the value is less than zero
         */
        public boolean isNegative() {
            return lt(ZERO);
        }

        /**
         * @return true if the value is less than or equal with zero
         */
        public boolean isNonPositive() {
            return lte(ZERO);
        }

        /**
         * @return true if the value is greater than or equal with zero
         */
        public boolean isNonNegative() {
            return gte(ZERO);
        }

        /**
         * @return true if the value is equal with zero
         */
        public boolean isZero() {
            return eq(ZERO);
        }

        /**
         * @return true if the value is greater than or less than zero
         */
        public boolean isNotZero() {
            return notEq(ZERO);
        }

        /**
         * @return true if the value is null or zero
         */
        public boolean isNullOrZero() {
            return bigDecimal == null || isZero();
        }

        /**
         * @return true if the value is not null nor zero
         */
        public boolean notNullOrZero() {
            return bigDecimal != null && isNotZero();
        }
    }
}
