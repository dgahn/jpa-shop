package io.github.dgahn.jpashop.domain;


import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;


@MappedSuperclass
public abstract class BaseEntity {

  private String createdBy;
  private LocalDateTime createDate;
  private String lastModifiedBy;
  private LocalDateTime lastModifiedDate;

  public String getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(final String createdBy) {
    this.createdBy = createdBy;
  }

  public LocalDateTime getCreateDate() {
    return createDate;
  }

  public void setCreateDate(final LocalDateTime createDate) {
    this.createDate = createDate;
  }

  public String getLastModifiedBy() {
    return lastModifiedBy;
  }

  public void setLastModifiedBy(final String lastModifiedBy) {
    this.lastModifiedBy = lastModifiedBy;
  }

  public LocalDateTime getLastModifiedDate() {
    return lastModifiedDate;
  }

  public void setLastModifiedDate(final LocalDateTime lastModifiedDate) {
    this.lastModifiedDate = lastModifiedDate;
  }

}
