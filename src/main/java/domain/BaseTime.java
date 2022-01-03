package domain;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import java.util.Date;

@MappedSuperclass
public abstract class BaseTime {

    @CreationTimestamp
    private Date createdTime;

    @UpdateTimestamp
    private Date modifiedTime;
}
