package com.aliza.davening.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Weekly {
	
    public String parashaName;
    public String fullWeekName;
    public long categoryId;
    public String message;
}
