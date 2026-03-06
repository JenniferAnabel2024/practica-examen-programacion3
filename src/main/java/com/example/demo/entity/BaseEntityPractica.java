package com.example.demo.entity;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@MappedSuperclass
public class BaseEntityPractica {
	@Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;
	
	public BaseEntityPractica () {
		
	}
	public BaseEntityPractica (Long id) {
		this.id = id;
	}
		public Long getId() {
		return id;
		}
		
		public void setId(Long id) {
		this.id=id;
		}
	}

