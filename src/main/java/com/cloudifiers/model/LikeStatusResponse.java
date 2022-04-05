package com.cloudifiers.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LikeStatusResponse extends ResponseStatus {

	@JsonProperty("isLiked")
	private Boolean isLiked;

	public LikeStatusResponse(Boolean success, String errorCode, Boolean isLiked) {
		super(success, errorCode);
		this.isLiked = isLiked;
	}
}
