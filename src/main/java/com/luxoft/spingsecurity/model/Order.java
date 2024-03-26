package com.luxoft.spingsecurity.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.luxoft.spingsecurity.utils.HibernateUtils;
import lombok.Data;
import lombok.NonNull;
import lombok.experimental.ExtensionMethod;

import static com.luxoft.spingsecurity.utils.HibernateUtils.*;

@SuppressWarnings({
    "com.intellij.jpb.LombokDataInspection",
    "JpaObjectClassSignatureInspection",
})

@Entity
@Table(name = "orders")
@SequenceGenerator(
    name = "order_seq_gen",
    sequenceName = "order_seq",
    initialValue = 2010)
@Data(staticConstructor = "Order")
@ExtensionMethod(HibernateUtils.class)
public class Order {

    @GeneratedValue(generator = "order_seq_gen")
    @Id Long id;

    @NonNull Double amount;

    @ManyToOne
    Company customer;

    @Override
    public final boolean equals(Object o) {
      return this == o || o != null
                          && effectiveClass(this) == o.effectiveClass()
                          && getId() != null
                          && o instanceof Order
                          && Objects.equals(getId(), ((Order) o).getId());
    }

    @Override public final int hashCode() {
        return effectiveClass(this).hashCode();
    }
}
