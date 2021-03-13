package net.javaci.springangularcourse.db.entity.dto;

import java.time.LocalDateTime;

public class TicketStats {

    private String status;
    
    private Long count;
    
    private LocalDateTime minCreateDateTime;
    
    private LocalDateTime maxCreateDateTime;

    public TicketStats(String status, Long count, LocalDateTime minCreateDateTime, LocalDateTime maxCreateDateTime) {
        super();
        this.status = status;
        this.count = count;
        this.minCreateDateTime = minCreateDateTime;
        this.maxCreateDateTime = maxCreateDateTime;
    }

    @Override
    public String toString() {
        return "status=" + status + ", count=" + count + ", minCreateDateTime=" + minCreateDateTime
                + ", maxCreateDateTime=" + maxCreateDateTime + "";
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public LocalDateTime getMinCreateDateTime() {
        return minCreateDateTime;
    }

    public void setMinCreateDateTime(LocalDateTime minCreateDateTime) {
        this.minCreateDateTime = minCreateDateTime;
    }

    public LocalDateTime getMaxCreateDateTime() {
        return maxCreateDateTime;
    }

    public void setMaxCreateDateTime(LocalDateTime maxCreateDateTime) {
        this.maxCreateDateTime = maxCreateDateTime;
    }
}
