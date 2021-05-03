package com.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseObject {

	private String content;
	private String message;
	private List<String> listContent;

	public ResponseObject(String content,String message){
		this.content = content;
		this.message = message;
	}
}
