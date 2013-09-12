package me.dreamand.jpa.query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 */
public class Specifications<T> implements Specification<T> {

    private final Specification<T> spec;

    /**
     * Creates a new {@link Specifications} wrapper for the given {@link Specification}.
     *
     * @param spec can be {@literal null}.
     */
    private Specifications(Specification<T> spec) {
        this.spec = spec;
    }

    /**
     * Simple static factory method to add some syntactic sugar around a {@link Specification}.
     *
     * @param <T>
     * @param spec can be {@literal null}.
     */
    public static <T> Specifications<T> where(Specification<T> spec) {
        return new Specifications<T>(spec);
    }

    /**
     * ANDs the given {@link Specification} to the current one.
     *
     * @param other can be {@literal null}.
     */
    public Specifications<T> and(final Specification<T> other) {

        return new Specifications<T>(new Specification<T>() {
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

                Predicate otherPredicate = other == null ? null : other.toPredicate(root, query, cb);
                Predicate thisPredicate = spec == null ? null : spec.toPredicate(root, query, cb);

                return thisPredicate == null ? otherPredicate : otherPredicate == null ? thisPredicate : cb.and(
                        thisPredicate, otherPredicate);
            }
        });
    }

    /**
     * ORs the given specification to the current one.
     *
     * @param other can be {@literal null}.
     */
    public Specifications<T> or(final Specification<T> other) {

        return new Specifications<T>(new Specification<T>() {
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

                Predicate otherPredicate = other == null ? null : other.toPredicate(root, query, cb);
                Predicate thisPredicate = spec == null ? null : spec.toPredicate(root, query, cb);

                return thisPredicate == null ? otherPredicate : otherPredicate == null ? thisPredicate : cb.or(
                        thisPredicate, otherPredicate);
            }
        });
    }

    /**
     * Negates the given {@link Specification}.
     *
     * @param <T>
     * @param spec can be {@literal null}.
     */
    public static <T> Specifications<T> not(final Specification<T> spec) {
        return new Specifications<T>(new Specification<T>() {
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return spec == null ? null : cb.not(spec.toPredicate(root, query, cb));
            }
        });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        return spec.toPredicate(root, query, cb);
    }
}
