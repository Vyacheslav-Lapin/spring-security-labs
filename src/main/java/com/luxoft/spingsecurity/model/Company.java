package com.luxoft.spingsecurity.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

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
@SequenceGenerator(
    name = "company_seq_gen",
    sequenceName = "company_seq",
    initialValue = 1010)
@Data(staticConstructor = "Company")
@ExtensionMethod(HibernateUtils.class)
public class Company {

  @Id
  @GeneratedValue(generator = "company_seq_gen")
  Long id;

  @NonNull String name;

  @OneToMany(mappedBy = "customer")
  List<Order> orders;

  @Override
  public final boolean equals(Object o) {
    return this == o || o != null
                        && effectiveClass(this) == o.effectiveClass()
                        && getId() != null
                        && o instanceof Company
                        && Objects.equals(getId(), ((Company) o).getId());
  }

  @Override
  public final int hashCode() {
    return effectiveClass(this).hashCode();
  }
}
