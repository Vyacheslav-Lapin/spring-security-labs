package com.luxoft.spingsecurity.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

import com.luxoft.spingsecurity.utils.HibernateUtils;
import lombok.Data;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.ExtensionMethod;

import static com.luxoft.spingsecurity.utils.HibernateUtils.*;

@SuppressWarnings({
    "com.intellij.jpb.LombokDataInspection",
    "JpaObjectClassSignatureInspection",
})

@Entity
@SequenceGenerator(
    name = "user_seq_gen",
    sequenceName = "user_seq",
    initialValue = 3010)
@Data(staticConstructor = "User")
@ExtensionMethod(HibernateUtils.class)
public class User {

    @GeneratedValue(generator = "user_seq_gen")
    @Id Long id;

    @NonNull String login;
    @NonNull String password;

    @ElementCollection
    List<String> roles;

    @JoinTable(name = "user_company")
    @ManyToMany(cascade = CascadeType.ALL) @ToString.Exclude
    List<Company> companies;

    @Override
    public final boolean equals(Object o) {
        return this == o || o != null
                            && effectiveClass(this) == o.effectiveClass()
                            && getId() != null
                            && o instanceof User
                            && Objects.equals(getId(), ((User) o).getId());
    }

    @Override
    public final int hashCode() {
        return effectiveClass(this).hashCode();
    }
}
