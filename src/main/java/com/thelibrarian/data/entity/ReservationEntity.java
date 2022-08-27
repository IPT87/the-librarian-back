package com.thelibrarian.data.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "RESERVATION")
@NoArgsConstructor
@AllArgsConstructor
public class ReservationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer id_usuario;

    private Integer id_book;

    private Boolean is_reservado;

    @ManyToOne()
    @JoinColumn(name = "id_book", insertable = false, updatable = false)
	private BookEntity book;


    @ManyToOne()
    @JoinColumn(name = "id_usuario", insertable = false, updatable = false)
	private UsersEntity usuario;
    
}
