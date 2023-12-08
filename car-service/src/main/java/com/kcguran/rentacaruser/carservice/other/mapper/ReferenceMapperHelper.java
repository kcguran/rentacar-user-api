package com.kcguran.rentacaruser.carservice.other.mapper;

import com.kcguran.rentacaruser.carservice.entity.shared.BaseEntity;
import com.kcguran.rentacaruser.carservice.other.SpringBeanFactoryUtil;
import jakarta.persistence.EntityManager;
import org.mapstruct.TargetType;
import org.springframework.stereotype.Component;

@Component
public class ReferenceMapperHelper {

    public <T extends BaseEntity> T resolve(Long reference, @TargetType Class<T> clazz) {
        EntityManager entityManager = SpringBeanFactoryUtil.getBean(EntityManager.class);
        assert entityManager != null;
        return reference == null ? null : entityManager.find(clazz, reference);
    }

    public <T extends BaseEntity> Long toReference(T entity) {
        return entity != null ? entity.getId() : null;
    }
}
