package de.pohlproductions.servermonitoring.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = Status.TABLE_NAME)
@Entity(name = Status.TABLE_NAME)
public class Status {

    public static final String TABLE_NAME = "STATUS";

    @Id
    @Column
    @GeneratedValue
    private UUID id;
    @Column
    private String url;
    @Column
    private boolean reachable;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime created;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime updated;

    public Status(String url, boolean reachable) {
        this.url = url;
        this.reachable = reachable;
    }

    @PrePersist
    protected void onCreate() {
        created = LocalDateTime.now();
        updated = created;
    }

    @PreUpdate
    protected void onUpdate() {
        updated = LocalDateTime.now();
    }

}
