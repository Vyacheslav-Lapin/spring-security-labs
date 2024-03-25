package com.luxoft.spingsecurity.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.Data;
import org.hibernate.proxy.HibernateProxy;

@SuppressWarnings("com.intellij.jpb.LombokDataInspection")

@SequenceGenerator(
    name = "company_seq_gen",
    sequenceName = "company_seq",
    initialValue = 1010
)
@Data
@Entity
public class Company {

  @Id
  @GeneratedValue(generator = "company_seq_gen")
  Long id;

  String name;

  @OneToMany(mappedBy = "customer")
  List<Order> orders;

  @Override
  public final boolean equals(Object o) {
    if (this == o) return true;
    if (o == null) return false;
    Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer()
                                                                 .getPersistentClass() : o.getClass();
    Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer()
                                                                       .getPersistentClass() : this.getClass();
    if (thisEffectiveClass != oEffectiveClass) return false;
    Company company = (Company) o;
    return getId() != null && Objects.equals(getId(), company.getId());
  }

  @Override
  public final int hashCode() {
    return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass()
                                                .hashCode() : getClass().hashCode();
  }
}
