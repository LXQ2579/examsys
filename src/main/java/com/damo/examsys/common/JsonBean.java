package com.damo.examsys.common;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel
@Getter
@Setter
public class JsonBean<T> {

	@ApiModelProperty(value = "返回数据状态码, 0 正常返回, 其他 表示异常")
	private Integer code;
	@ApiModelProperty(value = "返回具体数据, 可以为null")
	private T data;

	public JsonBean() {
	}

	public JsonBean(Integer code, T data) {
		this.code = code;
		this.data = data;
	}
}
