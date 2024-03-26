package com.luxoft.spingsecurity.utils;

import lombok.experimental.UtilityClass;
import org.hibernate.proxy.HibernateProxy;

@UtilityClass
public class HibernateUtils {

  public Class<?> effectiveClass(Object entity) {
    return entity instanceof HibernateProxy ?
               ((HibernateProxy) entity)
                   .getHibernateLazyInitializer()
                   .getPersistentClass()
               : entity.getClass();
  }
}
