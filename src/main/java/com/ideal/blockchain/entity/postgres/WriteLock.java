package com.ideal.blockchain.entity.postgres;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "write_lock")
@Data
public class WriteLock {

    @Id
    private int write_lock;
}
