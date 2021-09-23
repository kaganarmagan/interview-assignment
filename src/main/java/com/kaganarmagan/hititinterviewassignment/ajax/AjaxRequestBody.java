package com.kaganarmagan.hititinterviewassignment.ajax;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AjaxRequestBody {
    @NotNull
    @JsonProperty("request")
    private  String request;
}
