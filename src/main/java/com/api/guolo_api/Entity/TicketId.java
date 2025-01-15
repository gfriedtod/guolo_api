package com.api.guolo_api.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class TicketId implements Serializable {
    private static final long serialVersionUID = -7253559621468122851L;
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "number", nullable = false)
    private Short number;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        TicketId entity = (TicketId) o;
        return Objects.equals(this.number, entity.number) &&
                Objects.equals(this.id, entity.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, id);
    }

}