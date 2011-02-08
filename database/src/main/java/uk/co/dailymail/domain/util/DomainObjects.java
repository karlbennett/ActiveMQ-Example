package uk.co.dailymail.domain.util;

import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.OneToOne;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.ManyToMany;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * User: Karl Bennett
 * Date: 27-Jan-2011
 */
public final class DomainObjects {

    private DomainObjects() {}

    public static Boolean isColumn(Field field) {
        return null != field.getAnnotation(Id.class) || null != field.getAnnotation(Column.class)
                || null != field.getAnnotation(OneToOne.class) || null != field.getAnnotation(OneToMany.class)
                || null != field.getAnnotation(ManyToOne.class) || null != field.getAnnotation(ManyToMany.class);
    }

    public static <D> List<Field> getColumnFields(Class<D> type) {
        List<Field> columnFields = new ArrayList<Field>();

        for (Field field : type.getDeclaredFields()) {
            if (isColumn(field)) columnFields.add(field);
        }

        return columnFields;
    }

    public static <D> String getIdName(Class<D> type) {
        String idName = "";

        for (Field field : getColumnFields(type)) {
            if (null != field.getAnnotation(Id.class)) {
                idName = field.getName();
            }
        }

        return idName;
    }
}
